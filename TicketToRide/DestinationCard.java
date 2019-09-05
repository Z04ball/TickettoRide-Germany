
/**
 * Class that will create the destination card
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class DestinationCard
{
    private Destination start;
    private Destination end;
    private String type; // long or short
    private int value;
    /**
     * Constructor to create a destination card
     * 
     * @param start the starting city
     * @param end the ending city
     * @param type either long or short
     * @param value the value of the city
     */
    public DestinationCard(Destination start, 
    Destination end, String type, int value){
        this.start = start;
        this.end = end;
        this.type = type;
        this.value = value;
    }

    /**
     * gets the starting destination
     * 
     * @return the starting destination
     */
    public Destination getStart(){
        return this.start;
    }

    /**
     * gets the ending destination
     * 
     * @return the ending destination
     */
    public Destination getEnd(){
        return this.end;
    }

    /**
     * gets the type
     * 
     * @return string telling 
     * if it is long or short
     */
    public String getType(){
        return this.type;
    }

    /**
     * gets the value at the point
     * 
     * @return the integer value
     */
    public int getValue(){
        return this.value;
    }

    public LocationNode getNode(Destination p, LocationNode[] nodez)
    {
        for(LocationNode ln: nodez)
        {
            if(ln.getDestination() == p)
            {
                return ln;
            }
        }
        return null;
    }
}
