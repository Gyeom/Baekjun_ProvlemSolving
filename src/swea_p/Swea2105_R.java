package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea2105_R {
	static int[][] map ;
	static int y,x;
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
			ans=-1;
			
			for(int i=0; i<N; i++) {
				outloof:
					for(int j=0; j<N; j++) {
						inloof:
						for(int a=1; a<Integer.MAX_VALUE; a++) {
							for(int b=1; b<Integer.MAX_VALUE; b++) {
								visited = new boolean[101];
								visited[map[i][j]]=true;
								y=i;x=j;
								count=1;
								if(!simulation(3,a)) continue outloof;
								if(!simulation(0,b)) continue inloof;
								if(!simulation(1,a)) continue;
								if(!simulation(2,b-1)) continue;
								if(count>ans) {
									ans=count;
									
								}
							}					
						}
					}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static boolean[] visited;
	static int[] dy = {1,1,-1,-1};
	static int[] dx = {1,-1,-1,1};
	static int count;
	static int ans;
	private static boolean simulation(int k, int d) {
		// TODO Auto-generated method stub
		for(int i=1; i<=d; i++) {
			int ry=y+dy[k];
			int rx=x+dx[k];
			if(ry<0||rx<0||ry>=N||rx>=N) return false;
			if(visited[map[ry][rx]]) return false;
			visited[map[ry][rx]]=true;
			count++;
			y=ry;
			x=rx;
		}
		return true;
	}


}
