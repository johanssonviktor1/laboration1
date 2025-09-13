package oodesign;

public class Counter60 extends CircularCounter {
    public Counter60() {
        this(Direction.INCREASING, null); // vad anropas här?
    }

    public Counter60(CounterType next) {
        this(Direction.INCREASING, next); // vad anropas här?
    }

    public Counter60(Direction direction) {
        this(direction, null); // vad anropas här?
    }

    public Counter60(Direction direction, CounterType next) {
        super(60, direction, next); // vad anropas här?
    }
}
