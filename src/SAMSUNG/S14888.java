package SAMSUNG;

import java.util.Scanner;

public class S14888 {
	static int[] num;
	static int[] way;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int[N];
		way = new int[4];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			way[i]=sc.nextInt();
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		dfs(num[0],N,0);
		System.out.println(max);
		System.out.println(min);
	}
	static int min;
	static int max;
	private static void dfs(int sum, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end-1) {
			if(sum<min) {
				min=sum;
			}
			if(sum>max) {
				max=sum;
			}
		}
		for(int i=0; i<4; i++) {
			if(way[i]==0) continue;
				way[i]--;
				switch (i) {
				case 0:
					dfs(sum+num[index+1],end,index+1);
					break;
				case 1:
					dfs(sum-num[index+1],end,index+1);
					break;
				case 2:
					dfs(sum*num[index+1],end,index+1);
					break;
				case 3:
					dfs(sum/num[index+1],end,index+1);
					break;
				}
				way[i]++;	
		}
	}
}