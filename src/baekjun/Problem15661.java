package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem15661 {

	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] a= new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		int[] bit = new int[N+1];
		int ans = 2000;
		for(int i=1; i<(1<<N)-1;i++) {
			Arrays.fill(bit, 0);
			int start=0,link=0;
			for(int j=0; j<N; j++) {
				if(((1<<j)&i)>0) {
					bit[j+1]=1;
				}
			}
			for(int ii=1; ii<=N; ii++) {
				for(int jj=1; jj<=N; jj++) {
					if(ii==jj) continue;
					if(bit[ii]!=bit[jj])continue;
					if(bit[ii]==1&&bit[jj]==1) {
						start+=a[ii][jj];
					}else if(bit[ii]==0&&bit[jj]==0) {
						link+=a[ii][jj];
					}
				}
				
			}
			int val = Math.abs(start-link);
			if(val<ans) {
				ans=val;
			}
			
		}
		System.out.println(ans);
	}
}
