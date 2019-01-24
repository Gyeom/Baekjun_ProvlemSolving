package baekjun;

import java.util.Scanner;

public class Problem9465 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		do {
			int N = sc.nextInt();
			int [][] dp = new int[3][N+1];
			int [][] a = new int[3][N+1];
			int ans = 0;
			for(int i=1; i<=2; i++) {
				for(int j=1; j<=N; j++) {
					a[i][j]=sc.nextInt();
				}
			}
			dp[1][1]=a[1][1];
			dp[2][1]=a[2][1];
			for(int i=2; i<=N; i++) {
				for(int j=0; j<=2; j++) {			
					if(j==0) {
						dp[j][i]=Math.max(dp[1][i-1],dp[2][i-1]);
					}else if(j==1) {
						dp[j][i]=a[j][i]+Math.max(dp[0][i-1],dp[2][i-1]);
					}else if(j==2) {
						dp[j][i]=a[j][i]+Math.max(dp[0][i-1],dp[1][i-1]);
					}
				}
			}
			if(dp[1][N]>dp[2][N]) {
				ans = dp[1][N];
			}else {
				ans = dp[2][N];
			}
			if(dp[0][N]>ans) {
				ans = dp[0][N];
			}
			System.out.println(ans);
		}while(--TC>0);
	}
}