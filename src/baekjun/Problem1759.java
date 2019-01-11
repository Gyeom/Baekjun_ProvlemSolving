package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1759 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int C = sc.nextInt();
		String[] a = new String[C];
		for(int i=0; i<C; i++) {
			a[i]=sc.next();
		}
		Arrays.sort(a);
		
		dfs("",L,0,a);
		
		
	}

	public static void dfs(String begin, int end, int index, String[] a) {
		// TODO Auto-generated method stub
		if(begin.length()==end) {
			if(check(begin)) {
			System.out.println(begin);
			}
			return;
		}
		if(index==a.length) {
			return;
		}
		
		dfs(begin+a[index],end,index+1,a);
		dfs(begin, end, index+1, a);
		
	}

	private static boolean check(String begin) {
		// TODO Auto-generated method stub
		int xCount=0;
		int yCount=0;
		for(int i=0; i<begin.length(); i++) {
			if(begin.charAt(i)=='i'||begin.charAt(i)=='a'||begin.charAt(i)=='o'||begin.charAt(i)=='u'||begin.charAt(i)=='e') {
				yCount++;
			}else {
				xCount++;
			}
		}
		if(xCount<2||yCount<1) {
			return false;
		}
		return true;
		
		
	}

}
