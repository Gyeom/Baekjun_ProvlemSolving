package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem16236_R {
	static class Shark implements Comparable<Shark>{
		int y;
		int x;
		int t;
		Shark(int y, int x, int t){
			this.y=y;
			this.x=x;
			this.t=t;
		}

		@Override
		public int compareTo(Shark target) {
			// TODO Auto-generated method stub
			if(this.t==target.t) {
				if((map[this.y][this.x]>0&&map[this.y][this.x]<lv)&&(map[target.y][target.x]==0||map[target.y][target.x]==lv)) {
					return -1;
				}else if((map[this.y][this.x]==0||map[this.y][this.x]==lv)&&(map[target.y][target.x]>0&&map[target.y][target.x]<lv)) { 
					return 1;
				}else {
					return this.y==target.y?(this.x>target.x?1:-1):(this.y>target.y?1:-1);
				}
			}else if(this.t<target.t) {
				return -1;
			}else{
				return 1;
			}
		}
	}
	static int time;
	static int lv;
	static int count;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =  Integer.parseInt(br.readLine());
		map = new int[N][N];
		PriorityQueue<Shark> q = new PriorityQueue<>();
		StringTokenizer token;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==9) {
					q.add(new Shark(i,j,0));
					map[i][j]=0;
				}
			}
		}
		lv=2;
		count=0;
		time=0;
		boolean[][] visited = new boolean[N][N];
		while(!q.isEmpty()) {
			Shark p = q.remove();
			if(map[p.y][p.x]<lv&&map[p.y][p.x]!=0) {
				time=p.t;
				q.clear();
				map[p.y][p.x]=0;
				count++;
				if(count==lv) {
					lv++;
					count=0;
				}
				visited = new boolean[N][N];
				visited[p.y][p.x]=true;
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(map[ry][rx]>lv) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				q.add(new Shark(ry,rx,p.t+1));
			}
		}
		System.out.println(time);
	}
}