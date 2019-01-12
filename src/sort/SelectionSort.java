package sort;

import java.util.PriorityQueue;

public class SelectionSort {
	static class Student{
		public Student(int x, int y) {
			
		}
	}
	public static void main(String args[]) {
		Student st = new Student(1,2);
		PriorityQueue<Student> q = new PriorityQueue<>();
		q.add(st);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}
