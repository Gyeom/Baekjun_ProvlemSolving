package baekjun;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem1697 {

	static final int MAX = 100000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int dist[] = new int[MAX+1];
		boolean visited[] = new boolean[MAX+1];
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		visited[N]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : new int[] {now-1,now+1,now*2}) {
				if(next<0||next>MAX) continue;
				if(visited[next]) continue;
				visited[next]=true;
					q.add(next);
					dist[next]=dist[now]+1;
			}
		}
		
		System.out.println(dist[M]);
	}

}
