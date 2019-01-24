package sort;

import java.util.Scanner;

public class TEST {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long b = Long.parseUnsignedLong("123A4564123A4564",16);
		String c = Long.toUnsignedString(b);
		String s = String.format("%02X%n", Long.valueOf(c));
		System.out.println(b);
		System.out.println((b&(3<<1))+""+(b&(2<<1))+""+(b&(1<<1))+""+(b&(0<<1)));
		System.out.println(s);
	}

}
