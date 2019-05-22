package SAMSUNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S15683 {
	static int[][] map;
	static int[] way;
	static class CCTV{
		int num;
		int y;
		int x;
		CCTV(int num, int y, int x){
			this.y=y;
			this.x=x;
			this.num=num;
		}
	}
	static ArrayList<CCTV> cctvList;
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans=0;
		map = new int[N][M];
		cctvList = new ArrayList<>();
	
		int wall=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>0&&map[i][j]!=6) {
					cctvList.add(new CCTV(map[i][j],i,j));
				}else if(map[i][j]==6) {
					wall++;
				}
			}
		}
		way = new int[cctvList.size()];
		
		dfs(cctvList.size(), 0);
		System.out.println(N*M-ans-wall-cctvList.size());
	}
	static int[][] copy;
	static int ans;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			copy = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copy[i][j]=map[i][j];
				}
			}
			for(int i=0; i<way.length; i++) {
				CCTV cctv = cctvList.get(i);
				if(cctv.num==1) {
					simulation(cctv.y,cctv.x,way[i]);
				}else if(cctv.num==2) {	
					if(way[i]==0) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,1);
					}else if(way[i]==1) {
						simulation(cctv.y,cctv.x,2);
						simulation(cctv.y,cctv.x,3);
					}else {
						return;
					}
				}else if(cctv.num==3) {
					if(way[i]==0) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,2);
					}else if(way[i]==1) {
						simulation(cctv.y,cctv.x,2);
						simulation(cctv.y,cctv.x,1);
					}else if(way[i]==2) {
						simulation(cctv.y,cctv.x,1);
						simulation(cctv.y,cctv.x,3);
					}else if(way[i]==3) {
						simulation(cctv.y,cctv.x,3);
						simulation(cctv.y,cctv.x,0);
					}
				}else if(cctv.num==4) {
					if(way[i]==0) {
						simulation(cctv.y,cctv.x,1);
						simulation(cctv.y,cctv.x,2);
						simulation(cctv.y,cctv.x,3);
					}else if(way[i]==1) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,2);
						simulation(cctv.y,cctv.x,3);
					}else if(way[i]==2) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,1);
						simulation(cctv.y,cctv.x,3);
					}else if(way[i]==3) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,1);
						simulation(cctv.y,cctv.x,2);
					}
				}else if(cctv.num==5) {
					if(way[i]==0) {
						simulation(cctv.y,cctv.x,0);
						simulation(cctv.y,cctv.x,1);
						simulation(cctv.y,cctv.x,2);
						simulation(cctv.y,cctv.x,3);
					}else {
						return;
					}
				}
			}
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copy[i][j]==9) {
						count++;
					}
				}
			}
			if(count>ans) {
				ans=count;
			}
			return;
		}

		for(int i=0; i<4; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void simulation(int y, int x, int d) {
		// TODO Auto-generated method stub
		int ry=y+dy[d];
		int rx=x+dx[d];
		while(ry>=0&&rx>=0&&ry<N&&rx<M&&copy[ry][rx]!=6) {
			if(copy[ry][rx]==0) {
				copy[ry][rx]=9;
			}
			ry+=dy[d];
			rx+=dx[d];
		}
	}
}