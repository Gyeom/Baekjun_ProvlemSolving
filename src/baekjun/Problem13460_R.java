package baekjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13460_R{
	static int N;
	static int M;
	static int[] way;
	static int START_RED_Y;
	static int START_RED_X;
	static int START_BLUE_Y;
	static int START_BLUE_X;
	static int START_HOLE_Y;
	static int START_HOLE_X;
	static char[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] c = br.readLine().split(" ");
		N = Integer.parseInt(c[0]);
		M = Integer.parseInt(c[1]);
		way = new int[10];
		map = new char[N][M];
		ans= Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='R') {
					START_RED_Y=i;
					START_RED_X=j;
				}else if(map[i][j]=='B') {
					START_BLUE_Y=i;
					START_BLUE_X=j;	
				}else if(map[i][j]=='O') {
					START_HOLE_Y=i;
					START_HOLE_X=j;
				}
			}
		}
		dfs(10,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(ans==1) {
			return;
		}
		if(index==end) {
			check();
			return;
		}

		for(int i=0; i<4; i++) {
			way[index]=i;
			if(index!=0) {
				if(way[index]==way[index-1]) continue;
				if(way[index]==0&&way[index-1]==1) continue;
				if(way[index]==1&&way[index-1]==0) continue;
				if(way[index]==2&&way[index-1]==3) continue;
				if(way[index]==3&&way[index-1]==2) continue;
			}
			dfs(end,index+1);
		}
	}
	static class Marble{
		int y;
		int x;
		char color;
		Marble(int y, int x, char color){
			this.y=y;
			this.x=x;
			this.color=color;
		}
	}
	static int ans;
	static char[][] copy;
	private static void check() {
		// TODO Auto-generated method stub
		Marble B = new Marble(START_BLUE_Y,START_BLUE_X,'B');
		Marble R = new Marble(START_RED_Y,START_RED_X,'R');
		copy = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j]=map[i][j];
			}
		}
		for(int i=0; i<10; i++) {
			boolean BLUE = false;
			boolean RED = false;
			if(way[i]==0) {
				if(R.y<B.y) {
					BLUE = simulation(B,way[i]);
					RED = simulation(R,way[i]);
				}else {
					RED = simulation(R,way[i]);
					BLUE = simulation(B,way[i]);
				}
			}else if(way[i]==1) {
				if(R.y<B.y) {
					RED = simulation(R,way[i]);
					BLUE = simulation(B,way[i]);
				}else {
					BLUE = simulation(B,way[i]);
					RED = simulation(R,way[i]);
				}
			}else if(way[i]==2) {
				if(R.x<B.x) {
					RED = simulation(R,way[i]);
					BLUE = simulation(B,way[i]);
				}else {
					BLUE = simulation(B,way[i]);
					RED = simulation(R,way[i]);
				}
			}else if(way[i]==3) {
				if(R.x>B.x) {
					RED = simulation(R,way[i]);
					BLUE = simulation(B,way[i]);
				}else {
					BLUE = simulation(B,way[i]);
					RED= simulation(R,way[i]);
				}

			}
			if(BLUE) break;
			if(RED) {
				if(i+1<ans) {
					ans=i+1;
				}
				break;
			}
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	private static boolean simulation(Marble marble, int k) {
		// TODO Auto-generated method stub
		while(true) {
			int ry = dy[k]+marble.y;
			int rx = dx[k]+marble.x;
			if(ry<0||rx<0||ry>=N||rx>=M) return false;
			if(copy[ry][rx]=='B'&&marble.color=='R') return false;
			if(copy[ry][rx]=='R'&&marble.color=='B') return false;
			if(copy[ry][rx]=='#') return false;
			copy[marble.y][marble.x]='.';
			if(copy[ry][rx]=='O') return true;
			copy[ry][rx]=marble.color;
			marble.y=ry;
			marble.x=rx;
		}
	}
}