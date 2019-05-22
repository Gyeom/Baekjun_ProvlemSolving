package SAMSUNG;

import java.util.Scanner;

public class S14889 {

	static int[] way;
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		 map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		way = new int[N];
		dfs(0,N/2,0);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			int start=0;
			int link=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(way[i]==way[j]&&way[i]==1) start+=map[i][j];
					if(way[i]==way[j]&&way[i]==0) link+=map[i][j];
				}
			}
			int d = Math.abs(start-link);
			if(d<ans) {
				ans = d;
			}
		}
		for(int i=num; i<N; i++) {
			way[i]=1;
			dfs(i+1,end,index+1);
			way[i]=0;
		}
	}
}