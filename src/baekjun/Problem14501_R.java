package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14501_R {
	static int ans;
	static int[] time;
	static int[] pay;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		time = new int[N];
		pay = new int[N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			time[i] = Integer.parseInt(s[0]);
			pay[i] = Integer.parseInt(s[1]);
		}
		ans=0;
		dfs(0, 0, N);
		System.out.println(ans);
	}
	private static void dfs(int sum, int num, int end) {
		// TODO Auto-generated method stub
		if(num>end) {
			return;
		}
		if(sum>ans) {
			ans=sum;
		}
		for(int i=num; i<end; i++) {
			dfs(sum+pay[i], i+time[i], end);
		}
	}
}