package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem9019_R {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= TC; tc++) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int[] from = new int[10000];
			char[] alpha = new char[10000];
			Queue<Integer> q= new LinkedList<>();
			Arrays.fill(from, -1);
			q.add(A);
			while(!q.isEmpty()) {
				int p = q.remove();
				if(p==B) {
					StringBuilder b = new StringBuilder();
					int num = p;
					b.append(alpha[p]);
					while(from[num]!=A) {
						
						num = from[num];
						b.append(alpha[num]);
					}
					b.reverse();
					sb.append(b.toString()+"\n");
					break;
				}
				for(int k=0; k<4; k++) {
					int r = p;
					if(k==0) {
						r=(2*r)%10000;
						if(from[r]>-1) continue;
						alpha[r]='D';
					}else if(k==1) {
						r=(r-1==-1?9999:r-1);
						if(from[r]>-1) continue;
						alpha[r]='S';
					}else if(k==2) {
						int temp = r/1000;
						r-=temp*1000;
						r*=10;
						r+=temp;
						if(from[r]>-1) continue;
						alpha[r]='L';
					}else if(k==3) {
						int temp = r%10;
						r=r/10+temp*1000;
						if(from[r]>-1) continue;
						alpha[r]='R';
					}
					from[r]=p;
					q.add(r);
				}
			}
		}
		System.out.println(sb);
	}
}
