//import java.util.Scanner;
//
//public class Main {
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] a = new int[N];
//		int[] dp = new int[N];
//		int ans = -1000;
//		for(int i=0; i<N; i++) {
//			a[i]=sc.nextInt();
//			dp[i]=a[i];
//			if(dp[i]>ans) {
//				ans=dp[i];
//			}
//		}
//		
//		for(int i=1; i<N; i++) {
//			if(a[i]<a[i]+dp[i-1]) {
//				dp[i]=a[i]+dp[i-1];
//				if(dp[i]>ans) {
//					ans=dp[i];
//				}
//			}
//		}
//		
//		System.out.println(ans);
//		
//	}
//
//}
