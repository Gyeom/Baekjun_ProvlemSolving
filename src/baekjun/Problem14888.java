package baekjun;

import java.util.Scanner;

public class Problem14888 {

	static int[] num;
	static int[] count;
	static int[] way;
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		int N = sc.nextInt();
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		count = new int[4];
		for(int i=0; i<4; i++) {
			count[i]=sc.nextInt();
		}
		way = new int[4];
		dfs(num[0],N-1,0);
		System.out.println(max);
		System.out.println(min);
	}
	static int max;
	static int min;
	private static void dfs(int sum, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(sum<min) min=sum;
			if(sum>max) max=sum;
			return;
		}

		for(int i=0; i<4; i++) {
			if(way[i]>=count[i]) continue;
			way[i]++;
			int next_sum=0;
			switch (i) {
			case 0:
				next_sum=sum+num[index+1];
				break;
			case 1:
				next_sum=sum-num[index+1];
				break;
			case 2:
				next_sum=sum*num[index+1];
				break;
			case 3:
				next_sum=sum/num[index+1];
				break;
			}
			dfs(next_sum,end,index+1);
			way[i]--;
		}
	}
}