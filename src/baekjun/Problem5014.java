package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem5014 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		int[] a = new int[F+1];
		int[] dist = new int[F+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		boolean[] visited = new boolean[F+1];
		visited[S]=true;
		boolean pass = false;
		while(!q.isEmpty()) {
			int now = q.remove();
			if(now==G) {
				System.out.println(dist[now]);
				pass =true;
				break;
			}
			for(int next : new int[] {now+U,now-D}) {
				if(next<1||next>F)continue;
				if(visited[next])continue;
				visited[next]=true;
				dist[next]=dist[now]+1;
				q.add(next);
			}
		}
		if(!pass) {
			System.out.println("use the stairs");
		}
	}
}
