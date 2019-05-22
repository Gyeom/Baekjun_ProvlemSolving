package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S14503 {
	static int[][] map;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
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
		System.out.println(bfs(new Bot(r,c,d)));
	}
	static int N;
	static int M;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	private static int bfs(Bot bot) {
		// TODO Auto-generated method stub
		Queue<Bot> q= new LinkedList<>();
		q.add(bot);
		int count=0;
		boolean[][] visited = new boolean[N][M];
		visited[bot.y][bot.x]=true;
		count++;
		int y=0;
		int x=0;
		int d=0;
		do {
			outloof:
				while(!q.isEmpty()) {
					Bot p = q.remove();
					d=p.d;
					y=p.y;
					x=p.x;
					for(int k=1; k<=4; k++) {
						int rd = p.d-k>=0?p.d-k:4+p.d-k;
						int ry = p.y+dy[rd];
						int rx = p.x+dx[rd];
						if(ry<0||rx<0||ry>=N||rx>=M) continue;
						if(map[ry][rx]==1) continue;
						if(visited[ry][rx]) continue;
						visited[ry][rx]=true;
						count++;
						q.add(new Bot(ry,rx,rd));
						continue outloof;
					}
				}
		int ad = d+2>=4?d-2:d+2;
		int ay = y+dy[ad];
		int ax = x+dx[ad];
		if(ay<0||ax<0||ay>=N||ax>=M||map[ay][ax]==1) break;
		q.add(new Bot(ay,ax,d));
		}while(true);
		return count;
	}
}