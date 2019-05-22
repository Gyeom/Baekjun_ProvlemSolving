package baekjun;

import java.util.Scanner;

public class Problem12100_v2 {

	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		int[][] a = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				a[i][j]=sc.nextInt();
				if(a[i][j]>ans) {
					ans=a[i][j];
				}
			}
		}
		for(int i=0; i<(1<<10); i++) {
			int num=i;
			int[] way = new int[5];
			for(int j=0; j<5; j++) {
				int temp =num%4;
				num>>=2;
			way[j]=temp;
			}
			int temps[][] = new int[N][N];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					temps[j][k]=a[j][k];
				}
			}
			solve(way,temps);
		}
		System.out.println(ans);
	}

	static boolean[][] visited;
	private static void solve(int[] way,int[][] a) {
		// TODO Auto-generated method stub

		for(int i=0; i<5; i++) {
			visited = new boolean[N][N];
			if(way[i]==0) {
				for(int j=N-1; j>=0; j--) {
					for(int k=0; k<N; k++) {
						a=bfs(j,k,way[i],a);
					}
				}
			}else if(way[i]==1) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<N; k++) {
						a=bfs(j,k,way[i],a);
					}
				}
			}else if(way[i]==2) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<N; k++) {
						a=bfs(j,k,way[i],a);
					}
				}
			}else if(way[i]==3) {
				for(int j=N-1; j>=0; j--) {
					for(int k=N-1; k>=0; k--) {
						a=bfs(j,k,way[i],a);
					}
				}
			}
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans=0;
	private static int[][] bfs(int y,int x,int k,int[][] a) {
		// TODO Auto-generated method stub
		int ry = y;
		int rx = x;
		int count=0;
		do {
			ry+=dy[k];
			rx+=dx[k];
			count++;
			if(ry<0||rx<0||ry>N-1||rx>N-1||visited[ry][rx]) {
				if(count!=1) {
					a[ry-dy[k]][rx-dx[k]]=a[y][x];
					a[y][x]=0;
				}
				return a;
			}
		}while(a[ry][rx]==0);

		if(a[ry][rx]!=a[y][x]) {
			if(count!=1) {	
				a[ry-dy[k]][rx-dx[k]]=a[y][x];
				a[y][x]=0;
			} 
			return a;
		}
		if(a[ry][rx]==a[y][x]) {
			visited[ry][rx]=true;
			a[ry][rx]*=2;
			if(a[ry][rx]>ans) {
				ans=a[ry][rx];
			}
			a[y][x]=0;
		}
		return a;
	}
}