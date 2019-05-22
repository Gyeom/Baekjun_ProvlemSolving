package mysort;

public class Queue {
	Object[] queue;
	int rear =-1;
	int front =-1;
	int size;
	public Queue(int size) {
		this.size =size;
		this.queue = new Object[size];
	}
	
	public void enqueue(Object object) {
		if(isFull()) {
			throw new QueueOverflow();
		}
		queue[++rear] = object;
	}
	public Object dequeue(){
		if(isEmpty()) {
			throw new QueueUnderflow();
		}
		Object temp = queue[++front];
		queue[front]=null;
		
		if(isEmpty()) {
			rear =-1;
			front =-1;
		}
		return temp;
		
	}
	
	static class QueueOverflow extends RuntimeException{
		
	}
	static class QueueUnderflow extends RuntimeException{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(5);
		q.enqueue(5);
		q.enqueue(3);
		System.out.println(q.size);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}
	public int getSize() {
		return size;
	}
	public boolean isFull() {
		return rear==size-1 ? true : false;
	}
	public boolean isEmpty() {
		return front==rear ? true : false;
	}
}
