package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea5656 {

	static int H;
	static int W;
	static int[][] a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer token;
			token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			H = Integer.parseInt(token.nextToken());
			a= new int[H][W];
			for(int i=0; i<H; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					a[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			ans=W*H+1;
			way = new int[N];
			dfs(N,0);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}
	static int[] way;
	static int ans;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			int[][] b= new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					b[i][j]=a[i][j];
				}
			}
			int count=0;
			for(int i=0; i<way.length; i++) {
				check(way[i],b);
			}
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(b[i][j]==0) continue;
					count++;
				}
			}
			if(count<ans) {
				ans=count;
			}
			return;
		}

		for(int i=0; i<W; i++) {
			way[index]=i;
			dfs(end,index+1);
		}

	}
	private static void check(int w, int[][] b) {
		// TODO Auto-generated method stub
		int h = 0;
		while(b[h][w]==0) {
			h++;
			if(h==H) {
				return;
			}
		}
		bfs(h,w,b);
		reArray(b);
	}
	private static void reArray(int[][] b) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(b[j][i]==0) continue;
				stack.push(b[j][i]);
			}
			for(int j=H-1; j>=0; j--) {
				if(!stack.isEmpty()) {
					b[j][i]=stack.pop();
				}else {
					b[j][i]=0;
				}
			}
		}
	}
	static class Pair{
		int y;
		int x;
		int y_life;
		int x_life;
		Pair(int y, int x, int y_life, int x_life){
			this.y=y;
			this.x=x;
			this.y_life=y_life;
			this.x_life=x_life;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void bfs(int h, int w, int[][] b) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		q.add(new Pair(h,w,b[h][w],b[h][w]));
		b[h][w]=0;
		visited[h][w]=true;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = p.y;
				int rx = p.x;
				if(k<=1) {
					for(int i=1; i<p.y_life; i++) {
						ry+=dy[k];
						rx+=dx[k];
						if(ry<0||rx<0||ry>=H||rx>=W) continue;
						if(visited[ry][rx])continue;
						q.add(new Pair(ry,rx,b[ry][rx]>=p.y_life-i?b[ry][rx]:p.y_life-i,b[ry][rx]));
						visited[ry][rx]=true;
						b[ry][rx]=0;
					}
				}else {
					for(int i=1; i<p.x_life; i++) {
						ry+=dy[k];
						rx+=dx[k];
						if(ry<0||rx<0||ry>=H||rx>=W) continue;
						if(visited[ry][rx])continue;
						q.add(new Pair(ry,rx,b[ry][rx],b[ry][rx]>=p.x_life-i?b[ry][rx]:p.x_life-i));
						visited[ry][rx]=true;
						b[ry][rx]=0;
					}
				}
			}
		}
	}
}
