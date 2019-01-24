package baekjun;

import java.util.Scanner;

public class Problem9095 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long[] dp = new long [1000001];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		long top=4;
		int TC = sc.nextInt();
		for(int t=1; t<=TC; t++) {
		int N = sc.nextInt();
		for(int i=(int)top; i<=N; i++) {
			if(dp[i]>0) {
			
				continue;
			}
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			dp[i]=dp[i]%1000000009;
		}
		if(top<N) {
			top=N;
		}
		System.out.println(dp[N]);
	}
	}
}
