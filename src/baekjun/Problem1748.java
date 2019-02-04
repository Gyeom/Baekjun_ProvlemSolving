package baekjun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Problem1748 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int length = String.valueOf(N).length();
		int ans = 0;
		for(int i=1; i<length; i++) ans+= 9*i*Math.pow(10, i-1);
		ans+= (N-Math.pow(10, length-1)+1)*length;
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
