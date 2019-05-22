package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Swea1953_R {
	static int[][] map;
	static int N,M,R,C,L;
	static class Man{
		int y;
		int x;
		int d;
		Man(int y, int x, int d){
			this.y=y;
			this.x=x;
			this.d=d;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			R = Integer.parseInt(s[2]);
			C = Integer.parseInt(s[3]);
			L = Integer.parseInt(s[4]);
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(bfs(new Man(R,C,1))));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static int bfs(Man man) {
		// TODO Auto-generated method stub
		Queue<Man> q= new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[man.y][man.x]=true;
		q.add(man);
		int count=1;
		while(!q.isEmpty()) {
			Man p = q.remove();
			if(p.d==L) continue;
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(visited[ry][rx]) continue;
				if(map[ry][rx]==0) continue;
				if(k==0) {
					if(map[p.y][p.x]==3||map[p.y][p.x]==4||map[p.y][p.x]==7) continue;
					if(map[ry][rx]==3||map[ry][rx]==5||map[ry][rx]==6) continue;
				}else if(k==1) {
					if(map[p.y][p.x]==3||map[p.y][p.x]==5||map[p.y][p.x]==6) continue;
					if(map[ry][rx]==3||map[ry][rx]==4||map[ry][rx]==7) continue;
				}else if(k==2) {
					if(map[p.y][p.x]==2||map[p.y][p.x]==4||map[p.y][p.x]==5) continue;
					if(map[ry][rx]==2||map[ry][rx]==6||map[ry][rx]==7) continue;
				}else if(k==3) {
					if(map[p.y][p.x]==2||map[p.y][p.x]==6||map[p.y][p.x]==7) continue;
					if(map[ry][rx]==2||map[ry][rx]==4||map[ry][rx]==5) continue;
				}
				visited[ry][rx]=true;
				q.add(new Man(ry,rx,p.d+1));
				count++;
			}
		}
		return count;
	}
}
