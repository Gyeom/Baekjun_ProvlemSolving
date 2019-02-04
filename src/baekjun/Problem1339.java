package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1339 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Character>[] alpa = (ArrayList<Character>[]) new ArrayList[N];
		for(int i=0; i<N; i++) {
			alpa[i]= new ArrayList<Character>();
		}
		Queue<Integer> q = new LinkedList<>();
	
		ArrayList<Character> visited = new ArrayList<>();
		HashMap<Character, Integer> dp = new HashMap<>();
		for(int i=9; i>=0; i--) {
			q.add(i);
		}
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=7; j>=0; j--) {
				if(j>=str.length()) {
					alpa[i].add('0');
				}else {
					alpa[i].add(str.charAt(str.length()-j-1));
				}
			}
		}
		int ans =0;
			for(int j=0; j<=7; j++) {
				for(int i=0; i<N; i++) {
					if(alpa[i].get(j)=='0') continue;
				if(dp.containsKey(alpa[i].get(j))) {
					ans+=dp.get(alpa[i].get(j))*Math.pow(10, 7-j);
				}else {
					dp.put(alpa[i].get(j), q.remove());
					ans+=dp.get(alpa[i].get(j))*Math.pow(10, 7-j);
				}
			}
		}
		System.out.println(ans);
	}
}
