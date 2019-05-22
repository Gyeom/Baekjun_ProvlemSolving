package baekjun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1339_v4 {

	static int N;
	static Map<Character,Integer> map;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		String[] word = new String[N];
		map = new HashMap<>();
		int index=0;
		for(int i=0; i<N; i++) {
			word[i]=sc.next();
			for(int j=0; j<word[i].length(); j++) {
				char key = word[i].charAt(j);
				if(!map.containsKey(key)) {
					map.put(key,index++);
				}
				
			}
		}
		visited = new boolean[map.size()];
		int[] num = new int[map.size()];
		Arrays.fill(num, -1);
		
//		dfs(num.length,0,word,num);
		System.out.println(ans);
	}
	
	static int ans=0;
	private static void dfs(int end, int index,String[] word,int[] num) {
		// TODO Auto-generated method stub
		if(index==end) {
			System.out.println(Arrays.toString(num));
			int sum =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<word[i].length(); j++) {
					if(word[i].length()>1) {
					sum+= num[map.get(word[i].charAt(j))]*Math.pow(10, word[i].length()-j-1);
					}else {
					sum+= num[map.get(word[i].charAt(j))];
					}
				}
			}
			if(sum>ans) {
				ans=sum;
			}
			return;
		}
		
		for(int i=0; i<end; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			num[index]=9-i;
			dfs(end,index+1, word,num);
			num[index]=-1;
			visited[i]=false;
		}
	}

}
