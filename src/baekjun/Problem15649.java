package baekjun;
import java.util.Scanner;

public class Problem15649 {

	static int[] a;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		a = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			a[i]=i+1;
		}
		dfs("",M,0);
		
		
	}

	public static void dfs(String begin, int end, int index  ) {
		// TODO Auto-generated method stub
		
		if(begin.length()==end*2) {
			System.out.println(begin);
			return;
		}
	
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			dfs(begin+a[i]+" ",end,index+1);	
			visited[i]=false;
		}
				
	}

}