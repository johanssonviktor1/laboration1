package oodesign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Counter24Test {

	@Test
	void testNextCounterTriggered() {
		CounterType hours = new Counter24();
		CounterType minutes = new Counter60(CircularCounter.Direction.INCREASING, hours);
		CounterType seconds = new Counter60(CircularCounter.Direction.INCREASING, minutes);
		

		// 59 steg -> sekunder på 59
		for (int i = 0; i < 59; i++) {
			seconds.count();
		}
		assertEquals(59, seconds.getCount());
		assertEquals(0, minutes.getCount());

		// ett steg till -> sekunder på 0, minuter ska öka till 1
		seconds.count();
		assertEquals(0, seconds.getCount());
		assertEquals(1, minutes.getCount());

		minutes.reset();
		
		for (int i = 0; i < 59; i++) {
			minutes.count();
		}
		assertEquals(59, minutes.getCount());
		assertEquals(0, hours.getCount());

		// ett steg till -> minuter på 0, timmar ska öka till 1
		minutes.count();
		assertEquals(0, minutes.getCount());
		assertEquals(1, hours.getCount());

	}

}
