package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		sort(arr);
	}
	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		for(int i=1; i<arr.length; i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(a[root]<a[c]) {
					int temp = a[root];
					a[root]=a[c];
					a[c]=temp;
				}
				c= root;
			}while(c!=0);
		}
		
		for(int i=a.length-1; i>=0; i--) {
			int temp = a[i];
			a[i]=a[0];
			a[0]=temp;
			int root = 0;
			int c = 1;
			do {
				c=root*2+1;
				if(c+1<i&&a[c]>a[c+1]) {
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
	}
}