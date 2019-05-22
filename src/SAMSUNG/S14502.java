package SAMSUNG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S14502 {
	static int N,M;
	static int[][] map;
	static ArrayList<Birus> birusList;
	static class Birus{
		int y;
		int x;
		Birus(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE;
		int wall=0;
		map = new int[N][M];
		birusList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					birusList.add(new Birus(i,j));
				}else if(map[i][j]==1) {
					wall++;
				}
			}
		}
		
		dfs(0,0,3,0);
		System.out.println(N*M-ans-birusList.size()-3-wall);
	}
	
	private static void dfs(int y, int x, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			int count = bfs(birusList);
			if(count<ans) {
				ans=count;
			}
			return;
		}
		if(x==M) {
			y++;
			x=0;
		}
		for(int i=y; i<N; i++) {
			for(int j=x; j<M; j++) {
				if(map[i][j]!=0) continue;
				map[i][j]=1;
				dfs(i,j+1,end,index+1);
				map[i][j]=0;
			}
			x=0;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	private static int bfs(ArrayList<Birus> birusList) {
		// TODO Auto-generated method stub
		Queue<Birus> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for(Birus b : birusList) {
			q.add(b);
			visited[b.y][b.x]=true;
		}
		int count=0;
		while(!q.isEmpty()) {
			Birus p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(map[ry][rx]!=0) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				count++;
				q.add(new Birus(ry,rx));
			}
		}
		return count;
	}
}