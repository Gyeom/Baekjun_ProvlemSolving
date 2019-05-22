package baekjun;

import java.util.Scanner;

public class Problem12865 {

	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for(int i=1; i<=N; i++) {
			W[i]=sc.nextInt();
			V[i]=sc.nextInt();
		}
		int[][] d = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				d[i][j]=d[i-1][j];
				if(j-W[i]<0) continue;
				d[i][j]=Math.max(d[i][j], d[i-1][j-W[i]]+V[i]);
			}
		}
		System.out.println(d[N][K]);
	}
}
