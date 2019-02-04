package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem6064 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-->0) {
			token = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(token.nextToken());
			int N = Integer.parseInt(token.nextToken());
			int X = Integer.parseInt(token.nextToken());
			int Y = Integer.parseInt(token.nextToken());
			int gcd=0;
			if(M>N) {
				gcd=gcd(M,N);
			}else {
				gcd=gcd(N,M);
			}
			dfs(1,1,X,Y,M,N,1,M*N/gcd);
		}
		
	}

	private static void dfs(int x, int y, int X, int Y, int M, int N, int index, int LCM) {
		// TODO Auto-generated method stub
		if(x==X&&y==Y) {
			System.out.println(index);
			return;
		}
		if(index==LCM) {
			System.out.println("-1");
			return;
		}
		if(x<M) {
			x++;
		}else {
			x=1;
		}
		if(y<N) {
			y++;
		}else {
			y=1;
		}
		dfs(x,y,X,Y,M,N,index+1,LCM);
	}

	private static int gcd(int M, int N) {
		// TODO Auto-generated method stub
		  if (N == 0) {
	            return M;
	        } else {
	            return gcd(N, M%N);
	        }
	}

}
