package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Swea2117 {
	static int N; 
	static int M;
	static int[][] map;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			ans=0;
			String[] s= br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					boolean home = (map[i][j]==1?true:false);
					bfs(i,j,home);
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static class Pair{
		int y;
		int x;
		int d;
		boolean home;
		Pair(int y, int x, int d, boolean home){
			this.y=y;
			this.x=x;
			this.d=d;
			this.home=home;
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	static int ans;
	static int max;
	private static void bfs(int y, int x,boolean home) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[y][x]=true;
		int count=0;
		if(map[y][x]==1) {
			count++;
		}
		q.add(new Pair(y,x,1,home));
		int D = 1;
		while(!q.isEmpty()) {
			Pair p = q.remove();

			if(p.d!=D) {
				int c=count;
				if(p.home==true) {
					c--;
				}
				for(Pair temp : q) {
					if(temp.home) {
						c--;
					}
				}
				if(D*D+(D-1)*(D-1)<=c*M) {
					if(c>ans) {
						ans=c;
					}
				}
				D=p.d;
			}

			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				boolean h = false;
				if(map[ry][rx]==1) {
					h=true;
					count++;
				}
				q.add(new Pair(ry,rx,p.d+1,h));
			}

		}
		if(D*D+(D-1)*(D-1)<=count*M) {
			if(count>ans) {
				ans=count;
			}
		}



	}

}
