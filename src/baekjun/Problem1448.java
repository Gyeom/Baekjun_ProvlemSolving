package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1448 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N =sc.nextInt();
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		int ans = 0;
		Arrays.sort(num);
		for(int i=N-1; i>1; i--) {
			if(num[i]>=num[i-1]+num[i-2]) continue;
			System.out.println(ans=num[i]+num[i-1]+num[i-2]);
			break;
		}
		if(ans==0) {
			System.out.println("-1");
		}
	}
}
