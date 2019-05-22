package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem15683_R {
	static int[][] map;
	static int N;
	static int M;
	static class CCTV{
		int y;
		int x;
		int num;
		CCTV(int y, int x, int num){
			this.y=y;
			this.x=x;
			this.num=num;
		}
	}
	static int[] way;
	static int ans;
	static ArrayList<CCTV> cctvList;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s= br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		int wall=0;
		cctvList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M ;j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==6) {
					wall++;
				}else if(map[i][j]>0) {
					cctvList.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		way = new int[cctvList.size()];
		dfs(cctvList.size(),0);
		System.out.println(N*M-ans-wall);
	}
	static boolean[][] visited;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			visited = new boolean[N][M];
			for(int i=0; i<way.length; i++) {
				//i´Â CCTV
				//way[i] = ¹æÇâ
				CCTV c = cctvList.get(i);
				switch (c.num) {
				case 1:
					simulation(c.y,c.x,way[i]);
					break;
				case 2:
					switch (way[i]) {
					case 0:
						simulation(c.y,c.x,2);
						simulation(c.y,c.x,3);
						break;
					case 1:
						simulation(c.y,c.x,0);
						simulation(c.y,c.x,1);
						break;
					}
					break;
				case 3:
					switch (way[i]) {
					case 0:
						simulation(c.y,c.x,0);
						simulation(c.y,c.x,3);
						break;
					case 1:
						simulation(c.y,c.x,3);
						simulation(c.y,c.x,1);
						break;
					case 2:
						simulation(c.y,c.x,1);
						simulation(c.y,c.x,2);
						break;
					case 3:
						simulation(c.y,c.x,2);
						simulation(c.y,c.x,0);
						break;
					}
					break;
				case 4:
					switch (way[i]) {
					case 0:
						simulation(c.y,c.x,0);
						simulation(c.y,c.x,1);
						simulation(c.y,c.x,2);
						break;
					case 1:
						simulation(c.y,c.x,1);
						simulation(c.y,c.x,2);
						simulation(c.y,c.x,3);
						break;
					case 2:
						simulation(c.y,c.x,2);
						simulation(c.y,c.x,3);
						simulation(c.y,c.x,0);
						break;
					case 3:
						simulation(c.y,c.x,3);
						simulation(c.y,c.x,0);
						simulation(c.y,c.x,1);
						break;
					}
					break;
				case 5:
					simulation(c.y,c.x,0);
					simulation(c.y,c.x,1);
					simulation(c.y,c.x,2);
					simulation(c.y,c.x,3);
					break;
				}
			}
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]) {
						count++;
					}
				}
			}
			if(count>ans) {
				ans=count;
			}

			return;
		}
		for(int i=0; i<4; i++) {
			if(cctvList.get(index).num==2&&i>1) return;
			if(cctvList.get(index).num==5&&i>0) return;
			way[index]=i;
			dfs(end,index+1);
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};

	private static void simulation(int y, int x, int k) {
		// TODO Auto-generated method stub
		visited[y][x]=true;
		while(true) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0||ry>=N||rx>=M) break;
			if(map[ry][rx]==6) break;
			visited[ry][rx]=true;
			y=ry;
			x=rx;
		}
	}
}