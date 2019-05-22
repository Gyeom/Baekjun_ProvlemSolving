package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Swea2117_RR {
	static int[][] map;
	static int N,M;
	static class Home{
		int y;
		int x;
		int d;
		Home(int y, int x, int d){
			this.y=y;
			this.x=x;
			this.d=d;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ans = Math.max(ans, bfs(new Home(i,j,1)));
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static int bfs(Home home) {
		// TODO Auto-generated method stub
		Queue<Home> q = new LinkedList<>();
		boolean[][] visited = new boolean [N][N];
		int count=0;
		visited[home.y][home.x]=true;
		if(map[home.y][home.x]==1) {
			count++;
		}
		int K=0;
		int MAX_COUNT= 0;
		q.add(home);
		while(!q.isEmpty()) {
			int c = count;
			for(Home h : q) {
				if(map[h.y][h.x]==1) {
					c--;
				}
			}
			Home p = q.remove();
			if(K<p.d) {
				if(M*c>=K*K+(K-1)*(K-1)) {
					MAX_COUNT=c;
				}
				K=p.d;
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				if(map[ry][rx]==1) {
					count++;
				}
				visited[ry][rx]=true;
				q.add(new Home(ry,rx,p.d+1));
			}
		}
		if(M*count>=K*K+(K-1)*(K-1)) {
			MAX_COUNT=count;
		}
		return MAX_COUNT;
	}
}
