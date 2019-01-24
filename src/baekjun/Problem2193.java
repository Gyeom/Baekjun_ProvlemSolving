package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2193 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N+1][2];
		dp[1][0]=0;
		dp[1][1]=1;
	

		for(int i=2; i<=N; i++) {
			for(int j=0; j<=1; j++) {
				if(j==1) {
					dp[i][j]=dp[i-1][0];
				}else if(j==0) {
					dp[i][j]=dp[i-1][0]+dp[i-1][1];
				}
			}
		}
		
		System.out.println(dp[N][0]+dp[N][1]);
		
	}

}
