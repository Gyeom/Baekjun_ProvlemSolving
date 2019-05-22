package mysort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Quick2 {

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
		Stack<Integer> lstack = new Stack<Integer>();
		Stack<Integer> rstack = new Stack<Integer>();

		lstack.push(l);
		rstack.push(r);

		while(!lstack.isEmpty()) {
			int pl = l = lstack.pop();
			int pr = r = rstack.pop();
			int x = a[(l+r)/2];
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl<=pr) {
					int temp = a[pl];
					a[pl] = a[pr];
					a[pr] = temp;
					pl++;
					pr--;
				}
			}while(pl<=pr);
	
			if(l<pr) {
				lstack.push(l);
				rstack.push(pr);
			}
			if(pl<r) {
				lstack.push(pl);
				rstack.push(r);
			}
		}
	}
}