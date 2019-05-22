package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Swea5653_R {
	static class Cell implements Comparable<Cell>{
		int y;
		int x;
		int initLife;
		int life;
		boolean isNonActive;
		boolean isActive;
		boolean isDie;
		Cell(int y, int x,int life){
			this.y=y;
			this.x=x;
			this.initLife=life;
			this.life=life;
			isNonActive=true;
			isActive=false;
			isDie=false;
		}

		@Override
		public String toString() {
			return "Cell [y=" + y + ", x=" + x + ", initLife=" + initLife + ", life=" + life + ", isNonActive="
					+ isNonActive + ", isActive=" + isActive + ", isDie=" + isDie + "]";
		}
		@Override
		public int compareTo(Cell target) {
			// TODO Auto-generated method stub
			return this.initLife<target.initLife? 1:-1;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static final int START_POINT = 151;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String[] s= br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int K = Integer.parseInt(s[2]);
			ArrayList<Cell>[][] map =(ArrayList<Cell>[][]) new ArrayList[351][351];
			ArrayList<Cell> cellList = new ArrayList<>();
			for(int i=0; i<351; i++) {
				for(int j=0; j<351; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			for(int i=START_POINT; i<START_POINT+N; i++) {
				s = br.readLine().split(" ");
				for(int j=START_POINT; j<START_POINT+M; j++) {
					int life = Integer.parseInt(s[j-START_POINT]);
					if(life==0) continue;
					Cell c = new Cell(i,j,life);
					map[i][j].add(c);
					cellList.add(c);
				}
			}


			for(int t=1; t<=K; t++) {
//			    System.out.println("---------------"+t+"------------------");
				Iterator<Cell> it  = cellList.iterator();
				PriorityQueue<Cell> temp = new PriorityQueue<>();
				while(it.hasNext()) {
					Cell c = it.next();
//					System.out.println(c.toString());
					if(c.isActive) {
						if(c.life==c.initLife) {
							for(int k=0; k<4; k++) {
								int ry = dy[k]+c.y;
								int rx = dx[k]+c.x;
								if(map[ry][rx].size()>0) continue;
								temp.add(new Cell(ry,rx,c.initLife));
							}
						}
						c.life--;
						if(c.life==0) {
							c.isActive=false;
							c.isDie=true;
							it.remove();
						}
					}
					if(c.isNonActive) {
						c.life--;
						if(c.life==0) {
							c.isNonActive=false;
							c.isActive=true;
							c.life=c.initLife;
						}
					}

				}
				while(!temp.isEmpty()) {
					Cell c = temp.remove();
					if(map[c.y][c.x].size()==0) {
						map[c.y][c.x].add(c);
						cellList.add(c);
					}

				}
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(cellList.size()));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}