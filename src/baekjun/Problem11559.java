package baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem11559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		map = new char[12][6];
		for(int i=0; i<12; i++) {
			String s= sc.next();
			for(int j=0; j<6; j++) {
				map[i][j]=s.charAt(j);
			}
		}
//		for(int i=0; i<12; i++) {
//		System.out.println(Arrays.toString(map[i]));
//		}
		int count=0;
		while(simulation()) {
//			System.out.println();
			count++;
			reArray();
//			for(int i=0; i<12; i++) {
//				System.out.println(Arrays.toString(map[i]));
//				}
		};
		System.out.println(count);
	}
	private static void reArray() {
		// TODO Auto-generated method stub
		for(int i=10; i>=0; i--) {
			for(int j=0; j<6; j++) {
				int k=1;
				while(i+k<12&&map[i+k][j]=='.') {
					map[i+k][j]=map[i+k-1][j];
					map[i+k-1][j]='.';
					k++;
				}
			}
		}
	}
	static boolean[][] visited;
	static char[][] map;
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	private static boolean simulation() {
		// TODO Auto-generated method stub
		boolean pass = false;
		visited= new boolean[12][6];

		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]=='.') continue;
				if(bfs(new Pair(i,j))) {
					pass = true;
				};
			}
		}
		return pass;
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static boolean bfs(Pair start) {
		// TODO Auto-generated method stub
		int count=0;
		Queue<Pair> q= new LinkedList<>();
		ArrayList<Pair> list = new ArrayList<>();
		q.add(start);
		list.add(start);
		visited[start.y][start.x]=true;
		count++;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int k=0; k<4; k++) {
				int ry = dy[k]+p.y;
				int rx = dx[k]+p.x;
				if(ry<0||rx<0||ry>=12||rx>=6) continue;
				if(map[p.y][p.x]!=map[ry][rx]) continue;
				if(visited[ry][rx]) continue;
				visited[ry][rx]=true;
				Pair next = new Pair(ry,rx);
				q.add(next);
				list.add(next);
				count++;
			}
		}

		if(count>=4) {
			for(Pair p : list) {
				map[p.y][p.x]='.';
			}
			return true;
		}
		return false;
	}

}
