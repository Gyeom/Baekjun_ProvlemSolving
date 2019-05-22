package baekjun;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
public class Problem14215 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] num = new int[3];
		for(int i=0; i<3; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(num);
		while(num[2]>=num[1]+num[0]){
			num[2]--;
		}
		System.out.println(num[2]+num[1]+num[0]);
	}
}
