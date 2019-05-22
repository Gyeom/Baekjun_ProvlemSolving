package SAMSUNG;

import java.util.Scanner;

public class S14999 {
	static int N,M;
	static int[][] map;
	static int[] dy = {0,0,0,-1,1};
	static int[] dx = {0,1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][M];


		int[][] dice = new int[4][3];

		//	    2
		//	  4 1 3
		//	    5
		//	    6		

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}

		for(int i=0; i<K; i++) {
			int d = sc.nextInt();
			int ry = dy[d]+y;
			int rx = dx[d]+x;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			int temp=0;
			switch (d) {
			//µ¿
			case 1:
				temp = dice[1][0];
				dice[1][0]=dice[3][1]; 
				dice[3][1]=dice[1][2];
				dice[1][2]=dice[1][1]; 
				dice[1][1]=temp; 
				break;
			//¼­	
			case 2:
				temp = dice[1][1];
				dice[1][1]=dice[1][2]; 
				dice[1][2]=dice[3][1];
				dice[3][1]=dice[1][0]; 
				dice[1][0]=temp;
				break;
			//ºÏ
			case 3:
				temp = dice[0][1];
				dice[0][1]=dice[1][1];
				dice[1][1]=dice[2][1];
				dice[2][1]=dice[3][1];
				dice[3][1]=temp;
				break;
			//³²
			case 4:
				temp = dice[3][1];
				dice[3][1]=dice[2][1];
				dice[2][1]=dice[1][1];
				dice[1][1]=dice[0][1];
				dice[0][1]=temp;
				break;
			}
			if(map[ry][rx]==0) {
				map[ry][rx]=dice[3][1];
			}else {
				dice[3][1]=map[ry][rx];
				map[ry][rx]=0;
			}
			System.out.println(dice[1][1]);
			y=ry;
			x=rx;
		}
	}
}