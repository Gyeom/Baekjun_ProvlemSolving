package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Swea1949_R {
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;

	static int N;
	static int K;
	static int[][] map;
	static class Mountain implements Comparable<Mountain>{
		int y;
		int x;
		int h;
		Mountain(int y, int x, int h){
			this.y=y;
			this.x=x;
			this.h=h;
		}
		
		@Override
		public int compareTo(Mountain target) {
			// TODO Auto-generated method stub
			return this.h<target.h?1:-1;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			ans=0;
			String s[] = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			map = new int[N][N];
			PriorityQueue<Mountain> max = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(max.size()==0||map[i][j]>max.peek().h) {
						max.clear();
						max.add(new Mountain(i,j,map[i][j]));
					}else if(map[i][j]==max.peek().h) {
						max.add(new Mountain(i,j,map[i][j]));
					}
				}
			}
			while(!max.isEmpty()) {
				Mountain m = max.remove();
				visited= new boolean[N][N];
				visited[m.y][m.x]=true;
				chance=false; chance_y=-1; chance_y=-1; chance_height=100; //ÃÊ±âÈ­
				dfs(m.y,m.x,1);
				visited[m.y][m.x]=false;
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static boolean chance;
	static int chance_y;
	static int chance_x;
	static int chance_height;
	static boolean[][] visited;
	private static void dfs(int y, int x,int index) {
		// TODO Auto-generated method stub
		if(index>ans) {
			ans=index;
		}
		for(int k=0; k<4; k++) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0||ry>=N||rx>=N) continue;
			if(visited[ry][rx]) continue;
			if(map[y][x]>map[ry][rx]) {
				if(chance&&y==chance_y&&x==chance_x&&map[ry][rx]>=chance_height) continue;
					visited[ry][rx]=true;
					dfs(ry,rx,index+1);
					visited[ry][rx]=false;
			}else {
				if(chance&&y==chance_y&&x==chance_x&&map[ry][rx]<chance_height) {
					visited[ry][rx]=true;
					dfs(ry,rx,index+1);
					visited[ry][rx]=false;
				}else if(!chance&&map[ry][rx]-K<map[y][x]) {
					chance=true;
					chance_height=map[y][x]-1;
					chance_y=ry; chance_x=rx;
					visited[ry][rx]=true;
					dfs(ry,rx,index+1);
					visited[ry][rx]=false;
					chance=false;
					chance_height=100;
					chance_y=-1; chance_x=-1;
				}else {
					continue;
				}
			}
		}
	}
}
