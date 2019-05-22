package baekjun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Problem3197 {
	
	static class Pair{
		int y;
		int x;
		int d;
		Pair(int y, int x, int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] a = new char[R][C];
		Deque<Pair> q = new ArrayDeque<>();
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<C; j++) {
				a[i][j]=s.charAt(j);
				if(a[i][j]=='L') {
					q.add(new Pair(i,j,0));
				}
			}
		}
		
		Pair end = q.remove();
		
		boolean[][] visited = new boolean[R][C];
		visited[q.peek().y][q.peek().x]=true;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			System.out.println(p.d);
			System.out.println(p.y+","+p.x);
			if(p.y==end.y&&p.x==end.x) {
				System.out.println(p.d/2+p.d%2);
				break;
			}
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<0||rx<0||ry>=R||rx>=C) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				if(a[ry][rx]=='X') {
					q.addLast(new Pair(ry,rx,p.d+1));
				}else {
					q.addFirst(new Pair(ry,rx,p.d));
				}
			
			}
		}
	}
}