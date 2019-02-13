package baekjun;

import java.util.Scanner;

public class Problem1644 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] a= new boolean[N+1];
		int[] p = new int[N+1];
		int index=0;
		for(int i=2; i*i<=N; i++) {
			if(a[i]) continue;
			for(int j=i+i; j<=N; j+=i) {
				a[j]=true;
			}
		}
		for(int i=2; i<=N; i++) {
			if(a[i]) continue;
			p[index++] = i;
		}
		int sum=0;
		int left=0;
		int count=0;
		for(int i=0; i<index; i++) {
			sum+=p[i];
			if(sum<N) continue;
			if(sum>N) {
				while(sum>N) {
					sum-=p[left++];	
				}
			}
			if(sum==N) {
				count++;
			}
		}
		System.out.println(count);
	}
}
