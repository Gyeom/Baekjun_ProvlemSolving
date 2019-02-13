package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem15558 {

	static class Pair{
		int y;
		int x;
		int t;
		Pair(int y, int x, int t){
			this.y = y;
			this.x = x;
			this.t = t;
			
		}
	}
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] dy = {1,-1,0,0};
		int[] dx = {K,K,-1,1};
		int [][] a = new int[2][N+K];
		boolean[][] visited= new boolean[2][N+K];
		for(int i=0; i<2; i++) {
			String s= sc.next();
			for(int j=0; j<N; j++) {
				a[i][j]=s.charAt(j)-'0';
			}
		}
		for(int i=0; i<2; i++) {
			for(int j=N; j<N+K; j++) {
				a[i][j]=1;
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0,0));
		visited[0][0] = true;
		visited[1][0] = true;
		int ans =0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			
			if(p.x>N-1) {
				ans =1;
				break;
			}
			
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=2||rx>=N+K) continue;
				if(a[ry][rx]==0) continue;
				if(visited[ry][rx]) continue;
				if(k==2&&visited[ry][rx-1]) continue; 
				visited[ry][rx] =true;
				visited[0][p.t] = true;
				visited[1][p.t] = true;
				q.add(new Pair(ry,rx,p.t+1));
			
			}
		}
		System.out.println(ans);
	}

}
