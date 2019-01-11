package baekjun;

import java.util.Scanner;

public class Promblem14501 {
	static int ans=0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		
		dfs(0,N,0,a,p);
		System.out.println(ans);
	}


	private static void dfs(int begin, int end, int index, int[] a, int[] p) {
		// TODO Auto-generated method stub
		if(index>end) {
			return;
		}
		if(index==end) {
			if(begin>ans) {
				ans=begin;
			
			}
			return;
		}
		
		dfs(begin+p[index],end,index+a[index],a,p);
		dfs(begin,end,index+1,a,p);
	
	}
}
