package oodesign;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActualCounterTest {

    @Test
    void testMinute() {
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

    @Test
    void testHour() {
        CounterType hours = new Counter24(CircularCounter.Direction.INCREASING);
        CounterType minutes = new Counter60(CircularCounter.Direction.INCREASING, hours);
        CounterType seconds = new Counter60(CircularCounter.Direction.INCREASING, minutes);

        for (int j = 0; j < 60; j++) {
            // 59 steg -> sekunder på 59
            for (int i = 0; i < 59; i++) {
                seconds.count();
            }

            assertEquals(59, seconds.getCount());

            // ett steg till -> sekunder på 0, minuter ska öka till 1
            seconds.count();
            assertEquals(0, seconds.getCount());
            if (hours.getCount() == 0) {
                assertTrue(minutes.getCount() > 0);
            }
        }

        //Checks to see if hours is registered and minutes gets reset
        assertEquals(0, minutes.getCount());
        assertEquals(1, hours.getCount());
    }

    @Test
    void testReset() {
        CounterType hours = new Counter24(CircularCounter.Direction.INCREASING);
        CounterType minutes = new Counter60(CircularCounter.Direction.INCREASING, hours);
        CounterType seconds = new Counter60(CircularCounter.Direction.INCREASING, minutes);

        for (int j = 0; j < 60; j++) {
            // 59 steg -> sekunder på 59
            for (int i = 0; i < 59; i++) {
                seconds.count();
            }

            assertEquals(59, seconds.getCount());

            // ett steg till -> sekunder på 0, minuter ska öka till 1
            seconds.count();
            assertEquals(0, seconds.getCount());
            if (hours.getCount() == 0) {
                assertTrue(minutes.getCount() > 0);
            }
        }

        //Checks to see if hours is registered and minutes gets reset
        assertEquals(0, minutes.getCount());
        assertEquals(1, hours.getCount());

        seconds.reset();
        minutes.reset();
        hours.reset();

        assertEquals(0, seconds.getCount());
        assertEquals(0, minutes.getCount());
        assertEquals(0, hours.getCount());
    }

    @Test
    void testPauseAndResume() {
        CounterType hours = new Counter24(CircularCounter.Direction.INCREASING);
        CounterType minutes = new Counter60(CircularCounter.Direction.INCREASING, hours);
        CounterType seconds = new Counter60(CircularCounter.Direction.INCREASING, minutes);

        seconds.pause();
        minutes.pause();
        hours.pause();

        for (int j = 0; j < 60; j++) {
            // 59 steg -> sekunder på 59
            for (int i = 0; i < 59; i++) {
                seconds.count();
            }
        }

        //Checks to see if all values are still at 0
        assertEquals(0, seconds.getCount());
        assertEquals(0, minutes.getCount());
        assertEquals(0, hours.getCount());

        seconds.resume();
        minutes.resume();
        hours.resume();

        for (int j = 0; j < 60; j++) {
            // 59 steg -> sekunder på 59
            for (int i = 0; i < 59; i++) {
                seconds.count();
            }

            assertEquals(59, seconds.getCount());

            // ett steg till -> sekunder på 0, minuter ska öka till 1
            seconds.count();
            assertEquals(0, seconds.getCount());
            if (hours.getCount() == 0) {
                assertTrue(minutes.getCount() > 0);
            }
        }

        //Checks to see if hours is registered and minutes gets reset
        assertEquals(0, minutes.getCount());
        assertEquals(1, hours.getCount());
    }
}