package SAMSUNG;

import java.util.Scanner;

public class S14891 {
	static boolean[] visited;
	static int[][] circle;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		circle = new int[4][8];
		for(int i=0; i<4; i++) {
			String s= sc.next();
			for(int j=0; j<8; j++) {
				circle[i][j]=s.charAt(j)-'0';
			}
		}
		int K = sc.nextInt();
		for(int i=0; i<K; i++) {
			visited = new boolean[4];
			int num = sc.nextInt()-1;
			int direct = sc.nextInt();
			dfs(num, direct);
		}
		System.out.println(circle[0][0]+circle[1][0]*2+circle[2][0]*4+circle[3][0]*8);
	}

	private static void dfs(int num, int direct) {
		// TODO Auto-generated method stub
		if(visited[num]) return;
		visited[num]=true;
		if(num-1>=0&&circle[num][6]!=circle[num-1][2]) dfs(num-1,direct*-1);
		if(num+1<=3&&circle[num][2]!=circle[num+1][6]) dfs(num+1,direct*-1);
		simulation(num,direct);
	}

	private static void simulation(int num, int direct) {
		// TODO Auto-generated method stub
		if(direct==1) {
			int temp = circle[num][7];
			for(int i=6; i>=0; i--) {
				circle[num][i+1]=circle[num][i];
			}
			circle[num][0]=temp;
		}else {
			int temp = circle[num][0];
			for(int i=1; i<=7; i++) {
				circle[num][i-1]=circle[num][i];
			}
			circle[num][7]=temp;
		}
	}
}
