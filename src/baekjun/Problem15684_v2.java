package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem15684_v2 {

	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int N;
	static int H;
	static int[][] a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		a = new int[H+1][N+1];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(token.nextToken());
			int x = Integer.parseInt(token.nextToken());
			a[y][x]=1;
			a[y][x+1]=-1;
		}
		//		for(int i=0; i<=H; i++) {
		//			System.out.println(Arrays.toString(a[i]));
		//		}
		//		System.out.println();

		boolean go=true;
		for(int i=1; i<=N+1; i++) {
			if(i==N+1) {
				bw.write("0");
				go=false;
				break;
			}
			if(!bfs(i)) break;
		}
		if(go) {
			for(int i=1; i<=4; i++) {
				if(i==4) {
					bw.write("-1");
					break;
				}
				if(dfs(i,0,a,1,1)) {
					bw.write(String.valueOf(i));
					break;
				}
			}
		}
		bw.flush();
		bw.close();
	}
	private static boolean dfs(int end, int index, int[][] a, int y, int x) {
		// TODO Auto-generated method stub
		if(index==end) {
			for(int i=1; i<=N+1; i++) {
				if(i==N+1) {
					return true;
				}
				if(!bfs(i)) return false;
			}
		}
		if(x==N) {
			y=y+1;
			x=1;
		}

		for(int i=y; i<=H; i++) {
			for(int j=x; j<=N-1; j++) {
				if(a[i][j]!=0||a[i][j+1]==1) continue;
				a[i][j]=1;
				a[i][j+1]=-1;
				if(dfs(end,index+1,a,i,j+1)) {
					a[i][j]=0;
					a[i][j+1]=0;
					return true;
				}
				a[i][j]=0;
				a[i][j+1]=0;
			}
			x=1;
		}

		return false;

	}
	private static boolean bfs(int num) {
		// TODO Auto-generated method stub
		int y=1;
		int x=num;

		while(y!=H) {
			//			System.out.println(y+","+x);
			if(a[y][x]==1) {
				x++;
				y++;
			}else if(a[y][x]==-1) {
				x--;
				y++;
			}else {
				y++;
			}
		}
		//		System.out.println(y+","+x);
		if(a[y][x]==1) {
			x++;
		}else if(a[y][x]==-1){
			x--;
		}
		if(x==num) {
			//			System.out.println(x+","+num);
			//			for(int i=0; i<=H; i++) {
			//			System.out.println(Arrays.toString(a[i]));
			//		}
			//		System.out.println();
			return true;
		}
		return false;
	}

}
