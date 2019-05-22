package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea5656_R {
	static int[][] map;
	static int[] way;
	static int N,W,H;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String[] s= br.readLine().split(" ");
			int wall=0;
			N = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			H = Integer.parseInt(s[2]);
			map = new int[H][W];
			way = new int[N];
			for(int i=0; i<H; i++) {
				s= br.readLine().split(" ");
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(map[i][j]!=0) {
						wall++;
					}
				}
			}
			
			ans=0;
			dfs(N,0);
//			System.out.println(ans);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(wall-ans));
			bw.newLine();
//			System.out.println(wall-ans);
		}
		bw.flush();
		bw.close();
	}
	static int count;
	static int ans;
	static int[][] copy;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {

//			//----------------µð¹ö±ë----------------------------
//			if(!Arrays.toString(way).equals("[2, 2, 6]")) return;
//
//			//----------------µð¹ö±ë----------------------------
			count=0;
			copy = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					copy[i][j]=map[i][j];
				}
			}
			outloof:
				for(int i=0; i<N; i++) {
					int H_POSITION = 0;
					while(copy[H_POSITION][way[i]]==0) {
						H_POSITION++;
						if(H_POSITION==H) {
							continue outloof;
						}
					}
					check(H_POSITION,way[i]);
//					System.out.println(i+":"+count);
//					simulation(H_POSITION,way[i],copy[H_POSITION][way[i]],1,-1);
					for(int a=H-2; a>=0; a--) {
						for(int b=0; b<W; b++) {
							int y = a;
							while(y<H-1&&copy[y+1][b]==0) {
								copy[y+1][b]=copy[y][b];
								copy[y][b]=0;
								y++;
							}
						}
					}
				}
			if(count>ans) {
				ans=count;
			}
			return;
		}


		for(int i=0; i<W; i++) {
			way[index]=i;
			dfs(end, index+1);
		}
	}
	private static void check(int y, int x) {
		// TODO Auto-generated method stub
		int REST = copy[y][x];
		count++;
		copy[y][x]=0;
		for(int k=0; k<4; k++) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0|ry>=H||rx>=W) continue;
			simulation(ry,rx,REST,1,k);
		}
	}
	static int[] dy=  {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void simulation(int y, int x,int end, int index,int prev) {
		// TODO Auto-generated method stub
		if(index>=end) {
			return;
		}
	
		int REST=copy[y][x];
		if(copy[y][x]>0) {
			count++;
			copy[y][x]=0;
		}

		for(int k=0; k<4; k++) {
			int ry = dy[k]+y;
			int rx = dx[k]+x;
			if(ry<0||rx<0|ry>=H||rx>=W) continue;
			if(prev==k) {
				if(end-index>=REST) {
					simulation(ry,rx,end,index+1,k);
				}else {
					simulation(ry,rx,REST,1,k);
				}
			}else {
				if((k==1&&prev==0)||(k==0&&prev==1)||(k==3&&prev==2)||(k==2&&prev==3)) {
					for(int i=1; i<REST; i++) {
						int ay = y+i*dy[k];
						int ax = x+i*dx[k];
						if(ay<0||ax<0|ay>=H||ax>=W) continue;
						if(copy[ay][ax]!=0) {
							simulation(ay,ax,copy[ay][ax],1,k);
						}
					}
				}
				simulation(ry,rx,REST,1,k);
			}
		}
	}
}