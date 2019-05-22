package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem11066 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int TC = Integer.valueOf(br.readLine());

		while(TC-->0) {
			int N = Integer.valueOf(br.readLine());
			token = new StringTokenizer(br.readLine());
			int[] a = new int[N];
			int[][] d= new int[N][N];
			for(int i=0; i<N; i++) {
				a[i]=Integer.valueOf(token.nextToken());
				Arrays.fill(d[i], -1);
			}
			System.out.println(dfs(0,N-1,d,a));
		}
	}

	private static int dfs(int start, int end,int[][] d, int[] a) {
		// TODO Auto-generated method stub

		if(start==end) {
			return 0;
		}
		if(d[start][end]!=-1) {
			return d[start][end];
		}

		int sum=0;
		for(int i=start; i<=end; i++) {
			sum+=a[i];
		}

		for(int k=start; k<=end-1; k++) {
			int temp = dfs(start,k,d,a)+dfs(k+1,end,d,a)+sum;
			if(d[start][end]==-1||temp<d[start][end]) {
				d[start][end]=temp;
			}
		}
		return d[start][end];
	}

}
