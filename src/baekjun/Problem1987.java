package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1987 {
	
	public static class Pair{
		int x;
		int y;
		int val;
		int dist;
		boolean[] visited_Val;
		Pair(int y, int x, int val, int dist){
			this.x = x;
			this.y = y;
			this.val = val;
			this.dist = dist;
			this.visited_Val = new boolean[100];
			this.visited_Val[val] = true;
		}
	}
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer =0;
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] a = new int[R+1][C+1];
		for(int i=1; i<=R; i++) {
			String s = sc.next();
			for(int j=1; j<=C; j++) {
				a[i][j]  = (int) s.charAt(j-1);
			}
		}
		boolean[][] visited = new boolean[R+1][C+1];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(1,1,a[1][1],1));
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.dist>answer) {
				answer=p.dist;
			}
			for(int i=0; i<4; i++) {
				int ry = dy[i]+p.y;
				int rx = dx[i]+p.x;
				int rdist = p.dist+1;
			
				if(ry<1||rx<1||ry>R||rx>C) continue;
				if(p.visited_Val[a[ry][rx]]) continue;
				Pair temp = new Pair(ry,rx,a[ry][rx],rdist);
				for(int j=1; j<=99; j++) {
					if(!p.visited_Val[j]) continue;
					temp.visited_Val[j]=true;
				}
				q.add(temp);			
			}
		}
		System.out.println(answer);
	}
}
