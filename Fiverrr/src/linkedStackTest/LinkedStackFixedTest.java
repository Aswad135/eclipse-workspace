package linkedStackTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;



public class LinkedStackFixedTest {

	@Test
	public void isEmptyTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		assertEquals(true,obj.isEmpty());
	}

	@Test
	//returns the number of items in the stack.
	public void sizeTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		obj.push(20);
		obj.push(3);

		assertEquals(2,obj.size());
	}

	@Test
	//inserts an item to the stack
	public void pushTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		obj.push(30);

		assertEquals(30,obj.peek());

	}

	@Test
	//removes and returns the top element in the stack
	public void popTest()  {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		obj.push(30);

		assertEquals(true,(obj.pop() == 30) && obj.isEmpty());
	}


	@Test
	//returns (but does not remove) the item most recently added to this stack.
	public void peekTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		obj.push(30);

		assertEquals(true,(obj.peek() == 30) && !obj.isEmpty());
	}


	@Test

	public void pushSpeedTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
		long Time = System.nanoTime();
		for (int i=0;i<=10000;i++) {
			obj.push(i);			
		}
		Time = System.nanoTime() - Time;
		System.out.println(Time);

		assertEquals(true,(Time <= 5000000l));
	}

	@Test
	public void popExceptionThrowTest() {
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
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
		LinkedStackFixed<Integer> obj = new LinkedStackFixed<Integer>();
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
