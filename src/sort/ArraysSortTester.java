package sort;
import java.util.Arrays;
import java.util.Scanner;
// Arrays.sort �޼��带 ����Ͽ� �����մϴ�(�� ����).

class ArraysSortTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("��ڼ���");
		int num = stdIn.nextInt();
		int[] x = new int[num];		// �迭�� ũ��� num�Դϴ�.

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = stdIn.nextInt();
		}

		Arrays.sort(x);				// �迭 x�� �����մϴ�.

		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < num; i++)
			System.out.println("x[" + i + "]��" + x[i]);
	}
}