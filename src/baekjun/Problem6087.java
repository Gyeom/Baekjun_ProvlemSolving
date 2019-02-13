package baekjun;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Problem6087 {
	
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		int s; //방향
		int c; //회전 수
	
		Pair(int y, int x, int s, int c){
			this.y = y;
			this.x = x;
			this.s = s;
			this.c = c;
		}
		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			if(this.c>p.c) {
				return 1;
			} else if(this.c<p.c) {
				return -1;
			}
			return 0;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		PriorityQueue<Pair> q = new PriorityQueue<>();
		char[][] a = new char[H][W];
		int[][] dist = new int[H][W];
		boolean[][][] visited = new boolean[4][H][W];
		for(int i=0, index=0; i<H; i++) {
			String s = sc.next();
			for(int j=0; j<W; j++) {
				a[i][j]= s.charAt(j);
				if(index==0&&a[i][j]=='C') {
					q.add(new Pair(i,j,-1,0));
					a[i][j]='.';
					dist[i][j]=0;
					index++;
				}else {
					dist[i][j]=10000;
				}
			}
		}
		int ans =10000;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(a[p.y][p.x]=='C') {
				if(p.c<ans) {
					ans=p.c;
				}
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				int rc = p.c;
				if(ry<0||rx<0||ry>=H||rx>=W) continue;
				if(a[ry][rx]=='*') continue;
				if(p.s!=k&&p.s!=-1) rc++; //방향 확인
				if(dist[ry][rx]<rc) continue;
				dist[ry][rx]=rc;
				q.add(new Pair(ry,rx,k,rc));
			}
		}
		System.out.println(ans);
	}
}