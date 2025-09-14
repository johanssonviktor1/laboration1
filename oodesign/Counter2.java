package oodesign;

public class Counter2 extends CircularCounter {
    public Counter2() {
        this(Direction.INCREASING, null);
    }

    public Counter2(CounterType next) {
        this(Direction.INCREASING, next);
    }

    public Counter2(Direction direction) {
        this(direction, null);
    }

    public Counter2(Direction direction, CounterType next) {
        super(2, direction, next);
    }
}
