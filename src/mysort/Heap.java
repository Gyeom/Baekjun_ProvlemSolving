package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
	public static void main(String args[]) {
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
		for(int i=1; i<a.length; i++) {
			int c= i;
			do {
				int root = (c-1)/2;
				if(a[root]<a[c]) {
					int temp = a[c];
					a[c] = a[root];
					a[root] = temp;
				}
				c= root;
			}while(c!=0);
		}
		for(int i= a.length-1; i>=0; i--) {
			int temp = a[i];
			a[i]= a[0];
			a[0]= temp;
			int root = 0;
			int c=1;
			do {
				c = root*2+1;
				if(c+1<i&&a[c]<a[c+1]) {
					c++;
				}
				if(c<i&&a[c]>a[root]) {
					temp = a[root];
					a[root]=a[c];
					a[c]=temp;
				}
				root = c;
			}while(c<i);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		for(int i=1; i<a.length; i++) {
//			int c = i;
//			do {
//				int root = (c-1)/2;
//				if(a[root]<a[c]){
//					int temp = a[root];
//					a[root] = a[c];
//					a[c] = temp;
//				}
//				c = root;
//			}while(c!=0);
//		}
//		for(int i=a.length-1; i>=0; i--) {
//			int temp = a[i];
//			a[i]=a[0];
//			a[0]=temp;
//			int c= 1;
//			int root = 0;
//			do {
//				c= 2*root+1;
//				if(c+1<i&&a[c]<a[c+1]) {
//					c++;
//				}
//				if(c<i&&a[c]>a[root]) {
//					temp = a[c];
//					a[c] =a[root];
//					a[root] = temp;
//				}
//				root = c;
//			}while(c<i);
//			
		}
















		//	
		//		for(int i=1; i<a.length; i++) {
		//			int c = i;
		//			do {
		//				int root = (c-1)/2;
		//				if(a[root]<a[c]) {
		//					int temp = a[c];
		//					a[c]= a[root];
		//					a[root]=temp;
		//				}
		//				c=root;
		//			}while(c!=0);
		//		}
		//		
		//		for(int i=a.length-1; i>=0; i--) {
		//			int temp = a[0];
		//			a[0] = a[i];
		//			a[i] = temp;
		//			int root = 0;
		//			int c = 1;
		//			do {
		//				c = root*2+1;	
		//				if(c+1<i&&a[c]<a[c+1]) {
		//					c++;
		//				}
		//				
		//				if(c<i&&a[c]>a[root]) {
		//					temp = a[c];
		//					a[c] = a[root];
		//					a[root] = temp;
		//				}
		//				root = c;
		//			}while(c<i);
		//		}
		//		

//	}

}
