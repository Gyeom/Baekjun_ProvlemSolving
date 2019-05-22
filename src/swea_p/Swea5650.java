package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea5650 {
	static class Hall{
		int y;
		int x;
		Hall(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int ans, count, N;
	static int START_Y, START_X;
	static ArrayList<Hall>[] moveList;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=TC; tc++) {
			ans=0;
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N+2][N+2];
			moveList = (ArrayList<Hall>[]) new ArrayList[5];
		
			for(int i=0; i<5; i++) {
				moveList[i]=new ArrayList<>();
			}
			for(int i=1; i<=N; i++) {
				map[0][i]=5;
				map[N+1][i]=5;
				map[i][0]=5;
				map[i][N+1]=5;
			}
			StringTokenizer token;
			for(int i=1; i<=N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
					if(map[i][j]>5) {
						moveList[map[i][j]-6].add(new Hall(i,j));
					}
				}
			}

			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j]!=0) continue;
					START_Y=i;
					START_X=j;
					for(int k=0; k<4; k++) {
						count=0;
						simulation(i,j,k);
						if(count>ans) {
							ans=count;
						}
					}
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void simulation(int y, int x, int k) {
		// TODO Auto-generated method stub
		outloof:
			while(true) {
				int ry = y;
				int rx = x;
				do {
					ry +=dy[k];
					rx +=dx[k];
					if(map[ry][rx]==-1||(ry==START_Y&&rx==START_X)) {
						return;
					}
				}while(map[ry][rx]==0);

				//1~5
				if(map[ry][rx]==1) {
					if(k==2) {
						k=1;
					}else if(k==0) {
						k=3;
					}else if(k==1) {
						k=0;
					}else if(k==3) {
						k=2;
					}
				}else if(map[ry][rx]==2) {
					if(k==2) {
						k=0;
					}else if(k==1) {
						k=3;
					}else if(k==0) {
						k=1;
					}else if(k==3) {
						k=2;
					}
				}else if(map[ry][rx]==3) {
					if(k==1) {
						k=2;
					}else if(k==3) {
						k=0;
					}else if(k==0) {
						k=1;
					}
					else if(k==2) {
						k=3;
					}
				}else if(map[ry][rx]==4) {
					if(k==0) {
						k=2;
					}else if(k==3) {
						k=1;
					}else if(k==2) {
						k=3;
					}else if(k==1) {
						k=0;
					}
				}else if(map[ry][rx]==5) {
					if(k==0) {
						k=1;
					}else if(k==1) {
						k=0;
					}else if(k==2) {
						k=3;
					}else if(k==3) {
						k=2;
					}
				}else if(map[ry][rx]>=6) {
					for(Hall H : moveList[map[ry][rx]-6]) {
						if(H.y==ry&&H.x==rx) continue;
						ry = H.y;
						rx = H.x;
						break;
					}
					y=ry;
					x=rx;
					continue outloof;
				}
				count++;
				y=ry;
				x=rx;
				continue outloof;
			}
	}
}