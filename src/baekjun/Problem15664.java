package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem15664 {
	static int[] a;
	static int[] s;
	static ArrayList<Integer> p;
	static StringBuilder sb;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a= new int[N];
		p = new ArrayList<>();
		s= new int[M];
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
			p.add(a[i]);
		}
		Arrays.sort(a);
		dfs("",M, 0);
		System.out.println(sb);
	}
	private static void dfs(String begin, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(sb.indexOf(begin)<0) {
			sb.append(begin+"\n");
			}
			return;
		}

		for(int i=0; i<a.length; i++) {
			if(!p.contains(a[i])) continue;
			if(index!=0) {
				if(s[index-1]>a[i]) continue;
			}
			s[index]=a[i];
			p.remove(p.lastIndexOf(a[i]));
			dfs(begin+a[i]+" ",end,index+1);
			p.add(a[i]);

		}
	}
}
