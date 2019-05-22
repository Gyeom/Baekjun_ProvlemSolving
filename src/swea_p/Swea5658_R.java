package swea_p;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Swea5658_R {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			StringBuilder sb= new StringBuilder();
			String s= sc.next();
			int M = N/4;
			sb.append(s);
			sb.append(s.substring(0,M));
			Set<String> set = new HashSet<>();
			for(int i=0; i<s.length(); i++) {
				set.add(sb.substring(i,i+M));
			}
			int[] numSet= new int[set.size()];
			int index=0;
			for(String temp : set) {
				for(int i=0; i<temp.length(); i++) {
					char c = temp.charAt(i);
					if(c>='A') {
						numSet[index]=numSet[index]*16+(c-'A'+10);	
					}else {
						numSet[index]=numSet[index]*16+(c-'0');
					}
				}
				index++;
			}
			Arrays.sort(numSet);
			System.out.println("#"+tc+" "+numSet[numSet.length-K]);
		}
	}
}