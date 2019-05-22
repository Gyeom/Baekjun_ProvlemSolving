package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14499 {

	static int[] dy = {0,0,0,-1,1};
	static int[] dx = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int x = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[][] map = new int[N][M];

		int[][] dice = new int[4][3];

					  dice[0][1]=0;
		dice[1][0]=0; dice[1][1]=0; dice[1][2]=0;
		              dice[2][1]=0;
		              dice[3][1]=0;


		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int k = Integer.parseInt(token.nextToken());
			int ry = y+dy[k];
			int rx = x+dx[k];
			if(ry<0||rx<0||ry>=N||rx>=M) {
				continue;
			}
			int temp =0;
			switch (k) {
			case 1: //µ¿
				temp = dice[1][0];
				dice[1][0]=dice[1][1]; 
				dice[1][1]=dice[1][2]; 
				dice[1][2]=dice[3][1];
				dice[3][1]=temp;
				break;
			case 2: //¼­
				temp = dice[1][0];
				dice[1][0]=dice[3][1];  
				dice[3][1]=dice[1][2];
				dice[1][2]=dice[1][1];
				dice[1][1]=temp;
				break;
			case 3: //ºÏ
				temp = dice[0][1];
				dice[0][1]=dice[3][1];
				dice[3][1]=dice[2][1];
				dice[2][1]=dice[1][1];
				dice[1][1]=temp;
				break;
			case 4: //³²
				temp = dice[0][1];
				dice[0][1]=dice[1][1];
				dice[1][1]=dice[2][1];
				dice[2][1]=dice[3][1];
				dice[3][1]=temp;
				break;
			}
		
			if(map[ry][rx]==0) {
				map[ry][rx]=dice[1][1];
			}else {
				dice[1][1]=map[ry][rx];
				map[ry][rx]=0;
			}
			y=ry;
			x=rx;
			System.out.println(dice[3][1]);
		}
	}
}