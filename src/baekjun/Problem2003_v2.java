package baekjun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Problem2003_v2 {
	static int M;
	static int[] a;
	static int count=0;
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		a= new int[N];
		
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}
		dfs(N,0,0);
		System.out.println(count);
	}


	private static void dfs(int end, int index, int x) {
		// TODO Auto-generated method stub
		
		if(index == end) {
			int sum=0;
			for(int i=0; i<index; i++) {
				if(((1<<i)&x)>0) sum+=a[i];
			}
			if(sum==M) {
				count++;
			}
			return;
		}
		
		
		if(!(al.contains(0)&&al.contains(1)&&(al.lastIndexOf(0)==(al.size()-1)))) {
			
			x|=(1<<index);
			al.add(1);
			dfs(end,index+1,x);
			al.remove(al.size()-1);
			x&=~(1<<index);
		}	

		
		al.add(0);
		dfs(end,index+1,x);
		al.remove(al.size()-1);
	}

}
