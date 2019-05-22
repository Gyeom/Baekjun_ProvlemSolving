package swea_p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Swea2382 {
	static class Monster{
		int no;
		int y;
		int x;
		int num;
		int direction;
		Monster(int no, int y, int x, int num, int direction){
			this.no=no;
			this.y=y;
			this.x=x;
			this.num=num;
			this.direction=direction;
		}
	}
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static ArrayList<Monster>[][] map;
	static Monster[] Monster_list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for(int tc=1; tc<=TC; tc++) {
			token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken()); //가로 세로
			int M = Integer.parseInt(token.nextToken()); // M시간동안 격리
			int K = Integer.parseInt(token.nextToken()); //군집개수
			map =(ArrayList<Monster>[][]) new ArrayList[N][N];
			Monster_list = new Monster[K];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=new ArrayList<>();
				}
			}
			for(int i=0;  i<K; i++) {
				token = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(token.nextToken());
				int x = Integer.parseInt(token.nextToken());
				int num = Integer.parseInt(token.nextToken());
				int direction = Integer.parseInt(token.nextToken());
				Monster mon = new Monster(i,y,x,num,direction);
				map[y][x].add(mon);
				Monster_list[i]= mon;
			}

			for(int t=1; t<=M; t++) {
				for(int i=0; i<K; i++) {
					if(Monster_list[i].num==0) continue;
					Monster mon = Monster_list[i];
					int ry = dy[mon.direction]+mon.y;
					int rx = dx[mon.direction]+mon.x;
					boolean delete = false;
					if(ry==0||rx==0||ry==N-1||rx==N-1) {
						if(mon.direction%2==0) {
							mon.direction-=1;
						}else {
							mon.direction+=1;
						}
						mon.num/=2;
						if(mon.num==0) {
							delete = true;
						}
					}
					deleteMon_one(mon);
					if(delete==false) {
						mon.y=ry;
						mon.x=rx;
						map[ry][rx].add(mon);
					}
				}
				for(int p=0; p<K; p++) {
					if(Monster_list[p].num==0) continue;
					Monster m  = Monster_list[p];
					int i= m.y;
					int j= m.x;
					if(map[i][j].size()<=1) continue;
					int Max=0;
					int Max_no=-1;
					int monsters_num=0;
					for(int k=0; k<map[i][j].size(); k++) {
						Monster mon= map[i][j].get(k);
						monsters_num+=mon.num;
						if(mon.num>Max) {
							Max=mon.num;
							Max_no=mon.no;
						}
					}
					deleteMon_others(i,j,Max_no);
					map[i][j].get(0).num=monsters_num;
					map[i][j].get(0).direction=Monster_list[Max_no].direction;
				}
			}
			int ans = 0;
			for(int i=0; i<K; i++) {
				int num= Monster_list[i].num;
				if(num==0) continue;
				ans+=num;
			}
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(ans));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void deleteMon_others(int i, int j, int Max_no) {
		// TODO Auto-generated method stub
		Iterator<Monster> it= map[i][j].iterator();
		while(it.hasNext()) {
			Monster m = (Monster) it.next();
			if(m.no!=Max_no) {
				Monster_list[m.no].num=0;
				it.remove();
			}
		}
	}

	private static void deleteMon_one(Monster mon) {
		// TODO Auto-generated method stub
		Iterator<Monster> it= map[mon.y][mon.x].iterator();
		while(it.hasNext()) {
			Monster m = (Monster) it.next();
			if(m.no==mon.no) {
				it.remove();
				break;
			}
		}
	}
}