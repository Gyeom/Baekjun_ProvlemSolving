package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem1699 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			dp[i]=(int)Math.sqrt(i);
		}
		int ans=0;
		do {
			N-=Math.pow((int)Math.sqrt(N), 2);
			ans++;
		}while(N>0);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}