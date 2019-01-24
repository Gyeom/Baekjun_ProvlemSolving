package baekjun;

import java.util.Scanner;

public class Problem11057 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[][] dp = new long[10][N+1];
		int ans=0;
		for(int i=0; i<=9; i++) {
			dp[i][1]=1;
		}
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=j; k<=9; k++) {
					dp[j][i]+=dp[k][i-1]%=10007;
				}
			}
		}	
		for(int i=0; i<=9; i++) {
			ans+=dp[i][N]%=10007;
		}
		ans%=10007;
		System.out.println(ans);
		
	}

}
