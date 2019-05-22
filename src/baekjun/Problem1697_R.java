package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1697_R {
	static class Subin{
		int x;
		int d;
		Subin(int x , int d){
			this.x=x;
			this.d=d;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		bfs(N,K);
	}
	static int[] visited;
	static int[] from;
	private static void bfs(int N, int K) {
		// TODO Auto-generated method stub
		visited = new int[100001];
		from = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		Queue<Subin> q = new LinkedList<>();
		q.add(new Subin(N,0));
		visited[N]=0;
		from[N]=-1;
		while(!q.isEmpty()) {
			Subin p = q.remove();
			if(p.x==K) {
				ArrayList<Integer> list = new ArrayList<>();
				StringBuilder sb = new StringBuilder();
				int from_x = from[p.x];
				list.add(p.x);
				do {
					if(from_x==-1) break;
					list.add(from_x);
					from_x=from[from_x];
				}while(from_x!=-1);
				sb.append(p.d+"\n");
				for(int i=list.size()-1; i>=0; i--) {
					sb.append(list.get(i)+" ");
				}
				System.out.println(sb);
				return;
			}
			
			for(int next : new int[] {p.x*2,p.x-1,p.x+1}) {
				if(next<0||next>100000) continue;
				if(visited[next]<p.d+1) continue;
				visited[next]=p.d+1;
				from[next]=p.x;
				q.add(new Subin(next,p.d+1));
			}
		}
	}
}