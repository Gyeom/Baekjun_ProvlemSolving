package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem14442 {

	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static class Pair{
		int y;
		int x;
		int c;
		int d;
		Pair(int y, int x, int c, int d){
			this.y = y;
			this.x = x;
			this.c = c;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[][] a = new int[N+1][M+1];
		int[][] count = new int[N+1][M+1];
		int[][] visited = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited[i], 1000*1000+1);
			Arrays.fill(count[i],  1000*1000+1);
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				a[i][j]=s.charAt(j-1)-'0';
			}
		}
		
		Queue<Pair> q = new LinkedList<>();
		visited[1][1]=1;
		count[1][1]=0;
		q.add(new Pair(1,1,0,1));
		int ans =1000*1000+1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
	
			if(p.y==N&&p.x==M) {
				if(p.d<ans) {
					ans=p.d;
				}
			}
			
			for(int k=0; k<4; k++) {
				int ry = p.y+dy[k];
				int rx = p.x+dx[k];
				if(ry<1||rx<1||ry>N||rx>M) continue;
				if(a[ry][rx]==1) {
					if(p.c>=K) continue;
					if(visited[ry][rx]<=p.d+1&&count[ry][rx]<=p.c+1) continue;
					q.add(new Pair(ry,rx,p.c+1,p.d+1));
					visited[ry][rx]=p.d+1;
					count[ry][rx]=p.c+1;
				}
				if(a[ry][rx]==0) {
					if(p.c>K) continue;
					if(visited[ry][rx]<=p.d+1&&count[ry][rx]<=p.c) continue;
					q.add(new Pair(ry,rx,p.c,p.d+1));
					visited[ry][rx]=p.d+1;
					count[ry][rx]=p.c;
				}
			}
		}
		
		if(ans==1000*1000+1) {
			bw.write("-1");
		}else {
			bw.write(String.valueOf(ans));
		}
		bw.flush();
		bw.close();
	}

}
