import java.awt.Color;
import java.awt.Shape;
import java.awt.Graphics2D.*;
import java.awt.geom.Ellipse2D;
import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
/**
 * This is the class for creating LocationNodes. 
 * It will keep track of cities 
 * as well as distance to others, colors of 
 * those tracks and all connecting cities.
 * 
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version (4/13/2018)
 */
public class LocationNode
{
    protected Destination city; 
    protected int x, y, distanceTo[]; 
    protected LocationNode nextCities[];
    protected Color col[];
    protected int meeple;
    protected Ellipse2D.Double area;
    protected boolean highlight;
    ////////////////////////////////////////////////////////////
    /**
     * Constructor for the location node of a given city
     * 
     * @param name the name of the city (as Enum)
     * @param distanceTo[] length to surrounding cities
     * @param nextCities[] names of surrounding cities
     * @param col[] colors of paths
     * @param meeple number of meeples
     */
    public LocationNode(Destination name, int 
    distanceTo[], LocationNode[] nextCities, Color
    col[], int meeple)
    {
        city = name;
        meeple = name.getMeeple();
        this.distanceTo = distanceTo;
        this.nextCities = nextCities;
        this.col = col;
        area = new Ellipse2D.Double(name.
            getX()-15, name.getY()-15,30,30); 
        highlight = false;
    }

    ////////////////////////////////////////////////////////////
    /**
     * Constructor for the location node of a given city
     * 
     * @param name the name of the city (as Enum)
     * @param size size of the node
     * @param meeple number of meeples
     */
    public LocationNode(Destination name, 
    int size, int meeple)
    {
        city = name;
        meeple= name.getMeeple();
        this.distanceTo = new int[size];
        this.nextCities = new LocationNode[size];
        this.col = new Color[size];
        area = new Ellipse2D.Double
        (name.getX()-15, name.getY()-15,30,30);
        highlight = false;
    }

    /**
     * zero arguement constuctor to 
     * create a default node
     */
    public LocationNode(){
        x = 50;
        y = 50;
        this.distanceTo = new int[] {3,4,6,2};
        this.nextCities = new LocationNode[1];
        area = new Ellipse2D.Double(x, y,30,30);
        highlight = false;
    }

    /**
     * gets the city 
     * 
     * @return the enum destination 
     * of the city you are at
     */
    public Destination getDestination(){
        return city;
    }

    ////////////////////////////////////////////////////////////
    /**
     * changes the size of the ellipse 
     * that is around the city
     * 
     * @param x the x coordinate
     * @param y the y coodinate
     * @param hor the radius
     */
    public void changeEllipse(int x, int y, int hor)
    {
        this.area = new Ellipse2D.Double(x,y,hor, hor);
    }

    /**
     * gets the name of the city as a String
     * 
     * @return the city
     */
    public String getCity()
    {
        return this.city.name(); 
    }

    /**
     * sets the name of the city
     * 
     * @param name the name of the city
     */
    private void setCity(Destination name)
    {
        this.city = name; 
    }

    /**
     * sets the x coordinate
     * 
     * @param xCoordinate the value 
     * to set the x coordinate to
     */
    public void setX(int xCoordinate)
    {
        this.x = xCoordinate;
    }

    /**
     * sets the y coordinate
     * 
     * @param yCoordinate the value 
     * to set the y coordinate to
     */
    public void setY(int yCoordinate)
    {
        this.y = yCoordinate;
    }

    /**
     * gets the x coordinate
     * 
     * @return the x coordinate
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * gets the y coordinate
     * 
     * @return the y coordinate
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * gets the color at a location
     * 
     * @param loc the location you are at
     * @return the color
     */
    public Color getCol(int loc)
    {
        return this.col[loc];
    }

    /**
     * Gets the length to a place
     * 
     * @param place the place to get the distance to
     * @return int the distance to the place
     */
    public int getLength(int place)
    {
        return this.distanceTo[place];
    }
    ////////////////////////////////////////////////////////////
    /**
     * adds a location 
     * 
     * @param newCity the city to set the array value to
     * @param tempCol the color to set the color to
     * @param distance the value to set the distance to
     */
    public void addLocation(LocationNode
    newCity,Color tempCol, int distance)
    {
        int count = 0;
        while(this.col[count] != null)
        {
            count++;
            if(count >= col.length)
            {
                System.err.println(
                    this.getCity() + 
                    " already has its max connections!");
                return;
            }
        }
        this.col[count] = tempCol;
        this.distanceTo[count] = distance;
        this.nextCities[count] = newCity;
    }

    /**
     * Getter method to get the next cities
     * 
     * @return LocationNode[] the location of the next cities
     */
    public LocationNode[] getNextCities(){
        return nextCities;
    }

    /**
     * gets the area of the ellipse
     * 
     * @return the area of the ellipse 
     */
    public Ellipse2D.Double getEllipse()
    {
        return this.area;
    }

    /**
     * determins if the move is valid
     * 
     * @param other LocationNode of a city
     * @return boolean true if the move is valid
     *                 false if the move isn't valid
     */
    public boolean isValid(LocationNode other)
    {
        if(other == null)
        {
            return false;
        }
        else
        { 
            int count = 0;
            while(this.nextCities[count] != other)
            {
                count++;
                if(count >= this.nextCities.length)
                {
                    System.err.
                    print("Connection not found!");
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * This is to get the distance in between 2 specific
     * cities that are connected
     * @parma city2 This is a LocationNode that is where
     * the track leads to.
     * @return int The distance to this location
     */
    public int getMatchingLength(LocationNode city2)
    {
        int count = 0;
        while(this.nextCities[count] != city2)
        {
            count++;
            if(count >= this.nextCities.length)
            {
                System.err.print("Connection not found!");
                return -1;
            }
        }
        return this.distanceTo[count];
    }

    public void extraSpots(ArrayList<Destination> city)
    {
        city.add(Destination.Kiel);
        city.add(Destination.Hamburg);
        city.add(Destination.Berlin);
        city.add(Destination.Hannover);
        city.add(Destination.Munster);
        city.add(Destination.Dortmund);
        city.add(Destination.Koln);
        city.add(Destination.Dusseldorf);
        city.add(Destination.Koblenz);
        city.add(Destination.Mainz);
        city.add(Destination.Frankfurt);
        city.add(Destination.Kassel);
        city.add(Destination.Erfurt);
        city.add(Destination.Nurnberg);
        city.add(Destination.Wurzburg);
        city.add(Destination.Mannheim);
        city.add(Destination.Stuttgart);
        city.add(Destination.Ulm);
        city.add(Destination.Augsburg);
        city.add(Destination.Munchen);

    }

    /**
     * Removes the objects connection to this city,
     * and thats city's connection to the object
     * @param city2 LocationNode that is to be removed
     * from connections 
     * @param player the player whose move it is
     */
    public void removeConnection(LocationNode city2,
    int player)
    {
        try
        {
            Player tempPlayer = BoardPanel.userNames.
            get(player);
            int count = 0;
            ArrayList<Destination> city3 = new 
                ArrayList<Destination>(); 
            extraSpots(city3);
            boolean extra = false;
            if(city3.contains(this.getDestination()) && 
            city3.contains(city2.getDestination()))
                extra = true;
            while(this.getNextCities()[count] == null)
            {
                count++;
            }
            while(this.getNextCities()[count] != city2)
            {
                while(this.getNextCities()[count] == null)
                {
                    count++;
                }
                count++;
            }
            this.nextCities[count] = null;
            this.col[count] = null;
            this.distanceTo[count] = 0;
            if(extra)
            {
                if(this.nextCities[count+1] == city2)
                {
                    this.nextCities[count+1] = null;
                    this.col[count+1] = null;
                    this.distanceTo[count+1] = 0;
                }
                else
                {
                    this.nextCities[count-1] = null;
                    this.col[count-1] = null;
                    this.distanceTo[count-1] = 0;
                }
            }
            // Next City removed
            count = 0;
            while(city2.getNextCities()[count] == null)
            {
                count++;
                if(count >= city2.getNextCities().length)
                {
                    System.err.print("Connection not found!");
                    return;
                }
            }
            while(city2.getNextCities()[count] != this)
            {
                while(city2.getNextCities()[count] == null)
                {
                    count++;
                }
                count++;
                if(count >= city2.getNextCities().length)
                {
                    System.err.print("Connection not found!");
                    return;
                }
            }
            city2.nextCities[count] = null;
            city2.col[count] = null;
            city2.distanceTo[count] = 0;
            if(extra)
            {
                if(city2.nextCities[count+1] == this)
                {
                    city2.nextCities[count+1] = null;
                    city2.col[count+1] = null;
                    city2.distanceTo[count+1] = 0;
                }
                else
                {
                    city2.nextCities[count-1] = null;
                    city2.col[count-1] = null;
                    city2.distanceTo[count-1] = 0;
                }
            }
            if(player >= 0)
                System.out.println("addPlayerConnection: "
                + addPlayerConnection(this,city2,tempPlayer));
        }
        catch(NullPointerException z)
        {
            System.err.print("One of the cities is null!");
        }
        catch(ArrayIndexOutOfBoundsException p)
        {
           
        }
    }

    /**
     * method to add a connection between cities and player
     * 
     * @param other LocationNode of a city
     * @param currentPlayerNumber number of player 
     * whose turn it is
     * 
     * @return boolean true if the connection could be made,
     *                 false if it can't be made
     */
    public boolean addPlayerConnection(LocationNode first,
    LocationNode other,Player player1)
    {
        int count = 0;
        LocationNode[] temp = player1.myGermany().getGermany();
        LocationNode Head = temp[count];
        while(temp[count].getDestination() 
        != first.getDestination())
        {
            count++;
            if(count >= temp.length)
            {           
                return false;
            }
        }
        Head = temp[count];
        count = 0;
        LocationNode End = temp[count];

        while(temp[count].getDestination() 
        != other.getDestination())
        {
            count++;
            if(count >= temp.length)
            {           
                return false;
            }
        }
        End = temp[count];
        Head.addLocation(End, player1.getColor(), 0);
        End.addLocation(Head, player1.getColor(), 0);
        return true;
    }

    /**
     * getter method to get the meeple
     * 
     * @return int the meeple
     */
    public int getMeeple()
    {
        return this.meeple;
    }

    /**
     * setter method to set the meeple
     * @param newVal value to set the meeple at
     */
    public void setMeeple(int newVal)
    {
        this.meeple = newVal;
    }

    /**
     * method to test the driver
     */
    public void driverTest()
    {
        LocationNode Dresden = 
        new LocationNode(Destination.Dresden, 1, 1);
        LocationNode temp =
        new LocationNode(Destination.Munchen, 1, 1);
        LocationNode WontFind =
        new LocationNode(Destination.Hamburg, 1, 2);
        System.out.println(Dresden.getCity());
        Dresden.addLocation(temp, Color.GREEN, 2);
        temp.addLocation(Dresden, Color.GREEN, 2);
        for(LocationNode p : Dresden.nextCities)
        {
            System.out.println("\t" + p.getCity());
        }
        System.out.println(temp.getCity());
        for(LocationNode p : temp.nextCities)
        {
            System.out.println("\t" + p.getCity());
        }
        System.out.println("Before removal: "
        + Dresden.isValid(temp));
  
        Dresden.removeConnection(temp,-1);
        System.out.println("Removed connections");
        System.out.println(Dresden.isValid(temp));

        System.out.println(Dresden.getCity());
        for(LocationNode p : Dresden.nextCities)
        {
            try
            {
                System.out.println("\t" + p.getCity());
            }
            catch(NullPointerException e)
            {
                System.out.println("\tNo City Availible");
            }
        }
        System.out.println(temp.getCity());
        for(LocationNode p : temp.nextCities)
        {
            try
            {
                System.out.println("\t" + p.getCity());
            }
            catch(NullPointerException e)
            {
                System.out.println("\tNo City Availible");
            }
        }
    }   

    /**
     * dertermines if the city is at the head of the stack
     * 
     * @param city2 city on the stack
     * @return boolean true if it is the head,
     *                 false if it isn't the head
     */
    public static boolean TylersConnectionDotCom(
    DestinationCard city, Player player1)
    {
        ArrayList<LocationNode> checked =
            new ArrayList<LocationNode>();
        LocationNode Head = city.getNode(city.getStart()
        , player1.myGermany().getGermany());
        LocationNode End = city.getNode(city.getEnd(),
        player1.myGermany().getGermany());
        checked.add(Head);
        Stack germanCities = new Stack();
        for(int x = 0; x < Head.nextCities.length; x++)
        {
            try
            {
                germanCities.push(Head.nextCities[x]);
            }
            catch(NullPointerException e)
            {
                System.err.print("Issue with 1st Head Node");
            }
        }
        while(!germanCities.isEmpty())
        {
            Head = ((LocationNode)(germanCities.pop()));
            while(Head == null)
            {
                try
                {
                    Head = ((LocationNode)(germanCities.pop()));
                }
                catch(EmptyStackException ESE)
                {
                    System.err.print(ESE);
                    return false;
                }
            }
            checked.add(Head);
            if(End == Head)
            {
                return true;
            }
            for(int x = 0; x < Head.nextCities.length; x++)
            {
                try
                {
                    if(!checked.contains(Head.nextCities[x]))
                        germanCities.push(Head.nextCities[x]);
                }
                catch(NullPointerException e)
                {
                    System.err.print("Issue with Head Node");
                }
            }
        }
        return false;
    }
}
