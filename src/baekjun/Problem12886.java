package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem12886 {
	static class Pair{
		int a;
		int b;
		int c;
		Pair(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = A+B+C;
		boolean[][] visited = new boolean[1001][1001];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(A,B,C));
		visited[A][B]=true;
		boolean pass=false;
		while(!q.isEmpty()) {
			Pair p = q.remove();

			int a = p.a;
			int b = p.b;
			int c = sum-p.a-p.b;
			if(a==b&&b==c) {
				System.out.println("1");
				pass=true;
				break;
			}

			if(a>b) {
				if(!(a-b<=0||b+b<=0||c<=0||a-b>1000||b+b>1000||c>1000)) {
					if(!visited[a-b][b+b]) {
						q.add(new Pair(a-b,b+b,c));
						visited[a-b][b+b]=true;
					}
				}
			}
			if(a>c) {
				if(!(a-c<=0||b<=0||c+c<=0||a-c>1000||b>1000||c+c>1000)) {
					if(!visited[a-c][b]) {
						q.add(new Pair(a-c,b,c+c));
						visited[a-c][b]=true;
					}
				}
			}	
			if(b>a) {
				if(!(a+a<=0||b-a<=0||c<=0||a+a>1000||b-a>1000||c>1000)) {
					if(!visited[a+a][b-a]) {
						q.add(new Pair(a+a,b-a,c));
						visited[a+a][b-a]=true;
					}
				}
			}
			if(b>c) {
				if(!(a<=0||b-c<=0||c+c<=0||a>1000||b-c>1000||c+c>1000)) {
					if(!visited[a][b-c]) {
						q.add(new Pair(a,b-c,c+c));
						visited[a][b-c]=true;
					}
				}
			}
			if(c>a) {
				if(!(a+a<=0||b<=0||c-a<=0||a+a>1000||b>1000||c-a>1000)) {
					if(!visited[a+a][b]) {
						q.add(new Pair(a+a,b,c-a));
						visited[a+a][b]=true;
					}
				}
			}
			if(c>b) {
				if(!(a<=0||b+b<=0||c-b<=0||a>1000||b+b>1000||c-b>1000)) {
					if(!visited[a][b+b]) {
						q.add(new Pair(a,b+b,c-b));
						visited[a][b+b]=true;
					}
				}
			}
		}
		if(!pass) {
			System.out.println("0");
		}

	}

}
