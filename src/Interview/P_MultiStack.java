package Interview;

import java.util.EmptyStackException;

class FullStackException extends Exception{
	public FullStackException() {
		super();
	}
	public FullStackException (String msg) {
		super(msg);
	}
}
class FixedMultiStacks{
	private int numOfStacks = 3;
	private int stackSize;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStacks (int stackSize) {
		this.stackSize = stackSize;
		this.sizes = new int [numOfStacks];
		this.values = new int [numOfStacks * stackSize];
	}
	
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackSize;
	}
	
	public int getTopIndex(int stackNum) {
		int offset = stackSize * stackNum;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	public void push(int stackNum, int data) throws FullStackException {
		if(isFull(stackNum)) {
			throw new FullStackException();
		}
		values[getTopIndex(stackNum)+1] = data;
		sizes[stackNum]++;
	}
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int top = getTopIndex(stackNum);
		int data = values[top];
		values[top]=0;
		sizes[stackNum]--;
		return data;
	}
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[getTopIndex(stackNum)];
	}
}

public class P_MultiStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedMultiStacks ms = new FixedMultiStacks(5);
		try {
			ms.push(0, 5);
		}catch (FullStackException e) {
			System.out.println("It's full");
			// TODO: handle exception
		}
		
		try {
			System.out.println(ms.pop(0));
		}catch (EmptyStackException e) {
			System.out.println("It's full");
			// TODO: handle exception
		}
	}

}
