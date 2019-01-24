package swea;

import java.util.Scanner;

public class SwExpert1865 {
	static float[] dp;
	static int[][] a;
	static boolean[] visited;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N+1][N+1];
		visited = new boolean[N+1];
		dp = new float[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				a[i][j]=sc.nextInt();
			}
		}
System.out.println(100*dfs(1,N,0));
		
	}


	private static float dfs(float begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return begin;
		}
		if(dp[index]>0) {
			return dp[index];
		}
		
		
		for(int i=1; i<=end; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			float temp=dfs(begin*((float)a[i][index+1]/100),end,index+1);
			dp[index]=Math.max(temp, dp[index]);
			visited[i]=false;
		}
		
		return dp[index];
		
	}
}

