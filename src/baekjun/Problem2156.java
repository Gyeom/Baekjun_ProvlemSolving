package baekjun;

import java.util.Scanner;

public class Problem2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] a = new int[2][100001];
		int[][] dp =new int[2][100001];
		for(int i=1; i<=N; i++) {
			a[1][i]=sc.nextInt();
		}
		
		dp[1][2]= a[1][2]+a[1][1];
		dp[0][2]= a[1][1];
		dp[1][1]= a[1][1];
		dp[0][1]= 0;

		for(int i=3; i<=N; i++) {
			dp[1][i]= a[1][i]+Math.max(dp[0][i-1], a[1][i-1]+dp[0][i-2]);
			dp[0][i]= a[0][i]+Math.max(dp[1][i-1], a[0][i-1]+dp[1][i-2]);
		}
		System.out.println(Math.max(dp[1][N], dp[0][N]));
	}

}
