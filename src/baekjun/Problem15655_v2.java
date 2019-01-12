package baekjun;

import java.util.Arrays;
import java.util.Scanner;


public class Problem15655_v2 {
	static int[] a;
	static int[] p;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a= new int[N];
		p= new int[M];
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
		}
		Arrays.sort(a);
		System.out.println(dfs(M,0)); 
	}
	private static StringBuilder dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			StringBuilder sb = new StringBuilder();
			for(int t : p) {
				sb.append(t+" ");
			}
			sb.append("\n");
			return sb;
		}
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<a.length; i++) {
			p[index]=a[i];
			ans.append(dfs(end, index+1));
			
		}
		
		return ans;
	}
}

