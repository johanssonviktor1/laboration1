package oodesign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Counter24Test {

    @Test
    void testNextCounterTriggered() {
        CounterType hours = new Counter24();
        CounterType minutes = new Counter60(CircularCounter.Direction.INCREASING, hours);

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
