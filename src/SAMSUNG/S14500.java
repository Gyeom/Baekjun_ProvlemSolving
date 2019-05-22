package SAMSUNG;

import java.util.Scanner;

public class S14500 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N][M];
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		ans=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				dfs(map[i][j],i,j,4,0);
				visited[i][j]=false;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(j+2<M&&i+1<N) ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1]);//で
				if(j+2<M&&i-1>=0) ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+1]);//ぬ
				if(i+2<N&&j+1<M) ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1]);//た
				if(j-1>=0&&i+2<N)ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j-1]);//っ
			}
		}
		System.out.println(ans);
	}
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void dfs(int sum, int y, int x, int end, int index) {
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
			dfs(sum+map[ry][rx],ry,rx,end,index+1);
			visited[ry][rx]=false;
		}
	}
}