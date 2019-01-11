package baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem16234 {
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		int[][] a = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				 a[i][j]= sc.nextInt();
			}
		}
		boolean con;
	
		Queue<Pair> q;
		ArrayList<Pair> pairs;
		ArrayList<Integer> s;
		boolean[][] visited;
		int sum;
		int count;
		int ans=0;
		do {
			visited= new boolean[N+1][N+1];
			con = false;
			s= new ArrayList<>();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(visited[i][j]) continue;
		
				q = new LinkedList<>();
			
				pairs = new ArrayList<>(); 
				sum = 0;
				count = 0;
				Pair p = new Pair(i,j);
				q.add(p);
				visited[i][j] = true;
				sum += a[p.y][p.x];
				count++;
				
				while(!q.isEmpty()) {
					p = q.remove();
					
					for(int k=0; k<4; k++) {
						int ry = p.y+dy[k]; 
						int rx = p.x+dx[k]; 
						if(rx<1||ry<1||rx>N||ry>N) continue;
						if(visited[ry][rx]) continue;
						int LR = (a[p.y][p.x]-a[ry][rx]) > 0 ? (a[p.y][p.x]-a[ry][rx]) : -(a[p.y][p.x]-a[ry][rx]);
						
						if((L<=LR)&&(LR<=R)) {
						con = true;
						Pair x = new Pair(ry,rx);
						pairs.add(x);
						q.add(x);
						visited[ry][rx] = true;
						sum += a[ry][rx];
						count++;
						}
					}
				}
		
				
				int num=sum/count;
				for(int z=0; z<pairs.size(); z++) {
					p = pairs.get(z);
					a[p.y][p.x] = num;
				}
				a[i][j]=num;
			

			}
		
		}
	
		if(!con) {
			break;
		}
		ans++;
	}while(true);
		System.out.println(ans);
	}

}
