package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1912 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
				
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] dp = new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i]=Integer.parseInt(token.nextToken());
			dp[i]=a[i];
		}
		int ans =a[0];
		for(int i=1; i<N; i++) {
			dp[i]+=dp[i-1];
			if(dp[i]>ans) {
				ans=dp[i];
			}
		}	
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(dp[i]<dp[i]-dp[j]) {
					if(dp[i]-dp[j]>ans) {
						ans=dp[i]-dp[j];
					}
				}
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
