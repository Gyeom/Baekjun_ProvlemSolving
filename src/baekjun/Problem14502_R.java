package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem14502_R {
	
	static ArrayList<Birus> birusList;
	static boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map;
	static int N,M;
	static int birus;
	static int ans;
	
	static class Birus{
		int y;
		int x;
		Birus(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = Integer.MAX_VALUE;
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		birusList = new ArrayList<>();
		int wall=0;
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==2) {
					birusList.add(new Birus(i, j));
				}else if(map[i][j]==1) {
					wall++;
				}
			}
		}
		dfs(0,0,3,0);
		System.out.println(N*M-ans-wall-3);
	}
	
	private static void dfs(int y, int x, int end, int index) {
		// TODO Auto-generated method stub
		if(ans==birusList.size()) {
			return;
		}
		if(index==end) {
			birus=birusList.size();
			visited = new boolean[N][M];
			for(Birus b : birusList) {
				visited[b.y][b.x]=true;
				spread(b.y,b.x);
			}
			if(birus<ans) {
				ans=birus;
			}
			return;
		}
		if(x==M) {
			y++;
			x=0;
		}
		for(int i=y; i<N; i++) {
			for(int j=x; j<M; j++) {
				if(map[i][j]==1||map[i][j]==2) continue;
				map[i][j]=1;
				dfs(i,j+1,end,index+1);
				map[i][j]=0;
			}
			x=0;
		}
	}

	private static void spread(int y, int x) {
		// TODO Auto-generated method stub
		for(int k=0; k<4; k++) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(visited[ry][rx]) continue;
			if(map[ry][rx]>0) continue;
			visited[ry][rx]=true;
			birus++;
			spread(ry,rx);
		}
	}
}