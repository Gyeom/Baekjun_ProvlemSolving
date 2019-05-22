package baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem13460_v2 {

	static class Pair{
		int y;
		int x;
		int py;
		int px;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
		Pair(int y, int x, int py, int px){
			this.y=y;
			this.x=x;
			this.py=py;
			this.px=px;
		}
	}
	static int N;
	static int M;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new char[N][M];
		ArrayList<Pair> point = new ArrayList<>();
		for(int i=0; i<3; i++) {
			point.add(i,null);
		}
		for(int i=0; i<N; i++) {
			String s= sc.next();
			for(int j=0; j<M; j++) {
				a[i][j]=s.charAt(j);
				if(a[i][j]=='R') {
					point.set(0, new Pair(i,j));
				}else if(a[i][j]=='B') {
					point.set(1, new Pair(i,j));
				}else if(a[i][j]=='O') {
					point.set(2, new Pair(i,j));
				}
			}
		}

		int[] way = new int[10];
		outloof:
		for(int i=0; i<(1<<20); i++) {
			int nums=i;
			for(int j=0; j<10; j++) {
				int num = nums%4;
				nums>>=2;
				way[j]=num;
				if(j>0&&way[j]==way[j-1]) continue outloof;
				if(j>0&&((way[j]==0&&way[j-1]==1)||(way[j]==1&&way[j-1]==0)||(way[j]==2&&way[j-1]==3)||(way[j]==3&&way[j-1]==2))) continue outloof;
			}
			solve(way,point.get(0),point.get(1),point.get(2));
		}
		if(count<11) {
			System.out.println(count);
		}else {
			System.out.println("-1");
		}
	}
	static int count=11;
	private static boolean solve(int[] way, Pair RED, Pair BLUE, Pair HOLE) {
		// TODO Auto-generated method stub
		for(int i=0; i<way.length; i++) {
			

			if(way[i]==0) {
				if(RED.x==BLUE.x&&RED.y>BLUE.y) {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}else if(RED.x==BLUE.x&&RED.y<BLUE.y){
					BLUE = bfs(way[i],BLUE,RED);
					RED = bfs(way[i],RED,BLUE);
				}else {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}
			}else if(way[i]==1) {

				if(RED.x==BLUE.x&&RED.y>BLUE.y) {
					BLUE = bfs(way[i],BLUE,RED);
					RED = bfs(way[i],RED,BLUE);
				}else if(RED.x==BLUE.x&&RED.y<BLUE.y){
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}else {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}
			}else if(way[i]==2) {
				if(RED.y==BLUE.y&&RED.x>BLUE.x) {
					BLUE = bfs(way[i],BLUE,RED);
					RED = bfs(way[i],RED,BLUE);
				}else if(RED.y==BLUE.y&&RED.x<BLUE.x){
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}else {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}
			}else if(way[i]==3) {
				if(RED.y==BLUE.y&&RED.x>BLUE.x) {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}else if(RED.y==BLUE.y&&RED.x<BLUE.x){
					BLUE = bfs(way[i],BLUE,RED);
					RED = bfs(way[i],RED,BLUE);
				}else {
					RED = bfs(way[i],RED,BLUE);
					BLUE = bfs(way[i],BLUE,RED);
				}
			}
			
			if((RED.y==HOLE.y&&RED.x==HOLE.x)&&(BLUE.y==HOLE.y&&BLUE.x==HOLE.x)) {
				if(RED.px==BLUE.px&&((RED.py>HOLE.y&&BLUE.py>HOLE.y)||(RED.py<HOLE.y&&BLUE.py<HOLE.y))) {
					return false;
				}else if(RED.py==BLUE.py&&((RED.px>HOLE.x&&BLUE.px>HOLE.x)||(RED.px<HOLE.x&&BLUE.px<HOLE.x))) {
					return false;
				}else {
					if(i+1<count) {
						count=i+1;
					}
					return true;
				}
			}else if(RED.y==HOLE.y&&RED.x==HOLE.x) {
				if(i+1<count) {
					count=i+1;
				}
				return true;
			}else if(BLUE.y==HOLE.y&&BLUE.x==HOLE.x) {
				return false;
			}
		}
		return false;
	}

	private static Pair bfs(int k, Pair start, Pair relative) {
		// TODO Auto-generated method stub
		Queue<Pair> q= new LinkedList<>();
		q.add(start);
		Pair p = null;
		while(!q.isEmpty()) {
			p = q.remove();
			int ry = dy[k]+p.y;
			int rx = dx[k]+p.x;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(a[ry][rx]=='O') return new Pair(ry,rx,p.y,p.x);
			if(ry==relative.y&&rx==relative.x) continue;
			if(a[ry][rx]=='#') continue;
			q.add(new Pair(ry,rx,p.y,p.x));
		}
		return p;
	}

}
