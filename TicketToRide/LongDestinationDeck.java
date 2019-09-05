import java.util.*;
////////////////////////////////////////////////////////////
/**
 * Long destination deck class for the destination cards 
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class LongDestinationDeck
{

    public List<DestinationCard> deck = new 
        LinkedList<DestinationCard>();
    final String LONG = "Long";
    private int count; 
    // keep track of number of times
    // cards are recycled

    /**
     * Constructor for objects of class 
     * LONGDestinationDeck
     */
    public LongDestinationDeck()
    {
        deck.add(new DestinationCard
            (Destination.Berlin,
                Destination.Dusseldorf, LONG, 13));
        deck.add(new DestinationCard
            (Destination.Berlin,
                Destination.Frankfurt, LONG, 14));
        deck.add(new DestinationCard
            (Destination.Berlin,
                Destination.Mainz, LONG, 15));
        deck.add(new DestinationCard
            (Destination.Berlin,
                Destination.Munchen, LONG, 15));
        deck.add(new DestinationCard
            (Destination.Berlin,
                Destination.Schweiz, LONG, 20));

        
        deck.add(new DestinationCard
            (Destination.Bremerhaven,
                Destination.Frankreich, LONG, 12));
        deck.add(new DestinationCard
            (Destination.Bremerhaven,
                Destination.Regensburg, LONG, 16));

        deck.add(new DestinationCard
            (Destination.Danemark,
                Destination.Lindau, LONG, 22));
        deck.add(new DestinationCard
            (Destination.Danemark,
                Destination.Regensburg, LONG, 20));

        deck.add(new DestinationCard
            (Destination.Dortmund,
                Destination.Munchen, LONG, 13));

        deck.add(new DestinationCard
            (Destination.Dresden, 
                Destination.Augsburg, LONG, 12));
        deck.add(new DestinationCard(Destination.Dresden, 
                Destination.Saarbrucken, LONG, 16));

        
        deck.add(new DestinationCard
            (Destination.Emden, 
                Destination.Freiburg, LONG, 15));
        ///// need both east / west
        deck.add(new DestinationCard
            (Destination.Emden, 
                Destination.Osterreich, LONG, 15));

        deck.add(new DestinationCard
            (Destination.Frankreich,
                Destination.Danemark, LONG, 17)); 
        deck.add(new DestinationCard
            (Destination.Frankreich,
                Destination.Leipzig, LONG, 15)); 

        deck.add(new DestinationCard
            (Destination.Hamburg,
                Destination.Dresden, LONG, 12));
        deck.add(new DestinationCard
            (Destination.Hamburg, 
                Destination.Munchen, LONG, 18));
        deck.add(new DestinationCard
            (Destination.Hamburg,
                Destination.Stuttgart, LONG, 15));

       
        deck.add(new DestinationCard
            (Destination.Kiel,
                Destination.Nurnberg, LONG, 15));
        deck.add(new DestinationCard
            (Destination.Kiel,
                Destination.Schweiz, LONG, 20));

        deck.add(new DestinationCard
            (Destination.Koln,
                Destination.Leipzig, LONG, 12));

        deck.add(new DestinationCard(Destination.Leipzig,
                Destination.Ulm, LONG, 12));

        deck.add(new DestinationCard
            (Destination.Munster, 
                Destination.Munchen, LONG, 14));
        //// check east and west //////
        deck.add(new DestinationCard
            (Destination.Munster, 
                Destination.Osterreich, LONG, 14));

        deck.add(new DestinationCard
            (Destination.Niederland,
                Destination.Berlin, LONG , 13));

        deck.add(new DestinationCard
            (Destination.Rostock,
                Destination.Konstanz, LONG, 22));
        /// have to check east and west
        deck.add(new DestinationCard
            (Destination.Rostock,
                Destination.Osterreich, LONG, 22));

        deck.add(new DestinationCard
            (Destination.Schwerin,
                Destination.Koblenz, LONG, 12));

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
