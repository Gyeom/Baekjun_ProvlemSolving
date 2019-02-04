package baekjun;

import java.util.Scanner;

public class Problem14391 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] a= new int[N+1][M+1];
		int[] rowSum;
		int[] colSum;
		for(int i=1; i<=N; i++) {
			String s = sc.next();
			for(int j=1; j<=M; j++) {
				a[i][j]= s.charAt(j-1)-'0';
			}
		}

		int ans = 0;
		for(int i=0; i<(1<<N*M); i++) {

			rowSum= new int[N+1];
			colSum= new int[M+1];
			int sum=0;
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=M; k++) {
					if(((1<<(M*(j-1)+(k-1)))&i)!=0) {
						colSum[k]=a[j][k]+colSum[k]*10;
						sum+=rowSum[j];
						rowSum[j]=0;
					}else {
						rowSum[j]=a[j][k]+rowSum[j]*10;
						sum+=colSum[k];
						colSum[k]=0;
					}
				}
			}
			int colSums=0;
			int rowSums=0;
			for(int j=1; j<=N; j++) {
				rowSums+=rowSum[j];
			}
			for(int j=1; j<=M; j++) {
				colSums+=colSum[j];
			}
		    sum+=colSums+rowSums;
			if(sum>ans) {
				ans = sum;
			}
		}
		System.out.println(ans);
	}

}
