import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedComponent {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		a = (ArrayList<Integer>[]) new ArrayList[N+1];
		c = new boolean[N+1];
		
		for(int i=1; i<=N; i++)
		{
			a[i]= new ArrayList<Integer>();
		}
		for(int i=1; i<=M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			a[u].add(v);
			a[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(a[i]);
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		c[1]=true;
		boolean cc = false;
		int start=1;
		int count=0;
		do {
			count++;
			if(cc==true) {
				q.add(start);
				c[start]=true;
			}
			
		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y : a[x]) {
				if(c[y]==false) {
				q.add(y);
				c[y]=true;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(c[i]==false) {
				cc= true;
				start=i;
				break;
			}
			cc = false;
		}
		}while(cc);
		
		System.out.println(count);
	}

}
