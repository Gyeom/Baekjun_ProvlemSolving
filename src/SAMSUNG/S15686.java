package SAMSUNG;

import java.util.ArrayList;
import java.util.Scanner;

public class S15686 {
	
	static int[][] map;
	static Pair[] way;
	static int N,M;
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static ArrayList<Pair> chickenList;
	static ArrayList<Pair> homeList;
	static int ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		way = new Pair[M];
		ans=Integer.MAX_VALUE;
		chickenList = new ArrayList<>();
		homeList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					homeList.add(new Pair(i,j));
				}else if(map[i][j]==2){
					chickenList.add(new Pair(i,j));
				}
			}
		}
		dfs(0,M,0);
		System.out.println(ans);
	}
	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			int cDistance=0;
			for(Pair home : homeList) {
				int distance=Integer.MAX_VALUE;
				for(Pair chicken : way) {
					distance = Math.min(distance, Math.abs(chicken.y-home.y)+Math.abs(chicken.x-home.x));
				}
				cDistance+=distance;
			}
			if(cDistance<ans) {
				ans=cDistance;
			}
			return;
		}
		
		for(int i=num; i<chickenList.size(); i++) {
			way[index]=chickenList.get(i);
			dfs(i+1,end,index+1);
		}
	}
}