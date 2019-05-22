package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Swea5644_R {
	static class AP implements Comparable<AP>{
		int num;
		int y;
		int x;
		int c;
		int p;
		int dist;
		AP(int num, int y, int x,int c, int p, int dist){
			this.num=num;
			this.y=y;
			this.x=x;
			this.c=c;
			this.p=p;
			this.dist=dist;
		}
		@Override
		public int compareTo(AP target) {
			// TODO Auto-generated method stub
			return this.p<target.p?1:this.p>target.p?-1:0;
		}
	}
	static ArrayList<AP>[][] map;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			map =(ArrayList<AP>[][]) new ArrayList[11][11];
			for(int i=1; i<=10; i++) {
				for(int j=1; j<=10; j++) {
					map[i][j]=new ArrayList<>();
				}
			}
			String[] s = br.readLine().split(" ");
			int M = Integer.parseInt(s[0]); // 총 이동 시간
			int A = Integer.parseInt(s[1]); // BC의 개수
			int[] MOVE_A = new int[M+1];
			int[] MOVE_B = new int[M+1];
			s = br.readLine().split(" ");
			for(int i=0; i<M; i++) {
				MOVE_A[i]=Integer.parseInt(s[i]);
			}
			s = br.readLine().split(" ");
			for(int i=0; i<M; i++) {
				MOVE_B[i]=Integer.parseInt(s[i]);
			}
			for(int i=0; i<A; i++) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				int C = Integer.parseInt(s[2]);//범위
				int P = Integer.parseInt(s[3]);//파워
				bfs(new AP(i,y,x,C,P,0));
			}
			for(int i=1; i<11; i++) {
				for(int j=1; j<11; j++) {
					Collections.sort(map[i][j]);
				}
			}
			int ay=1,ax=1;
			int by=10,bx=10;
			int ans=0;
			for(int t=0; t<=M; t++) {
				if(map[ay][ax].size()>0&&map[by][bx].size()>0) {
					if(map[ay][ax].get(0).num==map[by][bx].get(0).num) {
						if(map[ay][ax].size()>1&&map[by][bx].size()>1) {
							ans+=Math.max(map[ay][ax].get(1).p+map[by][bx].get(0).p, map[ay][ax].get(0).p+map[by][bx].get(1).p);
						}else if(map[ay][ax].size()>1) {
							ans+=map[ay][ax].get(1).p+map[by][bx].get(0).p;
						}else if(map[by][bx].size()>1) {
							ans+=map[by][bx].get(1).p+map[ay][ax].get(0).p;
						}else {
							ans+=(map[by][bx].get(0).p+map[ay][ax].get(0).p)/2;
						}
					}else {
						ans+=map[by][bx].get(0).p+map[ay][ax].get(0).p;
					}
				}else if(map[by][bx].size()>0) {
					ans+=map[by][bx].get(0).p;
				}else if(map[ay][ax].size()>0) {
					ans+=map[ay][ax].get(0).p;
				}
				ay+=dy[MOVE_A[t]];
				ax+=dx[MOVE_A[t]];
				by+=dy[MOVE_B[t]];
				bx+=dx[MOVE_B[t]];
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {0,-1,0,1,0};
	static int[] dx = {0,0,1,0,-1};
	private static void bfs(AP ap) {
		// TODO Auto-generated method stub
		Queue<AP> q = new LinkedList<>();
		boolean[][] visited = new boolean[11][11];
		visited[ap.y][ap.x]=true;
		map[ap.y][ap.x].add(ap);
		q.add(ap);
		while(!q.isEmpty()) {
			AP p = q.remove();
			for(int k=1; k<5; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<1||rx<1||ry>=11||rx>=11) continue;
				if(p.c==p.dist) continue;
				if(visited[ry][rx])continue;
				visited[ry][rx]=true;
				AP next = new AP(p.num,ry,rx,p.c,p.p,p.dist+1);
				map[ry][rx].add(next);
				q.add(next);
			}
		}
	}
}
