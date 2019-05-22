package baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem14502 {
	static int N;
	static int M;
	static boolean[][] visited;
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static ArrayList<Pair> al;
	static int safe=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N  = sc.nextInt();
		M  = sc.nextInt();
		visited = new boolean[N][M];
		int[][] a = new int[N][M];
		al = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				a[i][j]=sc.nextInt();
				if(a[i][j]==0) {
					safe++;
				}else if(a[i][j]==2) {
					al.add(new Pair(i,j));
				}
			}
		}
		dfs(3,0,a);
		System.out.println(ans-3);
	}

	static int ans =0;
	private static void dfs(int end, int index, int[][] a) {
		// TODO Auto-generated method stub
		if(index==end) {
				int temp = bfs(al,a);
				if(safe-temp>ans) {
					ans=safe-temp;
				}
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(a[i][j]==1||a[i][j]==2) continue;
				if(visited[i][j]) continue;
				visited[i][j]=true;
				a[i][j]=1;
				dfs(end,index+1,a);
				a[i][j]=0;
				visited[i][j]=false;
			}
		}
	}
	
	static boolean[][] visited_p;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static int bfs(ArrayList<Pair> al, int[][] a) {
		// TODO Auto-generated method stub
		Queue<Pair> q= new LinkedList<>();
		visited_p = new boolean[N][M];
		for(int i=0; i<al.size(); i++) {
			Pair temp = al.get(i);
			q.add(new Pair(temp.y,temp.x));
			visited_p[temp.y][temp.x]=true;
		}
		
		int count=0;
		while(!q.isEmpty()){
			Pair p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(visited_p[ry][rx]) continue;
				if(a[ry][rx]==1) continue;
				visited_p[ry][rx]=true;
				q.add(new Pair(ry,rx));
				count++;
			}
		}
		return count;
	}
}