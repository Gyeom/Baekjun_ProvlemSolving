package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2309 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		int sum = 0;
		for(int i=1; i<=9; i++) {
			a[i] = sc.nextInt();
			sum+= a[i];
		}
		
		label:
		for(int i=1; i<=8; i++) {
			for(int j=i+1; j<=9; j++) {
				if(a[i]+a[j]==sum-100) {
					a[i]=0; a[j]=0;
					break label;
				}
			}
		}
		
		Arrays.sort(a);
		for(int i=3; i<a.length; i++ ) {
			System.out.println(a[i]);
		}
		
	}
	
	
}



// <백준 답안>
//import java.util.*;
//public class Main {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int n = 9;
// int[] a = new int[n];
// int sum = 0;
// for (int i=0; i<n; i++) {
// a[i] = sc.nextInt();
// sum += a[i];
// }
// Arrays.sort(a);
// for (int i=0; i<n; i++) {
// for (int j=i+1; j<n; j++) {
// if (sum - a[i] - a[j] == 100) {
// for (int k=0; k<n; k++) {
// if (i == k || j == k) continue;
// System.out.println(a[k]);
// }
// System.exit(0);
// }
// }
// }
// }
//}
