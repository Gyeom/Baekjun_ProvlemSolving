package TEST;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class TEST {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//입력
//		Scanner sc = new Scanner(System.in);
		//컬렉션
//		HashMap<String, Integer> map = new HashMap<>();
//		Set<Integer> set = new HashSet<>();
//		ArrayList<Integer> al = new ArrayList<>();
//		Queue<Integer> q = new LinkedList<>();
//		Deque<Integer> dq = new ArrayDeque<>();
//		Queue<Pair> q = new LinkedList<>();
//		int[] dy = {-1,-1};
//		int[] dx = {-1,1};
//		
//		String[] s = {"..X...","......","....X.",".X....","..X.X.","...O.."};
//		char[][] a = new char[s.length][s.length];
//		for(int i=0; i<s.length; i++) {
//			for(int j=0; j<s[i].length();j++) {
//				a[i][j]=s[i].charAt(j);
//				if(a[i][j]=='O') {
//					q.add(new Pair(i,j));
//				}
//			}
//		}
//		
//		int count=0;
//		while(!q.isEmpty()) {
//			Pair p = q.remove();
//			for(int k=0; k<2; k++) {
//				int ry = dy[k]+p.y;
//				int rx = dx[k]+p.x;
//				int dry = dy[k]*2+p.y;
//				int drx = dx[k]*2+p.x;
//				if(ry<0||rx<0||ry>=s.length||rx>=s.length||dry<0||drx<0||dry>=s.length||drx>=s.length) continue;
//				if(a[ry][rx]!='X') continue;
//				if(a[dry][drx]!='.') continue;
//				count++;
//				q.add(new Pair(dry,drx));
//				
//			}
//		}
//		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		
//		int[] A= {5,4,0,3,1,6,2};
//		
//		ArrayList<Integer>[] a = new ArrayList[A.length];
//		for(int i=0; i<A.length; i++) {
//			a[i]=new ArrayList<Integer>();
//			a[i].add(A[i]);
//		}
//		System.out.println(Arrays.toString(a));
//		int ans=0;
//		boolean[] visited = new boolean[A.length];
//		for(int i=0; i<A.length; i++) {
//			if(visited[i]) continue;
//			int now =i;
//			int count =0;
//			
//			while(!a[now].isEmpty()) {
//				if(visited[now]) break;
//				visited[now]=true;
//				now=(int)a[now].get(0);
//				count++;
//				if(count>ans) {
//					ans=count;
//				}
//			}
//		}
//		System.out.println(ans);
//		
//		boolean[] visited = new boolean[A.length];
//		for(int i=0; i<A.length; i++) {
//			if(visited[i]) continue;
//			visited[i]=true;
//			int now = i;
//			int count =0;
//			while(!a[now].isEmpty()) {
//				now = (int) a[i].get(0);
//				visited[now]=true;
//				count++;
//				if(count>ans) {
//					ans=count;
//				}
//				System.out.println(now);
//				if(now==i) break;
//				
//			}
//			
//		}
//		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int[] rank= {3,4,3,0,2,2,3,0,0};
		
		Arrays.sort(rank);
		int temp=0;
		int ans=0;
		int count=0;
		for(int i=0; i<rank.length; i++) {
			if(rank[i]==temp) {
				count++;
				continue;
			}else if(rank[i]==temp+1){
				ans+=count;
				temp=rank[i];
				count=1;
			}else{
				temp=rank[i];
				count=1;
			}
		}
		System.out.println(ans);
		
	}

}
