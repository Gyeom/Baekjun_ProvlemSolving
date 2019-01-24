package baekjun;

import java.util.Scanner;

public class Problem11055 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
			dp[i]=a[i];
		}
		int ans =a[0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(a[i]>a[j]&&dp[i]<dp[j]+a[i]) {
					
					dp[i]=dp[j]+a[i];
					if(dp[i]>ans) {
						ans=dp[i];
					}
				}
			}
		}
		
			
		System.out.println(ans);
	}

}
