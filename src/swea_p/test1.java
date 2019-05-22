package swea_p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class test1 {
	static class Man{
		String id;
		String action;
		int hour;
		int min;
		int sec;
		int count;
		Man(String id, String action, int hour, int min, int sec,int count){
			this.id=id;
			this.action=action;
			this.hour=hour;
			this.sec=sec;
			this.min=min;
			this.count=count;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//		String s = "I love you";
		//		for(int i=0; i<s.length(); i++) {
		//			int alpha = s.charAt(i);
		//			if(alpha<='z'&&alpha>='a') {
		//				System.out.print((char)('z'-alpha+'a'));
		//			}else if(alpha<='Z'&&alpha>='A') {
		//				System.out.print((char)('Z'-alpha+'A'));
		//			}else {
		//				System.out.print((char)alpha);
		//			}
		//		}
		//

		//		class Solution {
		//		    public int solution(int[] pobi, int[] crong) {
		//		        int answer = 0;
		//		        if(pobi[0]<3||pobi[0]>398||pobi[1]<3||pobi[1]>398||crong[0]<3||crong[0]>398||crong[1]<3||crong[1]>398
		//		            ||pobi[0]%2!=1||crong[0]%2!=1||pobi[1]%2!=0||crong[1]%2!=0||Math.abs(crong[0]-crong[1])!=1||Math.abs(pobi[0]-pobi[1])!=1) {
		//		           return -1;
		//		        }else{
		//		              int pobiLength_l= String.valueOf(pobi[0]).length();
		//			        int crongLength_l = String.valueOf(crong[0]).length();
		//			        int pobiLength_r = String.valueOf(pobi[1]).length();
		//			        int crongLength_r =  String.valueOf(crong[1]).length();
		//			        
		//			        int ans_pobi = 0;
		//			        
		//			        //pobi 왼쪽 합
		//			        int pobi_lsum;
		//			        int sum=0;
		//			        int val=pobi[0];
		//			        for(int i=pobiLength_l; i>=1; i--) {
		//			        	sum+=val/Math.pow(10, i-1);
		//			        	val-=sum*Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_pobi) {
		//			        	ans_pobi=sum;
		//			        }
		//			        //pobi 오른쪽 합
		//			        int pobi_rsum;
		//			        sum=0; //임시변수
		//			        val=pobi[1]; //임시변수
		//			        for(int i=pobiLength_r; i>=1; i--) {
		//			        	sum+=val/Math.pow(10, i-1);
		//			        	val-=sum*Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_pobi) {
		//			        	ans_pobi=sum;
		//			        }
		//
		//			        
		//			        //pobi 왼쪽 곱
		//			        int pobi_lmul;
		//			        sum=1; //임시변수
		//			        val=pobi[0]; //임시변수
		//			        for(int i=pobiLength_l; i>=1; i--) {
		//			        	sum*=(int)(val/Math.pow(10, i-1));
		//			        	val%=Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_pobi) {
		//			        	ans_pobi=sum;
		//			        }
		//			        //pobi 오른쪽 곱
		//			        int pobi_rmul;
		//			        sum=1; //임시변수
		//			        val=pobi[1]; //임시변수
		//			        for(int i=pobiLength_r; i>=1; i--) {
		//			        	sum*=(int)(val/Math.pow(10, i-1));
		//			        	val%=Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_pobi) {
		//			        	ans_pobi=sum;
		//			        }
		//			        
		//			        int ans_crong = 0;
		//			        //crong 왼쪽 합
		//			        int crong_lsum;
		//			        sum=0;
		//			        val=crong[0];
		//			        for(int i=crongLength_l; i>=1; i--) {
		//			        	sum+=val/Math.pow(10, i-1);
		//			        	val-=sum*Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_crong) {
		//			        	ans_crong=sum;
		//			        }
		//			        //crong 오른쪽 합
		//			        sum=0; //임시변수
		//			        val=crong[1]; //임시변수
		//			        for(int i=crongLength_r; i>=1; i--) {
		//			        	sum+=val/Math.pow(10, i-1);
		//			        	val-=sum*Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_crong) {
		//			        	ans_crong=sum;
		//			        }
		//
		//			        
		//			        //crong 왼쪽 곱
		//			        sum=1; //임시변수
		//			        val=crong[0]; //임시변수
		//			        for(int i=crongLength_l; i>=1; i--) {
		//			        	sum*=(int)(val/Math.pow(10, i-1));
		//			        	val%=Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_crong) {
		//			        	ans_crong=sum;
		//			        }
		//			        //crong 오른쪽 곱
		//			        sum=1; //임시변수
		//			        val=crong[1]; //임시변수
		//			        for(int i=crongLength_r; i>=1; i--) {
		//			        	sum*=(int)(val/Math.pow(10, i-1));
		//			        	val%=Math.pow(10, i-1);
		//			        }
		//			        if(sum>ans_crong) {
		//			        	ans_crong=sum;
		//			        }
		//			        
		//			        if(ans_pobi>ans_crong) {
		//			        	answer=1;
		//			        }else if(ans_pobi<ans_crong) {
		//			        	answer=2;
		//			        }else {
		//			        	answer=0;
		//			        }
		//			        
		//		       
		//		        }  
		//		        
		//		         return answer;
		//			      
		//		    }
		//		}
		//	      Scanner sc = new Scanner(System.in);
		//	      int N = sc.nextInt();
		//	      int answer=0;
		//	      for(int i=1 ; i<=N; i++) {
		//	    	  String number = String.valueOf(i);
		//	    	  for(int j=0; j<number.length(); j++) {
		//	    		  char num = number.charAt(j);
		//	    		  if(num=='3'||num=='6'||num=='9') {
		//	    			  answer++;
		//	    		  }
		//	    	  }
		//	      }
		//	        System.out.println(answer);
		//	        





		//		
		//		
		//		
		//		
		//		int[][] lands = {{ 10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};
		//		int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
		//		int[] point = {10, 10, 30, 30};
		//		
		//		
		//		for(int i=0; i<1000000; i++) {
		//			for(int j=0; j<1000000; j++) {
		//				
		//			}
		//		}
		//		
		//				






//
//
//
//
//
//		int totalTicket = 2000;
//		String[] logs = {
//				"woni request 09:12:29",
//				"brown request 09:23:11",
//				"brown leave 09:23:44",
//				"jason request 09:33:51",
//				"jun request 09:33:56",
//				"cu request 09:34:02"
//		};
//		ArrayList<Man> man_list = new ArrayList<>();
//		Queue<Man> q = new LinkedList<>();
//		for(int i=0; i<logs.length; i++) {
//			StringTokenizer token = new StringTokenizer(logs[i]);
//			String id = String.valueOf(token.nextToken());
//			String action = String.valueOf(token.nextToken());
//			token = new StringTokenizer(token.nextToken().replaceAll(":", " "));
//			int hour = Integer.parseInt(token.nextToken());
//			int min = Integer.parseInt(token.nextToken());
//			int sec = Integer.parseInt(token.nextToken());
//			if(hour>=9&&hour<=10&&min<=59) {
//				Man man = new Man(id, action, hour, min, sec,0);
//				q.add(man);
//				man_list.add(man);
//			}
//		}
//		String[] time = new String[3601];
//		while(!q.isEmpty()) {
//			Man man = q.remove();
//			int startTime=man.min*60+man.sec;
//			int endTime=startTime+60;
//			for(int t=startTime; t<endTime; t++) {
//				if(time[t]!=null&&!time[t].equals(man.id)) break;
//				if(man.action.equals("request")) {
//					time[t]=man.id;
//				}else if(man.action.equals("leave")) {
//					time[t]=null;
//				}
//			}
//		}
//		ArrayList<String> success = new ArrayList<>();
//		outloof:
//			for(int i=0; i<man_list.size(); i++) {
//				if(success.contains(man_list.get(i).id)) continue;
//				int count=0;
//				for(int t=0; t<3600; t++) {
//					if(time[t]==null) continue;
//					if(time[t].equals(man_list.get(i).id)) {
//						count++;
//					}else {
//						count=0;
//					}
//					if(count>=60) {
//						success.add(man_list.get(i).id);
//						if(success.size()==totalTicket) {
//							break outloof;
//						}
//						continue outloof;
//					}
//				}
//				
//			}
//		Collections.sort(success);
//		String[] answer = new String[success.size()];
//		success.toArray(answer);
//		System.out.println(Arrays.toString(answer));

		String s= "zyelleyz";
		boolean go=false;
		do {
			StringBuilder sb = new StringBuilder(s);
			go=false;
			for(int i=0; i<s.length()-1; i++) {
				if(s.charAt(i)==s.charAt(i+1)) {
					sb.setCharAt(i, ' ');
					sb.setCharAt(i+1, ' ');
					go=true;
				}
			}
			s=sb.toString().replaceAll(" ", "");
		}while(go);
		System.out.println(s);
	}
}
