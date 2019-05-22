package baekjun;

import java.util.Scanner;
public class Problem5557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		long[][] dp = new long[N][21];

		dp[0][a[0]]=1;
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<=20; j++) {
				if(j-a[i]>=0) {
					dp[i][j]+=dp[i-1][j-a[i]];
				}
				if(j+a[i]<=20) {
					dp[i][j]+=dp[i-1][j+a[i]];
				}
			}
		}
		System.out.println(dp[N-2][a[N-1]]);
	}
}
