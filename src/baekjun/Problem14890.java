package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14890 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int L = Integer.parseInt(token.nextToken());
		int[][] map = new int[2*N][N];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for(int i=N; i<2*N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=map[j][i-N];
			}
		}
		boolean[][] help = new boolean[2*N][N];
		int count=0;

		outloof : 
			for(int i=0; i<2*N; i++) {
				for(int j=1; j<N; j++) {
					if(Math.abs(map[i][j]-map[i][j-1])>1) continue outloof;
					if(map[i][j-1]>map[i][j]) {
						int curHeight=map[i][j];
						for(int k=j; k<=j+L-1; k++) {
							if(k>N-1) continue outloof;
							if(map[i][k]!=curHeight) continue outloof;
							help[i][k]=true;
						}
					}
				}
				for(int j=N-2; j>=0; j--) {
					if(Math.abs(map[i][j+1]-map[i][j])>1) continue outloof;
					if(map[i][j+1]>map[i][j]) {
						int curHeight=map[i][j];
						for(int k=j; k>=j-L+1; k--) {
							if(k<0) continue outloof;
							if(help[i][k]) continue outloof;
							if(map[i][k]!=curHeight) continue outloof;
							help[i][k]=true;
						}
					}
				}
				count++;
			}
		System.out.println(count);
	}
}