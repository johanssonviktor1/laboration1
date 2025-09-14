package oodesign;

public class ActualCounter {
    public static void main(String[] args) {
        CounterType hoursTimer = new Counter24();
        CounterType minutesTimer = new Counter60(hoursTimer);
        CounterType secondsTimer = new Counter60(minutesTimer);

        for (int i = 0; i < 6000; i++) {
            secondsTimer.count();

            //Hacky solution, fix later
            if (secondsTimer.getCount() == 0) {
                System.out.println(60);
            } else {
                System.out.println(secondsTimer.getCount());
            }
            if (minutesTimer.getCount() == 0 && secondsTimer.getCount() == 0) {
                System.out.println("You have reached: " + hoursTimer.getCount() + " hours!");
            } else if (secondsTimer.getCount() == 0) {
                System.out.println("You have reached: " + minutesTimer.getCount() + " minutes!");
            }
        }
    }
}
