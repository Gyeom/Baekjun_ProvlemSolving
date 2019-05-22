package Interview;

class LinkedList{
	Node header;
	
	static class Node{
		int data;
		Node next = null;
	}
	LinkedList(){
		header = new Node();
	}
	void append(int data) {
		Node end = new Node();
		end.data=data;
		Node n = header;
		while(n.next!=null) {
			n = n.next;
		}
		n.next=end;
	}
	void delete(int data) {
		Node n = header; 
		while(n.next!=null) {
			if(n.next.data==data) {
				n.next= n.next.next;
			}else {
				n=n.next;
			}
		}
	}
	void retrive() {
		Node n = header.next;
		while(n.next!=null) {
			System.out.print(n.data+"->");
			n = n.next;	
		}
		System.out.println(n.data);
	}
}
public class P_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.retrive();
		ll.delete(1);
		ll.retrive();
	}
}