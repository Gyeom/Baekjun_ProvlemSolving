package baekjun;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4991 {

	static class Pair{
		int y;
		int x;
		int dist;
		public Pair(int y, int x, int dist) {
			this.y= y;
			this.x= x;
			this.dist = dist;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		do {
			int W = sc.nextInt();
			int H = sc.nextInt();
			if(W==0&&H==0) break;
			char[][] a = new char[H][W];
			Deque<Pair> start = new ArrayDeque<>(); 
			ArrayList<Pair> al = new ArrayList<>();
			for(int i=0; i<H; i++) {
				String s = sc.next();
				for(int j=0; j<W; j++) {
					a[i][j]=s.charAt(j);
					if(a[i][j]=='o') {
						start.addFirst(new Pair(i,j,0));
						al.add(new Pair(i,j,0));
					}
				}
			}
			boolean[][] visited;
			int ans=0;
			outloof:
				while(!start.isEmpty()) {
					Queue<Pair> q = new LinkedList<>();
					visited = new boolean[H][W];
					for(int v=0; v<al.size(); v++) {
						a[al.get(v).y][al.get(v).x]='.';
					}
					visited[start.peek().y][start.peek().x]=true;
					q.add(start.remove());
					while(!q.isEmpty()) {
						Pair p = q.remove();

						if(a[p.y][p.x]=='*') {
							ans+=p.dist;
							System.out.println(p.dist);
							System.out.println(p.y+","+p.x);
							p.dist=0;
							start.add(p);
							al.add(p);
							continue outloof;
						}
						for(int k=0; k<4; k++) {
							int ry = dy[k]+p.y;
							int rx = dx[k]+p.x;
							int rdist = p.dist;
							if(ry<0||rx<0||ry>=H||rx>=W) continue;
							if(visited[ry][rx]) continue;
							if(a[ry][rx]=='x') continue;
							visited[ry][rx]=true;

							q.add(new Pair(ry,rx,rdist+1));
						}
					}
				}
			if(ans==0) {
				System.out.println("-1");
			}else {
				System.out.println(ans);	
			}

		}while(true);
	}

}
