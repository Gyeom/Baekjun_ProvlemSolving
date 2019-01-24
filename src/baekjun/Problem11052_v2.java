package baekjun;

import java.util.Scanner;

public class Problem11052_v2 {
	static int[] a;
	static int[] dp;
	static int MAX;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N+1];
		dp = new int[N+1];
		MAX = 0;
		for(int i =1; i<=N; i++) {
			a[i]=sc.nextInt();
		}

		System.out.println(dfs(0,N));
		
		
		
	}
	private static int dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return 0;
		}
		
		if(dp[index]>0) {
			return dp[index];
		}
		
		
		for(int i=1; i<a.length; i++) {
			if(index-i<0) continue;
			int temp = a[i]+dfs(0,index-i);
			if(temp>dp[index]) {
				dp[index]=temp;
			}
		}
		
		
		return dp[index];
	}

}
