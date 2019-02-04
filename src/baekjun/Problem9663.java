package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9663 {
	static boolean[][] visited;
	static int count=0;
	static int[] v_i;
	static int[] v_j;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		visited = new boolean[N+1][N+1];
		v_i = new int[N];
		v_j = new int[N];


		dfs(N,0);
		System.out.println(count);
	}

	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			System.out.println(Arrays.toString(v_i)+","+Arrays.toString(v_j));
			count++;
			return;
		}

		for(int i=1; i<=end; i++) {
			label :
				for(int j=1; j<=end; j++) {
					if(visited[i][j]) continue;


					for(int k=0; k<index; k++) {
						if(i==v_i[k]) continue label;
						if(j==v_j[k]) continue label;
						if(v_i[k]>i&&v_j[k]>j) {
							if((v_i[k]-i)/(v_j[k]-j)==1) {
								continue label;
							}
						}else if(v_i[k]<i&&v_j[k]<j) {
							if((v_i[k]-i)/(v_j[k]-j)==1) {
								continue label;
							}
						}else if(v_i[k]>i&&v_j[k]<j) {
							if((v_i[k]-i)/(-1*(v_j[k]-j))==1){
								continue label;
							}
						}else if(v_i[k]<i&&v_j[k]>j) {
							if((v_i[k]-i)/(-1*(v_j[k]-j))==1){
								continue label;
							}
						}
					}
					v_i[index]=i;
					v_j[index]=j;
					visited[i][j]=true;
					dfs(end,index+1);
					visited[i][j]=false;
					v_i[index]=0;
					v_j[index]=0;
				}
		}
	}

}
