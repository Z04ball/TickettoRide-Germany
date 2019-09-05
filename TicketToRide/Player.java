import java.awt.Color;
import java.util.ArrayList;

/**
 * Represents a player of Ticket To Ride.
 *
 * @author Ben, Kaley, Tyler, Sean, Zach
 * @version 4/29/18
 */
public class Player
{
    // name of player
    private String name;
    //player color
    private Color color;
    //list of their train cards
    private ArrayList<TrainCard> trainCards;
    // list of their destination cards
    private ArrayList<DestinationCard> 
    destinationCards;
    // list of their meeples
    private ArrayList<Meeples> meeples;
    // keeps counts for how many of each 
    //meeple they have
    private int whiteMeeples;
    private int redMeeples;
    private int blueMeeples;
    private int blackMeeples;
    private int greenMeeples;
    private int yellowMeeples;
    // keep track of their trains
    private int numberOfTrains;
    // must draw destination card first
    private boolean isFirstTurn;
    protected Germany myMap;
    private int score;
    private int numberOfCards;
    /**
     * Constructs a player based 
     * on user input from popup/
     * @param String name  players name
     * @param Color color  color of player
     * @TrainDeck deck to initialize players hand
     */
    public Player(String name, Color color,
    TrainDeck deck){
        this.name = name;
        this.color = color;
        trainCards = new ArrayList<TrainCard>();
        destinationCards = new ArrayList
        <DestinationCard>();
        meeples = new ArrayList<Meeples>();
        numberOfTrains = 45;
        this.redMeeples = this.blueMeeples = 
        this.blackMeeples =
        this.greenMeeples = this.yellowMeeples
        = this.whiteMeeples = 0;
        isFirstTurn = true;
        for(int i = 0; i < 4; i++){
            trainCards.add(deck.pop());
        }
        myMap = new Germany(false, 0);
        score = 0;
        numberOfCards = 0;
    }

    // public boolean giveMeeples(LocationNode city2)
    // {
    // // int loop = getMeeple();
    // while(loop != 0)
    // {
    // BoardPanel.UserNames.get(currentPlayerNumber)
    //.meeples.add(Meeples.getMeeple());
    // }
    // this.setMeeple(0);
    // loop = city2.getMeeple();
    // while(loop != 0)
    // {
    // Meeples.getMeeple();
    // }
    // city2.setMeeple(0);
    // return true;
    // }

    /**
     * Prints out all of the Location Nodes
     */
    public void printAllNodes()
    {
        for(LocationNode players: this.myGermany().getGermany())
        {
            System.out.println(getName() + "." +players.getCity());
            try
            {
                for(LocationNode connected: players.nextCities)
                {

                    System.out.println("\t" + getName() + "." + connected.getCity());
                }
            }
            catch(NullPointerException a)
            {
                System.out.println("\tnull reference");
            }
        }
    }

    /**
     * This adds to the players score that is displayed
     * @param points the points to be added to the players score
     */
    public void addToScore(int points)
    {
        score = score + points;
    }

    /**
     * Gets the current players score
     * @return the players current score
     */
    public int getScore()
    {
        return this.score;
    }

    /**
     * Returns players color
     * @return color of player
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns players name
     * @return name of player
     */
    public String getName(){
        return name;
    }

    /**
     * Returns ArrayList of players train cards
     * @return ArrayList<TrainCard>
     */
    public ArrayList<TrainCard> getTrainCards(){
        return trainCards;
    }

    /**
     * Returns ArrayList of players destination cards
     * @return ArrayList<DestinationCard>
     */
    public ArrayList<DestinationCard> getDestinationCards(){
        return destinationCards;
    }

    /**
     * Returns players meeples
     * @return ArrayList<Meeples>
     */
    public ArrayList<Meeples> getMeeples(){
        return meeples;
    }

    /**
     * Adds a train card to players list
     * @param TrainCard t train to add
     */
    public void addTrain(TrainCard t){
        trainCards.add(t);
    }

    /**
     * Removes a players TrainCard to capture a route
     * 
     * @param TrainCard t trainCard that will be removed
     */
    public void useTrain(TrainCard t){
        trainCards.remove(t);
    }

    /**
     * Adds a meeple to the players list.
     * Keeps track of number of each color
     * @param Meeples m  Meeples obj. to add
     */
    public void addMeeples(Meeples m){
        meeples.add(m);
        if(m == Meeples.WHITE){
            whiteMeeples++;
        }
        else if(m == Meeples.BLACK){
            blackMeeples++;
        }
        else if(m == Meeples.RED){
            redMeeples++;
        }
        else if(m == Meeples.BLUE){
            blueMeeples++;
        }
        else if(m == Meeples.GREEN){
            greenMeeples++;
        }
        else if(m == Meeples.YELLOW){
            yellowMeeples++;
        }
    }

    /**
     * Returns white meeple count
     * @return int num of white meeples
     */
    public int getWhite(){
        return whiteMeeples;

    }

    /**
     * Returns black meeple count
     * @return int num of black meeples
     */
    public int getBlack(){
        return blackMeeples;

    }

    /**
     * Returns red meeple count
     * @return int num of red meeples
     */
    public int getRed(){
        return redMeeples;

    }

    /**
     * Returns blue meeple count
     * @return int num of blue meeples
     */
    public int getBlue(){
        return blueMeeples;

    }

    /**
     * Returns green meeple count
     * @return int num of green meeples
     */
    public int getGreen(){
        return greenMeeples;

    }

    /**
     * Returns yellow meeple count
     * @return int num of yellow meeples
     */
    public int getYellow(){
        return yellowMeeples;

    }

    /**
     * Add a destination card to players list
     * @param DestinationCard c     dest. card to add
     */
    public void addDestinationCard(DestinationCard c){
        isFirstTurn = false;
        destinationCards.add(c);
    }

    /**
     * Returns train count
     * @return int num of trains 
     */
    public int getNumberOfTrains(){
        return numberOfTrains;
    }

    /**
     * Uses players trains to capture a route
     * @param int amount        number of trains to use
     */
    public void useTrains(int amount){
        numberOfTrains -= amount;
    }

    /**
     * Returns whether it is players first turn or not
     * @return boolean isFirst turn ; true if first turn, false
     * otherwise
     */
    public boolean getFirstTurn(){
        return isFirstTurn;
    }

    /**
     * Obtains the players nodes for cities
     * @return Germany 
     */
    public Germany myGermany()
    {
        return this.myMap;
    }

    public void checkDestCards()
    {
        ArrayList<DestinationCard> removals = new ArrayList<DestinationCard>();
        for(DestinationCard t: this.getDestinationCards())
        {
            if(LocationNode.TylersConnectionDotCom(t, this))
            {
                this.addToScore(t.getValue());
                removals.add(t);
            }
        }
        
        for(DestinationCard t: removals)
        {
            this.getDestinationCards().remove(this.getDestinationCards().indexOf(t));
            numberOfCards++;
        }
    }
    /**
     * returns how many dest. cards were completed
     * @return int number of dest. cards
     */
    public int getNumberOfCards(){
        return numberOfCards;
    }
}
