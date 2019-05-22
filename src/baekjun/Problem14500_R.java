package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14500_R {
	static int N, M;
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		ans=0;
		map = new int[N][M];
		visited= new boolean[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				dfs(i,j,map[i][j],4,0);
				visited[i][j]=false;
				//で
				if(j+2<M&&i+1<N) {
					ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1]);	
				}
				//ぬ
				if(j+2<M&&i-1>=0) {
					ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+1]);	
				}
				//た
				if(i+2<N&&j+1<M) {
					ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1]);
				}
				//っ
				if(i+2<N&&j-1>=0) {
					ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j-1]);
				}
			}
		}
		System.out.println(ans);
	}
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void dfs(int y, int x, int sum, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end-1) {
			if(sum>ans) {
				ans=sum;
			}
			return;
		}
		for(int k=1; k<4; k++) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(visited[ry][rx]) continue;
			visited[ry][rx]=true;
			dfs(ry,rx,sum+map[ry][rx],end,index+1);
			visited[ry][rx]=false;
		}
	}
}
