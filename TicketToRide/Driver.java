import java.util.Stack;
import java.util.Collections;
/**
 * Driver for the game which you call to play
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class Driver
{
    public static Stack<Meeples> shared;
    public static int index = 0;
    /**
     * calls board panel's run simulation class
     * to play ticket to ride
     */
    public static void main(String args[]){
        shared = new Stack<>();
        for(int i =0 ;i < 12; i++){
            Meeples[] m = Meeples.values();
            for(Meeples mp : m){

                shared.add(mp);
            }

        }
        Collections.shuffle(shared);

        BoardPanel b = new BoardPanel();
        b.runSimulation();
    }
}
