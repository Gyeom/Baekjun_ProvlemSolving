package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem13913 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		int[] ans ;
		int[] dist = new int[100001];
		int[] from = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		if(K==N) {
			sb.append("0\n"+N);
			System.out.println(sb);
//			System.out.println("0\n"+N);
		}else {
			q.add(N);
			visited[N] = true;
			dist[N]=0;
			
			while(!q.isEmpty()){
				int p = q.remove();
				if(p==K) {
					ans = new int[dist[p]+1];
					sb.append(dist[p]+"\n");
//					System.out.println(dist[p]);
					int index=0;
					do {
						ans[index++]=p;
						p=from[p];
					}while(p!=N);
					ans[index++]=N;
					for(int i=ans.length-1; i>=0; i--) {
						sb.append(ans[i]+" ");
//						System.out.print(ans[i]+" ");
					}
					System.out.println(sb);
					break;
				}
				for(int r : new int[] {p+1,p-1,2*p}) {
					if(r<0||r>100000) continue;
					if(visited[r]) continue;
					visited[r]= true;
					dist[r]=dist[p]+1;
					from[r]=p;
					q.add(r);
				}
			}
		}
		}
		
}
