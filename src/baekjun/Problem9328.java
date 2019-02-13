package baekjun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem9328 {

	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-->0) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] a = new char[H+2][W+2];
			for(int i=1; i<H+1; i++) {
				String s = sc.next();
				for(int j=1; j<W+1; j++) {
					a[i][j]=s.charAt(j-1);
				}
			}
			for(int i=0; i<H+2; i++) {
				for(int j=0; j<W+2; j++) {
					if(!((i==0)||(j==0)||(i==H+1)||(j==W+1))) continue;
					a[i][j] = '.';
				}
			}

			Set<Character> key = new HashSet<>();
			String s = sc.next();
			for(int i=0; i<s.length(); i++) {
				key.add(s.charAt(i));
			}
			Deque<Pair> q = new ArrayDeque<>();
			boolean[][] visited;
			int count=0;
			for(int i=0; i<2; i++) {
				visited = new boolean[H+2][W+2];
				q.addFirst(new Pair(0,0));
				visited[0][0]=true;
				Set<Pair> big = new HashSet<>();
				while(!q.isEmpty()) {
					Pair p = q.remove();
					for(int k=0; k<4; k++) {
						int ry = dy[k]+p.y;
						int rx = dx[k]+p.x;
						if((ry<0)||(rx<0)||(ry>H+1)||(rx>W+1)) continue;
						if(visited[ry][rx]) continue;
						if(a[ry][rx]=='*') continue;
						if(((a[ry][rx]-'A')>-1)&&((a[ry][rx]-'A')<26)) {
							if(!key.contains((char)(a[ry][rx]+32))) {
								big.add(new Pair(ry,rx));
								continue;
							}
						}
						visited[ry][rx]=true;
						if(a[ry][rx]=='.') {
							q.addFirst(new Pair(ry,rx));
						}else {
							if((i==0)&&(((a[ry][rx]-'a')>-1)&&((a[ry][rx]-'a')<26))) {
								if(key.add(a[ry][rx])){
									for(Pair temp : big) {
										if(a[temp.y][temp.x]!=(char)(a[ry][rx]-32))continue;
										if(visited[temp.y][temp.x]) continue;
										visited[temp.y][temp.x] =true;
										q.add(temp);
									}
								}

							}
							if((i==1)&&(a[ry][rx]=='$')) {
								count++;
							}
							q.addLast(new Pair(ry,rx));
						}

					}
				}
				q.clear();
			}
			//			System.out.println(key.toString());
			System.out.println(count);
		}
	}

}
