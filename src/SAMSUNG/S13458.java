package SAMSUNG;

import java.util.Scanner;

public class S13458 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] room = new int[N];
		for(int i=0; i<N; i++) {
			int A = sc.nextInt();
			room[i]=A;
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		long count=0;
		for(int i=0; i<N; i++) {
			long num = room[i]-B<=0?1:((room[i]-B)%C==0?(1+(room[i]-B)/C):(2+(room[i]-B)/C));
			count+=num;
		}
		System.out.println(count);
	}

}
