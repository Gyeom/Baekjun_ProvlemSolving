package baekjun;

import java.util.Scanner;

public class Problem11058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] D = new long[N+1];
		for(int i=1; i<=N; i++) {
			D[i]=D[i-1]+1;
			for(int j=3; j<i; j++) {
				D[i]=Math.max(D[i], D[i-j]*(j-1));
			}
		}
		System.out.println(D[N]);
	}
}
