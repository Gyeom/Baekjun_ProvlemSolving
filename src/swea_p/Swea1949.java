package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1949 {
	static class Mountain{
		int y;
		int x;
		int h;
		Mountain(int y, int x, int h ){
			this.y=y;
			this.x=x;
			this.h=h;
		}
	}
	static boolean[][] visited;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc=1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			map = new int [N][N];
			ArrayList<Mountain> M_list= new ArrayList<>();
			count=0;
			for(int i=0; i<N ;i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
					if(M_list.isEmpty()||map[i][j]==M_list.get(0).h) {
						M_list.add(new Mountain(i,j,map[i][j]));
					}else if(map[i][j]>M_list.get(0).h) {
						M_list.clear();
						M_list.add(new Mountain(i,j,map[i][j]));
					}
				}
			}
			for(int k=0; k<=K; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						map[i][j]-=k;
						for(int a=0; a<M_list.size(); a++) {
							Mountain m = M_list.get(a);
							visited = new boolean[N][N];
							visited[m.y][m.x]=true;
							dfs(m.y,m.x,1);
							visited[m.y][m.x]=false;
						}
						map[i][j]+=k;
					}
				}
			}
			sb.append("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		System.out.println(sb);
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int count;
	private static void dfs(int y, int x,int index) {
		// TODO Auto-generated method stub
		if(index>count) {
			count=index;
		}
		for(int k=0; k<4; k++) {
			int ry = y+dy[k];
			int rx = x+dx[k];
			if(ry<0||rx<0||ry>=N||rx>=N) continue;
			if(visited[ry][rx]) continue;
			if(map[ry][rx]>=map[y][x]) continue;
			visited[ry][rx]=true;
			dfs(ry, rx, index+1);
			visited[ry][rx]=false;
		}
	}
}