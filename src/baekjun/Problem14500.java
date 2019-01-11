package baekjun;

import java.util.Scanner;

public class Problem14500 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] a = new int[N+1];
		
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		nextpermutation(a);
		
	}
	

	
	static void nextpermutation(int a[]) {
		// TODO Auto-generated method stub

		for(int i=a.length-1; i>=0; i--) {
				if(a[i-1]<a[i]) {
					
				}
			
		}
	}
}
