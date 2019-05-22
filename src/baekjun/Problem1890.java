package baekjun;

import java.util.Scanner;

public class Problem1890 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] a= new long[N][N];
		long[][] d= new long[N][N];
		d[0][0]=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(a[i][j]==0) continue;
				if(d[i][j]==0) continue;
				if(i+a[i][j]<N) {
					d[(int) (i+a[i][j])][j]+=d[i][j];
				}
				if(j+a[i][j]<N) {
					d[i][(int) (j+a[i][j])]+=d[i][j];
				}
			}
		}
		System.out.println(d[N-1][N-1]);
	}
}
