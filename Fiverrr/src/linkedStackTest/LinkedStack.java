package linkedStackTest;

import java.util.NoSuchElementException;

public class LinkedStack<Item>{
    private int n;          // size of the stack
    private Node first;     // top of stack

    public class Node {
        private Item item;
        private Node next;
    }

    //initializes an empty stack.
    public LinkedStack() {
        first = null;
        n = 0;
    }

    //returns true if this stack is empty; false otherwise
    public boolean isEmpty() {
        return first == null;
    }

    //returns the number of items in the stack.
    public int size() {
        return n;
    }

    //inserts an item to the stack
    public void push(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        n++;
    }
    //removes and returns the top element in the stack
    public Item pop()  {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack underflow");
        Item item = first.item;
        first = first.next;
        return item;
    }


    //returns (but does not remove) the item most recently added to this stack.
    public Item peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack underflow");
        return first.item;
    }


}
