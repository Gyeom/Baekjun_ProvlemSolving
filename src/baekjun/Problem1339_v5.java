package baekjun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem1339_v5 {
//	static boolean[] visited;
//	static int[] num;
//	static int N;
//	static String[] word;
//	static int[] alpha;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		String[] word = new String[N];
		HashSet<Character> set =new HashSet<>(); 
		 int[] alpha = new int[26];
		for(int i=0,index=0; i<N; i++) {
			word[i]=sc.next();
			for(char a : word[i].toCharArray()) {
				if(set.add(a)) {
					alpha[a-'A']=index++;
				}
			}
		}
		
		boolean[] visited = new boolean[set.size()];
		int[] num = new int[set.size()];
		Arrays.fill(num, -1);

		dfs(set.size(),0,alpha,word,num,N,visited);
		System.out.println(ans);
	}
	static int ans =0;
	private static void dfs(int end, int index, int[] alpha, String[] word,int[] num,int N,boolean[] visited) {
		// TODO Auto-generated method stub
		if(index==end) {
			int allsum=0;
			for(int i=0; i<N; i++) {
				int sum=0;
				for(char w : word[i].toCharArray()) {
					sum=10*sum+num[alpha[w-'A']];
				}
				allsum+=sum;
			}
			if(allsum>ans) {
				ans=allsum;
			}
			return;
		}
		for(int i=0; i<end; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			num[index]=9-i;
			dfs(end,index+1,alpha, word,num,N,visited);
			num[index]=-1;
			visited[i]=false;
		}

	}

}
