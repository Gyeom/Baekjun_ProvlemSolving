package baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem15683 {
	static class Pair{
		int y;
		int x;
		int num;
		Pair(int y, int x, int num){
			this.y=y;
			this.x=x;
			this.num=num;
		}
	}
	static int[][] a;
	static ArrayList<Pair> al;
	static int N;
	static int M;
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N][M];
		al = new ArrayList<>();
		int wall=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				a[i][j]=sc.nextInt();
				if(a[i][j]!=0&&a[i][j]!=6) {
					al.add(new Pair(i,j,a[i][j]));
				}
				if(a[i][j]==6) {
					wall++;
				}
			}
		}
		bit = new int[al.size()];


		dfs(al.size(),0);
		System.out.println(N*M-al.size()-wall-ans);

	}
	static int[] bit;
	static int ans=0;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			int[][] visited = new int[N][M];
			for(int i=0; i<end; i++) {
				Pair p = al.get(i);
				if(p.num==1) {
					bfs(p,p.num,bit[i],visited);
				}else if(p.num==2) {
					if(bit[i]==1||bit[i]==3) {
						return;
					}
					if(bit[i]==0) {
						bfs(p,p.num,0,visited);
						bfs(p,p.num,1,visited);
					}else if(bit[i]==2){
						bfs(p,p.num,2,visited);
						bfs(p,p.num,3,visited);
					}

				}else if(p.num==3) {
					if(bit[i]==0) {
						bfs(p,p.num,0,visited);
						bfs(p,p.num,3,visited);
					}else if(bit[i]==1) {
						bfs(p,p.num,3,visited);
						bfs(p,p.num,1,visited);
					}else if(bit[i]==2) {
						bfs(p,p.num,1,visited);
						bfs(p,p.num,2,visited);
					}else if(bit[i]==3) {
						bfs(p,p.num,2,visited);
						bfs(p,p.num,0,visited);
					}
				}else if(p.num==4) {
					if(bit[i]!=0) {
						bfs(p,p.num,0,visited);
					}
					if(bit[i]!=1) {
						bfs(p,p.num,1,visited);
					}
					if(bit[i]!=2) {
						bfs(p,p.num,2,visited);
					}
					if(bit[i]!=3) {
						bfs(p,p.num,3,visited);
					}
				}else if(p.num==5) {
					bfs(p,p.num,0,visited);
					bfs(p,p.num,1,visited);
					bfs(p,p.num,2,visited);
					bfs(p,p.num,3,visited);
				}

			}
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]>0) {
						count++;
					}
				}
			}
			if(count>ans) {
				ans =count;
			}
			return;
		}

		for(int i=0; i<4; i++) {
			bit[index]=i;
			dfs(end, index+1);
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void bfs(Pair p, int num, int k,int[][] visited) {
		// TODO Auto-generated method stub
		Queue<Pair> q = new LinkedList<>();
		q.add(p);
		while(!q.isEmpty()) {
			p = q.remove();
			int ry = dy[k]+p.y;
			int rx = dx[k]+p.x;
			if(ry<0||rx<0||ry>=N||rx>=M) continue;
			if(a[ry][rx]==6) continue;
			if(a[ry][rx]==0) {
				visited[ry][rx]++;
			}
			q.add(new Pair(ry,rx,p.num));
		}
	}
}