package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem9019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int TC = sc.nextInt();
		while(TC-->0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean[] visited = new boolean[10000];
			int[] from = new int[10000];
			char[] alpha = new char[10000];
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			visited[A]= true;

			while(!q.isEmpty()) {
				int now = q.remove();
				if(now==B) {
					StringBuilder sb = new StringBuilder();
					do {
						sb.append(alpha[now]);
						now = from[now];
					}while(A!=now);
					System.out.println(sb.reverse());
					break;
				}
				for(int next : new int[] {((now/10)+(now%10)*1000),((now/1000)+(now%1000)*10),now*2,now-1}) {
					int next_prev = next;
					if(next>=10000) {
						next%=10000;
					}else if(now==0&&next==now-1) {
						next=9999;
					}
					if(next<0) continue;
					if(visited[next]) continue;
					visited[next]=true;
					if(next_prev==now*2) {
						alpha[next]='D';
					}else if(next_prev==now-1) {
						alpha[next]='S';
					}else if(next_prev==((now/10)+(now%10)*1000)) {
						alpha[next]='R';
					}else if(next_prev==((now/1000)+(now%1000)*10)) {
						alpha[next]='L';
					}
					q.add(next);
					from[next] = now;
				}
			}
		}
	}
}