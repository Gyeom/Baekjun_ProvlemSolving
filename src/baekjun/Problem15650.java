package baekjun;
import java.util.Scanner;

public class Problem15650 {

	static int[] a;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=i+1;
		}
		dfs("",M,0);
		
		
	}

	public static void dfs(String begin, int end, int index  ) {
		// TODO Auto-generated method stub
		
		if(begin.length()==end) {
			for(int i=0; i<begin.length(); i++) {
				System.out.print(begin.charAt(i)+" ");
			}
			System.out.println();
			return;
		}
		if(index==N) return;
	
		
			dfs(begin+a[index],end,index+1);
			dfs(begin,end,index+1);
		}
				
	}