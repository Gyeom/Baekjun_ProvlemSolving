package SWmaestro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1929 {
	//소수구하기 에라토스테네스의 체
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s= br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		boolean[] DP = new boolean[N+1];
		for(int i=2; i<=N; i++) {
			if(DP[i]) continue;
			for(int j=i+i; j<=N; j+=i) {
				DP[j]=true;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(DP[i]) continue;
			if(i==1) continue;
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}

}
