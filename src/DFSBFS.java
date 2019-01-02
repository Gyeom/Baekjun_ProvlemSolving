import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class DFSBFS {
	
	static ArrayList<Integer>[] a;
	static boolean[] c;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int start = sc.nextInt(); //시작 정점
		
		a=  (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i]= new ArrayList<Integer>();
		}
		
		//인접리스트 생성
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		//인접리스트 정렬 -> 조건 중 , <단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문> 을 충족하기 위해서
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		c= new boolean[n+1];
		dfs(start);
		System.out.println();
		bfs(start);
		
		
	}

	private static void bfs(int start) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start]=true;
		while (!q.isEmpty()) {
			int x = q.remove();
			System.out.println(x + " ");
			for(int y : a[x]) {
				if(!c[y]) {
					c[y]=true;
					q.add(y);
				}
			}
		}
	}

	private static void dfs(int x) {
		// TODO Auto-generated method stub
		if(c[x]) {
			return;
		}
		c[x]= true;
		System.out.print(x+" ");
		
		for(int y : a[x]) {
			if(!c[y]) {
				dfs(y);
			}
			
		}
		
	}
	
	public static void dfs2(int x) {
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(x, 0));
        c[x] = true;
        System.out.print(x + " ");
        while (!s.isEmpty()) {
            Pair p = s.pop();
            int node = p.first;
            int start = p.second;
            for (int i=start; i<a[node].size(); i++) {
                int next = a[node].get(i);
                if (c[next] == false) {
                    System.out.print(next + " ");
                    c[next] = true;
                    s.add(new Pair(node, i+1));
                    s.add(new Pair(next, 0));
                    break;
                }
            }
        }
    }
   
    }
