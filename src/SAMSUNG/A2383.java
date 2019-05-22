package SAMSUNG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class A2383 {
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		int DIST_RUN;
		int DIST_DOWN;
		Pair(int y, int x, int DIST_RUN,int DIST_DOWN){
			this.y=y;
			this.x=x;
			this.DIST_RUN=DIST_RUN;
			this.DIST_DOWN=DIST_DOWN;
		}
		@Override
		public int compareTo(Pair target) {
			// TODO Auto-generated method stub
			return this.DIST_RUN>target.DIST_RUN?1:-1;
		}
		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + ", DIST_RUN=" + DIST_RUN + ", DIST_DOWN=" + DIST_DOWN + "]";
		}
		
	}
	static ArrayList<Pair> manList;
	static Pair[] stairList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			ans=Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			manList = new ArrayList<>();
			stairList = new Pair[2];
			int index=0;
			for(int i=0; i<N; i++) {
				String[] s= br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(map[i][j]==1) {
						manList.add(new Pair(i,j,0,0));
					}else if(map[i][j]>1) {
						stairList[index++]=new Pair(i,j,0,map[i][j]);
					}
				}
			}
			way = new int[manList.size()];
			dfs(manList.size(),0);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] way;
	static int ans;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			PriorityQueue<Pair>[] q=(PriorityQueue<Pair>[]) new PriorityQueue[2];
			q[0]= new PriorityQueue<>();
			q[1]= new PriorityQueue<>();
			for(int i=0; i<way.length; i++) {
				Pair man = manList.get(i);
				Pair stair = stairList[way[i]];
				man.DIST_DOWN=stair.DIST_DOWN;
				man.DIST_RUN=Math.abs(man.y-stair.y)+Math.abs(man.x-stair.x);
				q[way[i]].add(man);
			}
			int t=0;
			for(int i=0; i<2; i++) {
				t=Math.max(t, bfs(q[i]));
			}
			if(t<ans) {
				ans=t;
			}
			return;
		}
		
		for(int i=0; i<2; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	private static int bfs(PriorityQueue<Pair> RUNNING_LIST) {
		// TODO Auto-generated method stub
		Queue<Pair> WAITING_LIST = new LinkedList<>();
		Queue<Pair> USING_LIST = new LinkedList<>();
		for(int t=1; t<Integer.MAX_VALUE; t++) {
			if(WAITING_LIST.size()==0&&RUNNING_LIST.size()==0&&USING_LIST.size()==0) {
				return t-1;
			}
			Iterator<Pair> it = USING_LIST.iterator();
			while(it.hasNext()) {
				Pair man = it.next();
				man.DIST_DOWN--;
				if(man.DIST_DOWN==0) {
					it.remove();
				}
			}
			while(USING_LIST.size()<3&&WAITING_LIST.size()>0) {
				USING_LIST.add(WAITING_LIST.remove());
			}
			
			while(RUNNING_LIST.size()>0&&RUNNING_LIST.peek().DIST_RUN==t){
				WAITING_LIST.add(RUNNING_LIST.remove());
			}
		}
		return -1;
	}
}