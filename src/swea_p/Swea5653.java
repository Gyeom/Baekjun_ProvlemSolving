package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea5653 {
	static class Cell implements Comparable<Cell> {
		int y;
		int x;
		int status;
		int life;
		Cell(int y, int x, int status, int life){
			this.y=y;
			this.x=x;
			this.status=status; //0:비활 1:활성 2:사망
			this.life = life;
		}
		@Override
		public int compareTo(Cell target) {
			// TODO Auto-generated method stub
			return this.life<target.life ? 1:-1;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=TC; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			int[][] life = new int[N+K][M+K];
			Cell[][] cell = new Cell[N+K][M+K];
			for(int i=(N+K)/2-N/2; i<(N+K)/2-N/2+N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=(M+K)/2-M/2+0; j<(M+K)/2-M/2+M; j++) {
					life[i][j]=Integer.parseInt(token.nextToken());
					if(life[i][j]==0) continue;
					cell[i][j]= new Cell(i, j, 0,life[i][j]);
				}
			}
			PriorityQueue<Cell> q = new PriorityQueue<>();
			for(int k=1; k<=K; k++) {
				for(int i=0; i<N+K; i++) {
					for(int j=0; j<M+K; j++) {
						if(cell[i][j]==null) continue;
						if(cell[i][j].status==2) continue;
						if(cell[i][j].life==life[i][j]&&cell[i][j].status==1) {
							for(int r=0; r<4; r++) {
								int ry = dy[r]+i;
								int rx = dx[r]+j;
								if(cell[ry][rx]==null) {
									q.add(new Cell(ry,rx,0,life[i][j]));
								}
							}
						}
						cell[i][j].life-=1;
						if(cell[i][j].life==0) {
							cell[i][j].status+=1;
							cell[i][j].life=life[i][j];
						}
					}
				}
				while(!q.isEmpty()) {
					Cell p = q.remove();
					if(cell[p.y][p.x]!=null) continue;
					cell[p.y][p.x]=p;
					life[p.y][p.x]=p.life;
				}
			}
			int count =0;
			for(int i=0; i<N+K; i++) {
				for(int j=0; j<M+K; j++) {
					if(cell[i][j]==null) continue;
					if(cell[i][j].status==2) continue;
					count++;
				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}