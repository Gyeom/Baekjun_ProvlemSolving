import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people= {2,2,2,2,3,4,5,6};
		int[] tshirts= {1,2,3,4,5,6,7,9,10,11};
	     int answer = 0;
	        int[] a= new int[1001];
	        int[] b=new int[1001];
	        for(int i=0; i<people.length; i++){
	            a[people[i]]++;
	        }
	        for(int i=0; i<tshirts.length; i++){
	            b[tshirts[i]]++;
	        }
	        System.out.println(Arrays.toString(b));
	        for(int i=1; i<1001; i++){
	        	int temp = Math.min(a[i],b[i]);
	            answer+=temp;
	            a[i]-=temp;
	            b[i]-= temp;
	        }
	        System.out.println(Arrays.toString(a));
	        System.out.println(Arrays.toString(b));
	        System.out.println(answer);
	           for(int i=1; i<11; i++){
	             for(int j=i+1; j<11; j++){  
	            if(a[i]==0) break;
	            if(b[j]==0)  continue;      
	            if(b[j]>=a[i]){
	                answer+=a[i];
	                int temp =a[i];
	                b[j]-=temp;
	                a[i]-=temp;
	            }else{
	                answer+=b[j];
	                int temp=b[j];
	                b[j]-=temp;
	                a[i]-=temp;
	            }
	            System.out.println(Arrays.toString(a));
		        System.out.println(Arrays.toString(b));
	        }  
	        }  
	           
	           System.out.println(answer);
	}

}
