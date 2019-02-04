package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9663_v2 {
	static int[] v_i;
	static int[] v_j;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		v_i = new int[N];
		v_j = new int[N];
		
		dfs(0,0,N,0);
	}

	private static void dfs(int p_i, int p_j, int end, int index) {
		// TODO Auto-generated method stub
		


		if(index==end) {
			System.out.println(Arrays.toString(v_i)+","+Arrays.toString(v_j));
			return;
		}
		if(p_i==end||p_j==end) {
			return;
		}
		v_i[index]=p_i;	
		v_j[index]=p_j;
		dfs(p_i,p_j+1,end,index+1);
		v_i[index]=0;
		v_j[index]=0;
		dfs(p_i+1,p_j+1,end,index);
		
	}

}
