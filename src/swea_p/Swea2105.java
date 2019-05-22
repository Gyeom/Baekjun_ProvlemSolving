package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Swea2105 {
	static int[] dy = {-1,1,1,-1};
	static int[] dx = {1,1,-1,-1};
	static int count;
	static int ans;
	static int[][] dissert;
	static int y;
	static int x;
	static boolean[] visited_d;
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
		dissert = new int[N][N];
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					dissert[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				outloof:
				for(int j=0; j<N; j++) {
					inloof:
					for(int k=1; k<N; k++) {
						for(int l=1; l<N; l++) {
							visited = new boolean[N][N];
							visited_d = new boolean[101];
							count = 0;
							y=i;
							x=j;
						
							count++;
							visited[i][j]=true;
							visited_d[dissert[i][j]]=true;
							if(!sum(y,x,k,0))continue outloof;
							if(!sum(y,x,l,1))continue inloof;
							if(!sum(y,x,k,2))continue; 
							if(!sum(y,x,l-1,3))continue;
							if(count>ans) {
								ans = count;
							}
						}
					}
				}
			}
			if(ans==0) {
				bw.write("#"+String.valueOf(tc)+" "+"-1");
				bw.newLine();
			}else {
				bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
				bw.newLine();
			}
			
		}
		bw.flush();
		bw.close();
	}
	private static boolean sum(int a, int b, int dist, int k) {
		// TODO Auto-generated method stub
		int c=0;
		for(int i=1; i<=dist; i++) {
			int ry = dy[k]+a;
			int rx = dx[k]+b;
			if(ry<0||rx<0||ry>=N||rx>=N) return false;
			if(visited[ry][rx]) return false;
			if(visited_d[dissert[ry][rx]]) return false;
			visited[ry][rx]=true;
			visited_d[dissert[ry][rx]]=true;
			c++;
			a=ry;
			b=rx;

		}
		y=a;
		x=b;
		count+=c;
		return true;
	}

}
