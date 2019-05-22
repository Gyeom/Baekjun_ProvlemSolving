package baekjun;

import java.util.Scanner;
import java.util.Stack;

public class Problem12906 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer>[] st =(Stack<Integer>[]) new Stack[4];
		for(int i=1; i<=3; i++) {
			st[i] = new Stack<Integer>();
		}
		for(int i=1; i<=3; i++) {
			int N = sc.nextInt();
			String s = sc.next();
			for(int j=0; j<N; j++) {
				if(s.charAt(j)=='A') {
					st[i].push(1);
				}else if(s.charAt(j)=='B') {
					st[i].push(2);
				}else {
					st[i].push(3);
				}
			}
		}
		
		for(int i=1; i<=3; i++) {
			
		}
		
		
	}

}
