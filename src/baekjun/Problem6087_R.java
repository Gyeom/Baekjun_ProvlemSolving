package baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem6087_R {
	static class Gun{
		int y;
		int x;
		int c;
		int prev;
		Gun(int y, int x, int c, int prev){
			this.y=y;
			this.x=x;
			this.c=c;
			this.prev=prev;
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		 int W = sc.nextInt();
		 int H = sc.nextInt();
		char[][] map = new char[H][W];
		int[][] count = new int[H][W];
		Gun[] gunList = new Gun[2];
		int index=0;
		int ans=Integer.MAX_VALUE;
		for(int i=0; i<H; i++) {
			String s= sc.next();
			for(int j=0; j<W; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='C') {
					gunList[index++]=new Gun(i,j,0,-1);
				}
				count[i][j]=Integer.MAX_VALUE;
			}
		}
		Queue<Gun> q = new LinkedList<>();
		Gun START = gunList[0];
		Gun END = gunList[1];
		q.add(START);
		count[START.y][START.x]=0;
		while(!q.isEmpty()) {
			Gun p = q.remove();
			if(p.y==END.y&&p.x==END.x) {
				if(p.c<ans) {
					ans=p.c;
				}
			}
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				int rd = p.c;
				if(ry<0||rx<0||ry>=H||rx>=W) continue;
				if(map[ry][rx]=='*') continue;
				if(p.prev!=k&&p.prev!=-1) rd++;
				if(count[ry][rx]<rd) continue;
				count[ry][rx]=rd;
				q.add(new Gun(ry,rx,rd,k));
			}
		}
		System.out.println(ans);

	}

//	private static void bfs(Gun START, Gun END) {
//		// TODO Auto-generated method stub
//		Queue<Gun> q = new LinkedList<>();
//		q.add(START);
//		count[START.y][START.x]=0;
//		while(!q.isEmpty()) {
//			Gun p = q.remove();
//			if(p.y==END.y&&p.x==END.x) {
//				if(p.c<ans) {
//					ans=p.c;
//				}
//			}
//			for(int k=0; k<4; k++) {
//				int ry = dy[k]+p.y;
//				int rx = dx[k]+p.x;
//				int rd = p.c;
//				if(ry<0||rx<0||ry>=H||rx>=W) continue;
//				if(map[ry][rx]=='*') continue;
//				if(p.prev!=k&&p.prev!=-1) rd++;
//				if(count[ry][rx]<rd) continue;
//				count[ry][rx]=rd;
//				q.add(new Gun(ry,rx,rd,k));
//			}
//		}
//	}
}