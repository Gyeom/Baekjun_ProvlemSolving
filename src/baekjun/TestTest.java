package baekjun;

import java.util.PriorityQueue;

public class TestTest {
	static class Tree implements Comparable<Tree>{
		int age;
		Tree(int age){
			this.age=age;
		}
		
		@Override
		public int compareTo(Tree target) {
			// TODO Auto-generated method stub
			return this.age>target.age?1:-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Tree> treeList = new PriorityQueue<>();
		treeList.add(new Tree(3));
		treeList.add(new Tree(2));
		treeList.add(new Tree(1));
		treeList.add(new Tree(4));
		treeList.add(new Tree(5));
		
		for(Tree t:treeList) {
			System.out.println(t.age);
		}
		
	}

}
