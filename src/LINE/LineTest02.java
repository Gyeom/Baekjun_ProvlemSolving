//import java.util.Scanner;
//import java.util.ArrayList;
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//   	String s = sc.next();
//		ArrayList<String> alpha = new ArrayList<>();
//		ArrayList<String> number = new ArrayList<>();
//        int count=0;
//		for(int i=0; i<s.length(); i++) {
//			char n = s.charAt(i);
//			if(n-'0'<10) {
//				number.add(String.valueOf(n));
//			}else {
//                if(n<'a'){
//                    count++;
//                }
//				alpha.add(String.valueOf(n));
//			}
//		}
//        if(count!=number.size()){
//            System.out.println("error");
//        }else{
//            String[] answer = new String[number.size()];
//		for(int i=0,index=0; i<number.size(); i++) {
//			do {
//				if(answer[i]==null) {
//					answer[i]=alpha.get(index++);
//				}else{
//					answer[i]+=alpha.get(index++);
//				}
//			}while(index<number.size()&&alpha.get(index).charAt(0)>'Z');
//		
//		}
//		for(int i=0; i<number.size(); i++) {
//			String num = number.get(i);
//			if(!num.equals("1")) {
//				answer[i]+=num;
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<number.size(); i++) {
//			sb.append(answer[i]);
//		}
//		System.out.println(sb);
//        }
//		
//    }
//}