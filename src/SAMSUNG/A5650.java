package SAMSUNG;

import java.util.Scanner;

public class A5650 {
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]!=0) continue;
					for(int k=0; k<4; k++) {
						simulation(i,j,k);
					}
				}
			}
			
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void simulation(int y, int x, int k) {
		// TODO Auto-generated method stub
		int START_Y=y;
		int START_X=x;
		do {
			while(true) {
				int ry = y+dy[k];
				int rx = x+dx[k];
				int rk = k;
				if((ry==START_Y&&rx==START_X)||map[ry][rx]==-1) {
					
					return;
				}else if(map[ry][rx]==1) {
				}else if(map[ry][rx]==2) {
					
				}else if(map[ry][rx]==3) {
					
				}else if(map[ry][rx]==4) {
					
				}else if(map[ry][rx]==5) {
					
				}
			}	
		}while(true);
	}

}
