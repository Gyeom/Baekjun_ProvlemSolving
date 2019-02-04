package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem15990_v2 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		long[][] dp = new long[100001][4];
		dp[1][1]=1;
		dp[2][2]=1;
		dp[3][1]=1;
		dp[3][2]=1;
		dp[3][3]=1;
		int lastDP=4;
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i=lastDP; i<=N; i++) {
				dp[i][3]=(dp[i-3][2]+dp[i-3][1])%1000000009;
				dp[i][2]=(dp[i-2][1]+dp[i-2][3])%1000000009;
				dp[i][1]=(dp[i-1][2]+dp[i-1][3])%1000000009;
			}
			if(N>lastDP) {
				lastDP=N;	
			}
			bw.write(String.valueOf((dp[N][1]+dp[N][2]+dp[N][3])%1000000009)+"\n");
		}
bw.flush();
bw.close();
	}
}