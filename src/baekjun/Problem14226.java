package baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14226 {
	static class Emoticon{
		int n;
		boolean clip;
		int clipNum;
		int t;
		Emoticon(int n, boolean clip, int clipNum, int t){
			this.n=n;
			this.clip=clip;
			this.clipNum=clipNum;
			this.t=t;
		}
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Emoticon> q = new LinkedList<>();
		boolean[][] visited = new boolean [1001][1001];
		q.add(new Emoticon(1, false, 0,0));
		visited[N][0]=true;
		while(!q.isEmpty()) {
			Emoticon p = q.remove();
			if(p.n==N) {
				System.out.println(p.t);
				break;
			}
			for(int k=0; k<3; k++) {
				boolean rclip = p.clip;
				int rclipNum = p.clipNum;
				int rn = p.n;
				//저장
				if(k==0) {
					rclip = true;
					rclipNum = rn;
				//붙여넣기
				}else if(k==1) {
					if(!rclip) continue;
					rn += rclipNum;
				//삭제
				}else {
					rn--;
				}
				
				if(rn<1||rn>1000) continue;
				if(visited[rn][rclipNum]) continue;
				visited[rn][rclipNum]=true;
				q.add(new Emoticon(rn, rclip, rclipNum,p.t+1));
			}
		}
	}
}