package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem15686_v2 {

	static class Pair{
		int y;
		int x;
		int c;
		Pair(int y, int x, int c){
			this.y=y;
			this.x=x;
			this.c=c;
		}
	}

	static ArrayList<Pair> al;
	static int[][] a;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		a= new int[N][N];
		al = new ArrayList<>();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				a[i][j]=sc.nextInt();
				if(a[i][j]==2) {
					al.add(new Pair(i,j,0));
					a[i][j]=0;
				}
			}
		}
		dfs(0,M,al.size(),0);
		System.out.println(ans);
	}
	static int ans=50000;
	private static void dfs(int begin, int end, int size, int index) {
		// TODO Auto-generated method stub
		if(index == end) {
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(a[i]));
//			}
//			System.out.println();
			Queue<Pair> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			for(int i=0; i<size; i++) {
				Pair p = al.get(i);
				int y = p.y;
				int x = p.x;
				if(a[y][x]!=2) continue;
				q.add(p);
				visited[y][x]=true;
			}
			int count = bfs(q, visited);
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(a[i]));
//			}
//			System.out.println(count);
			if(count<ans) {
				ans=count;
			}
			return;
		}
		for(int i=begin; i<size; i++) {
			int y = al.get(i).y;
			int x = al.get(i).x;
			a[y][x]=2;
			dfs(i+1,end,size,index+1);
			a[y][x]=0;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	private static int bfs(Queue<Pair> q, boolean[][] visited) {
		// TODO Auto-generated method stub
		int count=0;
		while(!q.isEmpty()) {
			Pair p = q.remove();

			if(a[p.y][p.x]==1) {
				count+=p.c;
			}

			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				q.add(new Pair(ry,rx,p.c+1));
			}
		}

		return count;
	}

}
