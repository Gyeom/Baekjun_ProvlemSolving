package SAMSUNG;

import java.util.Scanner;

public class S15684 {
	static int[][] map;
	static int N,H,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][N];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1; //¿­
			map[a][b]=1;
			map[a][b+1]=-1;
		}
		
		for(int i=0; i<=4; i++) {
			if(i==4) {
				System.out.println("-1");
				break;
			}
			if(dfs(0,0,i,0)) {
				System.out.println(i);
				break;
			}
		}
	}
	private static boolean dfs(int y,int x, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			return simulation();
			
		}
		if(x==H-1) {
			y++;
			x=0;
		}
		for(int i=y; i<H; i++) {
			for(int j=x; j<N-1; j++) {
				if(map[i][j]==-1) continue;
				if(map[i][j]==1) continue;
				if(map[i][j+1]==1) continue;
				map[i][j]=1;
				map[i][j+1]=-1;
				boolean pass = dfs(i,j+1,end,index+1);
				map[i][j]=0;
				map[i][j+1]=0;
				if(pass) return true;
			}
			x=0;
		}
		return false;
	}
	private static boolean simulation() {
		// TODO Auto-generated method stub
		for(int k=0; k<N; k++) {
			int x = k;
			for(int y=0; y<H; y++) {
				if(map[y][x]==1) {
					x++;
				}else if(map[y][x]==-1) {
					x--;
				}
			}
			if(k!=x) {
				return false;
			}
		}
		return true;
	}
}