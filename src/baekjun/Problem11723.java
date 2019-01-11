package baekjun;

import java.util.Scanner;

public class Problem11723 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans=0;
		StringBuilder result = new StringBuilder();


		for(int i=0; i<N; i++) {
			String s = sc.next();
			int a=0;
			
				if(s.equals("add")) {
					a=sc.nextInt();
					ans |= ( 1 << a );
					continue;
				}else if(s.equals("check")) {
					a=sc.nextInt();
					if((ans & (1 << a))>0) {
						result.append("1\n");
						continue;
					}else {
						result.append("0\n");
						continue;
					}
				}else if(s.equals("remove")) {
					a=sc.nextInt();
					ans &= ~(1 << a);
					continue;
				}else if(s.equals("toggle")) {
					a=sc.nextInt();
					ans ^= (1 << a);
					continue;
				}else if(s.equals("empty")) {
					ans = 0;
					continue;
				}else if(s.equals("all")) {
					ans = (1 << N)-1;
					continue;
				}
			}
		System.out.println(result);
	}
		
		

	}

