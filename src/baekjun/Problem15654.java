package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem15654 {
	static int[] a;
	static boolean[] visited;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		StringBuilder s = new StringBuilder();
		Arrays.sort(a);
		
		dfs(s,M,0);
		
	}
	public static void dfs(StringBuilder s, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
		System.out.println(s);
			return;
		}
		
		for(int i=0; i<a.length; i++) {
			if(visited[i]==true) continue;
			visited[i]=true;
			int temp = a[i];
			dfs(s.append(temp+" "), end, index+1);
			s.deleteCharAt(s.length()-1);
			while(temp>0) {
			s.deleteCharAt(s.length()-1);	
			temp/=10;
			}
			
			visited[i]=false;
		}
		
		
	}

}
