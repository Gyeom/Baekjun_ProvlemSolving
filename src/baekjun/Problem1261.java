package baekjun;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Problem1261 {
	public static class Pair{
		int y;
		int x;
		public Pair(int y, int x)
		{
			this.y=y;
			this.x=x;
		}
		
	}
	static final int MAX = 10000;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
			int M = sc.nextInt();
			int N = sc.nextInt();
			boolean visited[][] = new boolean[N+1][M+1];
			int dist[][] = new int[N+1][M+1];
			int ans=0;
			
			int[][] a = new int[N+1][M+1];
			String s = sc.nextLine();
			for(int i=1; i<=N; i++) {
				s = sc.nextLine();
				for(int j=1; j<=M; j++) {
					a[i][j]=s.charAt(j-1)-'0';
				}
			}
			
			
			
			ArrayDeque<Pair> q = new ArrayDeque<>();
			Pair p = new Pair(1,1);
			q.add(p);
			visited[p.y][p.x]=true;
			
			label:
			while(!q.isEmpty()) {
				p = q.remove();
				
				
				for(int i=0; i<4; i++) {
					int ry= p.y+dy[i];
					int rx= p.x+dx[i];
					if(rx==M&&ry==N) {
						ans=dist[p.y][p.x];
						break label;
					}
					
					if(ry<1||rx<1||ry>N||rx>M) continue;
					if(visited[ry][rx]) continue;
					if(a[ry][rx]==0) {
					q.addFirst(new Pair(ry,rx));
					dist[ry][rx]=dist[p.y][p.x];
					}else {
					q.addLast(new Pair(ry,rx));
					dist[ry][rx]=dist[p.y][p.x]+1;
					}
					visited[ry][rx]=true;
					
					
					}
				
			}
			
			System.out.println(ans);
			
			
	}

}
