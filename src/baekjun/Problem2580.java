package baekjun;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2580 {
	static int[][] a;
	static ArrayList<Integer> p_y;
	static ArrayList<Integer> p_x;
	static boolean[][] visited;
	static boolean quit;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		quit = false;
		a = new int[10][10];
		p_y = new ArrayList<>();
		p_x = new ArrayList<>();
		visited = new boolean[10][10];
		int count=0;
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				a[i][j]=sc.nextInt();
				if(a[i][j]==0) {
					count++;
					p_y.add(i);
					p_x.add(j);
				}
			}
		}

		dfs(count,0);
	}
	private static void dfs(int end, int index) {
		// TODO Auto-generated method stub
		if(index==end) {
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			
			quit=true;
			
			return;
		}
		int py = p_y.get(index);
		int px = p_x.get(index);
		
		label:
			for(int i=1; i<=9; i++) {
				
				for(int j=1; j<=9; j++) {
					if(a[py][j]==i) continue label;
					if(a[j][px]==i) continue label;
				}
				
				if(py<=3&&px<=3) {
					for(int k=1; k<=3; k++) {
						for(int l=1; l<=3; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=3&&px<=6) {
					for(int k=1; k<=3; k++) {
						for(int l=4; l<=6; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=3&&px<=9) {
					for(int k=1; k<=3; k++) {
						for(int l=7; l<=9; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=6&&px<=3) {
					for(int k=4; k<=6; k++) {
						for(int l=1; l<=3; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=6&&px<=6) {
					for(int k=4; k<=6; k++) {
						for(int l=4; l<=6; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=6&&px<=9) {
					for(int k=4; k<=6; k++) {
						for(int l=7; l<=9; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=9&&px<=3) {
					for(int k=7; k<=9; k++) {
						for(int l=1; l<=3; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=9&&px<=6) {
					for(int k=7; k<=9; k++) {
						for(int l=4; l<=6; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}else if(py<=9&&px<=9) {
					for(int k=7; k<=9; k++) {
						for(int l=7; l<=9; l++) {
							if(a[k][l]==i) continue label;
						}
					}
				}
				a[p_y.get(index)][p_x.get(index)]=i;
				dfs(end, index+1);
				if(quit) {
					return;
				}
				a[p_y.get(index)][p_x.get(index)]=0;
			}

	}
}


