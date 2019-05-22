package baekjun;

import java.util.Scanner;

public class Problem2669 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		boolean[][] visited = new boolean[101][101];
		for(int t=0; t<4; t++) {
			int x1 = sc.nextInt();
			int y1= sc.nextInt();
			int x2 = sc.nextInt();
			int y2 =sc.nextInt();
			for(int i=y1; i<y2; i++) {
				for(int j=x1; j<x2; j++) {
					visited[i][j]=true;
				}
			}
		}
		int count=0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(!visited[i][j])continue;
				count++;
			}
		}
		System.out.println(count);
	}
}
