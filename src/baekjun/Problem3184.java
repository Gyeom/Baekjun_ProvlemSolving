package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem3184 {
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
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
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<C; j++) {
				a[i][j]=s.charAt(j);
			}
		}
		boolean[][] visited = new boolean[R][C];
		int ans_o=0;
		int ans_v=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(visited[i][j]) continue;
				if(a[i][j]=='#') continue;
				int o=0;
				int v=0;
				Queue<Pair> q = new LinkedList<>();
				visited[i][j]=true;
				if(a[i][j]=='o') {
					o++;
				}else if(a[i][j]=='v') {
					v++;
				}
				q.add(new Pair(i,j));
				
				while(!q.isEmpty()) {
					Pair p = q.remove();
					for(int k=0; k<4; k++) {
						int ry = dy[k]+p.y;
						int rx = dx[k]+p.x;
						if(ry<0||rx<0||ry>=R||rx>=C) continue;
						if(a[ry][rx]=='#') continue;
						if(visited[ry][rx]) continue;
						if(a[ry][rx]=='o') {
							o++;
						}else if(a[ry][rx]=='v') {
							v++;
						}
					
						visited[ry][rx]=true;
						q.add(new Pair(ry,rx));
					}
				}
				if(o>v) {
					ans_o+=o;
				}else {
					ans_v+=v;
				}
			}
		}
		System.out.println(ans_o+" "+ans_v);
	}
}
