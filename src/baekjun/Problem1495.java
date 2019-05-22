package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1495 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int S = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[] V = new int[N+1];
		token = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			V[i]=Integer.parseInt(token.nextToken());
		}
		int[][] d= new int[N+1][M+1];
		d[0][S]=1;
		int ans =-1;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(d[i-1][j]==0) continue;
				if(j-V[i]>=0) {
					d[i][j-V[i]]=1;
				}
				if(j+V[i]<=M) {
					d[i][j+V[i]]=1;
				}
			}
		}

		for(int i=0; i<=M; i++) {
			if(d[N][i]==0) continue;
			if(i>ans) {
				ans=i;
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
