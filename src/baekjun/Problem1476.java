package baekjun;

import java.util.Scanner;

public class Problem1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		while(true) {
			count++;
			if(E==0) {
				E=15;
			}
			if(S==0) {
				S=28;
			}
			if(M==0) {
				M=19;
			}
			if(E==1&&S==1&M==1) {
				System.out.println(count);
				break;
			}
			E--; S--; M--; 
		}

	}

}




// 백준 정답
//import java.util.*;
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int E = sc.nextInt();
//        int S = sc.nextInt();
//        int M = sc.nextInt();
//        int e=1,s=1,m=1;
//        for (int i=1;; i++) {
//            if (e == E && s == S && m == M) {
//                System.out.println(i);
//                break;
//            }
//            e += 1;
//            s += 1;
//            m += 1;
//            if (e == 16) {
//                e = 1;
//            }
//            if (s == 29) {
//                s = 1;
//            }
//            if (m == 20) {
//                m = 1;
//            }
//        }
//    }
//}
