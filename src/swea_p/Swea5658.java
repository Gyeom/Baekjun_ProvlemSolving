package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Swea5658 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer token;
			token = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(token.nextToken());
			int K  = Integer.parseInt(token.nextToken());
			String s = br.readLine();
			s+=s;
			int cnt = N/4;
			Map<String, Integer> map = new HashMap<>();
			for(int i=0; i<cnt; i++) {
				for(int j=0; j<N; j+=cnt) {
					String temp = s.substring(j+i, j+cnt+i);
					if(!map.containsKey(temp)) {
						map.put(temp, 1);
					}
				}
			}
			ArrayList<Integer> al = new ArrayList<>();
			for(String temp : map.keySet()) {
				int sum=0;
				for(int i=0; i<cnt; i++) {
					
					char num = temp.charAt(i);
					int num_v=0;
					if(num-'0'>9) {
						num_v = num-'A'+10;
					}else {
						num_v = num-'0';
					}
					sum+=Math.pow(16, cnt-i-1)*num_v;
				}
				al.add(sum);
			}
			Collections.sort(al);
			Collections.reverse(al);
			bw.write(String.valueOf("#"+tc+" "+al.get(K-1)));
			if(tc!=TC) {
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}