package baekjun;

import java.util.Scanner;

public class Problem6064_v2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int x=1;
			int y=1;
			int count=1;
			boolean go=true;

			do {
				if(x==X&&y==Y) {
					go=false;
					break;
				}
				if(x==X) {
					break;
				}
				x++;
				y++;
				if(y>N) {
					y=1;
				}
				count++;
			}while(x!=X);
			int start =y;
			if(go) {
				do {
					if(x==X&&y==Y) {
						break;
					}
					y+=(M-N)%N;
					if(y<=0) {

						y=N-(Math.abs(y));

					}
					if(y>N) {
						y=y-N;

					}
					count+=M;
				}while(y!=start);
			}
			if(x==X&&y==Y) {
				System.out.println(count);
			}else {
				System.out.println("-1");
			}
		}
	}
}
