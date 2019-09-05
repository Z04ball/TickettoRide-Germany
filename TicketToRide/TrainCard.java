import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Class that will create the train cards
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class TrainCard
{
    // instance variables - replace the example below with your own
    private TrainColor color;
    private ImageIcon image;
    private int x;
    private int y;

    /**
     * constructs the train cards
     * 
     * @param color the color for the train card
     */
    public TrainCard(TrainColor color){
        this.color = color;
        image = setImage(getTrainColor(color));
    }
    
    /**
     * gets the String for the picture of the train
     * 
     * @param color the color of the train
     * @return the String of the trains file name
     * 
     */
    public String getTrainColor(TrainColor color){
        String retval = "";
        if(color == TrainColor.white){
            retval = "trains/white.png";
        }
        if(color == TrainColor.black){
            retval = "trains/black.png";
        }
        if(color == TrainColor.blue){
            retval = "trains/blue.png";
        }
        if(color == TrainColor.green){
            retval = "trains/green.png";
        }
        if(color == TrainColor.red){
            retval = "trains/red.png";
        }
        if(color == TrainColor.purple){
            retval = "trains/purple.png";
        }
        if(color == TrainColor.rainbow){
            retval = "trains/rainbow.png";
        }
        if(color == TrainColor.orange){
            retval = "trains/orange.png";
        }
        if(color == TrainColor.yellow){
            retval = "trains/yellow.png";
        }
        return retval;
    }

    /**
     * sets the image to the given value
     * 
     * @param s the image to use
     * @return the image 
     */
    public ImageIcon setImage(String s){
        ImageIcon temp = null;
        try{
            //temp = (ImageIO.read(new File(s)));
            temp = new ImageIcon(new File(s)
            .getAbsolutePath());

        }
        catch(Exception e){
            System.err.println("Error reading "+
            "in file " + s);
        }
        return temp;

    }

    /**
     * gets the Train color
     * 
     * @return the train color
     */
    public TrainColor getColor(){
        return this.color;
    }

    /**
     * gets the image used
     * 
     * @return the image being used
     */
    public ImageIcon getImage(){
        return image;
    }

}