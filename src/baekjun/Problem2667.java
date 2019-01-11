package baekjun;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem2667 {
	
	static class Matrix{
		int x;
		int y;
		
		public Matrix(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Matrix>[][] a;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Matrix[][] a = new Matrix[N+1][N+1];
		boolean[][] visited = new boolean[N+1][N+1];
		int [][] data = new int[N+1][N+1];
		ArrayList<Integer> counts = new ArrayList<>();
		sc.nextLine();
		for(int i=1; i<=N; i++) {
			String s = sc.nextLine();
			for(int j=1; j<=N; j++) {
				
			a[i][j] =new Matrix(i,j);
			data[i][j] = s.charAt(j-1)-'0';
			}
		}
		Queue<Matrix> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if((visited[i][j]==false)&&(data[i][j]==1)) {
					Matrix x = new Matrix(i,j);
					q.add(x);
					visited[i][j]=true;
					int count = 1;
					while(!q.isEmpty()) {
						x = q.remove();
						for(int k=0; k<4; k++) {
							int rx = x.x+dx[k], ry = x.y+dy[k];
							if((rx>=0)&&(rx<=N)&&(ry>=0)&&(ry<=N)&&(data[rx][ry]==1)&&(visited[rx][ry]==false)) {
							q.add(a[rx][ry]);
							visited[rx][ry]=true;
							count++;
							}
						}

					}
					counts.add(count);

				}
			}
		}
		
		Collections.sort(counts);
		System.out.println(counts.size());
		for(int i : counts) {
			System.out.println(i);
		}
		
	}
}
