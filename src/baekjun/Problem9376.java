package baekjun;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Problem9376 {
	
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();
		
		while(TC-->0) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] a = new char[H+2][W+2];
			int[] sx = new int[3];
			int[] sy = new int[3];
			int index=1;
			for(int i=1; i<=H; i++) {
				String s = sc.next();
				for(int j=1; j<=W; j++) {
					a[i][j] = s.charAt(j-1);
					if(a[i][j]=='$') {
						sx[index] = j;
						sy[index++] =i;
					}
				}
			}
			int[][] dist = new int[H+2][W+2];
			for(int k=0; k<3; k++) {
				int[][] temp = bfs(sy[k],sx[k],a, new int[H+2][W+2]);
				for(int i=0; i<H+2; i++) {
					for(int j=0; j<W+2; j++) {
						dist[i][j]+=temp[i][j];
					}
				}
			}
			int ans = 30000;
			for(int i=0; i<H+2; i++) {
				for(int j=0; j<W+2; j++) {
					if(a[i][j]=='*') continue;
					if(a[i][j]=='#') {
						dist[i][j]-=2;
					}
					if(dist[i][j]<ans) {
						ans = dist[i][j];
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static int[][] bfs(int y, int x, char[][] a, int[][] dist) {
		// TODO Auto-generated method stub
		for(int i=0; i<dist.length; i++) {
			for(int j=0; j<dist[0].length; j++) {
				dist[i][j]=-1;
			}
		}
		
		Deque<Pair> q = new ArrayDeque<>();
		q.addFirst(new Pair(y,x));
		dist[y][x]=0;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				
				if(ry<0||rx<0||ry>=dist.length||rx>=dist[0].length) continue;
				if(a[ry][rx]=='*') continue;
				if(dist[ry][rx]>-1) continue;
				if(a[ry][rx]=='#') {
					dist[ry][rx]=dist[p.y][p.x]+1;
					q.addLast(new Pair(ry,rx));
				}else{
					dist[ry][rx]=dist[p.y][p.x];
					q.addFirst(new Pair(ry,rx));
				}
			}
		}
		return dist;
	}
	
}
