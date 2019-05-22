package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea2112 {

	static int D;
	static int W;
	static int K;
	static int[][] films;
	static int[][] copy;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc = 1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			D = Integer.parseInt(token.nextToken()); // 높이
			W = Integer.parseInt(token.nextToken()); // 가로
			K = Integer.parseInt(token.nextToken()); // 연속으로 있어야하는 조건 수
			films = new int[D][W];
			copy = new int[D][W];
			for(int i=0; i<D; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					films[i][j]=Integer.parseInt(token.nextToken());
				}
			}

			makeCopy(films,copy);
			if(check(copy)) {

				bw.write("#"+String.valueOf(tc)+" "+"0");
				bw.newLine();
				continue;
			}

			bw.write("#"+String.valueOf(tc));
			for(int i=1; i<D; i++) {
				visited = new boolean[D];
				if(dfs(0,i,0)) {
					break;
				}
			}
		}
		bw.flush();
		bw.close();
	}
	static boolean[] visited;
	static int[] numbers;
	static int[] bit;
	private static boolean dfs(int num,int end, int index) throws IOException {
		// TODO Auto-generated method stub
		if(index == end) {
			numbers = new int[end];
			int idx =0;
			for(int i=0; i<D; i++) {
				if(!visited[i]) continue;
				numbers[idx++]=i;
			}
						bit = new int[D];
						Arrays.fill(bit, -1);
			makeCopy(films, copy);//추가
			if(dfs2(end, 0)) {
				return true;
			}else {
				return false;
			}

		}
		for(int i=num; i<D; i++) {
			if(visited[i])continue;
			visited[i]=true;
			if(dfs(i+1,end,index+1)) {
				return true;
			}
			visited[i]=false;
		}

		return false;

	}


	  private static boolean dfs2(int end, int index) throws IOException {
	        // TODO Auto-generated method stub
	        if(index==end) {
	            makeCopy(films, copy);
	            for(int i=0; i<D; i++) {
	                if(bit[i]==-1) continue;
	                for(int j=0;j<W; j++) {
	                    copy[i][j]=bit[i];
	                }
	            }
	            if(check(copy)) {
	                bw.write(" "+String.valueOf(end));
	                bw.newLine();
	                return true;
	            }
	            return false;
	        }
	        for(int i=0; i<2; i++) {
	            bit[numbers[index]]=i;
	            if(dfs2(end, index+1)) {
	                return true;
	            }
	        }
	        return false;
	    }

	private static void makeCopy(int[][] films, int[][] copy) {
		// TODO Auto-generated method stub
		for(int i=0; i<D; i++) {
			for(int j=0; j<W; j++) {
				copy[i][j]=films[i][j];
			}
		}
	}

	private static boolean check(int[][] films) {
		// TODO Auto-generated method stub
		outloof:
			for(int i=0; i<W; i++) {

				int count_A=0;
				int count_B=0;
				for(int j=0; j<D+1; j++) {
					if(j==D) {
						return false;
					}
					if(films[j][i]==0) {
						count_A++;
						count_B=0;
					}else {
						count_B++;
						count_A=0;
					}
					if(count_A>=K||count_B>=K) {
						continue outloof;
					}
				}

			}
	return true;
	}
}