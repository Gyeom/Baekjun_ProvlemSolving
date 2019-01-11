package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10971 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] s = new int[N][N];
		int[] a = new int[N];
		int ans=4000000;
		for(int i=0; i<N; i++) {
			a[i]=i+1;
			for(int j=0; j<N; j++) {
				s[i][j]=sc.nextInt();
			}
		}

		do {
			int sum=0;
			boolean ok= true;
			for(int i=0; i<N; i++) {
				

				if(i==N-1) {
					if(s[a[i]-1][a[0]-1]==0) {
						ok=false;
						break;
					}
					sum += s[a[i]-1][a[0]-1];
				}else {
					if(s[a[i]-1][a[i+1]-1]==0) {
						ok=false;
						break;	
					}
					sum += s[a[i]-1][a[i+1]-1];					
				}

			}
			if(sum<ans&&ok) {
				ans = sum;
			}

		}while(next_permutation(a));


		System.out.println(ans);

	}

	public static boolean next_permutation(int[] a) {
		// TODO Auto-generated method stub


		int i = a.length-1;
		while (i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}

		if (i <= 0) {
			return false;
		}

		int j = a.length-1;
		while (a[j] <= a[i-1]) {
			j -= 1;
		}

		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;

		j = a.length-1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;

	}
}