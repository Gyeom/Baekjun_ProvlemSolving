package baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem16235 {

	static int[] dy = {1,-1,0,0,1,1,-1,-1};
	static int[] dx = {0,0,-1,1,-1,1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 땅의크기 -> N*N
		int M = sc.nextInt(); // M = 나무의 개수
		int K = sc.nextInt(); //K년 후에 살아남은 나무의 수를 구해야 한다.

		long[][] bitamin = new long[N+1][N+1]; // 현재 양분
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				bitamin[i][j]=5;
			}
		}                                                             
                                                                      
		int[][] bitamin_p = new int[N+1][N+1]; //년마다 증가하는 양분
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				bitamin_p[i][j]=sc.nextInt();
			}
		}

		ArrayList<Integer>[][] age = (ArrayList<Integer>[][]) new ArrayList[N+1][N+1]; //나무의 나이
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				age[i][j]= new ArrayList<Integer>();
			}
		}

		for(int i=1; i<=M; i++) {
			age[sc.nextInt()][sc.nextInt()].add(sc.nextInt());
		}



		for(int t=0; t<K; t++) {
			int[][] ageToBita = new int[N+1][N+1];
			//봄
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(age[i][j].isEmpty()) continue;
					Collections.sort(age[i][j]);
					for(int k=0; k<age[i][j].size(); k++) {
						int curAge = age[i][j].get(k);
						if(bitamin[i][j]>=curAge) {
							age[i][j].set(k, curAge+1);
							bitamin[i][j]-=curAge;
						}else {
							ageToBita[i][j]+=curAge/2;
							age[i][j].set(k, -1);
						}
					}
					Collections.sort(age[i][j]);
					while(age[i][j].size()>0&&age[i][j].get(0)==-1) {
						age[i][j].remove(0);
					}
				}
			}
			//여름
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					bitamin[i][j]+=ageToBita[i][j];
				}
			}

			//가을
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(age[i][j].isEmpty()) continue;
					for(int k=0; k<age[i][j].size(); k++) {

						if(age[i][j].get(k)%5==0) {
							for(int r=0; r<8; r++) {
								int ry = i+dy[r];
								int rx = j+dx[r];
								if(ry<1||rx<1||ry>N||rx>N) continue;
								age[ry][rx].add(1);
							}
						}
					}
				}
			}

			//겨울
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					bitamin[i][j]+=bitamin_p[i][j];
				}
			}
		}
		
		int count=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				count+=age[i][j].size();
			}
		}
		System.out.println(count);

	}
}
