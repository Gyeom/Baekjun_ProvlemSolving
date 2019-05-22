package baekjun;

import java.util.Scanner;

public class Problem2293 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] a = new int[N];
		int[] d = new int[K+1];
		for(int i=0; i<a.length; i++) {
			a[i]=sc.nextInt();
		}
		d[0]=1;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<=K; j++ ) {
				if(j-a[i]<0) continue;
				System.out.print(j+":"+d[j-a[i]]+" ");
				d[j]+=d[j-a[i]];
			}
			System.out.println();
		}
		System.out.println(d[K]);
	}
}
