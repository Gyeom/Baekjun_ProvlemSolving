package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem13460 {
	static class Pair{
		int y;
		int x;
		int v;
		Pair(int y, int x, int v){
			this.y=y;
			this.x=x;
			this.v=v;
		}
	}
	static int N;
	static int M;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		char[][] a= new char[N][M];
		from  = new int[2][N][M];
		for(int i=0; i<2; i++) {
			for(int j=0; j<N; j++) {
				Arrays.fill(from[i][j], 10);
			}
		}
		ArrayList<Pair> al = new ArrayList<Pair>();
		for(int i=0; i<3; i++) {
			al.add(i, null);
		}
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<M; j++) {
				a[i][j] = s.charAt(j);
				if(a[i][j]=='B') {
					al.set(0,new Pair(i,j,4));
				}else if(a[i][j]=='R'){
					al.set(1,new Pair(i,j,4));
				}else if(a[i][j]=='O') {
					al.set(2, new Pair(i,j,4));
				}
			}
		}
		int hole_y=al.get(2).y;
		int hole_x=al.get(2).x;
		for(int i=0; i<al.size()-1; i++) {
			boolean go =bfs(al.get(i),al.get(2),a,i);
			if(i==1&&go) {
				if((blue_y==red_y)&&(s==bs)&&(blue_x==red_x)){
					System.out.println(s);
				}else if((blue_y==red_y)&&(s==bs)&&((blue_x-hole_x>0&&red_x-hole_x>0)||(blue_x-hole_x<0&&red_x-hole_x<0))) {
						System.out.println("-1");
				}else if((blue_x==red_x)&&(s==bs)&&((blue_y-hole_y>0&&red_y-hole_y>0)||(blue_y-hole_y<0&&red_y-hole_y<0))) {
						System.out.println("-1");
				}else {
					System.out.println(s);
				}
				
				}
			
			
			if(i==1&&!go){
				System.out.println("-1");
			}
			
			
			
			
		}
		
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int s=11;
	static int bs=11;
	static int[][][] from;
	static int blue_y;
	static int blue_x;
	static int red_y;
	static int red_x;
	private static boolean bfs(Pair Start, Pair Hole, char[][] a,int index) {
		// TODO Auto-generated method stub
		boolean pass = false;
		Queue<Pair> q= new LinkedList<>();
//		boolean[][] visited = new boolean[N][M];
		int[][][] dist = new int[N][M][5];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Arrays.fill(dist[i][j], -1);
			}
		}
		q.add(Start);
		dist[Start.y][Start.x][4]=0;
		from[index][Start.y][Start.x]=0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			
			
			label :
			for(int k=0; k<4; k++) {
				int ry = p.y;
				int rx = p.x;
			
				if(dist[p.y][p.x][p.v]==10) continue;
				if((p.v==k)||(p.v==0&&k==1)||(p.v==1&&k==0)||(p.v==2&&k==3)||(p.v==3&&k==2)) continue;
				while((ry+dy[k]>=0&&rx+dx[k]>=0&&ry+dy[k]<N&&rx+dx[k]<M&&a[ry+dy[k]][rx+dx[k]]!='#')) {
					ry += dy[k];
					rx += dx[k];
					if(a[ry][rx]=='O') {
					
						dist[ry][rx][k]=dist[p.y][p.x][p.v]+1;
						if(dist[ry][rx][k]<=s) {
							if(index==1) {
								red_y=p.y;
								red_x=p.x;
								bs=dist[ry][rx][k];
							}else {
								blue_y=p.y;
								blue_x=p.x;
							}
							s=dist[ry][rx][k];
							pass=true;
						}
						continue label;
					}
				}

				if(ry==p.y&&rx==p.x) continue;
				if(ry<0||rx<0||ry>=N||rx>=M||a[ry][rx]=='#') continue;
				if(dist[ry][rx][k]>=dist[p.y][p.x][p.v]+1) continue;
				
				if(index==1) {
					if(Math.abs(ry-p.y)+Math.abs(rx-p.x)>from[0][ry][rx]) {
						continue;
					}
				}
				dist[ry][rx][k]=dist[p.y][p.x][p.v]+1;
				from[index][ry][rx]=Math.abs(ry-p.y)+Math.abs(rx-p.x);
//				if(index==1) {	
//				System.out.println(ry+","+rx);
//				System.out.println((ry-p.y)+(rx-p.x));
//				System.out.println(from[0][ry][rx]);
//			}
				q.add(new Pair(ry,rx,k));
				if(ry==Hole.y&&rx==Hole.x) {
					if(dist[ry][rx][k]<=s) {
						if(index==1) {
							red_y=p.y;
							red_x=p.x;
						}else {
							blue_y=p.y;
							blue_x=p.x;
						}
						s=dist[ry][rx][k];
						pass=true;
					}
				
				}
			}
		}
		
		
		return pass;
	}
}