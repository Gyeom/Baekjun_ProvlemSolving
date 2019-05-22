package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9663_v3 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		
		
		int N= sc.nextInt();
		visited= new boolean[N];
		r = new int[N][N];
		l = new int[N][N];
		vr= new int[N];
		vl= new int[N];
		Arrays.fill(vr, 100);
		Arrays.fill(vl, 100);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				r[i][j]=i+j;
				l[i][j]=i-j;
			}
		}
		dfs(0,N,0);
		System.out.println(ans);
	}
	static boolean[] visited;
	static int[][] r, l;
	static int[] vr, vl;
	static int ans =0;
	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			ans++;
			return;
		}
		
		outloof:
		for(int i=0; i<end; i++) {
			if(visited[i]) continue;
			for(int j=0; j<end; j++) {
				if(r[index][i]==vr[j]) continue outloof;
				if(l[index][i]==vl[j]) continue outloof;
			}
			vr[index]=r[index][i];
			vl[index]=l[index][i];
			visited[i]=true;
			dfs(i,end,index+1);
			visited[i]=false;
			vr[index]=100;
			vl[index]=100;
		}
		
	}

}
