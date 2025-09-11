package oodesign;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Counter2Test {

	@Test
	void test() {

		CounterType myCounter = new Counter2();
		
		assertEquals(0, myCounter.getCount());
		myCounter.count();
		
		assertEquals(1, myCounter.getCount());
		myCounter.count();
		
		assertEquals(0, myCounter.getCount());
        myCounter.count();
	}
}
