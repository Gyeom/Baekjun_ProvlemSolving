package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Problem16235_R  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		int[][] energy = new int[N][N]; //양분
		for(int i=0; i<N; i++) {
			Arrays.fill(energy[i], 5); //초기 양분 5씩
		}
		int[][] A = new int[N][N]; //추가 양분
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j]=Integer.parseInt(token.nextToken());
			}
		}

		Deque<Integer>[][] treeList =(Deque<Integer>[][]) new ArrayDeque[N][N];
		Deque<Integer>[][] deadList =(Deque<Integer>[][]) new ArrayDeque[N][N];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				treeList[i][j]=new ArrayDeque<>();
				deadList[i][j]=new ArrayDeque<>();
			}
		}

		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(token.nextToken())-1;
			int x = Integer.parseInt(token.nextToken())-1;
			int z = Integer.parseInt(token.nextToken()); //나이
			treeList[y][x].add(z);
		}

		for(int k=0; k<K; k++) {
			//봄
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int size = treeList[i][j].size();
					while(size-->0) {
						int T = treeList[i][j].removeFirst();
						if(energy[i][j]>=T) {
							energy[i][j]-=T;
							T++;
							treeList[i][j].addLast(T);
						}else {
							deadList[i][j].addLast(T);
						}
					}
				}
			}
			//여름
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					while(!deadList[i][j].isEmpty()){
						int t = deadList[i][j].removeFirst();
						energy[i][j]+=t/2;
					}
				}
			}
			//가을
			int[] dy = {1,-1,0,0,1,-1,1,-1};
			int[] dx = {0,0,-1,1,1,-1,-1,1};
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int t : treeList[i][j]) {
						if(t%5==0) {
							for(int r=0; r<8; r++) {
								int ry = dy[r]+i;
								int rx = dx[r]+j;
								if(ry<0||rx<0||ry>=N||rx>=N) continue;
								treeList[ry][rx].addFirst(1);
							}
						}
					}
				}
			}
			//겨울
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					energy[i][j]+=A[i][j];
				}
			}
		}
		//K년 후,
		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				count+=treeList[i][j].size();
			}
		}
		System.out.println(count);
	}
}