	package baekjun;
	
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;
	
	public class Problem14503 {
		static class Bot{
			int y;
			int x;
			int d;
			Bot(int y, int x, int d){
				this.y=y;
				this.x=x;
				this.d=d;
			}
		}
		static int N;
		static int M;
		static int[][] map;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc= new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			bfs(new Bot(r,c,d));
		}
		static int[] dy = {-1,0,1,0};
		static int[] dx = {0,1,0,-1};
		static int count;
		private static void bfs(Bot bot) {
			// TODO Auto-generated method stub
			count=1;
			Queue<Bot> q = new LinkedList<>();
			q.add(bot);
			boolean[][] visited = new boolean[N][M];
			visited[bot.y][bot.x]=true;
			outloof:
				while(!q.isEmpty()) {
					Bot p = q.remove();
					for(int i=p.d-1; i>=p.d-4; i--) {
						int k=i;
						if(k<0) {
							k+=4;
						}
						int ry = dy[k]+p.y;
						int rx = dx[k]+p.x;
						if(ry<0||rx<0||ry>=N||rx>=M||map[ry][rx]==1) continue;
						if(visited[ry][rx]) continue;
						visited[ry][rx]=true;
						count++;
						q.add(new Bot(ry,rx,k));
						continue outloof;
					}
					int d = (p.d%2==0?2-p.d:4-p.d);
					int ay = dy[d]+p.y;
					int ax = dx[d]+p.x;
					if(ay<0||ax<0||ay>=N||ax>=M||map[ay][ax]==1) {
						System.out.println(count);
						break;
					}
					q.add(new Bot(ay,ax,p.d));	
				}
		}	
	}