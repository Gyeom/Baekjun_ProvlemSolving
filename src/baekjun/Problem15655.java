package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem15655 {
	static int[] a;
	static StringBuilder sb;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a= new int[N];
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
		}
		Arrays.sort(a);
		dfs("",M,0); 
		System.out.println(sb);
	}
	private static void dfs(String begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			sb.append(begin.trim()+"\n");
			return;
		}
		for(int i=0; i<a.length; i++) {
			dfs(begin+a[i]+" ", end, index+1);
		}
		return;
	}
}

