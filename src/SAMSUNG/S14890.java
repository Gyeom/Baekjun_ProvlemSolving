package SAMSUNG;

import java.util.Scanner;

public class S14890 {

	
	static int N,L;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		int[][] map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int count=0;
		for(int i=0; i<N; i++) {
			if(simulation(i, map)) count++;
		}
		int[][] copy = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j]=map[j][i];
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			if(simulation(i, copy)) count++;
		}
		System.out.println(count);
	}
	private static boolean simulation(int y, int[][] map) {
		// TODO Auto-generated method stub
		for(int x=0; x<N-1; x++) {
			if(map[y][x+1]>map[y][x]+1) return false;
			if(map[y][x+1]>map[y][x]) {
				visited[y][x]=true;
				for(int z=1; z<L; z++) {
					if(x-z<0) return false;
					if(map[y][x-z]!=map[y][x]) return false;
					visited[y][x-z]=true;
				}
			}
		}
		for(int x=0; x<N-1; x++) {
			if(map[y][x+1]<map[y][x]-1) return false;
			if(map[y][x+1]<map[y][x]) {
				int temp = map[y][x+1];
				for(int z=1; z<=L; z++) {
					if(x+z>=N) return false;
					if(visited[y][x+z]) return false; 
					if(map[y][x+z]!=temp) return false;
					visited[y][x+z]=true;
				}
			}
		}
		return true;
	}

}
