package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10942 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int[] a = new int[N+1];
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(dp[i], -1);
			a[i]=sc.nextInt();
		}
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			sb.append(dfs(sc.nextInt(),sc.nextInt(),a,dp)+"\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int i, int j, int[] a,int[][] dp) {
		// TODO Auto-generated method stub
		if(i==j) {
			return 1;
		}else if(i+1==j) {
			if(a[i+1]==a[i]) {
				return 1;
			}else {
				return 0;
			}
			
		}
		if(dp[i][j]>-1) {
			return dp[i][j];
		}
		if(a[i]!=a[j]) {
			dp[i][j]=0;
			return dp[i][j];
		}
		dp[i][j]=dfs(i+1,j-1,a,dp);
		return dp[i][j];
	}

}
