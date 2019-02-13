package baekjun;
import java.util.Arrays;
import java.util.Scanner;

public class Problem7453 {
	static int count=0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
			b[i]= sc.nextInt();
			c[i]= sc.nextInt();
			d[i]= sc.nextInt();
		}
		
		
		int[] AB= new int[N*N];
		int[] CD= new int[N*N];

		for(int i=0, index=0; i<N; i++) {
			for(int j=0; j<N; j++,index++) {
				AB[index]=a[i]+b[j];
				CD[index]=c[i]+d[j];
			}
		}
		
		Arrays.sort(CD);
		long ans=0;
		for(int i=0; i<AB.length; i++) {
			int lower = lower_bound(-AB[i],CD);
            int upper = upper_bound(-AB[i],CD);
            ans += upper - lower;
		}
		System.out.println(ans);
	}
	private static int upper_bound(int value, int[] CD) {
		// TODO Auto-generated method stub
		int left=0;
		int right=CD.length;
	
		while(left<right) {
			int mid=(left+right)/2;
			if(CD[mid]<=value) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return left;
	}
	private static int lower_bound(int value,int[] CD) {
		// TODO Auto-generated method stub
		int left=0;
		int right=CD.length;
	
		while(left<right) {
			int mid=(left+right)/2;
			if(CD[mid]<value) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return left;
	}

	
	

}
