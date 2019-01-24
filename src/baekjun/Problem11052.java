package baekjun;

import java.util.Scanner;

public class Problem11052 {
	static int[] a;
	static int MAX;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N];
		MAX = 0;
		for(int i =0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		
		
		dfs(0,N,0);
		System.out.println(MAX);
		
	}
	private static void dfs(int begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index>end) {
			return;
		}
		
		if(index==end) {
			if(begin>MAX) {
				MAX=begin;
			}
			return;
		}
		
		for(int i=0; i<a.length; i++) {
			dfs(begin+a[i],end,index+i+1);
		}
		
	}
}
