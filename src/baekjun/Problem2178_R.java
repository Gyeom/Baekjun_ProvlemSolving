package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178_R {
	static class Pair{
		int y;
		int x;
		int dist;
		Pair(int y, int x, int dist){
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		boolean[][] visited = new boolean[N][M];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0,1));
		visited[0][0]=true;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.y==N-1&&p.x==M-1) {
				System.out.println(p.dist);
				break;
			}
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(visited[ry][rx]) continue;
				if(map[ry][rx]==0) continue;
				visited[ry][rx]=true;
				q.add(new Pair(ry,rx,p.dist+1));
			}
		}
	}

}
