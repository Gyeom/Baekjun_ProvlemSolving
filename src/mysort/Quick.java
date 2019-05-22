package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Quick {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		
		sort(0,N-1,a);
		System.out.println(Arrays.toString(a));
		
		

	}
	private static void sort(int l, int r, int[] a) {
		// TODO Auto-generated method stub
		int left = l;
		int right = r;
		int pivot = a[(left+right)/2];
		do {
			while(pivot<a[right])right--;
			while(pivot>a[left])left++;
			if(left<=right) {
				int temp = a[right];
				a[right]= a[left];
				a[left] =temp;
				right--;
				left++;
			}
		
		}while(left<=right);
		if(l<right)sort(l,right,a);
		if(r>left)sort(left,r,a);
	}

	
	
//	private static void sort(int l, int r, int[] a) {
//		// TODO Auto-generated method stub
//		
//		int left = l;
//		int right = r;
//		int pivot = a[(left+right)/2];
//		
//		do {
//			while(a[left]<pivot) left++;
//			while(a[right]>pivot) right--;
//			if(left<=right) {
//				int temp = a[right];
//				a[right]= a[left];
//				a[left] = temp;
//				right--;
//				left++;
//			}
//			
//		}while(left<=right);
//		if(l<right)sort(l,right,a);
//		if(r>left) sort(left,r,a);
//	}

}
