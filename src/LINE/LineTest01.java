//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int answer =Integer.MAX_VALUE;
//        for(int h=1; h<=N; h++){
//            if(N%h==0){
//                int w = N/h;
//                if(Math.abs(w-h)<answer){
//                    answer=Math.abs(w-h);
//                }
//            }
//        }
//        System.out.println(answer);
//    }
//}