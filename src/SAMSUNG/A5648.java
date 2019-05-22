package SAMSUNG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class A5648 {
	static class Atom{
		int y;
		int x;
		int d;
		int k;
		Atom(int y, int x, int d, int k){
			this.y=y;
			this.x=x;
			this.d=d;
			this.k=k;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map = new int[4001][4001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC  = sc.nextInt();
		long time = System.nanoTime();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			ArrayList<Atom> atomList = new ArrayList<>();
			for(int i=0; i<N; i++) {
				int x = (sc.nextInt()+1000)*2;
				int y = (sc.nextInt()+1000)*2;
				int d = sc.nextInt();
				int K = sc.nextInt();
				Atom a = new Atom(y,x,d,K);
				atomList.add(a);
				map[y][x] = a.k;
			}
			int ans =0;
			for(int t=1; t<=Integer.MAX_VALUE; t++) {
				if(atomList.size()==0) break;
				Iterator<Atom> its = atomList.iterator();
				while(its.hasNext()) {
					Atom a = its.next();
					int ry = a.y+dy[a.d];
					int rx = a.x+dx[a.d];
					map[a.y][a.x]-=a.k;
					if(ry<0||rx<0||ry>4000||rx>4000) {
						its.remove();
						continue;
					}
					map[ry][rx]+=a.k;
					a.y=ry;
					a.x=rx;
				}
				Iterator<Atom> it = atomList.iterator();
				ArrayList<Atom> removeList = new ArrayList<>();
				while(it.hasNext()) {
					Atom a = it.next();
					if(map[a.y][a.x]!= a.k) {
						removeList.add(a);
						it.remove();
					}
				}
				for(Atom a : removeList) {
					map[a.y][a.x]-=a.k;
					ans+=a.k;
				}
				removeList.clear();
			}
			System.out.println("#"+tc+" "+ans);
		}
		System.out.println((float)(System.nanoTime()-time)/1000000000);
	}
}