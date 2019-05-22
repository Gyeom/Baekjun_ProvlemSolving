package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem15686_R {
	static class Pair{
		int y;
		int x;
		int dist;
		Pair(int y, int x, int dist){
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	
	static ArrayList<Pair> chickenList;
	static int[][] map;
	static int N, M, homeSize, ans;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][N];
		chickenList = new ArrayList<>();
		homeSize=0;
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==2) {
					chickenList.add(new Pair(i,j,0));
					map[i][j]=0;
				}else if(map[i][j]==1) {
					homeSize++;
				}
			}
		}
		ans=Integer.MAX_VALUE;
		dfs(0,M,0,chickenList.size());
		System.out.println(ans);

	}

	private static void dfs(int num, int end, int index, int N) {
		// TODO Auto-generated method stub
		if(index==end) {
			int dist = bfs();
			if(dist<ans) {
				ans=dist;
			}
			return;
		}
		for(int i=num; i<N; i++) {
			Pair c = chickenList.get(i);
			map[c.y][c.x]=2;
			dfs(i+1,end,index+1,N);
			map[c.y][c.x]=0;
		}
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for(Pair temp : chickenList) {
			if(map[temp.y][temp.x]!=2) continue;
			q.add(temp);
			visited[temp.y][temp.x]=true;
		}
		int count=0;
		int dist=0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(map[p.y][p.x]==1) {
				dist+=p.dist;
				count++;
				if(count==homeSize) {
					break;
				}
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				q.add(new Pair(ry,rx,p.dist+1));
			}
		}
		return dist;
	}
}