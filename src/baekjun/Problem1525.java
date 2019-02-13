package baekjun;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem1525 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v=0;
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				int num = sc.nextInt();
				if(num==0) {
					v+=9*Math.pow(10, (i-1)*3+j-1);
				}else {
					v+=num*Math.pow(10, (i-1)*3+j-1);
				}
			
			}
		}
		
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<>();
		String sv = Integer.toString(v);
		q.add(sv);
		dist.put(sv, 0);
		
		boolean success = false;
		while(!q.isEmpty()) {
			String p = q.remove();
//			String s = String.valueOf(p);
			int index = p.indexOf('9');
			int y = ((9-index)+2)/3;
			int x = ((9-index)-1)%3+1;
			int value = dist.get(p);
			if(p.equals("987654321")) {
				System.out.println(value);
				success=true;
				break;
			}

			for(int i=0; i<4; i++) {
				int ry = dy[i]+y;
				int rx = dx[i]+x;
				if(ry<1||rx<1||ry>3||rx>3) continue;
				StringBuilder sb = new StringBuilder(p);
				
				int rindex = 9-((ry-1)*3+rx);
				sb.setCharAt(index, sb.charAt(rindex));
				sb.setCharAt(rindex, '9');
				String key =sb.toString(); 
				if(dist.containsKey(key)) continue;
				dist.put(key, value+1);
				q.add(key);
			}
		}
		if(!success) {
			System.out.println("-1");
		}
		
	}

}
