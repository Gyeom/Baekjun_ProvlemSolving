package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class S16235 {
	static class Tree{
		int age;
		Tree(int age){
			this.age=age;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		Deque<Tree>[][] treeList =(Deque<Tree>[][]) new Deque[N][N];
		int[][] A = new int[N][N];
		int[][] energy = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(energy[i], 5);
		}
		for(int i=0; i<N; i++) {
			s= br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				A[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				treeList[i][j] = new ArrayDeque<>();
			}
		}
		for(int i=0; i<M; i++) {
			s= br.readLine().split(" ");
			int y = Integer.parseInt(s[0])-1;
			int x = Integer.parseInt(s[1])-1;
			int z = Integer.parseInt(s[2]); 
			treeList[y][x].addLast(new Tree(z));
		}
		for(int t=1; t<=K; t++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int renergy=0;
					Iterator<Tree> it = treeList[i][j].iterator();
					while(it.hasNext()) {
						Tree T = it.next();
						if(energy[i][j]<T.age) {
							renergy+=T.age/2;
							it.remove();
							continue;
						}
						energy[i][j]-=T.age;
						T.age++;
					}
					energy[i][j]+=renergy;
				}
			}
			int[] dy = {1,-1,0,0,1,1,-1,-1};
			int[] dx = {0,0,-1,1,1,-1,1,-1};
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(Tree T : treeList[i][j]) {
						if(T.age%5==0) {
							for(int k=0; k<8; k++) {
								int ry = dy[k]+i;
								int rx = dx[k]+j;
								if(ry<0||rx<0||ry>=N||rx>=N) continue;
								treeList[ry][rx].addFirst(new Tree(1));
							}
						}
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					energy[i][j]+=A[i][j];
				}
			}

		}

		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				count+=treeList[i][j].size();
			}
		}
		System.out.println(count);
	}
}