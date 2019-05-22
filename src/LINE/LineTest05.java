//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Solution {
//    	static class Brown{
//		int time;
//		int dist;
//		Brown(int time, int dist){
//			this.time = time;
//			this.dist=dist;
//		}
//	}
//    public static void main(String[] args) {
//   Scanner sc = new Scanner(System.in);
//		int C = sc.nextInt();
//		int B = sc.nextInt();
//		int[] dist = new int[200001];
//		Queue<Brown> q = new LinkedList<>();
//		Arrays.fill(dist, -1);
//		dist[B]=0;
//		q.add(new Brown(0,B));
//		while(!q.isEmpty()) {
//			Brown p = q.remove();
//			
//			for(int next_dist : new int[]{p.dist-1,p.dist+1,p.dist*2}) {
//				if(next_dist<0||next_dist>200000) continue;
//				if(dist[next_dist]!=-1) continue;
//				dist[next_dist]=p.time+1;
//				q.add(new Brown(p.time+1,next_dist));
//			}
//		}
//		int d=0;
//		int t=0;
//		boolean pass = false;
//		for(int i= C; i<200001; i+=d) {
//			if(dist[i]==t) {
//				pass=true;
//				System.out.println(t);
//				break;
//			}
//			t++;
//			d++;
//		}
//		if(!pass) {
//			System.out.println("-1");
//		}
//    }
//}