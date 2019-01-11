	package baekjun;
	
	import java.util.Scanner;
	
	public class Problem6603 {
		
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			
			
			do {
				int N = sc.nextInt();
				int[] a = new int[N];
				int[] s = new int[N];
				if(N==0) { break;}	
			for(int i=0; i<N; i++) {
				s[i] = sc.nextInt();
			}
			for(int i=6; i<N; i++) {
				a[i]=1;
			}
		
			
			do {
				for(int i=0; i<N; i++) {
					if(a[i]==0) {
						System.out.print(s[i]+" ");
					}
				}
				
				System.out.println();
			}while(next_permutation(a));
System.out.println();
			}while(true);
			
		}
		
		public static boolean next_permutation(int[] a) {
			// TODO Auto-generated method stub
	
	
			int i = a.length-1;
			while (i > 0 && a[i-1] >= a[i]) {
				i -= 1;
			}
	
			if (i <= 0) {
				return false;
			}
	
			int j = a.length-1;
			while (a[j] <= a[i-1]) {
				j -= 1;
			}
	
			int temp = a[i-1];
			a[i-1] = a[j];
			a[j] = temp;
	
			j = a.length-1;
			while (i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i += 1;
				j -= 1;
			}
			return true;
	
		}
	
	}
	
	
	
	
	
