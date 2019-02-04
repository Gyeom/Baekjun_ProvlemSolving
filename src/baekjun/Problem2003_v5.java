package baekjun;

import java.util.Scanner;
public class Problem2003_v5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) a[i]=sc.nextInt();
		int sum=0, left =0 ,count=0;
		for(int i=0; i<N; i++) {
			sum+=a[i];
			if(sum<M) continue;
			if(sum>M) while(sum>M) sum-=a[left++];
			if(sum==M) count++; continue;
		}
		System.out.println(count);
	}
}
