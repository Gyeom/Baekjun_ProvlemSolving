package SAMSUNG;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class S15685 {
	static int[] dy= {0,-1,0,1};
	static int[] dx= {1,0,-1,0};
	static int[][] map;
	static int[] direct;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[101][101];
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			direct = new int[(int)Math.pow(2, g)];
			direct[0]=d;
			ry = dy[d]+y;
			rx = dx[d]+x;
			map[y][x]=1;
			map[ry][rx]=1;
			
			for(int j=1; j<=g; j++) {
				dfs((int)Math.pow(2, j)/2,0);
			}
		}
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1&&map[i][j+1]==1&&map[i+1][j]==1&&map[i+1][j+1]==1) count++;
			}
		}
		System.out.println(count);
	}
	static int ry;
	static int rx;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return;
		}
		dfs(end,index+1);
		direct[2*end-index-1]=direct[index]+1==4?0:direct[index]+1;
		ry+=dy[direct[2*end-index-1]];
		rx+=dx[direct[2*end-index-1]];
		map[ry][rx]=1;
	}

}
