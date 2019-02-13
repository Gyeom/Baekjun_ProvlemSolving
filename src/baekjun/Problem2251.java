package baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2251 {

	static class ABC{
		int A;
		int B;
		int C;
		ABC(int A, int B, int C){
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Queue<ABC> q = new LinkedList<>();
		int A_size = sc.nextInt();
		int B_size = sc.nextInt();
		int C_size = sc.nextInt();
		boolean[][][] visited = new boolean[201][201][201];
		q.add(new ABC(0,0,C_size));
		visited[0][0][C_size]= true;
		ArrayList<Integer> al = new ArrayList<>();
		al.add(C_size);
		while(!q.isEmpty()) {
			ABC p  = q.remove();

			int index=0;
			for(int r :new int[] {Math.min(p.C, A_size-p.A),Math.min(p.C, B_size-p.B),Math.min(p.A, C_size-p.C),Math.min(p.A, B_size-p.B),Math.min(p.B, C_size-p.C),Math.min(p.B, A_size-p.A)}) {
				index++;
				int ra = p.A;
				int rb = p.B;
				int rc = p.C;

				if(index ==1 ) {
					ra+=r;
					rc-=r;
				}else if(index ==2) {
					rb+=r;
					rc-=r;
				}else if(index ==3) {
					rc+=r;
					ra-=r;
				}else if(index ==4) {
					rb+=r;
					ra-=r;
				}else if(index ==6) {
					ra+=r;
					rb-=r;
				}else if(index==5) {
					rc+=r;
					rb-=r;
				}

				if(ra<0||rb<0||rc<0||ra>A_size||rb>B_size||rc>C_size) continue;
				if(visited[ra][rb][rc]) continue;

				visited[ra][rb][rc]=true;
				if(ra==0) al.add(rc);
				q.add(new ABC(ra,rb,rc));
			}
		}
		Collections.sort(al);
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
	}
}