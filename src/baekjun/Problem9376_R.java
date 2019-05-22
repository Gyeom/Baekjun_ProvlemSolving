package baekjun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem9376_R {

	static class Man{
		int y;
		int x;
		Man(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();

			int[][] map = new int[h+2][w+2];
			Man[] manList = new Man[2];
			int index=0;
			for(int i=1; i<=h; i++) {
				String s = sc.next();
				for(int j=1; j<=w; j++) {
					map[i][j]=(int)s.charAt(j-1);
					//*:42 #:35 $:36 .:46
					if(map[i][j]==36) {
						manList[index++]= new Man(i,j);
					}
				}
			}

			for(int k=0; k<2; k++) {
				int[][] copy = new int[h+2][w+2];
				for(int i=0; i<h+2; i++) {
					for(int j=0; j<w+2; j++) {
						copy[i][j]=map[i][j];
					}
				}
				bfs(manList[k]);
			}
		}
	}
	private static void bfs(Man man) {
		// TODO Auto-generated method stub
		Deque<Man> q = new ArrayDeque<>();
		while(!q.isEmpty()) {
			Man p = q.removeFirst();
			for(int k=0; k<4; k++) {
				
			}
		}
	}
}
