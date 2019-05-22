package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		sort(a);
		System.out.println(Arrays.toString(a));
	}


		
		
		
		
		
		
		
		
		
		
//		for(int i=1; i<a.length; i++) {
//			int r =a[i];
//			int j;
//			for(j=i-1; j>=0; j--) {
//				if(a[j]<=r) break;
//				a[j+1]=a[j];
//			}
//			
//			a[j+1]=r;
//			
//		}

	
	
	
	
	
	
	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		
//		int j=0;
//		for(int i=1; i<a.length; i++) {
//			int temp = a[i];
//			for(j=i-1; j>=0; j--) {
//				if(a[j]<temp) break;
//				a[j+1]=a[j];
//			}
//			a[j+1]=temp;
//		}
		
		
		
		
		
		
		
		int j=0;
		for(int i=1; i<a.length; i++) {
			int temp = a[i];
			for(j=i-1; j>=0; j--) {
				if(a[j]<temp) break;
				a[j+1]=a[j];
			}
			a[j+1]=temp;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int j=0;
//		for(int i = 1; i < a.length; i++){
//			int temp = a[i];
//			for(j=i-1; j>=0; j--){
//				if(temp>=a[j]) break; 
//				a[j+1] = a[j];
//			}
//			a[j+1] = temp;
//		}
	}
}
