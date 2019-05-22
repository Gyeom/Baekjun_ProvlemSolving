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
import java.util.StringTokenizer;

public class Swea5644 {
	static ArrayList<AP>[][] map;
	static class AP implements Comparable<AP>{
		int num;
		int y;
		int x;
		int C;
		int P;
		AP(int num, int y, int x, int C, int P){
			this.num=num;
			this.y=y;
			this.x=x;
			this.C=C;
			this.P=P;
		}
		@Override
		public int compareTo(AP target) {
			// TODO Auto-generated method stub
			if(this.P<target.P) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	static int[] dyy = {0,-1,0,1,0};
	static int[] dxx = {0,0,1,0,-1};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc =1 ; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(token.nextToken()); //총이동시간
			int A = Integer.parseInt(token.nextToken()); //BC의 개수
			int[] move_A = new int[M];
			int[] move_B = new int[M];
			map =(ArrayList<AP>[][]) new ArrayList[10][10];
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map[i][j]=new ArrayList<>();
				}
			}
			token = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				move_A[i]=Integer.parseInt(token.nextToken());
			}
			token = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				move_B[i]=Integer.parseInt(token.nextToken());
			}
			
			for(int i=0; i<A; i++) {
				token = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				int C = Integer.parseInt(token.nextToken());
				int P = Integer.parseInt(token.nextToken());
				bfs(new AP(i, y-1, x-1, C, P));
			}
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					Collections.sort(map[i][j]);
				}
			}
			int score=0;
			int ay=0;
			int ax=0;
			int by=9;
			int bx=9;
			if(!map[ay][ax].isEmpty()) {
				score+=map[ay][ax].get(0).P;
			}
			if(!map[by][bx].isEmpty()) {
				score+=map[by][bx].get(0).P;
			}
			for(int i=0; i<M; i++) {
				ay+=dyy[move_A[i]];
				ax+=dxx[move_A[i]];
				by+=dyy[move_B[i]];
				bx+=dxx[move_B[i]];
				if(!map[ay][ax].isEmpty()&&!map[by][bx].isEmpty()) {
					if(map[ay][ax].get(0).num==map[by][bx].get(0).num) {
						if(map[ay][ax].size()>1&&map[by][bx].size()>1) {
							score+=map[ay][ax].get(0).P+map[by][bx].get(1).P>=map[ay][ax].get(1).P+map[by][bx].get(0).P?map[ay][ax].get(0).P+map[by][bx].get(1).P:map[ay][ax].get(1).P+map[by][bx].get(0).P;
						}else if(map[ay][ax].size()>1) {
							score+=map[ay][ax].get(1).P+map[by][bx].get(0).P;
						}else if(map[by][bx].size()>1) {
							score+=map[ay][ax].get(0).P+map[by][bx].get(1).P;
						}else {
							score+=map[ay][ax].get(0).P;
						}
					}else {
						score+=map[ay][ax].get(0).P+map[by][bx].get(0).P;
					}
				}else if(!map[ay][ax].isEmpty()) {
					score+=map[ay][ax].get(0).P;
				}else if(!map[by][bx].isEmpty()) {
					score+=map[by][bx].get(0).P;
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(score));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};

	private static void bfs(AP ap) {
		// TODO Auto-generated method stub
		int range = ap.C;
		int y = ap.y;
		int x = ap.x;
		Queue<AP> q = new LinkedList<>();
		boolean[][] visited = new boolean[10][10];
		q.add(ap);
		map[ap.y][ap.x].add(ap);
		visited[ap.y][ap.x]=true;
		while(!q.isEmpty()) {
			AP p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=10||rx>=10) continue;
				if(range<Math.abs(ry-y)+Math.abs(rx-x)) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				AP temp = new AP(p.num,ry,rx,p.C,p.P);
				q.add(temp);
				map[ry][rx].add(temp);
			}
		}
	}
}