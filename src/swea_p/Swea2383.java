package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Swea2383 {
	static class Man implements Comparable<Man>{
		int y;
		int x;
		int dist;
		int RUNNING_DIST;
		Man(int y, int x){
			this.y=y;
			this.x=x;
			this.dist=0;
			this.RUNNING_DIST=0;
		}
		@Override
		public int compareTo(Man target) {
			// TODO Auto-generated method stub
			return this.dist>target.dist?1:-1;
		}
	}
	static ArrayList<Man> manList;
	static int GROUP_A_Y;
	static int GROUP_A_X;
	static int GROUP_B_Y;
	static int GROUP_B_X;
	static int[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			manList = new ArrayList<>();
			int index=0;
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(map[i][j]==1) {
						manList.add(new Man(i,j));
					}else if(map[i][j]>=2){
						if(index==0) {
							GROUP_A_Y=i;
							GROUP_A_X=j;
							index++;
						}else {
							GROUP_B_Y=i;
							GROUP_B_X=j;
						}
					}
				}
			}
			way = new int[manList.size()];
			ans=Integer.MAX_VALUE;
			dfs(manList.size(),0);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static PriorityQueue<Man> GROUP_A;
	static PriorityQueue<Man> GROUP_B;
	static int[] way;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			GROUP_A = new PriorityQueue<>();
			GROUP_B = new PriorityQueue<>();
			for(int i=0; i<way.length; i++) {
				if(way[i]==0) {
					Man m = manList.get(i);
					m.dist = Math.abs(GROUP_A_Y-m.y)+Math.abs(GROUP_A_X-m.x)+1;
					GROUP_A.add(m);
				}else {
					Man m = manList.get(i);
					m.dist = Math.abs(GROUP_B_Y-m.y)+Math.abs(GROUP_B_X-m.x)+1;
					GROUP_B.add(m);
				}
			}
			int time = Math.max(simulation(GROUP_A,map[GROUP_A_Y][GROUP_A_X]), simulation(GROUP_B,map[GROUP_B_Y][GROUP_B_X]));
			if(time<ans) {
				ans=time;
			}
			return;
		}
		for(int i=0; i<=1; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	static final int MAX_SIZE=3;
	static int ans;
	private static int simulation(PriorityQueue<Man> NON_LIST, int DISTANCE) {
		// TODO Auto-generated method stub
		if(NON_LIST.size()==0) return 0;
		Queue<Man> WAITING_LIST = new LinkedList<>();
		Queue<Man> RUNNING_LIST = new LinkedList<>();
		for(int t=0; t<Integer.MAX_VALUE; t++) {
			if(NON_LIST.isEmpty()&&WAITING_LIST.isEmpty()&&RUNNING_LIST.isEmpty()) {
				return t-1;
			}
			while(!NON_LIST.isEmpty()&&NON_LIST.peek().dist==t) {
				WAITING_LIST.add(NON_LIST.remove());
			}
			int RUNNING_SIZE = RUNNING_LIST.size();
			while(RUNNING_SIZE-->0) {
				Man m = RUNNING_LIST.remove();
				m.RUNNING_DIST+=1;
				if(m.RUNNING_DIST==DISTANCE) {
					m.dist=0;
					m.RUNNING_DIST=0;
					continue;
				}
				RUNNING_LIST.add(m);
			}
			while(RUNNING_LIST.size()<MAX_SIZE&&!WAITING_LIST.isEmpty()) {
				RUNNING_LIST.add(WAITING_LIST.remove());
			}
		}
		return 0;
	}
}