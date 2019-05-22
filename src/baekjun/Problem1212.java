package baekjun;

import java.util.Scanner;

public class Problem1212 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			sb.append("000");
			sb.delete(sb.length()-Integer.toBinaryString(s.charAt(i)-'0').length(), sb.length());
			sb.append(Integer.toBinaryString(s.charAt(i)-'0'));
		}
		String ans = sb.toString();
		int idx=-1;
		for(int i=0; i<ans.length(); i++) {
			if(ans.charAt(i)-'0'==0) {
				idx++;
			}else {
				break;
			}
		}
		
		if(idx==-1) {
			System.out.println(ans);
		}else {
			String temp = ans.substring(idx+1);
			if(temp.length()==0) {
				System.out.println(ans.substring(idx+1)+"0");
			}else {
				System.out.println(ans.substring(idx+1));
			}
		}
	}
}
