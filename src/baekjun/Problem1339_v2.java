package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem1339_v2 {

	static class Alpha{
		char alpha;
		int cnt;
		Alpha(char alpha, int cnt) {
			this.alpha = alpha;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	HashMap<Character,Integer> cnt = new HashMap<>();
	Queue<Alpha> q= new LinkedList<>();
	int N = Integer.parseInt(br.readLine());
	
	for(int i=0; i<N; i++) {
		String str = br.readLine();
		for(int j=0; j<str.length(); j++) {
			char alpha = str.charAt(j);
			if(cnt.containsKey(alpha)) {
				cnt.put(alpha, cnt.get(alpha)+1);
			}else {
				cnt.put(alpha, 1);
			}
		}
	}
	
	for(Character key : cnt.keySet()) {
		
	}
	
	
		

	}

}
