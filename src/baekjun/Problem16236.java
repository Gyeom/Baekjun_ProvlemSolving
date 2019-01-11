package baekjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem16236 {
		static class Matrix {
			int x;
			int y;
			public Matrix(int y, int x) {
				this.x = x;
				this.y = y;
			}
		}
	
		static int[] dx = {0,0,-1,1};
		static int[] dy = {1,-1,0,0};
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[][] a = new int[N+1][N+1];
			int[][] dist = new int[N+1][N+1];
			boolean[][] visited = new boolean[N+1][N+1];
			int sx =0, sy =0;
			int myLv = 2;
			int eat =0;
			int minTime=999999999;
			int ans =0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					a[i][j]= sc.nextInt();
					if(a[i][j]==9) {
						sy=i;
						sx=j;
						a[i][j]=0;
					}
				}
			}
			do {
			Queue<Matrix> q = new LinkedList<>();
			Matrix m = new Matrix(sy,sx);
			q.add(m);
			visited[m.y][m.x]=true;
			int row=100000;
			int col=0;
			
			while(!q.isEmpty()) {
				m = q.remove();
				if((dist[m.y][m.x]>minTime))break;
				if((a[m.y][m.x]<myLv)&&(a[m.y][m.x]!=0)) {
					if(m.x==2&&m.y==2) {
					}
						if(m.y<row) {
							row= m.y;
							col= m.x;
							minTime = dist[m.y][m.x];
							
						}else if((m.y==row)&&(m.x<col)) {
							row = m.y;
							col = m.x;
							
							
							minTime = dist[m.y][m.x];
						}
						
						
					continue;
				}
				
				
				
				int rx;
				int ry;
			
				for(int k=0; k<4; k++) {
					rx = dx[k]+m.x;
					ry = dy[k]+m.y;
					
					if((rx<1)||(ry<1)||(rx>N)||(ry>N)) continue;
					if(visited[ry][rx]) continue;
					if(myLv>=a[ry][rx]) {
					q.add(new Matrix(ry,rx));
					visited[ry][rx]=true;
					dist[ry][rx]= dist[m.y][m.x]+1;
					}
				}
				
				
			}
			if(minTime==999999999)break;
			sy=row;
			sx=col;
			a[sy][sx]=0;
			visited = new boolean[N+1][N+1];
			dist = new int[N+1][N+1];
			visited[sy][sx]=true;
			ans += minTime;
			minTime=999999999;
			eat++;
			if(myLv==eat) {
				myLv++;
				eat=0;
			}
		
	
			}while(true);
			
			System.out.println(ans);
			
			
			
			
			
			
		}

	}




