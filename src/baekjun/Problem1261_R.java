package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1261_R {
	static class Pair{
		int y;
		int x;
		int bomb;
		Pair(int y, int x, int bomb){
			this.y=y;
			this.x=x;
			this.bomb=bomb;
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N+1][M+1];	
		int[][] visited = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String s = sc.next();
			for(int j=1; j<=M ;j++) {
				map[i][j]=s.charAt(j-1)-'0';
				visited[i][j]=Integer.MAX_VALUE;
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(1,1,0));
		visited[1][1]=0;
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.y==N&&p.x==M) {
				if(p.bomb<ans) {
					ans=p.bomb;
				}
			}
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<1||rx<1||ry>N||rx>M) continue;
				int count=0;
				if(map[ry][rx]==1) count++;
				if(visited[ry][rx]<=p.bomb+count)continue;
				visited[ry][rx]=p.bomb+count;
				q.add(new Pair(ry,rx,p.bomb+count));
			}
		}
		System.out.println(ans);
	}
}