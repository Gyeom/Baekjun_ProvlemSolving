package swea;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Test {


	public static void main(String args[])  {


		//입력
		Scanner sc = new Scanner(System.in);
		//컬렉션
		HashMap<String, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> al = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		Deque<Integer> dq = new ArrayDeque<>();

		//	String s = "010XXXXXXXX";
		//	if(s.length()==13&&s.charAt(3)=='-'&&s.charAt(8)=='-'&&s.substring(0, 3).equals("010")) {
		//		System.out.println(1);
		//	}
		//	if(s.length()==11&&s.substring(0,3).equals("010")) {
		//		System.out.println(2);
		//	}
		//	if(s.length()==16&&s.charAt(11)=='-'&&s.substring(0, 7).equals("+82-10-")) {
		//		System.out.println(3);
		//	}

		//	String[] moves = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
		//	String s = Arrays.toString(moves).replaceAll("[\\p{S}\\p{P}]+", "").replaceAll(" ", "").trim();
		//	int answer=0;
		//	System.out.println(s);
		//	 do{
		//         if(s.substring(0,4).equals("URDL")||s.substring(0,4).equals("ULDR")
		//            ||s.substring(0,4).equals("DRUL")||s.substring(0,4).equals("DLUR")
		//            ||s.substring(0,4).equals("RULD")||s.substring(0,4).equals("RDLU")
		//            ||s.substring(0,4).equals("LURD")||s.substring(0,4).equals("LDRU")){
		//             answer++;
		//             s=s.substring(4);
		//             System.out.println(s);
		//         }else{
		//             s=s.substring(1);
		//         }
		//     }while(s.length()>3);

		//		Map<String, Integer> m = new HashMap<>();
		//		String[] s = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
		//		ArrayList<Integer> rank = new ArrayList<>();
		//		int[] aRank = new int[7];
		//		int ans =0;
		//	
		//		for(int i=0; i<s.length; i++) {
		//			String[] temp = s[i].split(" ");
		//			m.put(temp[0], Integer.parseInt(temp[1]));
		//			for(String key : m.keySet()) {
		//				rank.add(m.get(key));
		//				Collections.sort(rank);
		//			}
		//			int index=0;
		//			int d=0;
		//			for(int score : rank){
		//				if(aRank[index]!=score) {
		//					d++;
		//				}
		//				  aRank[index++] = score;
		//				}
		//			if(d>1) {
		//				ans++;
		//			}
		//			System.out.println(Arrays.toString(aRank));
		//			rank.clear();
		//		}
		//		System.out.println(ans);
		
		
		
		
		
		
//		int[] coffee_times = {100, 1, 50, 1, 1};
//		boolean[] visited= new boolean[coffee_times.length];
//		int N= 3;
//	
//		int[] answer = new int[coffee_times.length];
//		int rank=0;
//		
//		label:
//		do{
//			int k=0;
//			for(int i=0; i<coffee_times.length; i++){
//				if(coffee_times[i]!=0){
//					if(k==N){
//						continue;
//					}
//					System.out.println(coffee_times[i]);
//					coffee_times[i]--;
//					k++;
//				}
//
//			}
//			for(int i=0; i<coffee_times.length; i++){
//				if(visited[i])continue;
//			
//				if(coffee_times[i]==0){
//					visited[i]=true;
//					answer[rank++]=i+1;
//				}
//			}
//			int quit=0;
//			for(int i=0; i<coffee_times.length; i++) {
//				if(visited[i]==true) {
//					quit++;
//				}
//			}
//			System.out.println(quit);
//			if(quit==coffee_times.length) {
//				break label;
//			}
//		}while(true);
//		System.out.println(Arrays.toString(answer));
		
		
		
		
		
	}
}
