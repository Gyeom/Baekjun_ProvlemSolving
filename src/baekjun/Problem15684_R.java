package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15684_R {

	static int[][] map;
	static int N;
	static int H;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken()); //가로
		int M = Integer.parseInt(token.nextToken()); //가로선의 개수
		H = Integer.parseInt(token.nextToken()); //세로
		map = new int[H+1][N+1];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken()); //세로
			int b = Integer.parseInt(token.nextToken());//가로
			map[a][b]=1;
			map[a][b+1]=-1;
		}
		boolean go = true;
		if(check()) {
			System.out.println("0");
			go = false;
		}
		if(go) {
			for(int i=1; i<=3; i++) {
				if(dfs(1,1,i,0)) {
					System.out.println(i);
					go = false;
					break;
				};
			}
		}
		if(go) {
			System.out.println("-1");	
		}
	}

	private static boolean dfs(int y, int x,int end, int index) {
		// TODO Auto-generated method stub
		if(index == end) {
			if(check()) {
				return true;
			}
			return false;
		}
		if(x==N) {
			y++;
			x=1;
		}
		for(int i=y; i<=H; i++) {
			for(int j=x; j<N; j++) {
				if(map[i][j]==1) continue;
				if(map[i][j+1]==1) continue;
				if(map[i][j]==-1) continue;
				map[i][j]=1;
				map[i][j+1]=-1;
				if(dfs(i,j+1,end,index+1)) return true;
				map[i][j]=0;
				map[i][j+1]=0;
			}
			x=1;
		}
		return false;
	}

	private static boolean check() {
		// TODO Auto-generated method stub
		for(int i=1; i<=N; i++) {
			if(!simulation(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean simulation(int start) {
		// TODO Auto-generated method stub
		int x = start;
		int y;
		for(y=1; y<=H; y++) {
			if(map[y][x]==1) {
				x++;
			}else if(map[y][x]==-1) {
				x--;
			}
		}
//		y--; // 위치조정
		if(x==start) {
			return true;
		}else {
			return false;
		}
	}
}
