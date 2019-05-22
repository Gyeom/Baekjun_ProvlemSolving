package baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem10026 {

	static class Pair{
		int y;
		int x;
		char c;
		Pair(int y, int x, char c){
			this.y=y;
			this.x=x;
			this.c=c;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] a = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<N; j++) {
				a[i][j]=s.charAt(j);
			}
		}
		
		for(int t=0; t<2; t++) {
			boolean[][] visited = new boolean[N][N];
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					count++;
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i,j,a[i][j]));
					visited[0][0]=true;
					while(!q.isEmpty()) {
						Pair p = q.remove();
						for(int k=0; k<4; k++) {
							int ry = p.y+dy[k];
							int rx = p.x+dx[k];
							
							if(ry<0||rx<0||ry>=N||rx>=N) continue;
							if(visited[ry][rx]) continue;
							if(t==0) {
								if(p.c!=a[ry][rx]) continue;
							}else {
								if(p.c=='R'||p.c=='G') {
									if(a[ry][rx]=='B') continue;
								}else {
									if(a[ry][rx]=='R'||a[ry][rx]=='G') continue;
								}
							}
							visited[ry][rx]=true;
							q.add(new Pair(ry,rx,a[ry][rx]));
						}
					}
				}
			}
			System.out.print(count+" ");
		}
	}
}