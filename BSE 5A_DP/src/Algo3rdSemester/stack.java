package Algo3rdSemester;

public class stack<t> {
	class node {
		t data;
		node next;

		node() {
			next = null;
			
		}
	}

	node top;

	stack() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(t val) {
		node newnode = new node();
		newnode.data = val;
		newnode.next = top;
		top = newnode;

	}

	public t pop() {
		node temp = new node();
		temp = top;
		if (isEmpty())
			System.out.println(" Already Empty");
		else if (top.next == null)
			top = null;
		else

			top = top.next;

		return temp.data;
	}
	public t getTop() {
		return top.data;
	}

}
