package baekjun;

import java.util.Scanner;

public class Problem10884 {

	static int[][] dp;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[10][N+1]; 

		System.out.println(dfs(0,N,0));
	}

	private static int dfs(int begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return 1;
		}
		if(dp[begin][index]>0) {
			return dp[begin][index];
		}

		if(index==0) {
			for(int i=1; i<=9; i++) {
				dp[begin][index]+=dfs(i,end,index+1);
				dp[begin][index]%=1000000000;
			}
		}

		if(begin!=0&&index!=0) {
			dp[begin][index]+=dfs(begin-1,end,index+1);
			dp[begin][index]%=1000000000;
		}
		if(begin!=9&&index!=0) {
			dp[begin][index]+=dfs(begin+1,end,index+1);
			dp[begin][index]%=1000000000;
		}
		


		dp[begin][index]%=1000000000;
		return dp[begin][index];
	}
}
