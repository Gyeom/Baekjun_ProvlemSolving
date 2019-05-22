package SAMSUNG;

import java.util.Scanner;

public class S12100 {
	static int N;
	static int[][] map;
	static int[] way;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		way = new int[5];
		ans=0;
		dfs(5,0);
		System.out.println(ans);
	}
	static int[][] copy;
	static int ans;
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			copy = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					copy[i][j]=map[i][j];
				}
			}
			for(int i=0; i<way.length; i++) {
				simulation(way[i]);
			}
			int max=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = Math.max(max, copy[i][j]);
				}
			}
			ans = Math.max(max, ans);
			return;
		}
		for(int i=0; i<4; i++) {
			way[index]=i;
			dfs(end,index+1);
		}
	}
	private static void simulation(int d) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[N][N];
		if(d==0) {
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<N; j++) {
					int k=1;
					while(i+k<N&&copy[i+k][j]==0) {
						copy[i+k][j]=copy[i+k-1][j];
						copy[i+k-1][j]=0;
						k++;
					}
					if(i+k<N&&copy[i+k][j]==copy[i+k-1][j]) {
						if(visited[i+k][j]) continue;
						copy[i+k][j]*=2;
						visited[i+k][j]=true;
						copy[i+k-1][j]=0;
					}
				}
			}
		}else if(d==1) {
			for(int i=1; i<N; i++) {
				for(int j=0; j<N; j++) {
					int k=1;
					while(i-k>=0&&copy[i-k][j]==0) {
						copy[i-k][j]=copy[i-k+1][j];
						copy[i-k+1][j]=0;
						k++;
					}
					if(i-k>=0&&copy[i-k][j]==copy[i-k+1][j]) {
						if(visited[i-k][j]) continue;
						copy[i-k][j]*=2;
						visited[i-k][j]=true;
						copy[i-k+1][j]=0;
					}
				}
			}
		}else if(d==2) {
			for(int i=0; i<N; i++) {
				for(int j=1; j<N; j++) {
					int k=1;
					while(j-k>=0&&copy[i][j-k]==0) {
						copy[i][j-k]=copy[i][j-k+1];
						copy[i][j-k+1]=0;
						k++;
					}
					if(j-k>=0&&copy[i][j-k]==copy[i][j-k+1]) {
						if(visited[i][j-k]) continue;
						copy[i][j-k]*=2;
						visited[i][j-k]=true;
						copy[i][j-k+1]=0;
					}
				}
			}
		}else if(d==3) {
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					int k=1;
					while(j+k<N&&copy[i][j+k]==0) {
						copy[i][j+k]=copy[i][j+k-1];
						copy[i][j+k-1]=0;
						k++;
					}
					if(j+k<N&&copy[i][j+k]==copy[i][j+k-1]) {
						if(visited[i][j+k]) continue;
						copy[i][j+k]*=2;
						visited[i][j+k]=true;
						copy[i][j+k-1]=0;
					}
				}
			}
		}
	}

}
