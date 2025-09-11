package oodesign;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Counter60Test {

    @Test
    void testReset() {
    	
        CounterType c = new Counter60();
        c.count();
        c.count();
        assertEquals(2, c.getCount());

        c.reset();
        assertEquals(0, c.getCount());
    }

    @Test
    void testPauseAndResume() {
        CounterType c = new Counter60();
        c.count();
        assertEquals(1, c.getCount());

        c.pause();
        c.count();  // ska inte öka, pausad
        assertEquals(1, c.getCount());

        c.resume();
        c.count();
        assertEquals(2, c.getCount());
    }

    @Test
    void testCountingUpToMax() {
        CounterType c = new Counter60();
        for (int i = 0; i < 60; i++) {
            c.count();
        }
        assertEquals(0, c.getCount()); // efter 60 tick, slå om
    }

    @Test
    void testNextCounterTriggered() {
        CounterType minutes = new Counter60();
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
    }
}
