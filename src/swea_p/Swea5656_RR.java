package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Swea5656_RR {

	static class Wall{
		int y;
		int x;
		Wall(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int N, W, H;
	static int ans;
	static int[] way;
	static int[][] map;
	static int[][] copy;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());	
		for(int tc=1; tc<=TC; tc++) {
			ans=0;
			int zero =0;
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			H = Integer.parseInt(s[2]);
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(map[i][j]==0) {
						zero++;
					}
				}
			}
			way = new int[N];
			dfs(N,0);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(H*W-ans-zero));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			copy = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					copy[i][j]=map[i][j];
				}
			}
			int cnt=0;
			for(int i=0; i<way.length; i++) {
				cnt+=simulation(way[i]);
				reArray();
			}
			if(cnt>ans) {
				ans=cnt;
			}
			return;
		}
		for(int i=0; i<W; i++) {
			way[index]=i;
			dfs(end, index+1);
		}
	}

	private static void reArray() {
		// TODO Auto-generated method stub
		for(int i=H-2; i>=0; i--) {
			for(int j=0; j<W; j++) {
				int k=1;
				while(i+k<H&&copy[i+k][j]==0) {
					copy[i+k][j]=copy[i+k-1][j];
					copy[i+k-1][j]=0;
					k++;
				}
			}
		}
	}

	private static int simulation(int w) {
		// TODO Auto-generated method stub
		int h=0;
		while(copy[h][w]==0) {
			h++;
			if(h==H) {
				return 0;
			}
		}
		return bfs(new Wall(h,w));
	}

	private static int bfs(Wall wall) {
		// TODO Auto-generated method stub
		int count=0;
		Queue<Wall> q = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		visited[wall.y][wall.x]=true;
		q.add(wall);
		while(!q.isEmpty()) {
			Wall p = q.remove();
			count++;	
			int d = copy[p.y][p.x];
			copy[p.y][p.x]=0;
			if(d<=1) continue;
			for(int k=0; k<4; k++) {
				int ry = p.y;
				int rx = p.x;
				for(int i=1; i<d; i++) {
					ry+=dy[k];
					rx+=dx[k];
					if(ry<0||rx<0||ry>=H||rx>=W) break;
					if(copy[ry][rx]==0) continue;
					if(visited[ry][rx]) continue;
					visited[ry][rx]=true;
					q.add(new Wall(ry,rx));	
				}
			}
		}
		return count;
	}
}