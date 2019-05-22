package swea_p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Swea5648{
	static int ans;
	static class Atom{
		int y;
		int x;
		int d;
		int K;
		Atom(int y, int x, int d, int K){
			this.y=y;
			this.x=x;
			this.d=d;
			this.K=K;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map = new int[4001][4001];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			ans=0;
			Queue<Atom> q = new LinkedList<>();
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				int d = Integer.parseInt(s[2]);
				int K = Integer.parseInt(s[3]);
				if(K==0) K=101;
				q.add(new Atom(2*y+2000,2*x+2000,d,K));
			}
			bfs(q);
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	private static void bfs(Queue<Atom> q) {
		// TODO Auto-generated method stub
		int cntZero=0;
		while(!q.isEmpty()) {
			Atom a = q.remove();
			if(map[a.y][a.x]>a.K) {
				if(a.K==101) {
					cntZero++;
				}
				ans+=map[a.y][a.x];
				map[a.y][a.x]=0;
				continue;
			}
			map[a.y][a.x]=0;
			int ry = a.y +dy[a.d];
			int rx = a.x +dx[a.d];
			if(ry<0||rx<0||ry>4000||rx>4000) continue;
			if(map[ry][rx]==0) {
				q.add(new Atom(ry,rx,a.d,a.K));
			}else {
				if(a.K==101) {
					cntZero++;
				}
			}
			map[ry][rx]+=a.K;
		}
		ans-=cntZero*101;
	}
}