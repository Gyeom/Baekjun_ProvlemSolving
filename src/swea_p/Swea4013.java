package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea4013 {
	static int[][] circle;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=TC; tc++) {
			int K =Integer.parseInt(br.readLine());
			circle = new int[4][8];
			for(int i=0; i<4; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					circle[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			for(int i=0; i<K; i++) {
				token = new StringTokenizer(br.readLine());
				visited = new boolean[4];
				int num=Integer.parseInt(token.nextToken())-1;
				int rotate=Integer.parseInt(token.nextToken());
				visited[num]=true;
				dfs(num,rotate);
				rotate(num,rotate);
			}
			bw.write("#"+tc+" "+String.valueOf(circle[0][0]+2*circle[1][0]+4*circle[2][0]+8*circle[3][0]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static boolean[] visited;
	private static void dfs(int num, int rotate) {
		// TODO Auto-generated method stub
		if(num-1>=0) {
			if(!visited[num-1]) {
				visited[num-1]=true;
				if(circle[num-1][2]!=circle[num][6]) {
					dfs(num-1,-1*rotate);
					rotate(num-1,-1*rotate);
				}
			}
		}
		if(num+1<4) {
			if(!visited[num+1]) {
				visited[num+1]=true;
				if(circle[num+1][6]!=circle[num][2]) {
					dfs(num+1,-1*rotate);
					rotate(num+1,-1*rotate);
				}
			}
		}
	}
	private static void rotate(int num, int rotate) {
		// TODO Auto-generated method stub
		if(rotate>0) {
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