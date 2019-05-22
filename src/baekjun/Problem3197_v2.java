package baekjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem3197_v2 {
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		int d;
		Pair(int y, int x, int d){
			this.y=y;
			this.x=x;
			this.d=d;
		}
		@Override
		public int compareTo(Pair target) {
			// TODO Auto-generated method stub
			return this.d>target.d?1:-1;
		}		
	}
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] count;
	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		ans=0;
		count = new int[R][C];
		map = new char[R][C];
		PriorityQueue<Pair> mark= new PriorityQueue<>();
		PriorityQueue<Pair> q= new PriorityQueue<>();
		visited= new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='.'||map[i][j]=='L') {
					mark.add(new Pair(i,j,0));
					visited[i][j]=true;
				}
				if(map[i][j]=='L') {
					q.add(new Pair(i,j,0));
				}
			}
		}
		bfs(mark);
		q.remove();
		visited = new boolean[R][C];
		search(q);
	}
	private static void search(PriorityQueue<Pair> q) {
		// TODO Auto-generated method stub
		Pair start = q.remove();
		visited[start.y][start.x]=true;
		q.add(start);
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.y!=start.y&&p.x!=start.x&&map[p.y][p.x]=='L') {
				System.out.println(p.d);
				return;
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=R||rx>=C) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				q.add(new Pair(ry,rx,Math.max(p.d, count[ry][rx])));
			}
		}
	}
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int ans;
	private static void bfs(PriorityQueue<Pair> mark) {
		// TODO Auto-generated method stub
		while(!mark.isEmpty()) {
			Pair p = mark.remove();

			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=R||rx>=C) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				if(map[ry][rx]=='X') {
					mark.add(new Pair(ry,rx,p.d+1));
					count[ry][rx]=p.d+1;
				}else {
					mark.add(new Pair(ry,rx,p.d));
					count[ry][rx]=p.d;
				}
			}
		}
	}
}