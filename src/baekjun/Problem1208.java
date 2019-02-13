package baekjun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class Problem1208 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] a= new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		int M = N/2;

		int[] L = new int[(1<<M)];
		int[] R = new int[(1<<(N-M))];
		//		Integer[] R = new Integer[(1<<(N-M))];
		for(int i=0; i<(1<<M); i++) {
			for(int j=0; j<M; j++) {
				if((i&(1<<j))>0) {
					L[i]+=a[j];
				}
			}
		}
		for(int i=0; i<(1<<(N-M)); i++) {
			R[i]= new Integer(0);
			for(int j=M; j<N; j++) {
				if((i&(1<<(j-M)))>0) {
					R[i]= new Integer(R[i]+a[j]);
				}
			}
		}
		Arrays.sort(L);
		//		Arrays.sort(R, Collections.reverseOrder());
		Arrays.sort(R);

		int pl=0;
		int pr=R.length-1;
		long count=0;
		while(pl<L.length&&pr>=0) {
			if(L[pl]+R[pr]==S) {
				long lcount=1;
				long rcount=1;
				pl++;
				pr--;
				while(pl<L.length&&L[pl]==L[pl-1]) {
					pl++;
					lcount++;
				}
				while(pr>=0&&R[pr]==R[pr+1]) {
					pr--;
					rcount++;
				}
				count+=lcount*rcount;
			}else if(L[pl]+R[pr]>S) {
				pr--;
			}else {
				pl++;
			}
		}
		 if (S == 0) count -= 1;
		System.out.println(count);
	}
}
