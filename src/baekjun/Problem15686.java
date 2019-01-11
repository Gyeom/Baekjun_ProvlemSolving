package baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem15686 {
	
	static class Matrix{
		int y;
		int x;
	
		public Matrix(int y, int x) {
			this.x = x;
			this.y = y;
		
		}
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

//	public static void main (String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int[][] a = new int[N+1][N+1];
//		int count  = 0;
//		int[][] dist = new int[N+1][N+1];
//		ArrayList<Integer> dists = new ArrayList<>();
//		int min= 9999; //INF
//		boolean[][] visited  = new boolean[N+1][N+1]; 
//		Queue<Matrix> q = new LinkedList<>();;
//		Matrix m;
//		boolean first = true;
//		for(int i =1; i <= N; i++) {
//			for(int j =1; j <= N; j++) {
//				a[i][j]=sc.nextInt();
//				if(a[i][j]==2) {
//					m = new Matrix(i,j);
//					q.add(m);
//					visited[i][j] = true;
//				}
//			}
//		}
//		while(!q.isEmpty()) {
//			m = q.remove();
//			
//		if(a[m.y][m.x]==1) {
//			dists.add(dist[m.y][m.x]);
//		}
//
//			if(count>M) continue;
//			
//			for(int k=0; k<4; k++) {
//				int rx = m.x+dx[k];
//				int ry = m.y+dy[k];
//				if((rx<1)||(ry<1)||(rx>N)||(ry>N)) continue;
//				if(visited[ry][rx]==true) continue;
//				q.add(new Matrix(ry,rx));
//				visited[ry][rx]= true;
//				dist[ry][rx]=dist[m.y][m.x]+1;
//				if(a[ry][rx]==1) {
//					count++;
//				}
//			}
//		}
//		Collections.sort(dists);
//		int distSum=0;
//		for(int z=0; z<M; z++) {
//			distSum += dists.get(z);
//		}
//		if(distSum<min) {
//			min = distSum;
//		}
//		
//
//		System.out.println(min);
//	}
	
//	public static void main (String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int[][] a = new int[N+1][N+1];
//		int hCount=0;
//		int dis;
//		ArrayList<Integer> dist =  new ArrayList<>();
//		int min= 9999; //INF
//		boolean[][] visited;
//		Queue<Matrix> q;
//		for(int i =1; i <= N; i++) {
//			for(int j =1; j <= N; j++) {
//				a[i][j]=sc.nextInt();
//				if(a[i][j]==1) {
//					hCount++;
//				}
//			}
//		}
//		for(int i =1; i <= N; i++) {
//			for(int j =1; j <= N; j++) {
//				if(a[i][j]==2) {
//					q = new LinkedList<>();
//					visited = new boolean[N+1][N+1]; 
//					dis =0;
//					
//					
//					Matrix m = new Matrix(i,j);
//					q.add(m);
//					visited[i][j] = true;
//					
//					while(!q.isEmpty()) {
//						m = q.remove();
//						if(a[m.y][m.x]==1) {
//							dis += Math.abs(m.y-i)+Math.abs(m.x-j);
//						}
//			
//						for(int k=0; k<4; k++) {
//							int rx = m.x+dx[k];
//							int ry = m.y+dy[k];
//							if((rx<1)||(ry<1)||(rx>N)||(ry>N)) continue;
//							if(visited[ry][rx]==true) continue;
//							q.add(new Matrix(ry,rx));
//							visited[ry][rx]= true;
//						
//						}
//					}
//					dist.add(dis);
//				
//				}
//				
//			}
//		}
//		Collections.sort(dist);
//		int dists=0;
//		for(int z=0; z<M; z++) {
//			dists += dist.get(z);
//		}
//		if(dists<min) {
//			min = dists;
//		}
//		System.out.println(min);
//	}
	
	public static void main (String args[]) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int M = sc.nextInt();
	int[][] a = new int[N+1][N+1];
	int count  = 0;
	int[][] dist = new int[N+1][N+1];
	ArrayList<Integer> dists = new ArrayList<>();
	int min= 9999; //INF
	boolean[][] visited  = new boolean[N+1][N+1]; 
	Queue<Matrix> q = new LinkedList<>();;
	Matrix m;
	boolean first = true;
	for(int i =1; i <= N; i++) {
		for(int j =1; j <= N; j++) {
			a[i][j]=sc.nextInt();
			if(a[i][j]==2) {
				m = new Matrix(i,j);
				q.add(m);
				visited[i][j] = true;
			}
		}
	}
	while(!q.isEmpty()) {
		m = q.remove();
		
	if(a[m.y][m.x]==2) {
		dists.add(dist[m.y][m.x]);
	}

		if(count>=M) continue;
		
		for(int k=0; k<4; k++) {
			int rx = m.x+dx[k];
			int ry = m.y+dy[k];
			if((rx<1)||(ry<1)||(rx>N)||(ry>N)) continue;
			if(visited[ry][rx]==true) continue;
			q.add(new Matrix(ry,rx));
			visited[ry][rx]= true;
			dist[ry][rx]=dist[m.y][m.x]+1;
			if(a[ry][rx]==2) {
				count++;
			}
		}
	}
	Collections.sort(dists);
	int distSum=0;
	for(int z=0; z<M; z++) {
		distSum += dists.get(z);
	}
	if(distSum<min) {
		min = distSum;
	}
	

	System.out.println(min);
}
}
