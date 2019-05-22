package SAMSUNG;

import java.util.Scanner;

public class S13460 {
	static char[][] map;
	static class Ball{
		int y;
		int x;
		char color;
		Ball(int y, int x, char color){
			this.y=y;
			this.x=x;
			this.color=color;
		}
	}
	static int BLUE_START_Y;
	static int BLUE_START_X;
	static int RED_START_Y;
	static int RED_START_X;
	static int HALL_Y;
	static int HALL_X;
	static int[] way;
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans=Integer.MAX_VALUE;
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='B') {
					BLUE_START_Y=i;
					BLUE_START_X=j;
				}else if(map[i][j]=='R') {
					RED_START_Y=i;
					RED_START_X=j;
				}else if(map[i][j]=='O') {
					HALL_Y=i;
					HALL_X=j;
				}
			}
		}
		way = new int[10];
		dfs(10,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			check();

			return;
		}
		for(int i=0; i<4; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	static int ans;
	static char[][] copy;
	private static void check() {
		// TODO Auto-generated method stub
		Ball RED = new Ball(RED_START_Y,RED_START_X,'R');
		Ball BLUE = new Ball(BLUE_START_Y,BLUE_START_X,'B');
		copy = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j]=map[i][j];
			}
		}
		for(int i=0; i<way.length; i++) {
			if(way[i]==0) {
				if(RED.y>=BLUE.y) {
					simulation(RED,way[i]);
					simulation(BLUE,way[i]);
				}else {
					simulation(BLUE,way[i]);
					simulation(RED,way[i]);
				}
			}else if(way[i]==1) {
				if(RED.y<=BLUE.y) {
					simulation(RED,way[i]);
					simulation(BLUE,way[i]);
				}else {
					simulation(BLUE,way[i]);
					simulation(RED,way[i]);
				}
			}else if(way[i]==2) {
				if(RED.x<=BLUE.x) {
					simulation(RED,way[i]);
					simulation(BLUE,way[i]);
				}else {
					simulation(BLUE,way[i]);
					simulation(RED,way[i]);
				}
			}else if(way[i]==3) {
				if(RED.x>=BLUE.x) {
					simulation(RED,way[i]);
					simulation(BLUE,way[i]);
				}else {
					simulation(BLUE,way[i]);
					simulation(RED,way[i]);
				}
			}
			if(BLUE.y==HALL_Y&&BLUE.x==HALL_X) {
				return;
			}
			if(RED.y==HALL_Y&&RED.x==HALL_X) {
				ans= Math.min(ans, i+1);
				return;
			}
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void simulation(Ball B, int d) {
		// TODO Auto-generated method stub
		do {
			int ry=B.y+dy[d];
			int rx=B.x+dx[d];
			if(ry<0||rx<0||ry>=N||rx>=M) break;
			if(copy[ry][rx]=='O') {
				copy[B.y][B.x]='.';
				B.y=ry;
				B.x=rx;
				return;
			}
			if(copy[ry][rx]!='.') return;
			copy[ry][rx]=B.color;
			copy[B.y][B.x]='.';
			B.y=ry;
			B.x=rx;
		}while(true);
	}

}
