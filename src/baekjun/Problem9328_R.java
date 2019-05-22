package baekjun;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Problem9328_R {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int h, w;
	static char[][] map;
	static Set<Character> key;
	static Set<Pair> door;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		//		System.out.println(((int)'A')); //65
		//		System.out.println(((int)'Z')); //90
		//		System.out.println(((int)'a')); //97
		//		System.out.println((int)('z')); // 122		
		int TC = sc.nextInt();
		for(int tc = 1; tc<=TC; tc++) {
			count=0;
			h = sc.nextInt();
			w = sc.nextInt();
			key = new HashSet<>();
			door = new HashSet<>();
			map = new char[h+2][w+2];
			for(int i=1; i<h+1; i++) {
				String s = sc.next();
				for(int j=1; j<w+1; j++) {
					map[i][j]=s.charAt(j-1);
				}
			}
			String s = sc.next();
			for(int i=0; i<s.length(); i++) {
				key.add(s.charAt(i));
			}
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					if(!(i==0||i==h+1||j==0||j==w+1)) continue;
					map[i][j]='.';
				}
			}
			bfs(new Pair(0,0));
			System.out.println(count);
		}
	}
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	private static void bfs(Pair start) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[h+2][w+2];
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x]=true;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			outloof:
				for(int k=0; k<4; k++) {
					int ry = dy[k]+p.y;
					int rx = dx[k]+p.x;
					if(ry<0||rx<0||ry>h+1||rx>w+1) continue;
					if(visited[ry][rx]) continue;
					if(map[ry][rx]=='*') continue;
					if((int)map[ry][rx]>=65&&(int)map[ry][rx]<=90) {
						boolean pass = false;
						for(char c : key) {
							if((int)map[ry][rx]==c-32) {
								pass=true;
								break;
							}
						}
						if(!pass) {
							door.add(new Pair(ry,rx));
							continue outloof;
						}
					}else if((int)map[ry][rx]>=97&&(int)map[ry][rx]<=122) {
						key.add(map[ry][rx]);
						for(Pair c : door) {
							if(map[c.y][c.x]==map[ry][rx]-32) {
								if(visited[c.y][c.x]) continue;
								visited[c.y][c.x]=true;
								q.add(new Pair(c.y,c.x));
							}
						}
					}else if(map[ry][rx]=='$') {
						count++;
					}
					visited[ry][rx]=true;
					q.add(new Pair(ry,rx));
				}
		}
	}
}
