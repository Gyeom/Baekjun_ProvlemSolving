package baekjun;

import java.util.Scanner;

public class Problem2003 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		int count =0;

		String s;
		String ss;
		for(int i=0; i<(1<<N); i++) {
			//			int sum=0;
			s = Integer.toBinaryString(i);
			ss =s.substring(0, s.lastIndexOf("1")+1).trim();
			for(int j=s.length(); j<N; j++) {
				s= "0"+s;
			}

			if(!ss.contains("0")&&!ss.equals("")) {
				int num=0;

				for(int j=0; j<s.length(); j++) {
					if(s.charAt(j)=='0') continue;
					num+=a[j];

				}
				if(num==M) {
					count++;
				}

			}
			//			for(int j=0; j<a.length; j++) {
			//				if((i&(1<<j))>0) {}
			//			}
			//			if(sum==M) {
			//				count++;
			//			}
		}			
		System.out.println(count);


	}

}

