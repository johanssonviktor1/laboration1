package oodesign;

public class lab1 {

	
	public abstract class CircularCounter implements CounterType
	{
		enum Direction {INCREASING, DECEASING};
		int currentCount;
		boolean isPaused;
		final int MAX_NR_OF_COUNTS;
		CounterType nextCounter;
		
		public CircularCounter(int maxNrOfCounts, Direction direction,
								CounterType nextCounter)
		{
			this.direction = direction;
			this.nextCounter = nextCounter;
			
			
			if (maxNrOfCounts < 2)
				this.MAX_NR_OF_COUNTS = 0;
			else
				this.MAX_NR_OF_COUNTS = maxNrOfCounts;
			
			
			//Om det är en nedåträknare, börja räkna från högsta värde istället för från noll
			if (this.direction == Direction.DECREASING && this.MAX_NR_OF_COUNTS>0)
				currentCount = MAX_NR_OF_COUNTS - 1;
			
			}
		
		
		@Override
		public int getCount() { return currentCount ;}
		
		//Starta om räknare från början
		@Override
		public void reset() { currentCount = 0; }
		
		@Override
		public void pause() { isPaused = true; }
		
		@Override
		public void resume() { isPaused = false; }
		
		@Override
		public void count()
			{
			if (!isPaused && this.MAX_NR_OF_COUNTS > 0 )
				{
				if (direction == Direction.INCREASING)
					{
					currentCount ++;
					
					if (currentCount >= MAX_NR_OF_COUNTS) 
					{
						currentCount = 0;
						
						if (nextCounter != null)
							
						}
					}
				else if (direction == Direction.DECEASING)
					{
						//flera kod-rader som saknas här
				
					}
				}
			}
	

		
		@Override
		public String toString()
		{
			//
		}
	}