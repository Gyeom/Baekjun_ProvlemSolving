package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Swea2382_R {
	static class Monster{
		int no;
		int y;
		int x;
		int num;
		int d;
		boolean die;
		Monster(int no,int y, int x, int num, int d,boolean die){
			this.no=no;
			this.y=y;
			this.x=x;
			this.num=num;
			this.d=d;
			this.die=die;
		}
		@Override
		public String toString() {
			return "Monster [no=" + no + ", y=" + y + ", x=" + x + ", num=" + num + ", d=" + d + ", die=" + die + "]";
		}
	}
	static ArrayList<Monster>[][] map;
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]); //맵 크기 : N*N
			int M = Integer.parseInt(s[1]); //총 이동시간
			int K = Integer.parseInt(s[2]); //군집 수
			map = (ArrayList<Monster>[][]) new ArrayList[N][N]; 
			ArrayList<Monster> monList= new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			for(int i=0; i<K; i++) {
				s = br.readLine().split(" ");
				int y = Integer.parseInt(s[0]);
				int x = Integer.parseInt(s[1]);
				int n = Integer.parseInt(s[2]);
				int d = Integer.parseInt(s[3]);
				Monster m = new Monster(i,y,x,n,d,false);
				monList.add(m);
				map[y][x].add(m);
			}
			for(int t=1; t<=M; t++) {
				for(Monster m : monList) {
					if(m.die) continue;
					int ry = m.y+dy[m.d];
					int rx = m.x+dx[m.d];
					if(ry<=0||rx<=0||ry>=N-1||rx>=N-1) {
						if(m.d==2||m.d==4) {
							m.d--;
						}else {
							m.d++;
						}
						m.num/=2;
						if(m.num==0) {
							m.die=true;
						}
						if(!m.die) {
							map[ry][rx].add(m);
						}
					}else {
						map[ry][rx].add(m);
					}
					removeOne(m.no,m.y,m.x);
					m.y=ry;
					m.x=rx;
				}
				for(Monster m : monList) {
					if(m.die) continue;
					if(map[m.y][m.x].size()<2) continue;
					int max_no=-1;
					int max_num=-1;
					int sum=0;
					for(Monster temp : map[m.y][m.x]) {
						sum+=temp.num;
						if(temp.num>max_num) {
							max_num=temp.num;
							max_no=temp.no;
						}
					}
					removeOther(max_no,m.y,m.x,sum);
				}
			}
			int ans =0;
			for(Monster m : monList) {
				if(m.die) continue;
				ans+=m.num;
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	private static void removeOther(int max_no, int y, int x,int sum) {
		// TODO Auto-generated method stub
		Iterator<Monster> it = map[y][x].iterator();
		while(it.hasNext()) {
			Monster m = it.next();
			if(m.no==max_no) {
				m.num=sum;
				continue;
			}
			m.die=true;
			it.remove();
		}
	}
	private static void removeOne(int no, int y, int x) {
		// TODO Auto-generated method stub
		Iterator<Monster> it = map[y][x].iterator();
		while(it.hasNext()) {
			Monster m = it.next();
			if(m.no!=no) continue;
			it.remove();
		}
	}
}