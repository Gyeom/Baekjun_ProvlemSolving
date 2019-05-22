package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2839 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[2];
		a[0]=3;
		a[1]=5;
		ans=Integer.MAX_VALUE;
		dfs(N,a,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
		
	}
	static int ans;
	private static void dfs(int num, int[] a, int count) {
		// TODO Auto-generated method stub
		if(num==0) {
			if(count<ans) {
				ans=count;
			}
		}
		for(int i=0; i<2; i++) {
			int mok = num/a[i];
			if(mok==0) continue;
			count += mok;
			dfs(num-(mok)*a[i],a,count);
			count -= num/a[i];
		}
	}

}
