package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1953 {
	static class Pair{
		int y;
		int x;
		int dist;
		Pair(int y, int x, int dist){
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	static int[][] map;
	static int N;
	static int M;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc = 1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			int R = Integer.parseInt(token.nextToken());
			int C = Integer.parseInt(token.nextToken());
			int L = Integer.parseInt(token.nextToken()); //탈출 후 소요시간
			map = new int[N][M];
			Queue<Pair> q= new LinkedList<>();
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
					if(i==R&&j==C) {
						q.add(new Pair(R,C,1));
					}
				}
			}
			if(L==1) {
				bw.write("#"+String.valueOf(tc)+" "+"1");
				bw.newLine();
				continue;
			}else {
				bw.write("#"+String.valueOf(tc)+" "+String.valueOf(bfs(q,L)));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static int bfs(Queue<Pair> q,int L) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[N][M];
		visited[q.peek().y][q.peek().x]=true;
		int count=1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.dist==L) break;
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(map[p.y][p.x]==2&&(k==2||k==3))continue;
				if(map[p.y][p.x]==3&&(k==0||k==1))continue;
				if(map[p.y][p.x]==4&&(k==0||k==2))continue;
				if(map[p.y][p.x]==5&&(k==1||k==2))continue;
				if(map[p.y][p.x]==6&&(k==1||k==3))continue;
				if(map[p.y][p.x]==7&&(k==0||k==3))continue;
				if(map[ry][rx]==0) continue;
				int kk=0;
				if(k%2==0) {
					kk=k+1;
				}else {
					kk=k-1;
				}
				if(map[ry][rx]==2&&(kk==2||kk==3))continue;
				if(map[ry][rx]==3&&(kk==0||kk==1))continue;
				if(map[ry][rx]==4&&(kk==0||kk==2))continue;
				if(map[ry][rx]==5&&(kk==1||kk==2))continue;
				if(map[ry][rx]==6&&(kk==1||kk==3))continue;
				if(map[ry][rx]==7&&(kk==0||kk==3))continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				count++;
				q.add(new Pair(ry,rx,p.dist+1));
			}
		}
		return count;
	}
}
