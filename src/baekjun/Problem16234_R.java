package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16234_R {
	static class Country{
		int y;
		int x;
		Country(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N, L, R;
	static int[][] country;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		L = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		country = new int[N][N];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				country[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		int count=0;
		while(solve()) {
			count++;
		};
		System.out.println(count);
	}
	static boolean[][] visited;
	private static boolean solve() {
		// TODO Auto-generated method stub
		visited = new boolean[N][N];
		boolean go = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				if(bfs(i,j)) {
					go=true;
				}
			}
		}
		return go;
	}

	private static boolean bfs(int y, int x) {
		// TODO Auto-generated method stub
		Queue<Country> q = new LinkedList<>();
		ArrayList<Country> group = new ArrayList<>();
		Country start = new Country(y,x);
		q.add(start);
		group.add(start);
		visited[y][x]=true;
		while(!q.isEmpty()) {
			Country p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=N) continue;
				if(visited[ry][rx]) continue;
				if(Math.abs(country[ry][rx]-country[p.y][p.x])<L) continue;
				if(Math.abs(country[ry][rx]-country[p.y][p.x])>R) continue;
				visited[ry][rx]=true;
				Country next = new Country(ry,rx);
				q.add(next);
				group.add(next);
			}
		}
		int sum=0;
		for(Country c : group) {
			sum+= country[c.y][c.x];
		}
		int people = sum/group.size();
		for(Country c : group) {
			country[c.y][c.x]=people;
		}
		return group.size()>1?true:false;
	}
}
