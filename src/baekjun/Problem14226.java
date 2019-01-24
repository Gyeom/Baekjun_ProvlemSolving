package baekjun;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14226 {
	public static class Pair{
		int data;
		int time;
		int clip;
		
		
		//2��� �þ�°� �ƴ϶�, ���� Ŭ���� ����Ǿ��ִ� �̸�Ƽ�� ������ ���ϴ� ��. �׷���visited[][clip]�϶� clip�� 1001�̾���Ѥ���
		public Pair(int data, int time, int clip) {
			this.data = data;
			this.time = time;
			this.clip = clip;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		boolean[][][] visited = new boolean[1001][1001][2];
		Queue<Pair> q = new LinkedList<>();
		int ans=0;


		Pair p= new Pair(1,0,0);
		q.add(p);

		label:
			while(!q.isEmpty()) {
				p = q.remove();

				if(p.data==S) {
					ans = p.time;
					break label;
				}
				for(int r : new int[] {p.data+p.clip,p.data,p.data-1}) {
					if(r<0||r>1000) continue;
					if(visited[r][p.clip][1]) continue;

					if(r==p.data&&!visited[p.data][p.clip][0]) {
						q.add(new Pair(p.data,p.time+1,p.data));
						visited[p.data][p.clip][0]=true; 
					}else if(r==p.data+p.clip&&visited[p.data][p.clip][0]&&!visited[p.data+p.clip][p.clip][0]) { 
						q.add(new Pair(p.data+p.clip,p.time+1,p.clip));
						visited[p.data][p.clip][1]=true;
					}else if(r==p.data-1&&visited[p.data][p.clip][1]&&!visited[r][p.clip][0]) {
						q.add(new Pair(r,p.time+1,p.clip));
					}

				}

				


			}
		System.out.println(ans);
	}
}