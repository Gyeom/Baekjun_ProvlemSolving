package baekjun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13398 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] dp = new int[N];
		int[] v= new int[N];
		token = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(token.nextToken());
			dp[i] = a[i];
		}



	}
}
