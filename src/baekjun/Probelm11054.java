package baekjun;
import java.util.Scanner;

public class Probelm11054 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] dpl = new int[N];
		int[] dpr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			dpl[i] = 1;
			dpr[i] = 1;
		}

		int p=0;
		int ans=0;
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(a[i]>a[j]&&dpl[i]<dpl[j]+1) {
					dpl[i]=dpl[j]+1;
					if(dpl[i]>ans) {
						ans=dpl[i];
						p = i;
					}
				}
			}
		}
		int ans2=0;
		int q=0;
		for(int i=p+1; i<N; i++) {
			for(int j=p; j<i; j++) {
				if(a[i]<a[j]&&dpr[i]<dpr[j]+1) {
					dpr[i]=dpr[j]+1;
					if(dpr[i]>ans2) {
						q = i;
					}
				}
			}
		}
		System.out.println(dpr[q]+dpl[p]-1);		
	}
}

