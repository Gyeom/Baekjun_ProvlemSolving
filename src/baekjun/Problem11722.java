package baekjun;

import java.util.Scanner;

public class Problem11722 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
		}
		dp[0]=1;
		int ans =dp[0];
		for(int i=1; i<N; i++) {
			dp[i]=1;
			for(int j=0; j<N; j++) {
				if(a[i]<a[j]&&dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					if(dp[i]>ans) {
						ans = dp[i];
					}
				}
				
			}
		}
		System.out.println(ans);
		
	}

}
