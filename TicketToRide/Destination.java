import java.util.ArrayList;
import java.util.Collections;
/**
 * Each city point represented as an enum
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public enum Destination{
    Danemark(258, 26, 1), //needs one meeple.
    Kiel(296, 93, 1), //needs one meeple.
    Rostock(455, 97, 1), //needs one meeple.
    Schwerin(399, 174, 1), //needs one meeple.
    Hamburg(312, 183, 4), //needs four meeples....
    Bremerhaven(194, 183, 1), //needs one meeple.
    Emden(80, 202, 1), //needs one meeple.
    Bremen(200, 242, 1), //needs one meeple.
    Hannover(273, 334, 1), //needs one meeple.
    Berlin(545, 303, 5), //needs five meeples.....
    Magdeburg(435, 359, 1), //needs one meeple.
    Munster(119, 360, 1), //needs one meeple.
    Niederland(20, 299, 1), //needs one meeple.
    Dortmund(108, 421, 1), //needs one meeple.
    Dusseldorf(53, 446, 1), //needs one meeple.
    Kassel(262, 460, 1), //needs one meeple.
    Erfurt(372, 498, 1), //needs one meeple.
    Leipzig(472, 442, 3), //needs three meeples...
    Dresden(588, 487, 1), //needs one meeple.
    Chemnitz(532, 512, 1), //needs one meeple.
    Frankfurt(189, 595, 1), //needs one meeple.
    Koln(49, 509, 4), //needs four meeples....
    Koblenz(63, 572, 1), //needs one meeple.
    Mainz(140, 626, 4), //needs four meeples....
    Wurzburg(283, 628, 1), //needs one meeple.
    Nurnberg(374, 656, 1), //needs one meeple.
    Regensburg(493, 724, 1), //needs one meeple.
    Munchen(448, 832, 4), //needs four meeples....
    Lindau(275, 898, 1), //needs one meeple.
    Konstanz(219, 883, 1), //needs one meeple.
    Ulm(300, 809, 1), //needs one meeple.
    Augsburg(357, 814, 1), //needs one meeple.
    Freiburg(127, 863, 1), //needs one meeple.
    Karlsruhe(162, 743, 1), //needs one meeple.
    Saarbrucken(38, 699, 1), //needs one meeple. 
    Mannheim(167, 684, 1), //needs one meeple.
    Stuttgart(226, 756, 3), //needs three meeples...
    Frankreich(31, 796, 1), //needs one meeple.
    Schweiz(161, 940, 1), //needs one meeple.
    OsterreichWest(384, 926, 1), //needs one meeple.
    OsterreichEast(575, 890, 1), //needs one meeple.
    Osterreich(0, 0, 1);
    
    private int x;
    private int y;
    public ArrayList<Meeples> meeple = new ArrayList<>();
    private int numMeeples;


    
    /**
     * constructor for each destination (or city)
     * 
     * @param x the x coordinate
     * @ param y the y coordinate 
     * @ param meeple the number of meeples 
     */
    Destination(int x, int y, int numMeeples) {
        this.x = x; 
        this.y = y; 
        this.numMeeples = numMeeples;
        for(int i = 0; i < numMeeples; i++){
            Meeples m = Driver.shared.pop();
            meeple.add(m);

        }
    }

    /**
     * accessor method for x coordinate 
     * of the city
     * 
     * @return the x coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * accessor method for y coordinate 
     * of the city
     * 
     * @return the y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * accessor method for meeples of 
     * of the city
     * 
     * @return the number of meeples
     */
    public ArrayList<Meeples> getMeeples(){
        return meeple;
    }

    /**
     * accessor method for meeples of 
     * of the city
     * 
     * @return the number of meeples
     */
    public int getMeeple(){
        return numMeeples;
    }

    /**
     * remove a meeple
     * @param Meeple to remove
     */
    public void removeMeeple(Meeples m){
        meeple.remove(m); 
        numMeeples--;
    }
}
