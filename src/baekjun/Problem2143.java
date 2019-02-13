package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2143 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int[] a = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] b = new int[M];
		for(int i=0; i<M; i++) {
			b[i] = sc.nextInt();
		}
		int[] A = new int[(N*(N+1))/2];
		int[] B = new int[(M*(M+1))/2];
		for(int i=0,index =0; i<N; i++) {
			int sum=0;
			for(int j=i; j<N; j++,index++) {
				sum+=a[j];
				A[index]=sum;
			}
		}
		
		for(int i=0,index =0; i<M; i++) {
			int sum=0;
			for(int j=i; j<M; j++,index++) {
				sum+=b[j];
				B[index]=sum;
			}
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int i=0;
		int j=B.length-1;
		long ans=0;
		while(i<A.length&&j>=0) {
			if(A[i]+B[j]==T) {
				i++;
				j--;
				long acount=1;
				long bcount=1;
				while(i<A.length&&(A[i]==A[i-1])) {
					i++;
					acount++;
				}
				while(j>=0&&(B[j]==B[j+1])) {
					j--;
					bcount++;
				}
				ans+=acount*bcount;	
			}else if(A[i]+B[j]>T) {
				j--;
			}else {
				i++;
			}
		}
		
		System.out.println(ans);
		
	}

}
