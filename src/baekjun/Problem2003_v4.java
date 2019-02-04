package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2003_v4 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		
		token = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[] a = new int[N];
		int count=0;
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i]= Integer.parseInt(token.nextToken());
		}
		
		label:
		for (int i=0; i<N; i++) {
			if(a[i]>M) {
				continue;
			}
			int sum=0; 
			for(int j=i; j<N; j++) {
				sum+=a[j];
				if(sum>=M) {
					if(sum==M) {
						count++;
					}
					continue label;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
