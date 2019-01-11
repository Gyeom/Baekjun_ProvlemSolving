package baekjun;

import java.util.Scanner;

public class Problem15652 {
	static int N;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder s = new StringBuilder();
		dfs(s,M,0);
	}

	public static void dfs(StringBuilder S, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			System.out.println(S);
			return;
		}
		
		
		for(int i=1; i<N+1; i++) {
			if(index!=0) {
			if(i<S.charAt(S.length()-2)-'0') continue;
			}
			S.append(i+" ");
			dfs(S, end, index+1);
			S.deleteCharAt(S.length()-1);
			S.deleteCharAt(S.length()-1);

		}
		
	}

}
