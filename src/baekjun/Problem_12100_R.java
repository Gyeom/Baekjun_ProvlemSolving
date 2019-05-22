package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_12100_R {
	static int N;
	static int[][] map;
	static int[][] copy;
	static int[] way;
	static int max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max=0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		way = new int[5];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		dfs(5,0);
		System.out.println(max);
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			check();
			return;
		}
		for(int i=0; i<4; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	static boolean[][] visited;
	private static void check() {
		// TODO Auto-generated method stub
		copy = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j]=map[i][j];
			}
		}
		for(int k=0; k<way.length; k++) {
			visited = new boolean[N][N];
			if(way[k]==0) {
				for(int i=N-1; i>=0; i--) {
					for(int j=0; j<N; j++) {
						simulation(i,j,way[k]);
					}
				}
			}else if(way[k]==1) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						simulation(i,j,way[k]);
					}
				}
			}else if(way[k]==2) {
				for(int j=0; j<N; j++) {
					for(int i=0; i<N; i++) {
						simulation(i,j,way[k]);
					}
				}
			}else if(way[k]==3) {
				for(int j=N-1; j>=0; j--) {
					for(int i=0; i<N; i++) {
						simulation(i,j,way[k]);
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copy[i][j]>max) {
					max=copy[i][j];
				}
			}
		}
	}
	private static void simulation(int y, int x, int k) {
		// TODO Auto-generated method stub
		if(copy[y][x]==0) return;
		while(true) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0||ry>=N||rx>=N) return;
			if(visited[ry][rx]) return;
			if(copy[ry][rx]==copy[y][x]) {
				visited[ry][rx]=true;
				copy[ry][rx]*=2;
				copy[y][x]=0;
				return;
			}else if(copy[ry][rx]!=0) return;
			copy[ry][rx]=copy[y][x];
			copy[y][x]=0;
			y=ry;
			x=rx;
		}
	}
}