package baekjun;

import java.util.Scanner;

public class Problem11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1001];
		dp[1]=1;
		dp[2]=2;
			for(int i=3; i<=N; i++) {
				dp[i]=dp[i-1]+dp[i-2];
				dp[i]%=10007;
			}
		System.out.println(dp[N]);
	}
	

}
