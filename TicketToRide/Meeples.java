import java.util.Collections; 
import java.util.ArrayList; 
/**
 * Enumeration class Meeples - represents a Meeple
 *
 * @author Ben, Zach, Tyler, Kaley, Sean
 * @version 4/28/18
 */
public enum Meeples
{
////////////////////////////////////////////////////////////
    WHITE, BLACK, RED, BLUE, GREEN, YELLOW;

    static ArrayList<Meeples> meeple = 
    new ArrayList<Meeples>();
    Meeples()
    {}
    
    /**
     * Adds meeples to above arraylist, 
     * then shuffles them to be placed.
     */
    public void shuffleMeeple()
    {
        for(int i = 0; i < 10; i++)
        {
            meeple.add(WHITE);
            meeple.add(RED); 
            meeple.add(BLACK); 
            meeple.add(BLUE); 
            meeple.add(GREEN); 
            meeple.add(YELLOW); 
        }
        Collections.shuffle(meeple); 
    }
    
    /**
     * Removes a meeple from the 
     * list to be placed.
     * 
     * @return Meeples meeples to be removed
     */
    public static Meeples getMeeple()
    {
       
        return meeple.remove(0);
    }
}
