package baekjun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem1062 {

	static String[] alpha;
	static int[] p;
	static int ans;
	static HashSet<Integer> set;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(K>=5) {
			p = new int[K-5];	
		}

		ans = 0;
		alpha = new String[N];
		set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String s = sc.next();
			alpha[i] = s.substring(4);
			alpha[i] = alpha[i].substring(0, alpha[i].length()-4);
			for(char c : s.toCharArray()){
				if((int)c==97||(int)c==99||(int)c==105||(int)c==116||(int)c==110) continue;
				set.add((int)c);
			}
		}
		if(K<5) {
			System.out.println("0");
		}else if(set.size()<=K-5) {
			System.out.println(N);
		}else {
			dfs(96,K-5,0);
			System.out.println(ans);
		}



	}

	private static void dfs(int num, int end, int index) {
		// TODO Auto-generated method stub
		
		if(index==end) {
			int countSum=0;
			label2 :
				for(int i=0; i<alpha.length; i++) {
					int count=0;
					if(alpha[i].length()==0) {
						countSum++;
						continue label2;
					}
					label :
						for(int j=0; j<alpha[i].length(); j++) {
							for(int k=0; k<end; k++) {
								if((int)alpha[i].charAt(j)==p[k]||(int)alpha[i].charAt(j)==97||(int)alpha[i].charAt(j)==99||(int)alpha[i].charAt(j)==105||(int)alpha[i].charAt(j)==116||(int)alpha[i].charAt(j)==110) {
									count++;
									if(count==alpha[i].length()) {
										countSum++;
										continue label2;
									}
									continue label;
								}
							}
						}
				}
			if(countSum>ans) {
				ans=countSum;
			}
			return;
		}
		if(num>=122) {
			return;
		}
		if(num+1==97||num+1==99||num+1==105||num+1==110||num+1==116) {
			p[index]=num+2;
			dfs(num+2,end,index+1);		
		}else {
			p[index]=num+1;
			dfs(num+1,end,index+1);
		}
		p[index]=0;
		if(num+1==97||num+1==99||num+1==105||num+1==110||num+1==116) {
			p[index]=num+2;
			dfs(num+2,end,index);		
		}else {
			p[index]=num+1;
			dfs(num+1,end,index);
		}
	
	}

}
