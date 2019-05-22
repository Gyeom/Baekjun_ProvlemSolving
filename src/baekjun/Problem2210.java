package baekjun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2210 {

	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a = new int[5][5];
		Scanner sc= new Scanner(System.in);
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		visited = new int[6];
		map = new HashMap<>();
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				visited[0]=a[i][j];
				dfs(i,j,5,0);
			}
		}
		System.out.println(count);

	}
	static Map<String, Integer> map;
	static int[] visited;
	static int[][] a;
	static int count=0;
	private static void dfs(int y, int x, int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			if(map.containsKey(Arrays.toString(visited))) {
				return;
			}else {
				map.put(Arrays.toString(visited), 1);
				count++;
			}
			return;
		}
		for(int k=0; k<4; k++) {
			int ry = y+dy[k];
			int rx = x+dx[k];
			if(ry<0||rx<0||ry>=5||rx>=5) continue;
			visited[index+1]=a[ry][rx];
			dfs(ry,rx,end,index+1);
		}
	}
}
