package baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem12851 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int dist[] = new int[(N > K ? 2*N+1 : 2*K+1) > 100001 ? 100001 : (N > K ? 2*N+1 : 2*K+1)];
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dist, 100001);
		q.add(N);
		dist[N]=0;
		
		int d =100001;
		int count =0;
		while(!q.isEmpty()) {
			int p = q.remove();
			if(p==K) {
				if(dist[p]<d) {
					d =dist[p];
					count =1;
				}else if(dist[p]==d) {
					count++;
				}
			}
			for(int r : new int[] {p+1,p-1,p*2}) {
				if(r<0||r>=dist.length||(((r>2*K)&&(N<K)))||((N>K)&&(r<K/2))) continue;
				if(dist[r]<dist[p]+1) continue;
				dist[r]=dist[p]+1;
				q.add(r);
			}
		
		}
		System.out.println(d);
		System.out.println(count);
		
	}
}