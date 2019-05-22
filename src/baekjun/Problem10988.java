package baekjun;

import java.util.Scanner;

public class Problem10988 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		String s =sc.nextLine();
		sb.append(s);
		sb.reverse();
		if(s.equals(sb.toString())) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
}
