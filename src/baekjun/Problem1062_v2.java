package baekjun;

import java.util.Scanner;

public class Problem1062_v2 {
	static int N;
	static int[] word;
	static int ans =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		word = new int[N];
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='a'||s.charAt(j)=='c'||s.charAt(j)=='n'||s.charAt(j)=='i'||s.charAt(j)=='t') continue;
				word[i]|=(1<<(s.charAt(j)-'a'));
			}
		}
		dfs(-1,K-5,0,0);
		System.out.println(ans);
	}
	private static void dfs(int num, int end, int index, int x) {
		// TODO Auto-generated method stub
		if(index==end) {

			int count=0;
			for(int i=0; i<N; i++) {
				if((word[i]&x)==word[i]) {
					count++;
				}
			}
			if(count>ans) {
				ans = count;
			}
			return;
		}
		if(num==26) {
			return;
		}
		if(num+1=='a'-'a'||num+1=='c'-'a'||num+1=='n'-'a'||num+1=='i'-'a'||num+1=='t'-'a') {
			x|=(1<<(num+2));
			dfs(num+2,end,index+1,x);
			x&=~(1<<(num+2));
			dfs(num+2,end,index,x);
		}else {
			x|=(1<<(num+1));
			dfs(num+1,end,index+1,x);
			x&=~(1<<(num+1));
			dfs(num+1,end,index,x);
		}
	}
}
