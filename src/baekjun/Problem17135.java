package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Problem17135 {
	static int N,M,D;
	static class Man implements Comparable<Man>{
		int y;
		int x;
		int d;
		Man(int y, int x, int d){
			this.y=y;
			this.x=x;
			this.d=d;
		}

		@Override
		public int compareTo(Man target) {
			// TODO Auto-generated method stub
			if(this.d>target.d) {
				return 1;
			}else if(this.d<target.d) {
				return -1;
			}else {
				return this.x>target.x?1:-1;	
			}

		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		D = Integer.parseInt(s[2]);
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		ans=0;
		way = new int[3];
		dfs(0,3,0);
		System.out.println(ans);
	}
	static int[] way;
	static int[][] copy;
	static int[][] map;
	static int ans;
	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
//			System.out.println(Arrays.toString(way));
			copy = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copy[i][j]=map[i][j];
				}
			}
			s_cnt=0;
			int c = cnt;
			while(c!=0){
				c-=simulation();
				c-=reArray();
			};
			if(s_cnt>ans) {
				ans=s_cnt;
			}


			return;
		}
		for(int i=num; i<M; i++) {
			way[index]=i;
			dfs(i+1,end,index+1);
		}
	}
	private static int reArray() {
		// TODO Auto-generated method stub
		int cnt =0;
		for(int i=0; i<M; i++) {
			if(copy[N-1][i]==1) {
				copy[N-1][i]=0;
				cnt++;
			}
		}
		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<M; j++) {
				copy[i+1][j]=copy[i][j];
			}
		}
		for(int i=0; i<M; i++) {
			copy[0][i]=0;
		}
		return cnt;
	}
	static int cnt;
	static int s_cnt;
	private static int simulation() {
		// TODO Auto-generated method stub
		PriorityQueue<Man> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][M];
		ArrayList<Man> list = new ArrayList<>();
		int cnt=0;
		outloof :
		for(int k=0; k<way.length; k++) {
			q.clear();
			for(int i=N-1; i>=(N-D>=0?N-D:0); i--) {
				for(int j=0; j<M; j++) {
					if(copy[i][j]==0) continue;
					int d= Math.abs(N-i)+Math.abs(way[k]-j);
					if(d>D) continue;
					q.add(new Man(i,j,d));
				}
			}
			if(!q.isEmpty()) {
				Man m = q.remove();
				if(visited[m.y][m.x]) continue outloof;
				visited[m.y][m.x]=true;
				cnt++;
				list.add(new Man(m.y,m.x,m.d));
			}
		}
		for(Man m : list) {
			copy[m.y][m.x]=0;
		}
		s_cnt+=cnt;
		return cnt;
	}
}
