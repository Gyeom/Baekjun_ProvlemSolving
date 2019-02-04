package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token; 
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] a = new int[M];
		boolean[] visited = new boolean[1000001];
		if(M!=0) {
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			a[i]=Integer.parseInt(token.nextToken());
		}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N]=true;
		int ans=-1;
		if(N==100){
		  System.out.println("0");
		}else if(M==10) {
			System.out.println(Math.abs(N-100));
		}else if(M==0) {
			if(Math.abs(N-100)<String.valueOf(N).length()) {
				System.out.println(Math.abs(N-100));
			}else {
				System.out.println(String.valueOf(N).length());
			}
		}else{
		
			label :
				while(!q.isEmpty()) {
					int now = q.remove();

					String nows = String.valueOf(now);
					in :
						for(int i=0; i<nows.length(); i++) {
							for(int j=0; j<a.length; j++) {
								if(nows.charAt(i)-'0'==a[j]) {
									break in;
								}
								if(i==nows.length()-1&&j==a.length-1) {
									ans = Integer.parseInt(nows);
									break label;
								}
							}
						}
					for(int next : new int []{now-1,now+1}) {
						if(next==-1||next==1000001) continue;
						if(visited[next]) continue;
						q.add(next);
						visited[next]=true;
					}
				}
		if(Math.abs(N-100)<Math.abs(N-ans)+String.valueOf(ans).length()) {
			System.out.println(Math.abs(N-100));
		}else {
			System.out.println(Math.abs(N-ans)+String.valueOf(ans).length());
		}
		}
	}
}
