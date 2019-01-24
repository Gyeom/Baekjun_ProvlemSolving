package baekjun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem13549 {
	public static final int MAX = 100000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int dist[] = new int[MAX+1];
		boolean[] visited = new boolean[MAX+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		visited[N]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : new int[] {now*2,now-1,now+1}) {
				if(next>MAX||next<0) continue;
				if(visited[next]) continue;
				visited[next]=true;
				if(next==now*2) {
					q.addFirst(next);
					dist[next]=dist[now];
				}else {
					q.addLast(next);
					dist[next]=dist[now]+1;
				}
			}
			
		}
		System.out.println(dist[K]);
	}

}
