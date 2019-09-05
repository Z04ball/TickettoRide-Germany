import java.nio.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Class that represents the 
 * destination panel on screen
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class DestinationPanel extends JPanel
{
    private LongDestinationDeck longDestinationDeck;
    private ShortDestinationDeck shortDestinationDeck;
    private ArrayList<DestinationCard> cards;
    /**
     * Constructor for objects of class DestinationPanel
     */
    public DestinationPanel()
    {
        setPreferredSize(new Dimension(640,460));
        setBackground(Color.black);

        longDestinationDeck = new 
        LongDestinationDeck();
        shortDestinationDeck = new 
        ShortDestinationDeck();
        cards = new ArrayList
        <DestinationCard>(4);

        JLabel longDeck = new JLabel
            (new ImageIcon(new File(
                        "TicketsResized/tealticket.jpg")
                    .getAbsolutePath()));
        longDeck.addMouseListener
            ////////////////////////////////////////////////////////////
        (new MouseAdapter(){
                /**
                 * mouse clicked method for 
                 * when the player clicks 
                 * in the panel
                 * 
                 * @param e the mouse event
                 */
                public void mouseClicked
                (MouseEvent e){
                    // if(cardsDrawn < 2){
                    // userNames.get
                    //(currentPlayerNumber)
                    //.addTrain(trainDeck.pop());
                    // cardsDrawn++;
                    // runTurns();
                    // }
                    if(cards.size() < 4){
                        DestinationCard temp = 
                            longDestinationDeck.
                            pullCard();
                        cards.add(temp);
                        Destination d1 = 
                            temp.getStart();
                        Destination d2 = 
                            temp.getEnd();
                        String dest1 = 
                            d1.toString().
                            toLowerCase();
                        String dest2 = 
                            d2.toString().
                            toLowerCase();
                        String pathName = 
                            "pics/de-" + dest1 
                            + "-" + dest2 +
                            "-small.png";
                        //File f = new File
                        //(pathName);
                        JLabel card = new 
                            JLabel(new ImageIcon
                                (pathName));
                        add(card);
                        repaint();
                        revalidate();
                    }
                }
            });
        add(longDeck);
            ////////////////////////////////////////////////////////////
        JLabel shortDeck = new 
            JLabel(new ImageIcon(         
                    new File(
                        "TicketsResized/yellowticket6.jpg"
                        ).getAbsolutePath()));
                        shortDeck.addMouseListener(
                        new MouseAdapter(){
                /**
                 * mouse clicked method for 
                 * when the player clicks in the panel
                 * 
                 * @param e the mouse event
                 */
                public void mouseClicked(MouseEvent e){
                    // if(cardsDrawn < 2){
                    // userNames.get(currentPlayerNumber
                    //).addTrain(trainDeck.pop());
                    // cardsDrawn++;
                    // runTurns();
                    // }
                    if(cards.size() < 4){
                        DestinationCard temp = 
                        shortDestinationDeck.pullCard();
                        cards.add(temp);
                        Destination d1 = temp.getStart();
                        Destination d2 = temp.getEnd();
                        String dest1 = d1.toString().
                        toLowerCase();
                        String dest2 = d2.toString().
                        toLowerCase();
                        String pathName = "pics/de-" +
                        dest1 + "-" + dest2 +
                            "-small.png";
                        //File f = new File(pathName);
                        JLabel card = new JLabel(new 
                        ImageIcon(pathName));
                        add(card);
                        repaint();
                        revalidate();
                    }
                }
            });
        add(shortDeck);

    }

}
