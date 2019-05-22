package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
		}
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		for(int i=a.length-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
			}
		}
		
//		for(int i=a.length-1; i>=0; i--) {
//			for(int j=0; j<i; j++) {
//				if(a[j]>a[j+1]) {
//					int temp = a[j];
//					a[j]=a[j+1];
//					a[j+1]=temp;
//				}
//			}
//		}
	}

}
