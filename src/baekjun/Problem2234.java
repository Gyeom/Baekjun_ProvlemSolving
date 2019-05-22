package baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2234 {
	static int[] dy = {0,-1,0,1};  
	static int[] dx = {-1,0,1,0}; 
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		boolean[][] visited;
		int[][] num = new int[m][n];
		ArrayList<Integer> numc = new ArrayList<>();
		int count =0;
		int ans_1 =0;
		int ans_2 =0;
		int size=0;
		for(int t=0; t<2; t++) {
			visited = new boolean[m][n];
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(visited[i][j]) continue;
					if(t==0) {
						size=1;
						count++;
						num[i][j]=count;
					}
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i,j));
					visited[i][j]=true;
					while(!q.isEmpty()) {
						Pair p = q.remove();
						for(int k=0; k<4; k++) {
							int ry = dy[k]+p.y;
							int rx = dx[k]+p.x;
							if(ry<0||rx<0||ry>=m||rx>=n) continue;
							if(((1<<k)&a[p.y][p.x])>0) {
								if(t==1&&num[p.y][p.x]!=num[ry][rx]&&numc.get(num[p.y][p.x]-1)+numc.get(num[ry][rx]-1)>ans_2) {
									ans_2=numc.get(num[p.y][p.x]-1)+numc.get(num[ry][rx]-1);
								}
								continue;
							}
							if(visited[ry][rx]) continue;
							q.add(new Pair(ry,rx));
							visited[ry][rx]=true;
							if(t==0) {
								num[ry][rx]=count;
								size++;
							}
						}
					}
					numc.add(size);
					if(size>ans_1) {
						ans_1=size;
					}
				}
			}
			if(t==0) {
				System.out.println(count);
				System.out.println(ans_1);
			}else {
				System.out.println(ans_2);
			}
		}
	}
}