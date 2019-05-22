package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem7576 {
	static class Pair{
		int y; int x; int dist;
		Pair(int y, int x, int dist){
			this.y =y;
			this.x= x;
			this.dist=dist;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		Queue<Pair> q = new LinkedList<>();
		int count=0;
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1) {
					q.add(new Pair(i,j,0));
				}else if(map[i][j]==0) {
					count++;
				}
			}
		}
		int max=0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			if(p.dist>max) {
				max=p.dist;
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(map[ry][rx]!=0) continue;
				map[ry][rx]=map[p.y][p.x]+1;
				q.add(new Pair(ry,rx,p.dist+1));
				count--;
			}
		}
		if(count!=0) {
			System.out.println("-1");
		}else {
			System.out.println(max);
		}
	}
}
