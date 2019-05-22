package SAMSUNG;

import java.util.Scanner;

public class S14501 {
	static int[] time;
	static int[] pay;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];
		pay = new int[N];
		ans=0;
		for(int i=0; i<N; i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			time[i]=t;
			pay[i]=p;
		}
		dfs(0,0,N);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int num,int sum, int end) {
		// TODO Auto-generated method stub
		if(num>end) {
			return;
		}
		if(sum>ans) {
			ans=sum;
		}
		for(int i=num; i<N; i++) {
			dfs(i+time[i],sum+pay[i],end);
		}
	}
}