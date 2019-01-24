package baekjun;

import java.util.Scanner;

public class Problem15990 {
	static int[][] dp;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		dp = new int[100001][4];
		
		for(int tc=0; tc<TC; tc++) {
			int N = sc.nextInt();
			System.out.println(dfs(N,0,0));
		}
		
	}

	private static int dfs(int begin, int end, int type) {
		if(begin<0) {
			return 0;
		}
		if(begin==end) {
			return 1;
		}
		if(dp[begin][type]>0) {
			return dp[begin][type];
		}
		
		if(type==1) {
			dp[begin][type]=dfs(begin-2,end,2)+dfs(begin-3,end,3);
			dp[begin][type]%=1000000009;
		}else if(type==2) {
			dp[begin][type]=dfs(begin-1,end,1)+dfs(begin-3,end,3);
			dp[begin][type]%=1000000009;
		}else if(type==3) {
			dp[begin][type]=dfs(begin-2,end,2)+dfs(begin-1,end,1);
			dp[begin][type]%=1000000009;
		}else {
			dp[begin][type]=dfs(begin-1,end,1)+dfs(begin-2,end,2)+dfs(begin-3,end,3);
			dp[begin][type]%=1000000009;
		}
		
		return dp[begin][type];
	
	}
}
