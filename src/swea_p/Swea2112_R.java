package swea_p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea2112_R {
	static int[][] map;
	static int[] way;
	static int D,W,K;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc=1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			D = Integer.parseInt(token.nextToken());//세로
			W = Integer.parseInt(token.nextToken()); //가로
			K = Integer.parseInt(token.nextToken()); //합격기준
			map = new int[D][W];
			copy = new int[D][W];

			for(int i=0; i<D; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
				}
			}

			if(check(map)) {
				bw.write("#"+String.valueOf(tc)+" "+String.valueOf("0"));
			}else {
				for(int i=0; i<D; i++) {
					for(int j=0; j<W; j++) {
						copy[i][j]=map[i][j];
					}
				}
				for(int i=1; i<=D; i++) {
					way = new int[i];
					rway = new int[i];
					if(dfs(0,i,0,D)) {
						bw.write("#"+String.valueOf(tc)+" "+String.valueOf(i));
						break;
					}
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static int[][] copy;
	static int[] rway;
	private static boolean dfs(int num, int end, int index, int N) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(dfs2(end,0)) return true;
			return false;
		}
		for(int i=num; i<N; i++) {
			way[index]=i;
			boolean pass = dfs(i+1,end,index+1,N);
			if(pass) return true;
		}
		return false;
	}
	private static boolean dfs2(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			for(int i=0; i<end; i++) {
				Arrays.fill(copy[way[i]], rway[i]);
			}
			boolean pass = check(copy);
			reArray();
			return pass;
		}
		for(int i=0; i<=1; i++) {
			rway[index]=i;
			if(dfs2(end,index+1)) return true;
		}
		return false;
	}
	private static void reArray() {
		// TODO Auto-generated method stub
		for(int i=0; i<way.length; i++) {
			for(int j=0; j<W; j++) {
				copy[way[i]][j]=map[way[i]][j];
			}
		}
	}
	private static boolean check(int[][] copy) {
		// TODO Auto-generated method stub
		outloof:
			for(int i=0; i<W; i++) {
				int A=0;
				int B=0;
				for(int j=0; j<D; j++) {
					if(copy[j][i]==0) {
						B=0;
						A++;
					}else {
						A=0;
						B++;
					}
					if(A==K||B==K) {
						continue outloof;
					}
				}
				return false;
			}
	return true;
	}
}