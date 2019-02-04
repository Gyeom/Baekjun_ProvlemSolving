package baekjun;

import java.util.Scanner;

public class Problem12100 {
	static int[][] a;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		a = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				a[i][j]= sc.nextInt();
			}
		}
	}
	
	

}
