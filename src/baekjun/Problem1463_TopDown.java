package baekjun;

import java.util.Scanner;

public class Problem1463_TopDown {

	static int ans=1000000;
	static int[] dp;
	public static void main(String args[]) {

		Scanner sc =new Scanner(System.in);
		int a = sc.nextInt();
		dp = new int[1000001];

		System.out.println(dfs(a,1));
	}

	private static int dfs(int begin, int end) {
		// TODO Auto-generated method stub
		if(begin==end) {
			return 0;
		}
		if(dp[begin]>0) {
			return dp[begin];
		}
		dp[begin] = dfs(begin-1,end)+1;
		
		if(begin%3==0) {
			int temp = dfs(begin/3,end)+1;
			if(temp<dp[begin]) {
				dp[begin]=temp; 
			}

		}
		if(begin%2==0) {
			int temp = dfs(begin/2,end)+1;
			if(temp<dp[begin]) {
				dp[begin]=temp; 
			}
		}


		return dp[begin];
	}

}
