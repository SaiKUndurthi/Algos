public class LinkedList<T>{
	class Node{
		T data;
		Node next;

		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public Node addToTheFirstNode(T data){
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		return head;
	}
	public Node addToTheLastNode(T data){
		Node temp = head;
		if(head == null){
			head = new Node(data);
		}else{
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
		return head;
	}

	public Node removeNodeFromTail(){
		Node temp = head;
		if(head == null || head.next == null){
			return null;
		}else{
			while(temp.next.next != null){
				temp = temp.next;
			}
			temp.next = null;
		}
		return head;
	}

	public Node removeThisNode(T data){
		if((head.next == null && head.data != data)||(head == null)){
			return null;
		}
		if(head.data == data && head.next == null){
			head = null;
		}else{
			Node prev = null;
			Node curr = head;
			while(curr != null){
				if(curr.data == data){
					prev.next = curr.next;
					return head;
				}else{
					prev = curr;
					curr = curr.next;
				}
			}
		}
		return head;
	}

	public void displayLinkedList(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		LinkedList<Integer> ls = new LinkedList<Integer>();
		LinkedList<String> l = new LinkedList<String>();
		ls.addToTheLastNode(1);
		l.addToTheLastNode("a");
		ls.addToTheLastNode(2);
		l.addToTheLastNode("b");
		ls.addToTheLastNode(3);
		ls.addToTheFirstNode(0);
		l.displayLinkedList();
		ls.removeThisNode(2);
		ls.displayLinkedList();
		ls.removeNodeFromTail();
		ls.displayLinkedList();
	}
}