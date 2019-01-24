package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2225 {
	static long[][] dp;
	static boolean[][] visited;
	static int N;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		dp = new long[K+1][N+1];
		visited = new boolean[K+1][N+1];
		bw.write(String.valueOf(dfs(0,K,0)));
		bw.flush();
		bw.close();
	}

	private static long dfs(int begin, int end, int index) {
		if(index==end) {
			if(begin==N) {
				return 1;
			}
			return 0;
		}
		if(begin>N) {
			return 0;
		}

		if(visited[index][begin]) {
			return dp[index][begin];
		}else {
			visited[index][begin] = true;
		}


		for(int i=0; i<=N; i++) {
			dp[index][begin]+=dfs(begin+i,end,index+1)%1000000000;
		}

		return dp[index][begin]%1000000000;

	}
}


