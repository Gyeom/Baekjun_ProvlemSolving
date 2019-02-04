package baekjun;

import java.util.Scanner;

public class Problem2003_v3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		int index=0;
		int[] p = new int[27483084];
		for(int i=0; i<N; i++) {
			a[i]= sc.nextInt();
		}
		int count=0;
		int s= (1<<N)-1;
//		al.add(s);
		p[index++]=s;
		for(int i=0; i<N-1; i++) {
			s&=~(1<<i);
//			al.add(s);
			p[index++]=s;
			for(int j=0; j<=i; j++) {
//				al.add(s>>(j+1));
				p[index++]=(s>>(j+1));
			}
		}
		for(int i=0; i<p.length; i++) {
			if(p[i]==0) break;
			int sum=0;
			for(int j=0; j<N; j++) {
				if((p[i]&(1<<j))>0) {
					sum+=a[j];
				}
			}
			if(sum==M) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}

}
