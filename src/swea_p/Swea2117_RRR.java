package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Swea2117_RRR {
	static int[][] map;
	static int N,M;
	static class Home{
		int y;
		int x;
		Home(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static ArrayList<Home> homeList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][N];
			homeList = new ArrayList<>();
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
					if(map[i][j]==1) {
						homeList.add(new Home(i,j));
					}
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ans = Math.max(ans, simulation(i,j));
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	private static int simulation(int y, int x) {
		// TODO Auto-generated method stub
		int[] dist = new int[N+N];
		for(Home h : homeList) {
			dist[Math.abs(h.y-y)+Math.abs(h.x-x)+1]++;
		}
		int count=0;
		int MAX_COUNT=0;
		for(int K=0; K<dist.length; K++) {
			if(dist[K]==0) continue;
			count+=dist[K];
			if(M*count>=K*K+(K-1)*(K-1)) {
				MAX_COUNT=count;
			}
		}
		return MAX_COUNT;
	}
}
