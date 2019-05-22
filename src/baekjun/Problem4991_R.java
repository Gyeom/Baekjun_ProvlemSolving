package baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4991_R {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int w,h;
	static char[][] map;
	static int count;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<Pair> sList;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		w=0;
		h=0;
		outloof:
			do {
				sList= new ArrayList<>(); 
				w = sc.nextInt();
				h = sc.nextInt();
				if(w==0&&h==0) break;
				map = new char[h][w];
				for(int i=0; i<h; i++) {
					String s = sc.next();
					for(int j=0; j<w; j++) {
						map[i][j]=s.charAt(j);
						if(map[i][j]=='o') {
							sList.add(0,new Pair(i,j));
						}else if(map[i][j]=='*') {
							sList.add(new Pair(i,j));
						}
					}
				}
				int[][] d = new int[sList.size()][sList.size()];
				for(int i=0; i<sList.size(); i++) {
					Pair src = sList.get(i);
					int[][] dist = bfs(src);
					for(int j=0; j<sList.size(); j++) {
						Pair dest = sList.get(j);
						d[i][j]=dist[dest.y][dest.x];
						if(d[i][j]==Integer.MAX_VALUE) {
							System.out.println("-1");
							continue outloof;
						}
					}
				}
				visited = new boolean[sList.size()];
				ans=Integer.MAX_VALUE;
				dfs(0,0,sList.size()-1,0,d);
				System.out.println(ans);
			}while(true);
	}
	static boolean[] visited;
	static int ans;
	private static void dfs(int num, int sum, int end, int index, int[][] d) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(sum<ans) {
				ans=sum;
			}
			return;
		}
		for(int i=1; i<sList.size(); i++) {
			if(visited[i]) continue;
			visited[i]=true;
			int next = sum+d[num][i];
			dfs(i,next, end, index+1, d);
			visited[i]=false;
		}
	}
	private static int[][] bfs(Pair start) {
		// TODO Auto-generated method stub
		int[][] dist = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		dist[start.y][start.x]=0;
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=h||rx>=w) continue;
				if(map[ry][rx]=='x') continue;
				if(dist[ry][rx]<=dist[p.y][p.x]+1) continue;
				dist[ry][rx]=dist[p.y][p.x]+1;
				q.add(new Pair(ry,rx));
			}
		}
		return dist;
	}
}