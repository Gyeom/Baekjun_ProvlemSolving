package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1987_v2 {
	static int R;
	static int C;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans =0;
	static int[][] a;
	static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		a= new int[R+1][C+1];
		visited = new boolean[100];
		for (int i=1; i<=R; i++) {
			String s = br.readLine();
			for (int j=1; j<=C; j++) {
				a[i][j]= (int)s.charAt(j-1);
			}
		}

		visited[a[1][1]]=true;
		dfs(1,1,R*C,1,1);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static void dfs(int p_i, int p_j, int end, int index, int count) {
		// TODO Auto-generated method stub
		if(count>ans) {
			ans=count;
		}
		if(index==end) {
			return;
		}
		for(int i=0; i<4; i++) {
			int ry = p_i+dy[i];
			int rx = p_j+dx[i];
			if(ry<1||rx<1||ry>R||rx>C) continue;
			if(visited[a[ry][rx]]) continue;
			visited[a[ry][rx]]=true;
			dfs(ry,rx,end,index+1,count+1);
			visited[a[ry][rx]]=false;
		}
	}
}