package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2529 {
	static boolean[] visited;
	static StringBuilder sb;
	static String max;
	static String min;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		max = "0";
		min = "9876543210";
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		char[] a = new char[N];
		visited= new boolean[10];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] =  token.nextToken().charAt(0);
		}
		for(int i=0; i<=9; i++) {
			visited[i]=true;
			sb.append(i);
			dfs(i,N,0,a);
			visited[i]=false;
			sb.deleteCharAt(sb.length()-1);
		}

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int begin, int end, int index, char[] a) {
		// TODO Auto-generated method stub

		if(index==end) {
			max = Long.parseLong(max)>Long.parseLong(sb.toString()) ? max : sb.toString();
			min = Long.parseLong(min)<Long.parseLong(sb.toString()) ? min : sb.toString();
			return;
		}

		for(int i=0; i<=9; i++) {
			if(visited[i]) continue;
			if(a[index]=='<') {
				
				if(begin<i) {
					sb.append(i);
					visited[i]=true;
					dfs(i,end,index+1,a);
					visited[i]=false;
					sb.deleteCharAt(sb.length()-1);
				}else {
				
					continue;
				}
			}else{
				if(begin>i) {
					sb.append(i);
					visited[i]=true;
					dfs(i,end,index+1,a);
					visited[i]=false;
					sb.deleteCharAt(sb.length()-1);
				}else {
					continue;
				}
			}
		}
	}
}
