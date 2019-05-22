package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem1181 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String>[] list =(ArrayList<String>[]) new ArrayList[51];
		for(int i=0; i<51; i++) {
			list[i] = new ArrayList<String>();
		}
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(!list[s.length()].contains(s)) {
				list[s.length()].add(s);
			}
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<51; i++) {
			if(list[i].isEmpty()) continue;
			Collections.sort(list[i]);
			for(int j=0; j<list[i].size(); j++) {
				sb.append(list[i].get(j)+"\n");
			}
		}
		
		System.out.println(sb);
	}
}
