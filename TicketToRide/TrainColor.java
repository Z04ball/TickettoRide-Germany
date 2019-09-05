import java.util.Random;
/**
 * Enum for the color of the trains on the cards
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/28/18
 */
public enum TrainColor{
////////////////////////////////////////////////////////////

    rainbow,
    black,
    blue,
    green,
    orange,
    purple,
    red,
    white,
    yellow;

    /**
     * Simulates drawing a random color
     */
    public static TrainColor createColor(){
        Random rand = new Random();
        int size = TrainColor.values().length;
        return TrainColor.values()[rand.nextInt(9)];
    }
}
