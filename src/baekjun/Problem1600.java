package baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1600 {
	static class Pair{
		int y;
		int x;
		int d;
		int k;
		Pair(int y, int x, int d, int k){
			this.y=y;
			this.x=x;
			this.d=d;
			this.k=k;
		}
	}
	static int[] dy = {1,-1,0,0,2,2,-2,-2,1,-1,1,-1};
	static int[] dx = {0,0,-1,1,-1,1,-1,1,-2,-2,2,2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int[][] a = new int[H+1][W+1];
		int[][] visited = new int[H+1][W+1];
		int[][] count = new int[H+1][W+1];
		for(int i=1; i<=H; i++) {
			Arrays.fill(visited[i], 40001);
			for(int j=1; j<=W; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		Queue<Pair> q = new LinkedList<>();

		int ans = 40001;
		q.add(new Pair(1,1,0,0));
		visited[1][1]=0;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();

			if(p.y==H&&p.x==W) {
				if(p.d<ans) {
					ans=p.d;
				}
				continue;
			}
			for(int k=0; k<12; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;

				if(ry<1||rx<1||ry>H||rx>W) continue;
				if(a[ry][rx]==1) continue;

				if(k>=4) {	
					if(p.k>=K) break;
					if(p.d+1>=visited[ry][rx]&&p.k+1>=count[ry][rx]) continue;
					q.add(new Pair(ry,rx,p.d+1,p.k+1));
					count[ry][rx]=p.k+1;
				}else {
					if(p.d+1>=visited[ry][rx]&&p.k>=count[ry][rx])continue;
					q.add(new Pair(ry,rx,p.d+1,p.k));
					count[ry][rx]=p.k;
				}
				visited[ry][rx]=p.d+1;
			}
		}
		if(ans==40001) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
}
