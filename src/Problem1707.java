import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1707 {
	
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int i=1; i<=TC; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[N+1];
			for(int j=1; j<=N; j++) {
				a[j]= new ArrayList();
			}
			for(int j=1; j<=M; j++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[v].add(u);
				a[u].add(v);
			}
			boolean visited[] = new boolean[N+1];
			boolean color[] = new boolean[N+1];
			Queue<Integer> q = new LinkedList<>();
			String str = "YES";
			int visitNum = 0;
			do {
				if(q.isEmpty()) {
					for(int v=1; v<=N; v++) {
						if(visited[v]==false) {
							q.add(v);
							visited[v]= true;
							color[v]=true;
							visitNum++;
							break;
						}
					}
					
				}
			while(!q.isEmpty()) {
				int x = q.remove();
				for(int y : a[x]) {
					//판단만하고 add할필요는없지
					if((visited[y]==true)&&(color[x]==color[y])) {
						str = "NO";
						break;
					}
					//add는 방문안한것만
					if(visited[y]==false) {
						color[y]=!color[x];
						q.add(y);
						visited[y]=true;
						visitNum++;
					}
				}
				if(str.equals("NO")) {
					break;
				}
			}
			}while(visitNum!=N);
			System.out.println(str);
		}
	}
}