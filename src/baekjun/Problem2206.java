package baekjun;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem2206 {
	
	public static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] a = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		boolean SUCCESS = false;
		int[][] one = new int[N+1][M+1];
		int[][] dist = new int[N+1][M+1];
		String s = sc.nextLine();
		for(int i=1; i<=N; i++) {
			s = sc.nextLine();
			for(int j=1; j<=M; j++) {
				a[i][j]= s.charAt(j-1)-'0';
			}
		}
		
		ArrayDeque<Pair> q = new ArrayDeque<>();
		Pair p = new Pair(1,1);
		q.add(p);
		visited[p.y][p.x]=true;
		dist[p.y][p.x]=1;
		
		label:
		while(!q.isEmpty()) {
			p = q.remove();
			
			if(p.y==N&&p.x==M) {
				SUCCESS = true;
				break label;
			}
		
			for(int i=0; i<4; i++) {
				int rx = p.x+dx[i];
				int ry = p.y+dy[i];
				
				if(rx<1||ry<1||rx>M||ry>N) continue;
				if(visited[ry][rx]) continue;
				if(a[ry][rx]==0) {
					q.addFirst(new Pair(ry,rx));
					visited[ry][rx]=true;
					dist[ry][rx]=dist[p.y][p.x]+1;
					one[ry][rx]= one[p.y][p.x];
				}else {
					if(one[p.y][p.x]==1) continue;
					q.addLast(new Pair(ry,rx));
					visited[ry][rx]=true;
					dist[ry][rx]=dist[p.y][p.x]+1;
					one[ry][rx]= one[p.y][p.x]+1;
				}
				System.out.println(ry+","+rx+" "+one[ry][rx]);
				System.out.println(dist[ry][rx]);
			}
		}
		if(SUCCESS) {
		System.out.println(dist[p.y][p.x]);
		}else {
			System.out.println("-1");
		}
	}
}