package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14889_R {
	static int N;
	static int ans;
	static boolean[] way;
	static int[][] startlink;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		startlink = new int[N+1][N+1];
		way = new boolean[N+1];
		ans=Integer.MAX_VALUE;

		for(int i=1; i<=N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				startlink[i][j]=Integer.parseInt(s[j-1]);
			}
		}
		dfs(1,N/2+1,1);
		System.out.println(ans);
	}
	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		if(ans==0) {
			return;
		}
		if(index==end) {
			int start=0;
			int link=0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(way[i]!=way[j]) continue;
					if(way[i]&&way[j]) {
						start+=startlink[i][j];	
					}else {
						link+=startlink[i][j];
					}
				}
			}
			int sum = Math.abs(start-link);
			if(sum<ans) {
				ans=sum;
			}
			return;
		}
		for(int i=num; i<=N; i++) {
			way[i]=true;
			dfs(i+1,end,index+1);
			way[i]=false;
		}
	}
}
