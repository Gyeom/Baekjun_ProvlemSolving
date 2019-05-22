package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem11048 {

	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy= {0,1,1};
	static int[] dx= {1,1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(token.nextToken());
		int M = Integer.valueOf(token.nextToken());
		int[][] a= new int[N][M];
		int[][] dist= new int[N][M];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				a[i][j]=Integer.valueOf(token.nextToken());
				dist[i][j]=-1;
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		dist[0][0]=a[0][0];
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			
			for(int k=0; k<3; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=N||rx>=M) continue;
				if(dist[ry][rx]>=dist[p.y][p.x]+a[ry][rx]) continue;
				dist[ry][rx]=dist[p.y][p.x]+a[ry][rx];
				q.add(new Pair(ry,rx));
			}
		}
		bw.write(String.valueOf(dist[N-1][M-1]));
		bw.flush();
		bw.close();
	}

}
