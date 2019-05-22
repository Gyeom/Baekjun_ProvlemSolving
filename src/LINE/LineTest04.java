//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] h = new int[N];
//        for(int i=0; i<N; i++){
//            h[i]=sc.nextInt();
//        }
//        int answer =0;
//        outloof :
//        for(int i=0; i<N-1; i++){
//            for(int j=i+1; j<N; j++){
//                
//                if(h[j]>=h[i]){
//                    
//                    for(int k=i+1; k<j; k++){
//                        if(h[k]>=Math.min(h[i],h[j])&&h[k]<=Math.max(h[i],h[j])){
//                            continue outloof;
//                        }
//                    }
//                    if(Math.abs(j-i)>answer){
//                        answer=Math.abs(j-i);
//                    }
//                }
//                
//            }
//        }
//         outloof2 :
//         for(int i=N-1; i>=1; i--){
//            for(int j=i-1; j>=0; j--){
//                
//                if(h[j]>=h[i]){
//                    
//                    for(int k=i-1; k>j; k--){
//                        if(h[k]>=Math.min(h[i],h[j])&&h[k]<=Math.max(h[i],h[j])){
//                            continue outloof2;
//                        }
//                    }
//                    if(Math.abs(j-i)>answer){
//                        answer=Math.abs(j-i);
//                    }
//                }
//                
//            }
//        }
//        System.out.println(answer);
//    }
//}