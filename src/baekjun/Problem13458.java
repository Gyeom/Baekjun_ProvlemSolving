package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			room[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		long ans = N;
		for(int i=0; i<N; i++) {
			int num = room[i]-B;
			if(num<=0) continue;
			ans+=(num/C)+((num%C)>0?1:0);
		}
		System.out.println(ans);
	}
}