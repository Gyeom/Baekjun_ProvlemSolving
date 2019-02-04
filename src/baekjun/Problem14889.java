package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem14889 {
	static int[] p;
	static boolean[] visited;
	static int[][] a;
	static int ans =2000;
	static ArrayList<Integer> start;
	static ArrayList<Integer> link;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		a = new int[N+1][N+1];
		visited = new boolean[N+1];
		p = new int[N+1];
		start = new ArrayList<>();
		link = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0,N/2,0);
		System.out.println(ans);
	}

	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
	
		if(index==end) {
//			System.out.println(Arrays.toString(p));
			int startSum=0;
			int linkSum=0;
			for(int i=1; i<=2*end; i++) {
				if(p[i]==0) {
					for(int j=0; j<start.size(); j++) {
						startSum += a[start.get(j)][i];
						startSum += a[i][start.get(j)];
					}
					start.add(i);
				}else {
					for(int j=0; j<link.size(); j++) {
						linkSum += a[link.get(j)][i];
						linkSum += a[i][link.get(j)];
					}
					link.add(i);
				}
			}
			if(Math.abs(startSum-linkSum)<ans) {
				ans= Math.abs(startSum-linkSum);
			}
			start.clear();
			link.clear();
			return;
		}
		if(num>=2*end) {
			return;
		}
		
//		for(int i=1; i<=2*end; i++) {
//			if(visited[i]) continue;
//			visited[i]=true;
//			p[i]=1;
//			dfs(i,end,index+1);
//			p[i]=0;
//			visited[i]=false;
//		}
		p[num+1]=1;
		dfs(num+1,end,index+1);
		p[num+1]=0;
		dfs(num+1,end,index);
	}

}
