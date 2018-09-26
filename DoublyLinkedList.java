public class DoublyLinkedList<T>{
	class Node{
		T data;
		Node prev;
		Node next;

		public Node(T data){
			this.data = data;
			prev = null;
			next = null;
		}
	}

	Node head;

	public Node addFirst(T data){
		Node temp = new Node(data);
		if(head == null){
			head = temp;
		}else{
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		return head;
	}

	public Node addLast(T data){
		Node temp = new Node(data);
		if(head == null){
			head = temp;
		}else{
			Node curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = temp;
			temp.prev = curr;
		}
		return head;
	}

	public void displayBothWays(){
		if(head == null){
			return;
		}else{
			Node iteratorf = head;
			Node iteratorb = null;
			while(iteratorf != null){
				iteratorb = iteratorf;
				System.out.print(iteratorf.data+"->");
				iteratorf = iteratorf.next;
			}
			System.out.println();
			while(iteratorb != null){
				System.out.print(iteratorb.data+"->");
				iteratorb = iteratorb.prev;
			}
		}
	}

	public void removeFirst(){
		if(head == null){
			return;
		}
		if(head.next == null){
			head = null;
		}else{
			head = head.next;
			head.prev = null;
		}
	}

	public void removeLast(){
		if(head == null){
			return;
		}else{
			Node temp = head;
			while(temp.next.next != null){
				temp = temp.next;
			}
			temp.next.prev = null;
			temp.next = null;
		}
	}

	public void deleteNode(T data){
		if(head == null){
			return;
		}else{
			Node temp = head;
			while(temp != null){
				if(temp.data == data){
					if(temp.prev == null){
						head = temp.next;
						head.prev = null;
					}else if(temp.next == null){
						temp.prev.next = null; 
						temp.prev = null;
					}else{
						temp.prev.next = temp.next;
						temp.next.prev = temp.prev;
					}
					return;
				}else{
					temp = temp.next;
				}
			}
		}		
	}

	public static void main(String[] args){
		DoublyLinkedList<Integer> dls = new DoublyLinkedList<Integer>();
		dls.addFirst(1);
		dls.addFirst(2);
		dls.addFirst(3);
		dls.addFirst(4);
		dls.addLast(0);
		dls.displayBothWays();
		System.out.println();
		dls.deleteNode(0);
		dls.displayBothWays();
		System.out.println();
		dls.removeLast();
		System.out.println();
		dls.displayBothWays();
		System.out.println();
	}


}