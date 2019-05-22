package mysort;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {

	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		sort(arr,0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	private static void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end) return;
		int mid = (start+end)/2;
		sort(arr,start,mid);
		sort(arr,mid+1,end);
		int[] temp = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			temp[i]=arr[i];
		}
		int index=start;
		int part1 = start;
		int part2 = mid+1;
		while(part1<=mid&&part2<=end){
			if(temp[part1]<=temp[part2]) {
				arr[index++]=temp[part1++];
			}else{
				arr[index++]=temp[part2++];
			}
		}
		for(int i=part1; i<=mid; i++) {
			arr[index++]=temp[i];
		}
	}
}