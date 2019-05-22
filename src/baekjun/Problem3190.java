	package baekjun;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayDeque;
	import java.util.Deque;
	import java.util.StringTokenizer;
	
	public class Problem3190 {
		static class Snake{
			int y;
			int x;
			Snake(int y, int x){
				this.y=y;
				this.x=x;
			}
		}
	
		static int[] dy = {1,-1,0,0};
		static int[] dx = {0,0,-1,1};
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			int K = Integer.parseInt(br.readLine());
			StringTokenizer token;
	
			for(int i=0; i<K; i++) {
				token = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(token.nextToken());
				int x = Integer.parseInt(token.nextToken());
				map[y][x]=1;
			}
			map[1][1]=2;
			int L = Integer.parseInt(br.readLine());
			char[] time = new char[10001];
	
			for(int i=0; i<L; i++) {
				token = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(token.nextToken());
				char direct = token.nextToken().charAt(0);
				time[t]=direct;
			}
	
			Deque<Snake> q = new ArrayDeque<>();
			q.addLast(new Snake(1,1));
			int k=3;
			for(int t=0; t<10001; t++) {
				if(time[t]=='D') {
					switch (k) {
					case 0: k=2;
					break;
					case 1: k=3;
					break;
					case 2: k=1;
					break;
					case 3: k=0;
					break;
					}
				}else if(time[t]=='L') {
					switch (k) {
					case 0: k=3;
					break;
					case 1: k=2;
					break;
					case 2: k=0;
					break;
					case 3: k=1;
					break;
					}
				}
				Snake head = q.peekFirst();
				int ry = dy[k]+head.y;
				int rx = dx[k]+head.x;
				if(ry<1||rx<1||ry>N||rx>N||(map[ry][rx]==2)) {
					System.out.println(t+1);
					break;
				}
				if(map[ry][rx]!=1){
					Snake tail = q.removeLast();
					map[tail.y][tail.x]=0;	
				}
				map[ry][rx]=2;
				q.addFirst(new Snake(ry,rx));
			}
		}
	}
