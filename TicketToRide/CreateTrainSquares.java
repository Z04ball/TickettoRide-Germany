import java.awt.*;
import javax.swing.*;
/**
 * creates train square objects for 
 * drawing each rectangle when a
 * route is captured
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class CreateTrainSquares{

    ////////////////////////////////////////////////////////////
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected int x3;
    protected int y3;
    protected int x4;
    protected int y4;
    protected Color Col;
    protected int x[];
    protected int y[];
    protected int numPoints;
    /**
     * creates each train square on the board 
     * 
     * @param x1 the first corner's x coord
     * @param y1 the first corner's y coord
     * @param x2 the second corner's x coord
     * @param y2 the second corner's y coord
     * @param x3 the third corner's x coord
     * @param y3 the third corner's y coord
     * @param x4 the fourth corner's x coord
     * @param y4 the fourth corner's y coord
     */
    public CreateTrainSquares(int x1, 
    int y1, int x2, int y2, int x3, int y3, 
    int x4, int y4){
        x = new int[]{x1, x2, x3, x4};
        y = new int[]{y1, y2, y3, y4};
        numPoints = 4;

    }

}
