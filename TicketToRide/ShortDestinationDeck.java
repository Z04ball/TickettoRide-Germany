import java.util.*;
/**
 * Class that represents the 
 * deck of destination cards
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class ShortDestinationDeck
{
    public List<DestinationCard> deck = new LinkedList<DestinationCard>();
    final String SHORT = "Short";
    private int count;
    /**
     * Constructor for objects of class ShortDestinationDeck
     */
    public ShortDestinationDeck()
    {
        deck.add(new DestinationCard(Destination.Berlin,
                Destination.Chemnitz, SHORT, 6));
        deck.add(new DestinationCard(Destination.Bremen,
                Destination.Berlin, SHORT, 10));
        deck.add(new DestinationCard(Destination.Berlin,
                Destination.Dusseldorf, SHORT, 5));
        deck.add(new DestinationCard(Destination.Bremen, 
                Destination.Kassel, SHORT, 6));
        deck.add(new DestinationCard(Destination.Danemark,
                Destination.Niederland, SHORT, 10));
        deck.add(new DestinationCard(Destination.Dortmund,
                Destination.Erfurt, SHORT, 7));
        deck.add(new DestinationCard(Destination.Dortmund,
                Destination.Magdeburg, SHORT, 9));
        deck.add(new DestinationCard(Destination.Dortmund, 
                Destination.Mannheim, SHORT, 6));
        deck.add(new DestinationCard(Destination.Erfurt,
                Destination.Wurzburg, SHORT, 6));
        deck.add(new DestinationCard(Destination.Frankfurt,
                Destination.Lindau, SHORT, 8));
        deck.add(new DestinationCard(Destination.Frankfurt,
                Destination.Munchen, SHORT, 9));
        // need to check both east and west
        deck.add(new DestinationCard(Destination.Frankfurt,
                Destination.Osterreich, SHORT, 10)); 
        deck.add(new DestinationCard(Destination.Frankreich,
                Destination.Munchen, SHORT, 8)); 

        deck.add(new DestinationCard(Destination.Hamburg, 
                Destination.Koln, SHORT, 9));
        deck.add(new DestinationCard(Destination.Hamburg,
                Destination.Rostock, SHORT, 4));
        deck.add(new DestinationCard(Destination.Hannover, 
                Destination.Leipzig, SHORT, 6));
        deck.add(new DestinationCard(Destination.Hannover,
                Destination.Saarbrucken, SHORT, 11));
        deck.add(new DestinationCard(Destination.Karlsruhe, 
                Destination.Augsburg, SHORT, 4));
        deck.add(new DestinationCard(Destination.Karlsruhe, 
                Destination.Regensburg, SHORT, 9));
        deck.add(new DestinationCard(Destination.Kassel,
                Destination.Freiburg, SHORT, 10));
        deck.add(new DestinationCard(Destination.Koblenz,
                Destination.Ulm, SHORT, 7));
        deck.add(new DestinationCard(Destination.Koln,
                Destination.Nurnberg, SHORT, 8));
        deck.add(new DestinationCard(Destination.Koln,
                Destination.Schweiz, SHORT, 10));
        deck.add(new DestinationCard(Destination.Koln, 
                Destination.Stuttgart, SHORT, 6));
        deck.add(new DestinationCard(Destination.Leipzig,
                Destination.Nurnberg, SHORT, 7));
        deck.add(new DestinationCard(Destination.Mainz,
                Destination.Stuttgart, SHORT, 3));
        deck.add(new DestinationCard(Destination.Mannheim,
                Destination.Wurzburg, SHORT, 4));
        deck.add(new DestinationCard(Destination.Munster, 
                Destination.Stuttgart, SHORT, 9));
        // deck.add(new DestinationCard(Destination
        //.Niederland, Destination.Berlin, "LONG", 13));
        deck.add(new DestinationCard(Destination.Niederland,
                Destination.Frankfurt, SHORT, 8));
        deck.add(new DestinationCard(Destination.Niederland,
                Destination.Karlsruhe, SHORT, 9));
        deck.add(new DestinationCard(Destination.Nurnberg,
                Destination.Stuttgart, SHORT, 7));
        deck.add(new DestinationCard(Destination.Hamburg,
                Destination.Frankfurt, SHORT, 10));
        count = 0;
        
        
        Collections.shuffle(deck);
    }

     /**
     * method involving removing a card from the deck
     * 
     * @return the destination card that is removed
     */
    public DestinationCard pullCard(){
        return deck.remove(0);
    }
    
    /**
     * method that adds a card to the deck
     * 
     * @param the card that is 
     *      added to the deck
     */
    public void putCardOnBottom(DestinationCard d){
        deck.add(d);
        count++;
        if(count % deck.size() == 0){
            Collections.shuffle(deck); 
            // every card has been discarded to bottom
        }
    }
}
