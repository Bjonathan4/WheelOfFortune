import java.util.ArrayList;
import java.util.Random;
public class Randomization {
    // Dollar value of the wheel spin
    public static int wheelVal;

    // Default Constructor
    public Randomization() {
        wheelVal = 0;
    }

    public static int wheelVal() {
        Random random = new Random();
        // Create list to store wheel values (in dollars)
        ArrayList<Integer> wheelNums = new ArrayList<>();
        wheelNums.add(-1);
        wheelNums.add(-1);
        wheelNums.add(-1);
        wheelNums.add(500);
        wheelNums.add(500);
        wheelNums.add(500);
        wheelNums.add(500);
        wheelNums.add(550);
        wheelNums.add(550);
        wheelNums.add(600);
        wheelNums.add(600);
        wheelNums.add(600);
        wheelNums.add(600);
        wheelNums.add(650);
        wheelNums.add(650);
        wheelNums.add(650);
        wheelNums.add(700);
        wheelNums.add(700);
        wheelNums.add(700);
        wheelNums.add(800);
        wheelNums.add(800);
        wheelNums.add(900);
        wheelNums.add(900);
        wheelNums.add(2500);
        // Chooses a random number from the list
        wheelVal = wheelNums.get(random.nextInt(wheelNums.size()));
        return wheelVal;
    }
}
