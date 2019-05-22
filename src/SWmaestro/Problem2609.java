package SWmaestro;

import java.util.Scanner;


//최대공약수,공배수 유클리드 호제법
public class Problem2609 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int TC= sc.nextInt();
		for(int i=1; i<=TC; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int tempA = A;
			int tempB = B;
			if(B>A) {
				B=tempA;
				A=tempB;
			}
			int r=1;

			while(r>0) {
				r= A%B	;
				A=B;
				B=r;
			}
			System.out.println(tempA*tempB/A);
		}
	}
}
