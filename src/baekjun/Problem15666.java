package baekjun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem15666 {
	static int[] a;
	static int[] p;
	static HashSet<String> set;
	static StringBuilder sb;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a = new int[N];
		p = new int[M];
		set = new HashSet<String>();
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		dfs("",M,0);
		System.out.println(sb);
	}
	private static void dfs(String begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(!set.contains(begin)) {
				set.add(begin);
				sb.append(begin+"\n");
			}
			return;
		}
		for(int i=0; i<a.length; i++) {
		
			if(index!=0) {
				if(p[index-1]>a[i]) continue;
			}
			p[index]=a[i];
			dfs(begin+a[i]+" ",end,index+1);
			
		}
	}

}
