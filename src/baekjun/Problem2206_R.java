package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2206_R {

	static class Pair{
		int y;
		int x;
		int bomb;
		int d;
		Pair(int y, int x, int bomb, int d){
			this.y=y;
			this.x=x;
			this.bomb=bomb;
			this.d=d;
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][M+1];
		boolean[][][] visited = new boolean[2][N+1][M+1];
		for(int i=1; i<=N; i++) {
			String s = sc.next();
			for(int j=1; j<=M; j++) {
				map[i][j]=s.charAt(j-1)-'0';
			}
		}
		int ans = Integer.MAX_VALUE;
		Queue<Pair> q = new LinkedList<>();
		visited[0][1][1]=true;
		q.add(new Pair(1,1,0,1));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.y==N&&p.x==M) {
				if(p.d<ans) {
					ans=p.d;
				}
			}
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				int rbomb=p.bomb;
				if(ry<1||rx<1||ry>N||rx>M) continue;
				if(visited[rbomb][ry][rx]) continue;
				if(map[ry][rx]==1&&rbomb==1) continue;
				if(map[ry][rx]==1) rbomb=1;
				visited[rbomb][ry][rx]=true;
				q.add(new Pair(ry,rx,rbomb,p.d+1));
			}
		}
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}

}
