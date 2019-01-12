package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem15657 {
	static int[] a;
	static StringBuilder sb;
	static int[] p;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		sb = new StringBuilder();
		a= new int[N];
		p= new int[M];
		for(int i=0; i<N; i++ ) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		
		dfs("",M,0);
		
		
		System.out.println(sb);
		
	}
	private static void dfs(String begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end){
			sb.append(begin.trim()+"\n");
			return;
		}
		
		for(int i=0; i<a.length; i++) {
			if(index!=0) {
				if(p[index-1]>a[i]) {
					continue;
				}
			}
			p[index]=a[i];
			dfs(begin+a[i]+" ",end,index+1);
		}
		
	}

}
