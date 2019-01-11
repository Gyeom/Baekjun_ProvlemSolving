	package baekjun;
	
	import java.util.Scanner;
	
	public class Problem1182 {
	static int S;
	static int count=0;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			S = sc.nextInt();
			int[] a = new int[N];
			for(int i=0; i<N; i++) {
				a[i]=sc.nextInt();
			}
			dfs(0,N,0,a);
			if(S==0) {
				count--;
			}
			System.out.println(count);
		}
		public static void dfs(int begin, int end, int index, int[] a) {
			// TODO Auto-generated method stub
		
			if(index==end) {
				if(begin==S) {
					count++;
				}
				return;
			}
		
			dfs(begin+a[index],end,index+1,a);
			dfs(begin,end,index+1,a);
			
			
		}
	
	}
