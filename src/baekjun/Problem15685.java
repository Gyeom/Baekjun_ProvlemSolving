package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15685 {

	//©Л,го,аб,╩С
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static int[][] map;
	static int[] direct;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			int g = Integer.parseInt(token.nextToken());
			if(g==0) {
				map[y][x]=1;
				map[y+dy[d]][x+dx[d]]=1;
			}else {
				int n = (int)Math.pow(2, g);
				direct = new int[n];
				direct[0]=d;
				for(int k=1; k<=n/2; k*=2) {
					dfs(k,0);
				}
				map[y][x]=1;
				check(y,x,n,0);
			}
		}
		int count=0;
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(map[i][j]==1&&map[i+1][j]==1&&map[i][j+1]==1&&map[i+1][j+1]==1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void check(int y, int x, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return;
		}
		int ry = dy[direct[index]]+y;
		int rx = dx[direct[index]]+x;
		map[ry][rx]=1;
		check(ry,rx,end,index+1);
	}

	private static void dfs(int end, int index) {
		if(index==end) return;
		dfs(end,index+1);
		direct[2*end-index-1]=(direct[index]+1)%4;
	}
}