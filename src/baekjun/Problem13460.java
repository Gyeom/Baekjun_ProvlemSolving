//package baekjun;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Problem13460 {
//	static char[][] a;
//	static int[] dy = {1,-1,0,0};
//	static int[] dx = {0,0,-1,1};
//	static int o_i;
//	static int o_j;
//	static class Blue{
//		int y;
//		int x;
//		Blue(int y, int x){
//			this.y = y;
//			this.x = x;
//		}
//	}
//	static class Red{
//		int y;
//		int x;
//		Red(int y, int x){
//			this.y = y;
//			this.x = x;
//		}
//	}x
//	public static void main(String args[]) {
//		Scanner sc= new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//
//		Queue<Blue> bq = new LinkedList<>();
//		Queue<Red> rq = new LinkedList<>();
//		a = new char[N+1][M+1];
//		for(int i=1; i<=N; i++){
//			String s = sc.next();
//			for(int j=1; j<=M; j++) {
//				a[i][j] = s.charAt(j-1);
//				if(a[i][j]=='B') {
//					bq.add(new Blue(i,j));
//				}else if(a[i][j]=='R'){
//					rq.add(new Red(i,j));
//				}else if(a[i][j]=='O') {
//					o_i=i;
//					o_j=j;
//				}
//			}
//		}
//		
//		
//		
//		
//	}
//}