package SAMSUNG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A2382 {

	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static class Monster implements Comparable<Monster>{
		int no;
		int y;
		int x;
		int num;
		int d;
		boolean die;
		Monster(int no, int y, int x,int num, int d, boolean die){
			this.no=no;
			this.y=y;
			this.x=x;
			this.num=num;
			this.d=d;
			this.die=die;
		}
		
		@Override
		public int compareTo(Monster target) {
			// TODO Auto-generated method stub
			return this.num<target.num?1:-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			PriorityQueue<Monster>[][] map =(PriorityQueue<Monster>[][]) new PriorityQueue[N][N];
			ArrayList<Monster> monList = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = new PriorityQueue<>();
				}
			}
			for(int i=0; i<K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int num = sc.nextInt();
				int d = sc.nextInt();
				Monster m = new Monster(i,y,x,num,d,false);
				monList.add(m);
				map[y][x].add(m);
			}

			for(int t=1; t<=M; t++) {
				for(Monster m : monList) {
					if(m.die) continue;
					int ry = m.y+dy[m.d];
					int rx = m.x+dx[m.d];
					int rd = m.d;
					int rnum = m.num;
					if(ry==0||rx==0||ry==N-1||rx==N-1) {
						if(rd<3) {
							rd=3-rd;
						}else {
							rd=7-rd;
						}
						rnum/=2;
					}
					map[ry][rx].add(m);
					Iterator<Monster> it = map[m.y][m.x].iterator();
					while(it.hasNext()) {
						Monster x = it.next();
						if(x.no==m.no) {
							it.remove();
							break;
						}
					}
					m.y=ry;
					m.x=rx;
					m.d=rd;
					m.num=rnum;
				}
				for(Monster mon : monList) {
					if(map[mon.y][mon.x].size()==1) continue;
					if(mon.die) continue;
					Monster bm = map[mon.y][mon.x].remove();
					while(!map[mon.y][mon.x].isEmpty()) {
						Monster m = map[mon.y][mon.x].remove();
						bm.num+=m.num;
						m.die=true;
					}
					map[mon.y][mon.x].add(bm);
				}
			}
			int ans=0;
			for(Monster m : monList) {
				if(m.die) continue;
				ans+=m.num;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}