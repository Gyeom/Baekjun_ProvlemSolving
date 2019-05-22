package mysort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
	
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
//	for(int i=0; i<a.length-1; i++) {
//		int min = i;
//		for(int j=i+1; j<a.length; j++) {
//			if(a[min]>a[j]) {
//				min=j;
//			}
//		}
//		int temp = a[min];
//		a[min] = a[i];
//		a[i]= temp;
//	}
		
	
		for(int i=0; i<a.length-1; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			int temp = a[i];
			a[i]= a[min];
			a[min] = temp;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0; i<a.length-1; i++) {
//			int min=i;
//			for(int j=i+1; j<a.length; j++) {
//				if(a[min]>a[j]) {
//					min=j;
//				}
//			}
//			int temp = a[i];
//			a[i] = a[min];
//			a[min] = temp;
//		}
	}

}
