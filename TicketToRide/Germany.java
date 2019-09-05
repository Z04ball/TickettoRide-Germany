import static java.awt.Color.*;
import java.util.Stack;
import java.util.ArrayList;
/**
 * creates nodes for each city
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class Germany{
    private LocationNode[] germany;
    /**
     * Constructor which creates each node
     * 
     * @param connections true if the city has
     * connections 
     * false if no connections to other cities
     * @param numOfPlayers keeps track of 
     * how many users are playing
     */
    ////////////////////////////////////////////////////////////
    public Germany(boolean connections, int numOfPlayers){
        germany = new LocationNode[41];
        LocationNode Danemark = new LocationNode
            (Destination.Danemark, 2, Destination.
                Danemark.getMeeple());
        Danemark.changeEllipse(Destination.
            Danemark.getX() - 30, Destination.
            Danemark.getY() - 35, 67);
        germany[0] = Danemark;
        LocationNode Kiel = new LocationNode
            (Destination.Kiel, 6, Destination.
                Kiel.getMeeple());
        germany[1] = Kiel;
        LocationNode Rostock = new LocationNode
            (Destination.Rostock, 3, Destination
                .Rostock.getMeeple());
        germany[2] = Rostock;
        LocationNode Schwerin = new LocationNode
            (Destination.Schwerin, 4, Destination.
                Schwerin.getMeeple());
        germany[3] = Schwerin;
        LocationNode Hamburg = new LocationNode
            (Destination.Hamburg, 9, Destination.
                Hamburg.getMeeple());
        germany[4] = Hamburg;
        LocationNode Bremerhaven = new LocationNode
            (Destination.Bremerhaven, 5, Destination.
                Bremerhaven.getMeeple());
        germany[5] = Bremerhaven;
        LocationNode Emden = new LocationNode
            (Destination.Emden, 4, Destination.
                Emden.getMeeple());
        germany[6] = Emden;
        LocationNode Bremen = new LocationNode
            (Destination.Bremen, 5, Destination
                .Bremen.getMeeple());
        germany[7] = Bremen;
        LocationNode Hannover = new LocationNode
            (Destination.Hannover, 10, Destination.
                Hannover.getMeeple());
        germany[8] = Hannover;
        LocationNode Berlin = new LocationNode
            (Destination.Berlin, 8, Destination.
                Berlin.getMeeple());
        germany[9] = Berlin;
        LocationNode Magdeburg = new LocationNode
            (Destination.Magdeburg, 3, Destination.
                Magdeburg.getMeeple());
        germany[10] = Magdeburg;
        LocationNode Munster = new LocationNode
            (Destination.Munster, 6, Destination.
                Munster.getMeeple());
        germany[11] = Munster;
        LocationNode Niederland = new LocationNode
            (Destination.Niederland, 3, Destination.
                Niederland.getMeeple());
        Niederland.changeEllipse(Destination.
            Niederland.getX()-40, Destination.
            Niederland.getY()-40, 85);
        germany[12] = Niederland;
        LocationNode Dortmund = new LocationNode
            (Destination.Dortmund, 6, Destination.
                Dortmund.getMeeple());
        germany[13] = Dortmund;
        LocationNode Dusseldorf = new LocationNode
            (Destination.Dusseldorf, 7, Destination.
                Dusseldorf.getMeeple());
        germany[14] = Dusseldorf;
        LocationNode Kassel = new LocationNode
            (Destination.Kassel, 6, Destination.
                Kassel.getMeeple());
        germany[15] = Kassel;
        LocationNode Erfurt = new LocationNode
            (Destination.Erfurt, 8, Destination.
                Erfurt.getMeeple());
        germany[16] = Erfurt;
        LocationNode Leipzig = new LocationNode
            (Destination.Leipzig, 5, Destination.
                Leipzig.getMeeple());
        germany[17] = Leipzig;
        LocationNode Dresden = new LocationNode
            (Destination.Dresden, 4, Destination.
                Dresden.getMeeple());
        germany[18] = Dresden;
        LocationNode Chemnitz = new LocationNode
            (Destination.Chemnitz, 4, Destination.
                Chemnitz.getMeeple());
        germany[19] = Chemnitz;
        LocationNode Frankfurt = new LocationNode
            (Destination.Frankfurt, 10, Destination.
                Frankfurt.getMeeple());
        germany[20] = Frankfurt;
        LocationNode Koln = new LocationNode
            (Destination.Koln, 7, Destination.
                Koln.getMeeple());
        germany[21] = Koln;
        LocationNode Koblenz = new LocationNode
            (Destination.Koblenz, 5, Destination
                .Koblenz.getMeeple());
        germany[22] = Koblenz;
        LocationNode Mainz = new LocationNode
            (Destination.Mainz, 9, Destination.
                Mainz.getMeeple());
        germany[23] = Mainz;
        LocationNode Wurzburg = new LocationNode
            (Destination.Wurzburg, 4, Destination
                .Wurzburg.getMeeple());
        germany[24] = Wurzburg;
        LocationNode Nurnberg = new LocationNode
            (Destination.Nurnberg, 8, Destination.
                Nurnberg.getMeeple());
        germany[25] = Nurnberg;
        LocationNode Regensburg = new LocationNode
            (Destination.Regensburg, 6, Destination
                .Regensburg.getMeeple());
        germany[26] = Regensburg;
        LocationNode Munchen = new LocationNode
            (Destination.Munchen, 7, Destination
                .Munchen.getMeeple());
        germany[27] = Munchen;
        LocationNode Lindau = new LocationNode
            (Destination.Lindau, 5, Destination.
                Lindau.getMeeple());
        germany[28] = Lindau;
        LocationNode Konstanz = new LocationNode
            (Destination.Konstanz, 4, Destination
                .Konstanz.getMeeple());
        germany[29] = Konstanz;
        LocationNode Ulm = new LocationNode
            (Destination.Ulm, 5, Destination.
                Ulm.getMeeple());
        germany[30] = Ulm;
        LocationNode Augsburg = new LocationNode
            (Destination.Augsburg, 5, Destination.
                Augsburg.getMeeple());
        germany[31] = Augsburg;
        LocationNode Freiburg = new LocationNode
            (Destination.Freiburg, 5, Destination.
                Freiburg.getMeeple());
        germany[32] = Freiburg;
        LocationNode Karlsruhe = new LocationNode
            (Destination.Karlsruhe, 5, Destination.
                Karlsruhe.getMeeple());
        germany[33] = Karlsruhe;
        LocationNode Saarbrucken = new LocationNode
            (Destination.Saarbrucken, 5, Destination.
                Saarbrucken.getMeeple());
        germany[34] = Saarbrucken;
        LocationNode Mannheim = new LocationNode
            (Destination.Mannheim, 8, Destination
                .Mannheim.getMeeple());
        germany[35] = Mannheim;
        LocationNode Stuttgart = new LocationNode
            (Destination.Stuttgart, 7, Destination.
                Stuttgart.getMeeple());
        germany[36] = Stuttgart;
        LocationNode Frankreich = new LocationNode
            (Destination.Frankreich, 3, Destination.
                Frankreich.getMeeple());
        Frankreich.changeEllipse(Destination.Frankreich
            .getX() - 47, Destination.Frankreich.getY()-47, 100);
        germany[37] = Frankreich;
        LocationNode Schweiz = new LocationNode
            (Destination.Schweiz, 3, Destination
                .Schweiz.getMeeple());
        Schweiz.changeEllipse(Destination.Schweiz.
            getX() - 40, Destination.Schweiz.getY() - 46, 75);
        germany[38] = Schweiz;
        LocationNode OsterreichEast = new LocationNode
            (Destination.OsterreichEast, 2, Destination
                .OsterreichEast.getMeeple());
        OsterreichEast.changeEllipse(Destination
            .OsterreichEast.getX()-50, Destination.
            OsterreichEast.getY()-50, 100);
        germany[39] = OsterreichEast;
        LocationNode OsterreichWest = 
            new LocationNode(Destination.
                OsterreichWest, 1, Destination.
                OsterreichWest.getMeeple());
        OsterreichWest.changeEllipse( Destination.
            OsterreichWest.getX()-25, Destination.
            OsterreichWest.getY()-20, 50);
        germany[40] = OsterreichWest;
        ////////////////////////////////////////////////////////////
        if(connections)
        {


            //Danemark
            Danemark.addLocation(Bremerhaven, GREEN, 5);
            Danemark.addLocation(Kiel, GRAY, 2);
            //Bremerhaven
            Bremerhaven.addLocation(Danemark, GREEN, 5);
            Bremerhaven.addLocation(Kiel, GRAY, 3);
            Bremerhaven.addLocation(Hamburg, GRAY, 3);
            Bremerhaven.addLocation(Bremen, WHITE, 1);
            Bremerhaven.addLocation(Emden, GRAY, 3);
            //Kiel
            Kiel.addLocation(Danemark,GRAY,2);
            Kiel.addLocation(Rostock,ORANGE,4);
            Kiel.addLocation(Schwerin,YELLOW,3);
            Kiel.addLocation(Hamburg,PINK,2);
            
            Kiel.addLocation(Hamburg,BLACK,2);
            
            Kiel.addLocation(Bremerhaven,GRAY,3);
            //Rostock
            Rostock.addLocation(Kiel,ORANGE,4);
            Rostock.addLocation(Schwerin,RED,2);
            Rostock.addLocation(Berlin,PINK,6);
            //Schwerin
            Schwerin.addLocation(Rostock, RED, 2);
            Schwerin.addLocation(Berlin, WHITE, 5);
            Schwerin.addLocation(Hamburg, GREEN, 2);
            Schwerin.addLocation(Kiel, YELLOW, 3);
            //Hamburg
            Hamburg.addLocation(Kiel, PINK, 2);

                Hamburg.addLocation(Kiel, BLACK, 2);
            
            Hamburg.addLocation(Schwerin, GREEN, 2);
            Hamburg.addLocation(Berlin, BLUE, 7);
            //if(numOfPlayers >= 4)
                Hamburg.addLocation(Berlin, YELLOW, 7);
            Hamburg.addLocation(Hannover, WHITE, 4);
            //if(numOfPlayers >= 4)
                Hamburg.addLocation(Hannover, RED, 4);
            Hamburg.addLocation(Bremen, 
                ORANGE, 3);
            ////////////////////////////////////////////////////////////
            Hamburg.addLocation(Bremerhaven,
                GRAY, 3);
            //Emden
            Emden.addLocation(Bremerhaven,
                GRAY, 3);
            Emden.addLocation(Bremen, BLUE, 3);
            Emden.addLocation(Munster, RED, 4);
            Emden.addLocation(Niederland, 
                WHITE, 2);
            //Bremen
            Bremen.addLocation(Bremerhaven,
                WHITE, 1);
            Bremen.addLocation(Hamburg, 
                ORANGE, 3);
            Bremen.addLocation(Hannover, 
                YELLOW, 3);
            Bremen.addLocation(Munster, 
                BLACK, 3);
            Bremen.addLocation(Emden, BLUE, 3);
            //Niederland
            Niederland.addLocation(Emden,
                WHITE, 2);
            Niederland.addLocation(Munster, 
                ORANGE, 2);
            Niederland.addLocation(Dusseldorf, 
                PINK, 3);
            //Munster
            Munster.addLocation(Emden, RED, 4);
            Munster.addLocation(Bremen, 
                BLACK, 3);
            Munster.addLocation(Hannover, 
                PINK, 4);
            Munster.addLocation(Dortmund, GRAY, 1);
            //if(numOfPlayers >= 4)
                Munster.addLocation(Dortmund, GRAY, 1);
            Munster.addLocation(Niederland, ORANGE, 2);
            //Hannover
            ////////////////////////////////////////////////////////////
            Hannover.addLocation(Hamburg, RED, 4);
            //if(numOfPlayers >= 4)
                Hannover.addLocation(Hamburg, WHITE, 4);
            Hannover.addLocation(Berlin, BLACK, 7);
            Hannover.addLocation(Magdeburg, BLUE, 4);
            Hannover.addLocation(Erfurt, GREEN, 5);
            //if(numOfPlayers >= 4)
                Hannover.addLocation(Erfurt, ORANGE, 5);
            Hannover.addLocation(Kassel, GRAY, 3);  
            //if(numOfPlayers >= 4)
                Hannover.addLocation(Kassel, GRAY, 3);
            Hannover.addLocation(Munster, PINK, 4);
            Hannover.addLocation(Bremen, YELLOW, 3);
            //Berlin
            Berlin.addLocation(Rostock, PINK, 6);
            Berlin.addLocation(Dresden, GREEN, 5);
            Berlin.addLocation(Leipzig, ORANGE, 4);
            Berlin.addLocation(Magdeburg, RED, 3);
            Berlin.addLocation(Hamburg, YELLOW, 7);
            //if(numOfPlayers >= 4)
                Berlin.addLocation(Hamburg, BLUE, 7);
            Berlin.addLocation(Schwerin, WHITE, 5);
            //Magdeburg
            Magdeburg.addLocation(Berlin, RED, 3);
            Magdeburg.addLocation(Leipzig, YELLOW, 2);
            Magdeburg.addLocation(Hannover, BLUE, 4);
            //Leipzig
            Leipzig.addLocation(Magdeburg, YELLOW, 2);
            Leipzig.addLocation(Berlin, ORANGE, 4);
            Leipzig.addLocation(Dresden, BLACK, 3);
            Leipzig.addLocation(Chemnitz, BLUE, 2);
            Leipzig.addLocation(Erfurt, RED, 3);
            Dresden.addLocation(Berlin, GREEN, 5);
            Dresden.addLocation(Regensburg, RED, 7);
            Dresden.addLocation(Chemnitz, YELLOW, 1);
            Dresden.addLocation(Leipzig, BLACK, 3);

            //Chemnitz
            Chemnitz.addLocation(Dresden, YELLOW, 1);
            Chemnitz.addLocation(Regensburg, PINK, 6);
            Chemnitz.addLocation(Erfurt, BLACK, 4);
            Chemnitz.addLocation(Leipzig, BLUE, 2);
            ////////////////////////////////////////////////////////////
            //Erfurt
            Erfurt.addLocation(Leipzig, RED, 3);
            Erfurt.addLocation(Chemnitz, BLACK, 4);
            Erfurt.addLocation(Regensburg, WHITE, 7);
            Erfurt.addLocation(Nurnberg, PINK, 4);
            //if(numOfPlayers >= 4)
                Erfurt.addLocation(Nurnberg, YELLOW, 4);
            Erfurt.addLocation(Kassel, GRAY, 3);
            Erfurt.addLocation(Hannover, ORANGE, 5);
            //if(numOfPlayers >= 4)
                Erfurt.addLocation(Hannover, GREEN, 5);

            //Kassel
            Kassel.addLocation(Hannover, GRAY, 3);
            //if(numOfPlayers >= 4)
                Kassel.addLocation(Hannover, GRAY, 3);
            Kassel.addLocation(Erfurt, GRAY, 3);
            Kassel.addLocation(Frankfurt, WHITE, 4);
            //if(numOfPlayers >= 4)
                Kassel.addLocation(Frankfurt, BLUE, 4);
            Kassel.addLocation(Dortmund, GREEN, 4);

            //Dortmund
            Dortmund.addLocation(Munster, GRAY, 1);
            //if(numOfPlayers >= 4)
                Dortmund.addLocation(Munster, GRAY, 1);
            Dortmund.addLocation(Kassel, GREEN, 4);
            Dortmund.addLocation(Dusseldorf, GRAY, 1);
            //if(numOfPlayers >= 4){
                Dortmund.addLocation(Dusseldorf, GRAY, 1);
                Dortmund.addLocation(Dusseldorf, GRAY, 1);
            //}
            ////////////////////////////////////////////////////////////
            //Dusseldorf 
            Dusseldorf.addLocation(Dortmund, GRAY, 1);
            //if(numOfPlayers >= 4){
                Dusseldorf.addLocation(Dortmund, GRAY, 1);
                Dusseldorf.addLocation(Dortmund, GRAY, 1);
            //}
            Dusseldorf.addLocation(Koln, GRAY, 1);
            //if(numOfPlayers >= 4){
                Dusseldorf.addLocation(Koln, GRAY, 1);
                Dusseldorf.addLocation(Koln, GRAY, 1);
            //}
            Dusseldorf.addLocation(Niederland, PINK, 3);

            //Koln
            Koln.addLocation(Dusseldorf, GRAY, 1);
            //if(numOfPlayers >= 4){
                Koln.addLocation(Dusseldorf, GRAY, 1);
                Koln.addLocation(Dusseldorf, GRAY, 1);
            //}
            Koln.addLocation(Frankfurt, GRAY, 4);
            //if(numOfPlayers >= 4)
                Koln.addLocation(Frankfurt, GRAY, 4);
            Koln.addLocation(Koblenz, GRAY, 1);
            //if(numOfPlayers >= 4)
                Koln.addLocation(Koblenz, GRAY, 1);
            ////////////////////////////////////////////////////////////
            //Frankfurt
            Frankfurt.addLocation(Kassel, BLUE, 4);
            //if(numOfPlayers >= 4)
                Frankfurt.addLocation(Kassel, WHITE, 4);
            Frankfurt.addLocation(Wurzburg, GRAY, 2);
            //if(numOfPlayers >= 4)
                Frankfurt.addLocation(Wurzburg, GRAY, 2);
            Frankfurt.addLocation(Mannheim, GRAY, 2);
            //if(numOfPlayers >= 4)
                Frankfurt.addLocation(Mannheim, GRAY, 2);
            Frankfurt.addLocation(Mainz, GRAY, 1);
            //if(numOfPlayers >= 4)
                Frankfurt.addLocation(Mainz, GRAY, 1);
            Frankfurt.addLocation(Koln, GRAY, 4);
            //if(numOfPlayers >= 4)
                Frankfurt.addLocation(Koln, GRAY, 4);

            //Wurzburg
            Wurzburg.addLocation(Nurnberg, GRAY, 2);
            //if(numOfPlayers >= 4)
                Wurzburg.addLocation(Nurnberg, GRAY, 2);
            Wurzburg.addLocation(Frankfurt, GRAY, 2);
            //if(numOfPlayers >= 4)
                Wurzburg.addLocation(Frankfurt, GRAY, 2);
            ////////////////////////////////////////////////////////////
            //Nurnberg
            Nurnberg.addLocation(Erfurt, YELLOW, 4);
            //if(numOfPlayers >= 4)
                Nurnberg.addLocation(Erfurt, PINK, 4);
            Nurnberg.addLocation(Regensburg, GREEN, 3);
            Nurnberg.addLocation(Munchen, BLACK, 5);
            //if(numOfPlayers >= 4)
                Nurnberg.addLocation(Munchen, BLUE, 5);
            Nurnberg.addLocation(Augsburg, ORANGE, 4);
            Nurnberg.addLocation(Wurzburg, GRAY, 2);
            //if(numOfPlayers >= 4)
                Nurnberg.addLocation(Wurzburg, GRAY, 2);

            //Mainz
            Mainz.addLocation(Frankfurt, GRAY, 1);
            //if(numOfPlayers >= 4)
                Mainz.addLocation(Frankfurt, GRAY, 1);
            Mainz.addLocation(Mannheim, GRAY, 1);
            //if(numOfPlayers >= 4)
                Mainz.addLocation(Mannheim, GRAY, 1);
            Mainz.addLocation(Saarbrucken, GRAY, 3);
            Mainz.addLocation(Koblenz, GRAY, 2);
            //if(numOfPlayers >= 4)
                Mainz.addLocation(Koblenz, GRAY, 2);
            ////////////////////////////////////////////////////////////
            //Mannheim
            Mannheim.addLocation(Frankfurt, GRAY, 2);
            //if(numOfPlayers >= 4)
                Mannheim.addLocation(Frankfurt, GRAY, 2);
            Mannheim.addLocation(Stuttgart, GRAY, 2);
            //if(numOfPlayers>=4)
                Mannheim.addLocation(Stuttgart, GRAY, 2);
            Mannheim.addLocation(Karlsruhe, BLUE, 1);
            Mannheim.addLocation(Saarbrucken, GRAY, 3);
            Mannheim.addLocation(Mainz, GRAY, 1);
            //if(numOfPlayers >= 4)
                Mannheim.addLocation(Mainz, GRAY, 1);

            //Regensburg
            Regensburg.addLocation(Chemnitz, PINK, 6);
            Regensburg.addLocation(Dresden, RED, 7);
            Regensburg.addLocation(OsterreichEast, 
                YELLOW, 4);
            Regensburg.addLocation(Munchen, ORANGE, 3);
            Regensburg.addLocation(Nurnberg, GREEN, 3);
            Regensburg.addLocation(Erfurt, WHITE, 7);

            //Saarbrucken
            Saarbrucken.addLocation(Koblenz, GRAY, 3);
            Saarbrucken.addLocation(Mainz, GRAY, 3);
            Saarbrucken.addLocation(Mannheim, GRAY, 3);
            Saarbrucken.addLocation(Karlsruhe, GRAY, 3);
            Saarbrucken.addLocation(Frankreich, GREEN, 1);

            //Karlsruhe 
            Karlsruhe.addLocation(Mannheim, BLUE, 1);
            Karlsruhe.addLocation(Stuttgart, PINK, 1);
            Karlsruhe.addLocation(Freiburg, WHITE, 3);
            Karlsruhe.addLocation(Frankreich, BLACK, 2);
            Karlsruhe.addLocation(Saarbrucken, GRAY, 3);
            ////////////////////////////////////////////////////////////
            //Stuttgart
            Stuttgart.addLocation(Ulm, GRAY, 2);
            //if(numOfPlayers >= 4){
                Stuttgart.addLocation(Ulm, GRAY, 2);
            //}
            Stuttgart.addLocation(Konstanz, GREEN, 3);
            Stuttgart.addLocation(Freiburg, GRAY, 3);
            Stuttgart.addLocation(Karlsruhe, PINK, 1);
            Stuttgart.addLocation(Mannheim, GRAY, 2);
            //if(numOfPlayers >= 4){
                Stuttgart.addLocation(Mannheim, GRAY, 2);
            //}

            //Ulm
            Ulm.addLocation(Augsburg, GRAY, 1);
            //if(numOfPlayers >= 4){
                Ulm.addLocation(Augsburg, GRAY, 1);
            //}
            Ulm.addLocation(Lindau, RED, 2);
            Ulm.addLocation(Stuttgart, GRAY, 2);
            //if(numOfPlayers >= 4){
                Ulm.addLocation(Stuttgart, GRAY, 2);
            //}

            //Augsburg
            Augsburg.addLocation(Nurnberg, ORANGE, 4);
            Augsburg.addLocation(Munchen, GRAY, 2);
            //if(numOfPlayers >= 4){
                Augsburg.addLocation(Munchen, GRAY, 2);
            //}
            Augsburg.addLocation(Ulm, GRAY, 1);
            //if(numOfPlayers >= 4){
                Augsburg.addLocation(Ulm, GRAY, 1);
            //}
            ////////////////////////////////////////////////////////////
            //Munchen
            Munchen.addLocation(Regensburg, ORANGE, 3);
            Munchen.addLocation(OsterreichEast, RED, 3);
            Munchen.addLocation(Lindau, GRAY, 5);
            Munchen.addLocation(Augsburg,GRAY,2);
            //if(numOfPlayers >= 4){
                Munchen.addLocation(Augsburg,GRAY,2);
            //}
            Munchen.addLocation(Nurnberg, BLUE, 5);
            //if(numOfPlayers >= 4){
                Munchen.addLocation(Nurnberg, BLACK, 5);
            //}

            //Frankreich
            Frankreich.addLocation(Saarbrucken, GREEN, 1);
            Frankreich.addLocation(Karlsruhe, BLACK, 2);
            Frankreich.addLocation(Freiburg, YELLOW, 2);

            //Schweiz
            Schweiz.addLocation(Konstanz, WHITE, 1);
            Schweiz.addLocation(Lindau, BLUE, 2);
            Schweiz.addLocation(Freiburg, ORANGE, 2);

            //Osterreich
            OsterreichEast.addLocation(Regensburg, 
                YELLOW, 4);
            OsterreichWest.addLocation(Lindau, PINK, 2);
            OsterreichEast.addLocation(Munchen, RED, 3);
            ////////////////////////////////////////////////////////////
            //Lindau
            Lindau.addLocation(Munchen, GRAY, 5);
            Lindau.addLocation(OsterreichWest, PINK, 2);
            Lindau.addLocation(Schweiz, BLUE, 2);
            Lindau.addLocation(Konstanz, YELLOW, 1);
            Lindau.addLocation(Ulm, RED, 2);
        }
    }

    /**
     * gets the locaation node array that is created above
     * 
     * @return an array of location nodes 
     */
    public LocationNode[] getGermany(){
        return germany;
    }

}
