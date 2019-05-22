package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4991_v2 {

	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		outloof:
			do {
				int W = sc.nextInt();
				int H = sc.nextInt();
				if(W==0&&H==0) break;
				ArrayList<Pair> start = new ArrayList<>();
				char[][] a = new char[H][W];
				for(int i=0; i<H; i++) {
					String s=sc.next();
					for(int j=0; j<W; j++) {
						a[i][j]=s.charAt(j);
						if(a[i][j]=='o') {
							start.add(0, new Pair(i,j));
						}else if(a[i][j]=='*') {
							start.add(new Pair(i,j));
						}
					}
				}

				int[][] d = new int[start.size()][start.size()];
				for(int i=0; i<start.size(); i++) {
					int[][] temp = bfs(start.get(i),H,W,a);
					for(int j=0; j<start.size(); j++) {
						if(i==j) continue;
						for(int n=0; n<H; n++) {
							for(int m=0; m<W; m++) {
								if(n==start.get(j).y&&m==start.get(j).x) {
									if(temp[n][m]==-1) {
										System.out.println("-1");
										continue outloof;
									}
								
									d[i][j]=temp[n][m];
								}
							}
						}

					}

				}
				boolean[] visit = new boolean[start.size()];
				dfs(0,start.size()-1,0,d,visit,start);
				System.out.println(ans);
				ans=4000;
				sum=0;
			}while(true);

	}
	static int ans=4000;
	static int sum=0;
	private static void dfs(int num, int end, int index,int[][] d,boolean[] visit, ArrayList<Pair> start) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(sum<ans) {
				ans =sum;

			}
			return;
		}
		for(int i=1; i<=end; i++) {
			if(visit[i])continue;
			visit[i]=true;
			sum+=d[num][i];
			dfs(i,end,index+1,d,visit,start);
			sum-=d[num][i];
			visit[i]=false;
		}
	}
	private static int[][] bfs(Pair start, int H, int W,char[][] a) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		int[][] dist = new int[H][W];
		for(int[] temp : dist) {
			Arrays.fill(temp, -1);
		}

		q.add(start);
		dist[start.y][start.x]=0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int i=0; i<4; i++) {
				int ry = dy[i]+p.y;
				int rx = dx[i]+p.x;
				if(ry<0||rx<0||rx>=W||ry>=H) continue;
				if(a[ry][rx]=='x') continue;
				if(dist[ry][rx]!=-1) continue;
				dist[ry][rx]=dist[p.y][p.x]+1;
				q.add(new Pair(ry,rx));

			}
		}

		return dist;
	}

}
