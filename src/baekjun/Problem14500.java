package baekjun;

import java.util.Scanner;

public class Problem14500 {
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y =y;
			this.x =x;
		}
	}
	static int N;
	static int M;
	static int[][] a;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				dfs(a[i][j],3,0,i,j);
				visited[i][j]=false;
				visited[i][j]=true;
				dfs2(a[i][j],3,0,i,j);
				visited[i][j]=false;
			}
		}
		System.out.println(ans);
		
	}
	private static void dfs2(int sum, int end, int index, int py, int px) {
		// TODO Auto-generated method stub
		if(index == end) {
			if(sum>ans) {
				ans =sum;
			}
			return;
		}
		for(int k=0; k<4; k++) {
			int ry = py+dy[k];
			int rx = px+dx[k];
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(visited[ry][rx]) continue;
			visited[ry][rx]=true;
			sum+=a[ry][rx];
			dfs2(sum,end, index+1,py,px);
			sum-=a[ry][rx];
			visited[ry][rx]=false;
		}
	}
	static boolean[][] visited;
	static int ans = 0;
	private static void dfs(int sum, int end, int index,int py, int px) {
		// TODO Auto-generated method stub
		if(index == end) {
			if(sum>ans) {
				ans=sum;
			}
			return;
		}
		
		for(int k=0; k<4; k++) {
			int ry = dy[k]+py;
			int rx = dx[k]+px;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(visited[ry][rx]) continue;
			visited[ry][rx]=true;
			sum+=a[ry][rx];
			dfs(sum,end,index+1,ry,rx);
			sum-=a[ry][rx];
			visited[ry][rx]=false;
		}
		
	}
}
