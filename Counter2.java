package oodesign;

public class Counter2 extends CircularCounter {
	
	public Counter2() {
		this(Direction.INCREASING, null); // vad anropas här?
	}

	public Counter2(CounterType next) {
		this(Direction.INCREASING, next); // vad anropas här?
	}

	public Counter2(Direction direction) {
		this(direction, null); // vad anropas här?
	}

	public Counter2(Direction direction, CounterType next)
	{
		super(2, direction, next); // vad anropas här?
	}
}
