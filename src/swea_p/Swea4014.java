package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea4014 {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int N;
	static int X;
	static int[][] h;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			X = Integer.parseInt(token.nextToken());
			h = new int[N][N];
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					h[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			int count=0;
			for(int i=0; i<N; i++) {
				boolean go = true;
				visited= new boolean[N][N];
				if(!bfs(new Pair(i,0),3)) continue;
				if(!bfs(new Pair(i,N-1),2)) continue;
				if(go) {
					count++;
				}
			}
			for(int i=0; i<N; i++) {
				boolean go = true;
				visited= new boolean[N][N];
				if(!bfs(new Pair(0,i),0)) continue;
				if(!bfs(new Pair(N-1,i),1)) continue;
				if(go) {
					count++;
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static boolean bfs(Pair pair, int k) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		q.add(pair);
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if((k==3&&p.x==N-1)||(k==2&&p.x==0)||(k==0&&p.y==N-1)||(k==1&&p.y==0)) {
				return true;
			}
			int ry = p.y+dy[k];
			int rx = p.x+dx[k];
			if(h[ry][rx]>h[p.y][p.x]+1) return false;
			if(h[ry][rx]==h[p.y][p.x]+1) {
				int temp = h[p.y][p.x];
				int ay=p.y;
				int ax=p.x;
				if(visited[ay][ax]) return false;
				visited[ay][ax]=true;
				for(int i=1; i<X; i++) {
					ay-=dy[k];
					ax-=dx[k];
					if(ay<0||ax<0||ay>=N||ax>=N) return false;
					if(h[ay][ax]!=temp) return false;
					if(visited[ay][ax]) return false;
					visited[ay][ax]=true;
				}
			}
			q.add(new Pair(ry,rx));
		}
		return false;
	}
}