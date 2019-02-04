package baekjun;

import java.util.Scanner;

public class Problem1806{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] a = new int[N];
		int left=0, sum=0, length=0;
		int ans=100000000;
		for(int i=0; i<N; i++) a[i]= sc.nextInt();
		for(int i=0; i<N; i++) {
			sum+=a[i];
			length++;
			if(sum<S) continue;
			if(sum>=S) {
				while(sum>=S) {
					if(length<ans) {
						ans=length;
					}
					sum-=a[left++];
					length--;
				}
			}
		}
		if(ans==100000000) ans=0;
		System.out.println(ans);
	}
}