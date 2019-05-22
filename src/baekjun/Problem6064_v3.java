package baekjun;

import java.util.Scanner;

public class Problem6064_v3 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();		
			boolean pass=false;
			for(int i=X; i<=M*N; i+=M) {
				int temp = i%N;
				if(temp==0) {
					temp=N;
				}
				if(temp==Y) {
					System.out.println(i);
					pass=true;
					break;
				}
			}
			if(!pass) {
				System.out.println("-1");
			}
		}
	}
}