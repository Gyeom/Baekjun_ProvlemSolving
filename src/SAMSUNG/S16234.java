package SAMSUNG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S16234 {

	static int N, L, R;
	static int[][] map;
	static class Country{
		int y;
		int x;
		Country(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int count=-1;
		boolean MOVE;
		
		do {
			count++;
			MOVE=false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					if(bfs(new Country(i,j))) {
						MOVE=true;
					}
				}
			}
		}while(MOVE);
		System.out.println(count);
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static boolean bfs(Country C) {
		// TODO Auto-generated method stub
		visited[C.y][C.x]=true;
		Queue<Country> q = new LinkedList<>();
		ArrayList<Country> cList = new ArrayList<>();
		int people=map[C.y][C.x];
		q.add(C);
		cList.add(C);
		while(!q.isEmpty()) {
			Country p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				int gap = Math.abs(map[ry][rx]-map[p.y][p.x]);
				if(gap<L||gap>R) continue;
				visited[ry][rx]=true;
				Country c = new Country(ry,rx);
				people+=map[ry][rx];
				q.add(c);
				cList.add(c);
			}
		}
		int p = people/cList.size();
		for(Country c: cList) {
			map[c.y][c.x]=p;
		}
		return cList.size()==1?false:true;
	}

}
