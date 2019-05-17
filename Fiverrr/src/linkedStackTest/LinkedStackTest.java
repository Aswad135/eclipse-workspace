package linkedStackTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;



public class LinkedStackTest {

	@Test
	public void isEmptyTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		assertEquals(true,obj.isEmpty());
	}

	@Test
	//returns the number of items in the stack.
	public void sizeTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		obj.push(20);
		obj.push(3);

		assertEquals(2,obj.size());
	}

	@Test
	//inserts an item to the stack
	public void pushTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		obj.push(30);

		assertEquals(30,obj.peek());

	}

	@Test
	//removes and returns the top element in the stack
	public void popTest()  {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		obj.push(30);

		assertEquals(true,(obj.pop() == 30) && obj.isEmpty());
	}


	@Test
	//returns (but does not remove) the item most recently added to this stack.
	public void peekTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		obj.push(30);

		assertEquals(true,(obj.peek() == 30) && !obj.isEmpty());
	}


	@Test

	public void pushSpeedTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		long Time = System.nanoTime();
		for (int i=0;i<=10000;i++) {
			obj.push(i);			
		}
		Time = System.nanoTime() - Time;

		assertEquals(true,(Time <= 5000000l));
	}

	@Test
	public void popExceptionThrowTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		boolean test = false;
		try {
			obj.pop();
			fail("this should not complete");
		}catch(NoSuchElementException e) {
			test = true;
		}catch(Exception e) {
			test = false;
		}

		assertEquals(true, test);

	}
	
	@Test
	public void peekExceptionThrowTest() {
		LinkedStack<Integer> obj = new LinkedStack<Integer>();
		boolean test = false;
		try {
			obj.peek();
			fail("this should not complete");
		}catch(NoSuchElementException e) {
			test = true;
		}catch(Exception e) {
			test = false;
		}

		assertEquals(true, test);

	}
}
