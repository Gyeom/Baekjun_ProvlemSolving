package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Shell {

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
		
		int h;
		for(h=1; h<a.length/9; h=h*3+1);
		
		for(; h>0; h/=2) {
			for(int i=h; i<a.length; i++) {
				int j;
				int tmp = a[i];
				for(j= i-h; j>=0 && a[j]>tmp; j-=h) {
					a[j+h]=a[j];
				}
				a[j+h]=tmp;
			}
		}
	}
}