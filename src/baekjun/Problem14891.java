package baekjun;

import java.util.Scanner;

public class Problem14891 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		circle = new int[4+1][8];
		for(int i=1; i<=4; i++) {
			String s= sc.next();
			for(int j=0; j<8; j++) {
				circle[i][j]=s.charAt(j)-'0';
			}
		}

		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			int direct = sc.nextInt();
			visited = new boolean[4+1];
			dfs(num, direct);
		}
		int ans=0;
		for(int i=1; i<=4; i++) {
			if(circle[i][0]==0) continue;
			ans+=(int)Math.pow(2, i-1);
		}
		System.out.println(ans);
	}
	
	static boolean[] visited;
	static int[][] circle;
	private static void dfs(int num, int direct) {
		// TODO Auto-generated method stub
		if(visited[num]) return;
		visited[num]=true;
		if(num+1<=4&&circle[num][2]!=circle[num+1][6]) {
			dfs(num+1,-1*direct);
		}
		if(num-1>=1&&circle[num][6]!=circle[num-1][2]) {
			dfs(num-1,-1*direct);
		}

		if(direct==-1) {
			int temp = circle[num][0];
			for(int i=0; i<7; i++) {
				circle[num][i]=circle[num][i+1];
			}
			circle[num][7]=temp;	
		}else {
			int temp = circle[num][7];
			for(int i=6; i>=0; i--) {
				circle[num][i+1]=circle[num][i];
			}
			circle[num][0]=temp;
		}
	}
}
