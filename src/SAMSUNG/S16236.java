package SAMSUNG;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S16236 {
	static class Shark implements Comparable<Shark>{
		int y;
		int x;
		int t;
		boolean eat;
		Shark(int y, int x, int t, boolean eat){
			this.y=y;
			this.x=x;
			this.t=t;
			this.eat=eat;
		}
		@Override
		public int compareTo(Shark target) {
			// TODO Auto-generated method stub

			if(this.t>target.t) {
				return 1;
			}else if(this.t<target.t) {
				return -1;
			}else {
				if(this.y>target.y) {
					return 1;
				}else if(this.y<target.y) {
					return -1;
				}else {
					if(this.x>target.x) {
						return 1;
					}else if(this.x<target.x) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		}
	}
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		Shark shark = null;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9) {
					map[i][j]=0;
					shark = new Shark(i,j,0,false);	
				}
			}
		}
		System.out.println(bfs(shark));
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static int bfs(Shark shark) {
		// TODO Auto-generated method stub
		PriorityQueue<Shark> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		int lv=2;
		int c=0;
		int time=0;
		q.add(shark);
		visited[shark.y][shark.x]=true;
		while(!q.isEmpty()) {
			Shark p = q.remove();
			if(p.eat) {
				time=p.t;
				q.clear();
				c++;
				if(c==lv) {
					lv++;
					c=0;
				}
				p.eat=false;
				map[p.y][p.x]=0;
				visited = new boolean[N][N];
				visited[p.y][p.x]=true;
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				boolean reat = p.eat;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(map[ry][rx]>lv) continue;
				if(map[ry][rx]<lv&&map[ry][rx]!=0) reat=true;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				q.add(new Shark(ry,rx,p.t+1,reat));
			}
		}
		return time;
	}
}