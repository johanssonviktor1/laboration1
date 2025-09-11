package oodesign;

public class Counter24 extends CircularCounter {

	public Counter24() {
		this(Direction.INCREASING, null); // vad anropas här?
	}

	public Counter24(CounterType next) {
		this(Direction.INCREASING, next); // vad anropas här?
	}

	public Counter24(Direction direction) {
		this(direction, null); // vad anropas här?
	}

	public Counter24(Direction direction, CounterType next)
	{
		super(24, direction, next); // vad anropas här?
	}
}



