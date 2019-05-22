package baekjun;

import java.util.Scanner;

public class Problem11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] value = new int[N];
		for(int i=0; i<N; i++) {
			value[i] = sc.nextInt();
		}
		int ans=0;
		for(int i=N-1; i>=0; i--) {
			int count=0;
			count+=K/value[i];
			K-=count*value[i];
			ans+=count;
		}
		System.out.println(ans);
	}
}
