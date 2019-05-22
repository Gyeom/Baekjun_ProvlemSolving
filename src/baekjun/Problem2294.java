package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2294 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[K+1];
		Arrays.fill(d, K+1);
		d[0]=0;
		for(int i=1; i<=K; i++) {
			for(int j=0; j<N; j++) {
				if(i-a[j]<0) continue;
				if(d[i-a[j]]+1>=d[i]) continue;
				d[i]=d[i-a[j]]+1;
			}
		}
		
		
		if(d[K]==K+1) {
			System.out.println("-1");
		}else {
			System.out.println(d[K]);
		}
	}
}