package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class SwExpert5987 {
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	static int[] indegree;
	static Map<String, Integer> dp;
	static ArrayList<Integer> al2;
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++){
			token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			al = (ArrayList<Integer>[]) new ArrayList[N+1];
			al2 = new ArrayList<Integer>();
			visited= new boolean[N+1];
			dp = new HashMap<String,Integer>();
			indegree = new int[N+1];
			for(int i=1; i<=N; i++) {
				al[i]= new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				token = new StringTokenizer(br.readLine());
				int temp1 =Integer.parseInt(token.nextToken());
				int temp2 = Integer.parseInt(token.nextToken());
				al[temp1].add(temp2);
				indegree[temp2]++;
				if(!al2.contains(temp1)) {
					al2.add(temp1);
				}
				if(!al2.contains(temp2)) {
					al2.add(temp2);
				}
			}
			long allNum = factorial(N);
			long partNum = factorial(al2.size());
			int count = dfs(al2.size(),0);
			//			long answer = (allNum/partNum)*dfs(0,al2.size(),0); 
			bw.write("#"+t+" "+String.valueOf((allNum/partNum)*count));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	private static long factorial(int n) {
		// TODO Auto-generated method stub
		if(n==1) {
			return 1;
		}
		return factorial(n-1)*n;
	}
	private static int dfs(int end, int index) {
		// TODO Auto-generated method stub
//		System.out.println(Arrays.toString(indegree).replaceAll("[\\p{S}\\p{P}им]+", "").trim()+index);
		if(index==end) {
			return 1;
		}
		
		String dpKey = Arrays.toString(indegree).replaceAll("[\\p{S}\\p{P}им]+", "").trim()+index;
		if(!dp.containsKey(dpKey)) {
			dp.put(dpKey,null);
		}else if(dp.get(dpKey)!=null){
			return dp.get(dpKey);
		}
//		if(dp.get(dpKey)!=null) {
//			return dp.get(dpKey);
//		}else{
//			dp.put(dpKey, null);
//		};
		int sum=0;
		for(int i=0; i<end; i++) {
			int node = al2.get(i);
			if(indegree[node]!=0) continue;
			if(visited[node]) continue;
			visited[node]=true;
			for(int j=0; j<end; j++) {
				if(i==j) continue;
				int nextNode = al2.get(j);
				if(al[node].contains(nextNode)) indegree[nextNode]--;
			}
			sum+=dfs(end,index+1);
			for(int j=0; j<end; j++) {
				if(i==j) continue;
				int nextNode = al2.get(j);
				if(al[node].contains(nextNode)) indegree[nextNode]++;
			}
			visited[node]=false;
		}
		dp.put(dpKey, sum);
		return sum;
	}
}