package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem1248 {
	
	static int[] p;
	static char[][] a;
	static boolean quit;
	static String s;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		quit = false;

		p = new int[N];
		a = new char[N][N];
		s = br.readLine();

		for(int i=0,k=0; i<N; i++) {
			for(int j=i; j<N; j++,k++) {
				a[i][j]=s.charAt(k);
			}
		}
		dfs(0,N, 0);
	}

	
	private static void dfs(int num, int end, int index) throws IOException {
		// TODO Auto-generated method stub
		if(index == end) {
			
			
//			quit=true; //종료
//			bw.write(Arrays.toString(p).replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",", ""));
//			bw.flush();
//			bw.close();

			System.out.println(Arrays.toString(p).replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",", ""));
			System.exit(0);
			return;
		}
		
		label :
		for(int i=-10; i<=10; i++) {
		
	
			p[index]=i;
			for(int j=0; j<=index; j++) {
				int sum=0;
				for(int k=j; k<=index; k++) {
					sum+=p[k];
					if(sum>0) {
						if(a[j][k]!='+') {
							p[index]=0;
							continue label;
						}
					}else if(sum<0) {
						if(a[j][k]!='-') {
							p[index]=0;
							continue label;
						}
					}else {
						if(a[j][k]!='0') {
							p[index]=0;
							continue label;
						}
					}
				}
			}
		

	
			
			
			p[index]=i;
			dfs(i, end, index+1);
//			if(quit) return; //종료
			p[index]=0;
			
		}
	}


}
