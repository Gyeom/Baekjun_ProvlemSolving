package baekjun;

import java.util.Scanner;

public class Problem15658 {

	static int[] a;
	static int[] p;
	static int max=-1000000000;
	static int min= 1000000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N];
		p = new int[4];
		for(int i =0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			p[i]=sc.nextInt();
		}
		
		
		dfs(a[0],N,1,0);
		System.out.println(max);
		System.out.println(min);

	}
	public static void dfs(int sum, int end, int index, int e) {
		if(p[e]<0) {
			return;
		}
		if(index==end) {
			if(sum>max) {
				max=sum;
			}
			if(sum<min) {
				min=sum;
			}
			return;
		}

		
		
		p[0]--;
		dfs(sum+a[index],end,index+1,0);
		p[0]++;
		
		p[1]--;
		dfs(sum-a[index],end,index+1,1);
		p[1]++;
		
		p[2]--;
		dfs(sum*a[index],end,index+1,2);
		p[2]++;
		
		p[3]--;
		dfs(sum/a[index],end,index+1,3);
		p[3]++;

	}

//	public static void dfs(int sum, int end, int index) {
//		// TODO Auto-generated method stub
//		
//		dfs(a[index],end,index+1,0);
//
//	}

	

}
