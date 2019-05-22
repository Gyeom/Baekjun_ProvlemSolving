package baekjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem15684 {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int N;
	static int H;
	static int[][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		H = sc.nextInt();
		a = new int[H+1][N+1];
		for(int i=0; i<M; i++) {
			int y =sc.nextInt();
			int x =sc.nextInt();
			a[y][x]=1;
			a[y][x+1]=-1;
		}
		boolean go = false;
		for(int i=1; i<=N+1; i++) {
			if(i==N+1) {
				go=true;
				break;
			}
			if(!bfs(i)) {
				break;
			}
		}
		if(go) {
			System.out.println("0");
		}else {
			for(int i=1; i<=4; i++) {
				if(i==4) {
					System.out.println("-1");
					break;
				}
				boolean[][] visited = new boolean[H+1][N+1];
				if(dfs(i,0,visited,1,1)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	private static boolean dfs(int end, int index, boolean[][] visited,int x, int y) {
		// TODO Auto-generated method stub
		if(index==end) {
			for(int i=1; i<=N; i++) {
				if(!bfs(i)) {
					return false;
				}
			}
			return true;
		}
		if(y==N) {
			y=1;
			x++;
		}

		for(int i=x; i<=H; i++) {
			for(int j=y; j<N; j++) {
				if(a[i][j]==1||a[i][j]==-1||a[i][j+1]==1) continue;
				if(visited[i][j]) continue;
				visited[i][j]=true;
				a[i][j]=1;
				a[i][j+1]=-1;
				if(dfs(end,index+1,visited,i,j+1)) {
					visited[i][j]=false;
					a[i][j]=0;
					a[i][j+1]=0;
					return true;
				}
				visited[i][j]=false;
				a[i][j]=0;
				a[i][j+1]=0;
			}
		}
		return false;
	}
	private static boolean bfs(int num) {
		// TODO Auto-generated method stub
		Queue<Pair> q  = new LinkedList<>();
		q.add(new Pair(1,num));
		while(!q.isEmpty()) {
			Pair p = q.remove();

			if(p.y==H) {
				int rx= p.x;
				if(a[p.y][p.x]==1) {
					rx++;
				}
				if(a[p.y][p.x]==-1) {
					rx--;
				}
				if(rx==num) {
					return true;
				}else {
					return false;
				}
			}
			int ry =p.y;
			int rx =p.x;
			if(a[p.y][p.x]==1) {
				rx +=1;
				ry +=1;
				if(rx>N||ry>H) continue;
				q.add(new Pair(ry,rx));
			}else if(a[p.y][p.x]==-1) {
				rx -=1;
				ry +=1;
				if(rx<1||ry>H) continue;
				q.add(new Pair(ry,rx));
			}else {
				ry +=1;
				if(ry>H) continue;
				q.add(new Pair(ry,rx));
			}
		}
		return false;
	}
}
