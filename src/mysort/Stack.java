package mysort;

public class Stack {
	
	private int top = -1;
	private Object[] stack;
	private int size = 0;
	
	public Stack(int size) {
		this.stack = new Object[size];
	}
	
	public void push(Object element) {
		if(top>=size) {
			throw new StackOverflowError();
		}
		size++;
		stack[++top] = element;
	}
	
	public Object pop() {
		if(top==-1) {
			throw new StackUnderflowError();
		}
		size--;
		return stack[top--];
	}
	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
	public int getSize() {
		return size;
	}
	class StackUnderflowError extends RuntimeException{
		
	}
	public static void main(String args[]) {
		Stack s = new Stack(5);
		System.out.println(s.size);
		s.push(10);
		s.push(20);
		System.out.println(s.size);
		System.out.println(s.pop().toString());
		System.out.println(s.pop().toString());
	}

}
