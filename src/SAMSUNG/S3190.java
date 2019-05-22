package SAMSUNG;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class S3190 {
	static class Snake{
		int y;
		int x;
		Snake(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,-1,0,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i=0; i<K; i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			map[y][x]=1;
		}
		int L = sc.nextInt();
		char[] direct = new char[100001];
		for(int i=0; i<L; i++) {
			int X = sc.nextInt();
			char C = sc.next().charAt(0);
			direct[X]=C;
		}
		boolean[][] visited= new boolean[N][N];
		int y = 0;
		int x = 0;
		int d=3;
		Deque<Snake> q = new ArrayDeque<>();
		q.add(new Snake(0,0));
		visited[0][0]=true;
		for(int t=1; t<=Integer.MAX_VALUE; t++) {
			if(direct[t-1]=='D') {
				d=(d+1==4?0:d+1);
			}else if(direct[t-1]=='L') {
				d=(d-1==-1?3:d-1);
			}
			int ry = dy[d]+y;
			int rx = dx[d]+x;
			if(ry<0||rx<0||ry>=N||rx>=N||visited[ry][rx]) {
				System.out.println(t);
				break;
			}
			q.addFirst(new Snake(ry,rx));
			visited[ry][rx]=true;
			if(map[ry][rx]==0) {
				Snake tail = q.removeLast();
				visited[tail.y][tail.x]=false;
			}else {
				map[ry][rx]=0;
			}
			y=ry;
			x=rx;
		}
	}
}