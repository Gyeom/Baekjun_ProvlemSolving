package SWmaestro;

import java.util.Scanner;
public class Problem11653 {

	//���μ����� ���ϱ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=2; i<=N; i++) {
			while(N%i==0) {
				N=N/i;
				System.out.println(i);
				if(N==1) break;
			}
		}
	}
}
