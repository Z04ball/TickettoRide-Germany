import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.sound.sampled.*;
import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import static java.awt.Color.*;
////////////////////////////////////////////////////////////
/**
 * Class that represents the whole board panel 
 *
 * @author Kaley, Tyler, Ben, Zach, Sean
 * @version 4/29/18
 */
public class BoardPanel extends JPanel 
implements MouseListener, MouseMotionListener,
WindowListener{

    protected Germany theLand;
    private int width, height;
    static String choice = "";
    static BoardPanel panel;
    protected int numUsers;
    static volatile ArrayList<Player> 
    userNames = new ArrayList<Player>();
    private static BufferedImage boardPicture;
    protected ArrayList<TrainCard> 
    displayTrainCards = new ArrayList<>();

    protected Upcards upcards;
    // = new Upcards();
    public ArrayList<TrainCard> actualCards; 
    //cards to pick
    static protected TrainDeck trainDeck 
    = new TrainDeck(); // used to draw cards
    protected BufferedImage 
    backOfTrainCard; // for deck

    protected HashMap<String, ArrayList<CreateTrainSquares>>
    pathMap = new CreateTrainObjects().getMap();
    protected BufferedImage trainTemp;

    static protected ArrayList<String> users;
    static ArrayList<String> 
    colorOptionsAL = new ArrayList<String>();
    private SidePanel sidePanel;
    PlayerHand playerTrainHand;
    PlayerHand playerDestHand;
    private ScoreBoard scoreboard;
    BufferedImage endImg;
    protected DestinationPanel destPanel 
    = new DestinationPanel();
    protected String playerPanel 
    = "Destination";
    protected Destination d1;
    protected Destination d2;
    private boolean gameOver = false;
    private boolean startMenu = true;
    static volatile int currentPlayerNumber;
    volatile Player currentPlayer;
    private int cardsDrawn = 0;
    private boolean firstClick = true;
    private String startCity;
    private String endCity;
    static volatile LocationNode startLocNode;
    static volatile LocationNode endLocNode;
    // panel to hold 2 panels to select
    // train cards to use to capture route
    volatile JPanel selectionPanel;
    // display users cards available
    // taking off private to test synchornization
    volatile UseTrainCardPanel cardPanel;
    // cards to use to capture a route
    volatile UseTrainCardPanel usePanel; 
    // store paths taken
    private ArrayList<
    ArrayList<CreateTrainSquares>>
    routesTaken = new ArrayList<>();
    private ArrayList<Color> routeColors =
        new ArrayList<>();

    volatile ArrayList<TrainCard> selectedCards =
        new ArrayList<TrainCard>();

    ButtonPanel buttonPanel;
    /////////////////////////////////////////////////////////
    //for destinationPanel class
    protected  LongDestinationDeck longDestinationDeck
    = new LongDestinationDeck();
    protected ShortDestinationDeck shortDestinationDeck 
    = new ShortDestinationDeck();
    protected ArrayList<DestinationCard>destinationCards 
    = new ArrayList<DestinationCard>(4);
    protected  ArrayList<JLabel> destinationCardLabels
    = new ArrayList<JLabel>(4);
    // so player can only draw 4 dest. cards per turn
    protected int turnSize = 0;
    // must draw at least 1
    protected boolean destCardFlipped = false;
    // booleans for game
    // once you draw a card, you must select one.
    //can't go back to trains
    static volatile boolean cardPulled = false;
    static volatile boolean moveMade = false;
    public static volatile boolean isSelectedCards = false;
    private volatile int turnsRemaining = -1;
    /**
     * gets the current players number
     * 
     * @return int player number
     */
    public int currPlayer()
    {
        return currentPlayerNumber;
    }

    /**
     * Constructor for objects of class BoardPanel
     */
    public BoardPanel()
    {      
        super();
        setPreferredSize(new Dimension(630, 980));
        width = getPreferredSize().width;
        height = getPreferredSize().height;
        setBackground( Color.black );
        addMouseListener( this );
        addMouseMotionListener( this );
        theLand = new Germany(true, numUsers);
        currentPlayerNumber = 0;

        try{
            backOfTrainCard = ImageIO.read(new 
                File("BackofCardsResized/back1.jpg"));
            trainTemp = ImageIO.read(new File
                ("TrainCarImage.png"));
        }
        catch(IOException e){
            System.err.println("Error reading in back"+
                "of card");
        }

        // ArrayList<TrainCard> tc = new ArrayList<>(5);
        // tc.add(trainDeck.pop());
        // tc.add(trainDeck.pop());
        // tc.add(trainDeck.pop());
        // tc.add(trainDeck.pop());
        // tc.add(trainDeck.pop());
        // playerTrainHand = new PlayerHand(tc);
        repaint();
    }

    /**
     * Constructor for the board panel
     * 
     * @param x int x position
     * @param y int y position
     */
    public BoardPanel(int x, int y){
        setPreferredSize(new Dimension(x, y));
        repaint();
    }

    /**
     * When the mouse is entered
     * @param e mouse event happens
     */
    @Override
    public void mouseEntered( MouseEvent e ) { }

    /**
     * When the mouse is exited
     * @param e mouse event happens
     */
    @Override
    public void mouseExited( MouseEvent e ) { }
    //////////////////////////////////////////////////////////
    /**
     * When the mouse is clicked
     * @param e mouse event happens
     */
    @Override
    public void mouseClicked( MouseEvent e ) {
        //System.out.println(panel.
        //getComponentCount());
        if(e.getButton() == MouseEvent.BUTTON1){
            // left click, rotate image
            int x = e.getX();
            int y = e.getY();
            System.out.println(x + " " + y);
            System.out.println("userNames: " 
                + userNames.get(currentPlayerNumber).getName());
            System.out.println("currentPlayerNumber: " 
                + currentPlayerNumber);
        }

        int x = e.getX();
        int y = e.getY();
        if(theLand != null)
        {

            for(int p = 0; p < theLand.getGermany()
            .length; p++)
            {
                if(theLand.getGermany()[p].
                getEllipse().contains(x,y))
                {
                    if(userNames.get(
                        currentPlayerNumber).getFirstTurn()){
                        JOptionPane.showMessageDialog
                        (null, "Must draw destination" +
                            " card during first turn.");
                    }
                    else if(cardPulled){
                        JOptionPane.showMessageDialog
                        (null, "Must draw a card.");
                    }

                    else if(!moveMade){

                        theLand.getGermany()
                        [p].highlight = true;
                        System.out.println
                        ("Inside a city!");
                        if(firstClick){
                            startCity =
                            theLand.getGermany()[p].getCity();
                            startLocNode =
                            theLand.getGermany()[p];
                            firstClick = !firstClick;
                            repaint();
                        }
                        else if(!firstClick){
                            boolean nextTo = false;
                            endCity =
                            theLand.getGermany()[p].getCity();
                            endLocNode = 
                            theLand.getGermany()[p];                            
                            for(LocationNode q: 
                            startLocNode.getNextCities())
                            {
                                if(q == endLocNode)
                                {
                                    nextTo = true;
                                }
                            }
                            if(!nextTo)
                            {
                                endLocNode = null;
                                return;
                            }
                            firstClick = !firstClick;
                            //JFrame 
                            JFrame selectionFrame =
                                new JFrame("TicketToRide");
                            selectionFrame.setSize(
                                new Dimension(640,1000));
                            selectionFrame
                            .setDefaultCloseOperation(JFrame.
                                DISPOSE_ON_CLOSE);
                            selectionFrame.setLayout
                            (new BorderLayout());
                            selectionFrame
                            .setResizable(false);

                            selectionPanel = new JPanel();
                            selectionPanel.setPreferredSize(
                                new Dimension(640, 680));

                            cardPanel = 
                            new UseTrainCardPanel(userNames.
                                get(currentPlayerNumber).
                                getTrainCards(), true);
                            selectionPanel.add(cardPanel);

                            usePanel = 
                            new UseTrainCardPanel(
                                selectedCards,
                                false);

                            selectionPanel.add(usePanel,
                                BorderLayout.SOUTH);

                            selectionFrame
                            .add(selectionPanel);
                            selectionFrame
                            .setVisible(true);
                            selectionFrame
                            .addWindowListener(this);

                            //Added these -t
                            cardPanel.revalidate();
                            usePanel.revalidate();
                            selectionPanel.revalidate();
                            selectionFrame.revalidate();

                        }
                    }
                    else{

                        JOptionPane.showMessageDialog
                        (null, "Turn is over. Click " +
                            "next turn.");

                    }
                }
                else
                {
                    theLand.getGermany()[p]
                    .highlight = false;
                }
            }
        }
        ////////////////////////////////////////////////////////////
    }

    @Override
    public synchronized void revalidate()
    {

    }

    /**
     * method to track the players points
     * 
     * @param points interger for number of points
     * @return int the points 
     * 
     */
    public int trackPoints(int points)
    {
        switch(points)
        {
            case 1: return 1;
            case 2: return 3;
            case 3: return 4;
            case 4: return 7;
            case 5: return 10;
            case 6: return 15;
            case 7: return 18;
        }
        return 0;
    }

    /**
     * Method to claim train routes when the 
     * window is closed
     * @param e windowEvent window gets closed
     */
    @Override
    public synchronized void windowClosing(WindowEvent e){
        int length = startLocNode.getMatchingLength(endLocNode);
        
        if(userNames.get(currentPlayerNumber).
        getNumberOfTrains() >= length&& 
        calcSelect(startLocNode,
            endLocNode)){
            // System.out.print("Pre: " +
            //userNames.get(currentPlayerNumber).getScore());
            //userNames.get(currentPlayerNumber).addToScore(
            int pts = trackPoints(startLocNode.
                    getMatchingLength(endLocNode));
            int removeTrains = startLocNode.
                getMatchingLength(endLocNode);
            userNames.get(currentPlayerNumber).
            useTrains(removeTrains);
            // startLocNode.giveMeeples(endLocNode);
            // System.out.print("Post: " + 
            //userNames.get(currentPlayerNumber).getScore());
            startLocNode.removeConnection
            (endLocNode, currentPlayerNumber);

            System.out.println("Successful");
            updateMoveMade();
            String s = startCity.toUpperCase();
            String s2 = endCity.toUpperCase();
            String answer;
            System.out.println("Start " + s);
            System.out.println("end " + s2);
            if(s.compareTo(s2) < 0){
                answer = s + "_" + s2;
            }
            else answer = s2 + "_" + s;
            System.out.println(answer);
            routesTaken.add(
                pathMap.get(answer));
            routeColors.add(userNames
                .get(currentPlayerNumber)
                .getColor());
            System.out.println("windowsClosing: "
                + moveMade);
            userNames.get(currentPlayerNumber)
            .printAllNodes();
            userNames.get(currentPlayerNumber)
            .addToScore(pts);

            selectedCards.clear();
            repaint();     
            Meeples m1 = meepleChoice(
                    startLocNode.getDestination(),
                    startCity);
            Meeples m2 = meepleChoice(
                    endLocNode.getDestination(),
                    endCity);
            userNames.get(currentPlayerNumber).checkDestCards();
            if(m1 != null)
            {
                
                userNames.get(currentPlayerNumber)
                .addMeeples(m1);
            }
            else{
                JOptionPane.showMessageDialog(null,startCity+
                 " has no more meeples."
                );
            }
            if(m2 != null){
                
                userNames.get(currentPlayerNumber)
                .addMeeples(m2);
            }
            else{
                JOptionPane.showMessageDialog(null,endCity+
                 " has no more meeples."
                );
            }
            repaint();
            startLocNode = null;
            endLocNode = null;
        }
        else{
            startLocNode = null;
            endLocNode = null;
            for(TrainCard t : selectedCards){
                userNames.
                get(currentPlayerNumber)
                .addTrain(t);

            }
            selectedCards.clear();
            repaint();
        }

    }
    /**
     * Calculates players final score
     */
    public void calculateScore(){
        
        for(Player p: userNames){
            for(DestinationCard d : p.getDestinationCards()){
                int val = d.getValue() * -1;
                p.addToScore(val);
                
            }
            
        }
        Player p1 = userNames.get(0);
        Player p2 = userNames.get(1);
        if(p1.getBlue() 
        > p2.getBlue()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
        else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getBlack() 
        > p2.getBlack()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
         else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getRed() 
        > p2.getRed()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
         else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getYellow() 
        > p2.getYellow()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
         else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getGreen() 
        > p2.getGreen()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
         else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getWhite() 
        > p2.getWhite()){
            p1.addToScore(20);
            p2.addToScore(10);
        }
         else{
            p2.addToScore(20);
            p1.addToScore(10);
        }
        if(p1.getNumberOfCards() > p2.getNumberOfCards()){
            p1.addToScore(15);
        }
        else if (p1.getNumberOfCards() < p2.getNumberOfCards()){
            p2.addToScore(15);
        }
    }
    /**
     * When the window is deactivated
     * @param e windowEvent 
     */
    @Override
    public void windowDeactivated(WindowEvent e){}

    /**
     * When the window is activated
     * @param e windowEvent 
     */
    @Override
    public void windowActivated(WindowEvent e){}

    /**
     * When the window is deiconified
     * @param e windowEvent 
     */
    @Override
    public void windowDeiconified(WindowEvent e){}

    /**
     * When the window is conified
     * @param e windowEvent 
     */
    @Override
    public void windowIconified(WindowEvent e){}

    /**
     * When the window is closed
     * @param e windowEvent 
     */
    @Override
    public void windowClosed(WindowEvent e){}
    // @Override
    // public void windowGainedFocus(WindowEvent e){}
    // @Override
    // public void windowLostFocus(WindowEvent e){}
    /**
     * When the window is opened
     * @param e windowEvent 
     */
    @Override
    public void windowOpened(WindowEvent e){}

    /**
     * updates that a move was made
     */
    public synchronized void updateMoveMade(){
        cardPulled = true;
        cardsDrawn = 10;    
        moveMade = true;
        //System.out.println(moveMade);
    }

    /**
     * implemented when the mouse is pressed 
     * 
     * @param e the mouse event that happens
     */
    @Override
    public void mousePressed( MouseEvent e ) { }

    /**
     * implemented when the mouse is released 
     * 
     * @param e the mouse event that happens
     */
    @Override
    public void mouseReleased( MouseEvent e ) { }

    /**
     * implemented when the mouse is moved 
     * 
     * @param e the mouse event that happens
     */
    @Override
    public void mouseMoved( MouseEvent e ) 
    { 
        // int x = e.getX();
        // int y = e.getY();
        // for(int p = 0; p < theLand.germany.length; p++)
        // {
        // if(theLand.germany[p].getEllipse().contains(x,y))
        // {
        // theLand.germany[p].highlight = true;
        // }
        // else
        // {
        // theLand.germany[p].highlight = false;
        // }
        // }

    }

    /**
     * implemented when the mouse is dragged 
     * 
     * @param e the mouse event that happens
     */
    @Override
    public void mouseDragged( MouseEvent e ) { }

    /**
     * paint component method to paint the panel 
     * 
     * @param g the graphics object 
     */
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //draw the beginner board if user 
        //selects this option

        g.drawImage(boardPicture,0,0,this);
        g.setColor(Color.white);

        if(theLand != null)
        {
            if(startLocNode != null)
            {
                for(LocationNode p: 
                theLand.getGermany())
                {
                    if(Arrays.asList(
                        startLocNode.getNextCities())
                    .contains(p))
                    {
                        g.setColor(Color.YELLOW);
                        g2.setStroke(new BasicStroke(5));
                        g2.draw(p.getEllipse());
                    }    

                }
            }

            for(LocationNode loc: theLand.
            getGermany())
            {
                if(loc.highlight)
                {
                    g.drawString(loc.getCity(),100,100);
                }
            }
            int lcv = 0;
            for (
            ArrayList<CreateTrainSquares> entry
            : routesTaken) {
                // ArrayList<CreateTrainSquares> values = 
                // String key = entry.getKey();
                // ArrayList<CreateTrainSquares> value
                // = entry.getValue();
                g.setColor(routeColors.get(lcv));
                for(CreateTrainSquares t : entry)
                {
                    Polygon poly = new Polygon(t.x,t.y,
                            t.numPoints);

                    g.fillPolygon(poly);
                    // g.setClip(poly);
                    // g.fillPolygon(poly);
                    // g.drawImage(trainTemp,100,100,null);

                }
                // ...
                lcv++;
            }

        }
        ////////////////////////////////////////////////////////////
        // for(CreateTrainSquares c: dB.denBrem)
        // {
        // // Polygon temp = new Polygon(c.x,c.y,c.numPoints);
        // // g.setClip(temp);
        // // g.fill3DPolygon(temp);
        // // g.drawImage(trainTemp, 100, 100, null);
        // g.fillPolygon(c.x,c.y,c.numPoints);
        // }

        //g.drawImage(backOfTrainCard, 890, 225, this);
        // draw 4 cards from deck
        // if(trainDeck != null){
        // while(displayTrainCards.size() < 4){
        // displayTrainCards.add(trainDeck.pop());
        // }
        // int xval = 650;
        // for(TrainCard t : displayTrainCards){

        // g.drawImage(t.getImage(), xval, 30, this);
        // xval += 120;
        // }
        // }

    }

    ////////////////////////////////////////////////////////////
    /**
     * create the panel for showing the Jframe
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TicketToRide");
        frame.setSize(new Dimension(1280, 980));
        frame.setDefaultCloseOperation(JFrame.
            EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        panel = new BoardPanel();
        //FlowLayout testLayout = new FlowLayout();
        // testLayout.setHgap(200);
        // testLayout.setVgap(25);
        //panel.setLayout(testLayout);
        panel.setBackground(Color.black);
        panel.show();
        //panel.setLayout(testLayout);
        panel.doLayout();
        ////////////////////////////////////////////////////////////
        //upcards.show();
        //runTurns(currentPlayer, sidePanel);

        JButton nextbtn;
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        nextbtn = new JButton("Next player");
        nextbtn.setFont(new Font("Arial", Font.BOLD, 16));
        nextbtn.setBackground(Color.GREEN);
        nextbtn.setOpaque(true);
        c.gridx = 8;
        c.gridy=0;
        c.gridwidth=1;
        c.weightx=.05;
        c.ipadx = 15;
        c.ipady = 15;
        c.insets = new Insets(25,0,0,40);  
        panel.add(nextbtn, c);

        JLabel label = new JLabel("");
        c.gridx = 0;       
        c.gridy = 0;       
        c.weightx=.70;
        panel.add(label, c);

        JLabel label2 = new JLabel("");
        c.gridx = 0;       
        c.gridy = 1;       
        c.weighty=.70;
        c.gridwidth=2;
        panel.add(label2, c);
        nextbtn.addActionListener(new 
            ActionListener() { 
                /**
                 * tells the user to make a action if
                 * it is still their turn
                 * @param e ActionEvent
                 */
                public synchronized void actionPerformed
                (ActionEvent e) { 
                    if(!cardPulled && !moveMade){
                        JOptionPane.showMessageDialog
                        (frame, "Must make a move " +
                            "before finishing turn.");

                    }
                    else{
                        System.out.println(turnsRemaining + " turns");
                        if(turnsRemaining != -1){
                            System.out.println("************************************************************");
                            turnsRemaining--;
                        }
                        if(turnsRemaining == 0){
                           try{
                               calculateScore();
                               System.out.println("HERE");
                            EndPanel endPanel = new EndPanel();
                            frame.remove(sidePanel);
                            frame.remove(panel);
                            frame.getContentPane().add(endPanel);
                            endPanel.repaint();
                            endPanel.revalidate();
                            frame.setVisible(true);
                            
                            
                        }
                        catch(Exception p){
                            System.err.println(p);
                            }
                            
                        }
                        if(currentPlayer.getNumberOfTrains()
                        <= 2 && !gameOver){
                            turnsRemaining = numUsers;
                            gameOver = true;
                        }
                        destinationCards.clear();
                        destinationCardLabels.clear();
                        swapPanels();
                        System.out.println(
                            "currentPlayerNumber 556 Before: " 
                            + currentPlayerNumber);
                        currentPlayerNumber= 
                        currentPlayerNumber + 1;
                        System.out.println(
                            "currentPlayerNumber 556: " +
                            currentPlayerNumber);
                        wrapPlayerNumber
                        (currentPlayerNumber);
                        cardsDrawn = 0;   
                        startLocNode = null;
                        endLocNode = null;
                        moveMade = false;
                        cardPulled = false;                        
                        runTurns();
                        repaint();
                    }
                } 
            } );
        ////////////////////////////////////////////////////////////
        panel.add(nextbtn);
        if(startMenu){
            panel.hide();
            //upcards.hide();
            destPanel.hide();
            //home screen
            try{
                BufferedImage img = ImageIO.read(
                        new File("startmenu3.jpg"));
                boardPicture = img;
                BoardPanel tempSidePanel = new 
                    BoardPanel(1280, 980);

                FlowLayout test = new FlowLayout();
                test.setHgap(500);
                test.setVgap(500);
                tempSidePanel.setLayout(test);
                Button btn=new Button("Start Game");
                btn.setBackground(new 
                    Color(0, 175, 0));
                btn.setLocation(500, 500);
                btn.setPreferredSize(
                    new Dimension(150, 50));
                btn.setFont(new Font("Arial", 
                        Font.PLAIN, 20));

                // File f = new File("europe.wav");
                // AudioInputStream stream;
                // AudioFormat format;
                // DataLine.Info info;
                // Clip clip;

                // stream = AudioSystem.
                // getAudioInputStream(f);
                // format = stream.getFormat();
                // info = new DataLine.Info
                // (Clip.class, format);
                // clip = (Clip) AudioSystem.
                // getLine(info);
                // clip.open(stream);
                // clip.start();

                ////////////////////////////////////////////////////////////
                btn.addActionListener
                (new ActionListener() { 
                        /**
                         * When an action gets preformed
                         * @param e ActionEvent
                         */
                        public void 
                        actionPerformed
                        (ActionEvent e) { 
                            selectionButtonPressed
                            (frame);
                        } 
                    } );
                tempSidePanel.add(btn);

                frame.getContentPane().add
                (tempSidePanel);

                // AudioInputStream audioInputStream 
                //= AudioSystem.getAudioInputStream(
                // new File("europe.wav"));
                // Clip clip = AudioSystem.getClip();
                // clip.open(audioInputStream);
                // clip.start();

                repaint();
            }
            catch(Exception e){
                System.out.println("ERROR");}
        }

        else{
            try{
                //read in background image
                BufferedImage img = 
                    ImageIO.read(new File("map2.jpg"));
                //create new background
                boardPicture = img;
                frame.getContentPane().
                add(panel, BorderLayout.WEST);
                sidePanel = new SidePanel();

                //repaint();
                buttonPanel = new 
                ButtonPanel(sidePanel);
                //sidePanel.add(buttonPanel, 
                //BorderLayout.NORTH);
                frame.getContentPane().add
                (panel, BorderLayout.WEST);

                //Germany object
                // sidePanel.add(upcards, 
                //BorderLayout.NORTH);
                // sidePanel.add(playerTrainHand, 
                //BorderLayout.SOUTH);
                scoreboard = new ScoreBoard();
                sidePanel.add(scoreboard,
                    BorderLayout.NORTH);
                destPanel.show();
                sidePanel.add(destPanel, 
                    BorderLayout.NORTH);

                // destPanel = new DestinationPanel();
                // sidePanel.add(destPanel, 
                //BorderLayout.NORTH);
                frame.getContentPane().add(sidePanel, 
                    BorderLayout.EAST);

                

            }
            catch(IOException e){

            }

           
        }
        //Display the window.
        //frame.pack();
        currentPlayer = userNames.get(
            currentPlayerNumber);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        runTurns();
    }
    /** represents the game over panel
     * 
     */
    public class EndPanel extends JPanel{
        public EndPanel() throws Exception{
            endImg = ImageIO.read(
            new File("endGameFinal.png"));
            setPreferredSize(new Dimension(1280, 980));
            repaint();
        }
        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.drawImage(endImg, 0, 0, this);
            Player p1 = userNames.get(0);
            Player p2 = userNames.get(0);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            if(p1.getScore() > p2.getScore()){
                g.drawString(p1.getName(), 1150, 700);
                g.drawString(Integer.toString(p1.getScore()),
                1150, 800);
            }
            else{
                g.drawString(p2.getName(), 1150, 700);
                g.drawString(Integer.toString(p2.getScore()),
                1150, 800);
                
            }
        }
    }
    /**
     * Displays a choice panel to choose meeple from each city
     * @param Destination d city to chose from
     * @param String city string rep. of destination
     * @return MEppel chose 
     */
    public Meeples meepleChoice(Destination d, String city){
        ArrayList<Meeples> m = d.getMeeples();
        Meeples[] meep = new Meeples[d.getMeeple()];
        meep =  m.toArray(meep);
        if(m == null)
            return null;

        Meeples selected = (Meeples) JOptionPane.
            showInputDialog(null,
                "Choose the meeple from " 
                + city,
                "Choose Meeple",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                meep, meep[0]);
        d.meeple.remove(selected);
        repaint();
        return selected;
    }

    /**
     * figures out what player is up
     * 
     * @param num the total number
     */
    public synchronized void wrapPlayerNumber(int num){
        BoardPanel.currentPlayerNumber = num % 
        (userNames.size());
        // reset
        cardPulled = false;
        turnSize = 0;
        destCardFlipped = false;
    }

    /**
     * when the selection button is pressed
     * turn off music
     * 
     * @param frame the frame on the screen
     * @param clip the music playing
     */
    public void selectionButtonPressed(
    JFrame frame){
        startMenu = false;
        frame.dispose();
        // clip.stop();
        createAndShowGUI();
    }

    /**
     * method that runs through all 
     * the turns of the players 
     */
    public void runTurns(){

        currentPlayer = userNames.get
        (currentPlayerNumber);
        if(sidePanel !=null && 
        playerTrainHand != null){
            int x = sidePanel.
                countComponents();
            if(sidePanel.countComponents()==5){
                sidePanel.remove(playerTrainHand);
            }
        }
        if(sidePanel !=null && 
        playerDestHand != null){
            if(sidePanel.countComponents()==4){
                sidePanel.remove(playerDestHand);
            }
        }

        playerTrainHand = new PlayerHand
        (currentPlayer.getTrainCards());
        playerDestHand = new PlayerHand
        (currentPlayer.getDestinationCards(), 1);
        if(sidePanel != null){
            if(sidePanel.countComponents() == 3){
                sidePanel.add(playerTrainHand);
                sidePanel.add(playerDestHand);
            }
        }
        //sidePanel.add(playerTrainHand, 
        //BorderLayout.SOUTH);

        playerTrainHand.revalidate();
        playerDestHand.revalidate();
        if(sidePanel != null){
            sidePanel.revalidate();
            sidePanel.repaint();
        }
        selectedCards.clear();
        usePanel = null;
        cardPanel = null;
    }

    /**
     * run the simulation of ticket to ride
     */
    public void runSimulation() {
        //choose game board
        //produce dialog box to choose board
        //Schedule a job for the event-dispatching thread:
        //creating and showing this 
        //asidePanellication's GUI.
        javax.swing.SwingUtilities.invokeLater
        (new Runnable() {
                /**
                 * calls method to
                 * play ticket to ride
                 */
                public void run() {
                    UserInfo info = new UserInfo();
                    info.getInfo();

                    createAndShowGUI();
                }
            });
    }

    /**
     * swaps between the panels on the screen
     */
    public void swapPanels(){
        if(playerPanel.equals("Destination")){
            int y = sidePanel.countComponents();
            if(upcards != null){
                upcards.hide();

                sidePanel.remove(upcards);

                upcards.revalidate();
                //sidePanel.revalidate();
            }

            if(sidePanel.countComponents() == 5){
                if(destPanel != null){
                    destPanel.hide();

                    sidePanel.remove(destPanel);

                }
            }
            int x = sidePanel.countComponents();
            if(sidePanel.countComponents() == 4 || 
            sidePanel.countComponents() == 5 ) {

                destPanel = new DestinationPanel();
                sidePanel.add(destPanel, 
                    BorderLayout.NORTH);
                destPanel.show();
                destPanel.revalidate();
                destPanel.repaint();
                sidePanel.revalidate();
                sidePanel.repaint();
            }

        }
        else if(playerPanel.equals("Train")){
            //when switching between panels, 
            //clear destination upcards
            for(DestinationCard dc : 
            destinationCards){
                if(dc.getType().equals
                ("Short")){
                    shortDestinationDeck.
                    putCardOnBottom(dc);

                } 
                if(dc.getType().equals
                ("Long")){
                    longDestinationDeck.
                    putCardOnBottom(dc);

                } 
            }
            destinationCards.clear();
            destinationCardLabels.clear();

            destPanel.hide();
            sidePanel.remove(destPanel);
            destPanel.revalidate();
            destPanel.repaint();
            int x = sidePanel.countComponents();
            if(sidePanel.countComponents() == 4 ) {
                upcards = new Upcards();
                sidePanel.add(upcards, 
                    BorderLayout.NORTH);
                upcards.show();
                upcards.revalidate();
                upcards.repaint();
                sidePanel.revalidate();
                sidePanel.repaint();
            }
        }
        runTurns();
    }

    // public int calcSelect(LocationNode city1,
    //LocationNode city2)
    // {
    // int count = 0;
    // int myScore = 0;
    // while(city1.nextCities[count] != city2)
    // {
    // count++;
    // if(count >= city1.nextCities.length)
    // {
    // return -1;
    // }           
    // }
    // Color tempCol = city1.getCol(count);
    // for(TrainCards curr: selectedCards)
    // {
    // if(curr.getColor() == tempCol)
    // {
    // myScore++;
    // }
    // else if(curr.getColor == TrainColor.rainbow)
    // {
    // myScore++;
    // }
    // else
    // {
    // myScore= -99;
    // }
    // }
    // return myScore;
    // }

    /**
     * calculates the selected route
     * 
     * @param city1 first city
     * @param city2 second city
     * @return boolean true if you can make the move,
     *                 false if you cant make the move
     */
    public boolean calcSelect(LocationNode city1, 
    LocationNode city2)
    {
        int count = 0;
        int myScore = 0;
        ArrayList<Destination> doubles = 
            new ArrayList<Destination>();
        extraSpots(doubles);
        System.out.println(Arrays.toString(doubles.toArray()));

        while(city1.nextCities[count] != city2)
        {
            count++;
            if(count >= city1.nextCities.length)
            {
                return false;
            }           
        }
        Color tempCol = city1.getCol(count);        
        int size = city1.getLength(count);
        Color trainColor = null;
        if(tempCol == GRAY && size == selectedCards.size())
        {
            int k = 0;       
            TrainCard t;
            while((trainColor == null || 
                trainColor == CYAN) &&
            (k < selectedCards.size())){
                t = selectedCards.get(k);
                if(t.getColor() == TrainColor.white){
                    trainColor = white;
                }
                else if(t.getColor() == TrainColor.black){
                    trainColor = black;
                }
                else if(t.getColor() == TrainColor.blue){
                    trainColor = blue;
                }
                else if(t.getColor() == TrainColor.green){
                    trainColor = green;
                }
                else if(t.getColor() == TrainColor.red){
                    trainColor = red;
                }
                else if(t.getColor() == TrainColor.purple){
                    trainColor  = pink;
                }

                else if(t.getColor() == TrainColor.orange){
                    trainColor = orange;
                }
                else if(t.getColor() == TrainColor.yellow){
                    trainColor = yellow;
                }
                else{
                    trainColor = Color.CYAN;
                }
                k++;
                myScore++;
            }
            tempCol = trainColor;

            for(int i = k ; i < selectedCards
            .size(); i++){
                TrainCard temp = selectedCards.get(i);
                if(temp.getColor() == TrainColor.white){
                    trainColor = white;
                }
                else if(temp.getColor() == TrainColor.black){
                    trainColor = black;
                }
                else if(temp.getColor() == TrainColor.blue){
                    trainColor = blue;
                }
                else if(temp.getColor() == TrainColor.green){
                    trainColor = green;
                }
                else if(temp.getColor() == TrainColor.red){
                    trainColor = red;
                }
                else if(temp.getColor() == TrainColor.purple){
                    trainColor  = pink;
                }

                else if(temp.getColor() == TrainColor.orange){
                    trainColor = orange;
                }
                else if(temp.getColor() == TrainColor.yellow){
                    trainColor = yellow;
                }
                else{
                    trainColor = Color.CYAN;
                }

                if(trainColor == tempCol ||
                trainColor == Color.CYAN)
                {
                    myScore++;
                }
                else
                {
                    myScore= -99;
                }
            }
        }

        else{
            for(TrainCard t: selectedCards){
                if(t.getColor() == TrainColor.white){
                    trainColor = white;
                }
                else if(t.getColor() == TrainColor.black){
                    trainColor = black;
                }
                else if(t.getColor() == TrainColor.blue){
                    trainColor = blue;
                }
                else if(t.getColor() == TrainColor.green){
                    trainColor = green;
                }
                else if(t.getColor() == TrainColor.red){
                    trainColor = red;
                }
                else if(t.getColor() == TrainColor.purple){
                    trainColor  = pink;
                }

                else if(t.getColor() == TrainColor.orange){
                    trainColor = orange;
                }
                else if(t.getColor() == TrainColor.yellow){
                    trainColor = yellow;
                }
                else{
                    trainColor = Color.CYAN;
                }

                if(trainColor == tempCol ||
                trainColor == Color.CYAN)
                {
                    myScore++;
                }
                else
                {
                    myScore= -99;
                }

            }

            if(myScore != size && doubles.contains(city1.getDestination())
            && doubles.contains(city2.getDestination())  )
            {
                System.out.println("my score: " + myScore + "City1: " + city1.getDestination() + "City2: " + city2.getDestination());
                myScore = 0;
                if(city1.nextCities[count+1] == city2)
                {
                    count++;
                    System.out.print("city1 + 1: " + city1.nextCities[count].getDestination());
                }
                else
                {
                    count--;
                    System.out.print("city1 - 1: " + city1.nextCities[count].getDestination());
                }
                tempCol = city1.getCol(count);        
                size = city1.getLength(count);
                System.out.println("Color 2nd check: " + tempCol.toString() + "Length: "+ size);
                if(tempCol == GRAY && size == selectedCards.size())
                {
                    return true;
                }

                for(TrainCard t: selectedCards){
                    if(t.getColor() == TrainColor.white){
                        trainColor = white;
                    }
                    else if(t.getColor() == TrainColor.black){
                        trainColor = black;
                    }
                    else if(t.getColor() == TrainColor.blue){
                        trainColor = blue;
                    }
                    else if(t.getColor() == TrainColor.green){
                        trainColor = green;
                    }
                    else if(t.getColor() == TrainColor.red){
                        trainColor = red;
                    }
                    else if(t.getColor() == TrainColor.purple){
                        trainColor  = pink;
                    }

                    else if(t.getColor() == TrainColor.orange){
                        trainColor = orange;
                    }
                    else if(t.getColor() == TrainColor.yellow){
                        trainColor = yellow;
                    }
                    else{
                        trainColor = Color.CYAN;
                    }

                    if(trainColor == tempCol ||
                    trainColor == Color.CYAN)
                    {
                        myScore++;
                    }
                    else
                    {
                        myScore= -99;
                    }
                }

            }

        }
        return (myScore == size);
    }
/**
 * initializes array of cities w/ double paths
 */
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
     * creates a second jPanel
     */
    public class SidePanel extends JPanel{
        private BufferedImage image;

        /**
         * Constructor for the side panel
         */
        public SidePanel(){
            setPreferredSize
            (new Dimension(650, 980));
            try{
                image = ImageIO.read(new
                    File("sample_background.jpg"));
                repaint();
            }
            catch(Exception e){}
            setBackground
            (Color.black);

        }

        /**
         * paint component method to paint the panel 
         * 
         * @param g the graphics object 
         */
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(image != null){
                g.drawImage(image, 0, 0, this);
            }
        }
    }
    /**
     * Gets the information in the
     * beginning from the user
     *
     * @author Kaley, Ben, Tyler, Zach, Sean
     * @version 4/29/18
     */
    public class UserInfo{
        protected ArrayList<Color> colorsPicked;
        protected String[] colorOptions = 
            {"Yellow", "Black", "White", "Purple", "Red"};

        /**
         * constructor for userInfo
         * 
         * initializes the arraylists and 
         * adds color options to pick from
         */
        public UserInfo(){
            colorsPicked = new ArrayList<Color>();

            users = new ArrayList<String>();
            colorOptionsAL.add("Yellow");
            colorOptionsAL.add("White");
            colorOptionsAL.add("Black");
            colorOptionsAL.add("Purple");
            colorOptionsAL.add("Red");
        }

        /**
         * generates pop up windows
         * to get information about players
         */
        public void getInfo(){
            numUsers = 2;

            System.out.println("Number of users: " 
                + numUsers);

            for(int i = 0; i< numUsers; i++){
                String name = JOptionPane.
                    showInputDialog(null, 
                        "Enter the name of player " + (i+1)
                    , "Player Names",
                        JOptionPane.
                        QUESTION_MESSAGE);
                users.add(name);
            }

            for(int i = 0; i < numUsers; i++){
                String col = (String)(findColor
                        (colorOptions, i));
                colorsPicked.add(color(col));
            }

            for(int i = 0; i < numUsers; i++){
                userNames.add(new Player(users.get(i), 
                        colorsPicked.get(i), trainDeck));
            }

            for(int i = 0; i < numUsers; i++){
                System.out.println("Name: " 
                    + userNames.get(i) + ", Color " 
                    + (colorsPicked.get(i).toString()));
            }
        }       

        /**
         * gets the color for each player
         * does not allow to pick the same color again
         * 
         * @param a[] the string array that holds 
         * the color options
         * @param index the index of what person 
         * is chosing
         * @return the String of the color picked
         */
        public String findColor(String[] a, int index){
            String colorPicked = null;
            while(colorPicked == null){
                colorPicked = (String)JOptionPane.
                showInputDialog(null,
                    "Choose the color for " 
                    + users.get(index),
                    "Choose Color",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    a, a[0]);
            }
            colorOptionsAL.remove(colorPicked);
            colorOptions = colorOptionsAL.toArray
            (colorOptions);
            return colorPicked;
        }

        /**
         * gets the value of the color picked
         * from the string value
         * 
         * @param c the string value of the 
         * color that is picked
         * @return the Color value 
         */
        public Color color(String c){
            if(c.equals("Yellow")){
                return Color.YELLOW;
            }
            else if(c.equals("Black")){
                return Color.BLACK;
            }
            else if(c.equals("White")){
                return Color.WHITE;
            }
            else if(c.equals("Purple")){
                return new Color(203,142,186);
            }
            else{
                return Color.RED;
            }
        }
    }

    /**
     * class to get cards face up on the panel
     */
    public class Upcards extends JPanel 
    implements MouseListener
    {
        protected ArrayList<JLabel> 
        showCards = new ArrayList<>(5);

        /**
         * constructor for the cards 
         * that are face up on the panel
         */
        public Upcards(){
            setPreferredSize(new Dimension(619, 300));
            setBackground(Color.black);
            //TrainDeck t = new TrainDeck();
            setOpaque(false);
            TrainCard card = null;
            showCards.clear();

            if(actualCards == null){
                actualCards = new ArrayList<>(5);
            }
            while(actualCards.size() < 5){
                card = trainDeck.pop();
                ///////
                // if card == null deck is empty
                // make call to end game/
                //calculate score
                actualCards.add(card);
            }
            int count = 0;
            for(int i = 0; i < actualCards.size(); i++){
                if(actualCards.get(i).getColor()
                == TrainColor.rainbow){
                    count++;
                }
            }
            if(count >= 3){
                actualCards.clear();
            while(actualCards.size() < 5){
                card = trainDeck.pop();
                ///////
                // if card == null deck is empty
                // make call to end game/
                //calculate score
                actualCards.add(card);
            }
        }

            //replaceUpcard();
            for(int i = 0; i < 5; i++){
                // need to handle if deck is empty
                // card = trainDeck.pop();
                // actualCards.add(card);

                showCards.add(new JLabel
                    (actualCards.get(i).getImage()));
                showCards.get(i).
                addMouseListener

                (new MouseAdapter(){
                        /**
                         * is implemented when the mouse is 
                         * clicked 
                         * 
                         * @param e the mouse 
                         * button that is clicked
                         */
                        public void 
                        mouseClicked( MouseEvent e ) {                           
                            if(currentPlayer.
                            getFirstTurn()){
                                JOptionPane.
                                showMessageDialog
                                (null, 
                                    "Must draw Destination "
                                    + "card first.");
                                return;
                            }
                            if(cardsDrawn<2&&!moveMade) {
                                JLabel refLabel = 
                                    (JLabel)e.getSource();
                                System.out.println
                                (refLabel);
                                int index = showCards.
                                    indexOf(refLabel);
                                cardPulled = true;

                                if(cardsDrawn == 1 && 
                                actualCards.get(index).
                                getColor() == 
                                TrainColor.rainbow){
                                    JOptionPane.
                                    showMessageDialog
                                    (null, 
                                        "Cannot pull rainbow " 
                                        + "at this time.");
                                    //actualCards.remove(index);
                                    return;
                                }
                                else{
                                    userNames.get
                                    (currentPlayerNumber)
                                    .addTrain(actualCards.
                                        get(index));
                                }

                                if(actualCards.get(index).
                                getColor() == 
                                TrainColor.rainbow){
                                    cardsDrawn = 2;
                                }
                                showCards.remove
                                (e.getSource());

                                actualCards.remove(index);
                                // actualCards.add
                                //(trainDeck.pop());
                                replaceUpcard();
                                // upcards = 
                                //new Upcards(actualCards);
                                if(sidePanel != null && 
                                upcards != null){
                                    int y = 0;
                                    upcards.revalidate();
                                    sidePanel.revalidate();
                                    sidePanel.repaint();
                                }
                                runTurns();
                                remove(refLabel);
                                cardsDrawn++;

                            }
                            else{
                                JOptionPane
                                .showMessageDialog
                                (null, 
                                    "No more cards can " +
                                    "be drawn. "+
                                    "Press Next Turn"+ 
                                    " to continue.");
                                return;
                            }
                        }
                    });
                add(showCards.get(i));

            }

            JLabel deck = new JLabel(new ImageIcon(
                        new File("trainUpcard.png").getAbsolutePath()));
            deck.addMouseListener(new MouseAdapter(){
                    /**
                     * implemented when the
                     * mouse is clicked
                     * 
                     * @param e the mouse 
                     * event that happens
                     */
                    public void mouseClicked(MouseEvent e){
                        if(cardsDrawn < 2 && !moveMade){
                            userNames.get
                            (currentPlayerNumber).
                            addTrain(trainDeck.pop());
                            cardPulled = true;
                            cardsDrawn++;
                            runTurns();
                        }
                        else{
                            JOptionPane.showMessageDialog
                            (null, 
                                "No more cards can " +
                                "be drawn. "+
                                "Press Next Turn"+
                                " to continue.");
                            return;
                        }
                    }
                });
            add(deck);
            //addMouseListener(new MouseStuff());

        }

        /**
         * replaces the cards that are faced upright
         */
        public void replaceUpcard(){
            // TrainCard card  = null;
            // while(actualCards.size() < 5){
            // card = trainDeck.pop();
            // actualCards.add(card);
            // }

            if(sidePanel.countComponents() == 5){
                sidePanel.remove(upcards);
            }

            upcards = new Upcards();
            if(sidePanel.countComponents() == 4){
                sidePanel.add(upcards);
            }

            //sidePanel.add(playerTrainHand, 
            //BorderLayout.SOUTH);
            upcards.revalidate();
            sidePanel.revalidate();
            sidePanel.repaint();

        }

        // private class MouseStuff 
        //extends MouseAdapter{
        // // if e.getSource() ;

        // public void MouseClicked(MouseEvent e){
        // JLabel refLabel = (JLabel)e.getSource();
        // System.out.println(refLabel.toString());
        // System.out.println("HERE");
        // }

        // }

        /**
         * implemented when the mouse 
         * enters a component
         * 
         * @param e the mouse event that happens
         */
        @Override
        public void mouseEntered( MouseEvent e ) { }

        /**
         * implemented when the mouse 
         * exits a component
         * 
         * @param e the mouse event that happens
         */
        @Override
        public void mouseExited( MouseEvent e ) { }

        /**
         * implemented when the mouse 
         * is clicked
         * 
         * @param e the mouse event that happens
         */
        @Override
        public void mouseClicked( MouseEvent e ) {
            JLabel refLabel = (JLabel)e.getSource();
            showCards.remove(e.getSource());
            repaint();
        }

        /**
         * implemented when the mouse 
         * is pressed
         * 
         * @param e the mouse event that happens
         */
        @Override
        public void mousePressed( MouseEvent e ) { }

        /**
         * implemented when the mouse 
         * is released
         * 
         * @param e the mouse event that happens
         */
        @Override
        public void mouseReleased( MouseEvent e ) { }

    }
    /**
     * Button Panel Class
     *
     * @author Kaley, Ben, Tyler, Zach, Sean
     * @version 4/28/18
     */
    public class ButtonPanel extends JPanel 
    implements ActionListener
    {

        /**
         * Constructor for objects of class ChoicePanel
         */
        public ButtonPanel(JPanel p)
        {
            setPreferredSize(new Dimension
                (619,150));
            // provide any initialisation 
            //necessary for your JApplet
            JRadioButton redButton = new 
                JRadioButton("Draw Train Cards");
            redButton.setActionCommand("Train");

            JRadioButton blueButton = new 
                JRadioButton("Draw Destination Cards");
            blueButton.setActionCommand("Destination");

            ButtonGroup buttons = new 
                ButtonGroup();
            buttons.add(redButton);
            buttons.add(blueButton);
            blueButton.setSelected(true);

            redButton.addActionListener(this);
            blueButton.addActionListener(this);

            JPanel buttonPanel = new JPanel
                (new GridLayout(1,0));
            buttonPanel.add(redButton);
            buttonPanel.add(blueButton);
            p.add(buttonPanel, BorderLayout.NORTH);

        }

        /**
         * is initiated when an action is preformed
         * shows messages to user for instructions
         * 
         * @param e the event 
         */
        public void actionPerformed(ActionEvent e)
        {
            if(destCardFlipped){
                JOptionPane.showMessageDialog(null,
                    "Please finish your turn");
                return;
            }
            if(!cardPulled){
                if (e.getActionCommand().
                equals("Train"))
                    playerPanel = "Train";
                if (e.getActionCommand().
                equals("Destination"))
                    playerPanel = "Destination";

                swapPanels();
            }
        }

    }

    /**
     * Destination Panel Class
     *
     * @author Kaley, Ben, Tyler, Zach, Sean
     * @version 4/28/18
     */
    public class DestinationPanel extends JPanel
    {

        /**
         * Constructor for objects of class 
         * DestinationPanel
         */
        public DestinationPanel()
        {
            setOpaque(false);
            setPreferredSize(new Dimension
                (640,300));
            setBackground(Color.black);

            JLabel longDeck = new JLabel
                (new ImageIcon(
                        new File
                        ("tickets/" + 
                            "yellowticket6.jpg").
                        getAbsolutePath()));
            longDeck.addMouseListener
            (new MouseAdapter(){
                    /**
                     * if the mouse is clicked
                     * 
                     * @param e the mouse click
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

                        for(JLabel j : 
                        destinationCardLabels){
                            add(j);
                            revalidate();
                        }

                        if(turnSize < 4){
                            turnSize++;
                            destCardFlipped = true;
                            DestinationCard temp 
                            = longDestinationDeck.
                                pullCard();
                            destinationCards.add(temp);
                            Destination d1 = temp.
                                getStart();
                            Destination d2 = temp.
                                getEnd();
                            String dest1 = d1.
                                toString().toLowerCase();
                            String dest2 = d2.
                                toString().toLowerCase();
                            String pathName = 
                                "pics/de-" + 
                                dest1 + "-" + dest2 +
                                "-small.png";
                            //File f = new File
                            //(pathName);
                            System.out.println
                            (pathName);
                            JLabel card = new 
                                JLabel(new ImageIcon
                                    (pathName));
                            destinationCardLabels.
                            add(card);
                            card.
                            addMouseListener
                            (new MouseAdapter(){
                                    /**
                                     * if the 
                                     * mouse is 
                                     * clicked
                                     * 
                                     * @param e 
                                     * the mouse 
                                     * click
                                     */
                                    public void 
                                    mouseClicked
                                    ( MouseEvent e ) {

                                        if(moveMade){
                                            JOptionPane.
                                            showMessageDialog
                                            (null, 
                                                "Cannot draw card"
                                                +" at this time.")
                                            ;   
                                        }
                                        if(e.
                                        getClickCount() 
                                        == 2 && !e.
                                        isConsumed()){
                                            System.out.
                                            println(
                                                "Clicked");
                                            JLabel ref = 
                                                (JLabel) 
                                                e.getSource();
                                            int index = 
                                                destinationCardLabels.
                                                indexOf(ref);
                                            if(index 
                                            >= 0 ){
                                                currentPlayer.
                                                addDestinationCard
                                                (destinationCards
                                                    .get(index));
                                            }
                                            cardPulled = true;
                                            destinationCardLabels
                                            .remove(index);
                                            destinationCards
                                            .remove(index);
                                            swapPanels();
                                            // revalidate();
                                            // repaint();
                                            // sidePanel
                                            //.revalidate();
                                            // sidePanel
                                            //.repaint();
                                            updateDestPanel();
                                            e.consume();
                                        }
                                    }
                                });
                            e.consume();
                            add(card);
                            //repaint();
                            revalidate();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                                "Can only draw 4 " +
                                "destination cards in a turn.");
                            return;
                        }
                    }
                });
            add(longDeck);

            JLabel shortDeck = new JLabel(new ImageIcon(
                        new File("tickets/tealticket.jpg")
                        .getAbsolutePath()));
            shortDeck.addMouseListener(new MouseAdapter(){
                    /**
                     * if the mouse is clicked
                     * @param e mouseEvent
                     */                

                    public void mouseClicked(MouseEvent e){
                        // if(cardsDrawn < 2){
                        // userNames.get(currentPlayerNumber)
                        //.addTrain(trainDeck.pop());
                        // cardsDrawn++;
                        // runTurns();
                        // }
                        if(turnSize < 4){
                            destCardFlipped = true;
                            turnSize++;
                            DestinationCard temp =
                                shortDestinationDeck.pullCard();
                            destinationCards.add(temp);
                            Destination d1 = temp.getStart();
                            Destination d2 = temp.getEnd();
                            String dest1 = d1.toString().toLowerCase();
                            String dest2 = d2.toString().toLowerCase();
                            String pathName = "pics/de-" + dest1 
                                + "-" + dest2 +
                                "-small.png";
                            //File f = new File(pathName);
                            System.out.println(pathName);
                            JLabel card = new JLabel
                                (new ImageIcon(pathName));
                            destinationCardLabels.add(card);
                            card.addMouseListener(new MouseAdapter(){
                                    /**
                                     * if the mouse is clicked
                                     * @param e mouseEvent
                                     */
                                    public void mouseClicked
                                    ( MouseEvent e ) {
                                        if(e.getClickCount() == 2
                                        && !e.isConsumed()){
                                            System.out.println
                                            ("Clicked");
                                            cardPulled = 
                                            true;
                                            JLabel ref =
                                                (JLabel) e.getSource();
                                            int index = 
                                                destinationCardLabels
                                                .indexOf(ref);
                                            if(index >= 0 ){
                                                currentPlayer.
                                                addDestinationCard
                                                (destinationCards.get(index));
                                            }
                                            //System.out.println
                                            //(destinationCards.size());
                                            destinationCardLabels.remove(index);
                                            destinationCards.remove(index);
                                            //System.out.println
                                            //(destinationCards.size());
                                            revalidate();
                                            swapPanels();
                                            repaint();
                                            // sidePanel.revalidate();
                                            // sidePanel.repaint();
                                            updateDestPanel();
                                            e.consume();
                                        }
                                    }
                                });
                            e.consume();
                            add(card);
                            //repaint();
                            revalidate();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                                "Can only draw 4 " +
                                "destination cards in a turn.");
                            return;
                        }
                    }
                });
            add(shortDeck);

        }

        /**
         * Updates the destination panel
         */
        public void updateDestPanel(){
            for(JLabel j : destinationCardLabels){
                destPanel.remove(j);

            }
            for(JLabel j : destinationCardLabels){
                destPanel.add(j);

            }
            revalidate();
        }

        // @Override
        // public void paintComponent(Graphics g){
        // for(JLabel d : destinationCardLabels){
        // this.add(d);
        // }
        // }
    }
    /**
     * class to make the players hand
     */
    public class PlayerHand extends JPanel implements MouseListener
    {
        volatile ArrayList<JLabel> showTrainCards = 
            new ArrayList<>(); 
        // took off private for testing
        private ArrayList<JLabel> showDestinationCards = 
            new ArrayList<>();
        private int rainbow, black, blue, green, orange,
        purple, red, white, yellow = 0;
        private int start = 0;
        private int end = 5;

        /**
         * Constructor for objects of class PlayerHand
         */
        public PlayerHand
        (ArrayList<TrainCard> playerTrainCards)
        {
            //setLayout(new GridLayout(2,5));
            //ArrayList<TrainCard> playerTrainCards = 
            //player.getTrainCards();
            setOpaque(false);
            setPreferredSize(new Dimension(619, 320));
            setBackground(Color.black);
            JLabel temp = null;
            ArrayList<TrainColor> colorsUsed = 
                new ArrayList<>(8);
            selectedCards = new ArrayList<TrainCard>();
            // count number of cards of each color
            if(playerTrainCards != null){
                for(TrainCard t : playerTrainCards){
                    if(t.getColor() == TrainColor.white){
                        white++;
                    }
                    else if(t.getColor() == TrainColor.black){
                        black++;
                    }
                    else if(t.getColor() == TrainColor.blue){
                        blue++;
                    }
                    else if(t.getColor() == TrainColor.green){
                        green++;
                    }
                    else if(t.getColor() == TrainColor.red){
                        red++;
                    }
                    else if(t.getColor() == TrainColor.purple){
                        purple++;
                    }
                    else if(t.getColor() == TrainColor.rainbow){
                        rainbow++;
                    }
                    else if(t.getColor() == TrainColor.orange){
                        orange++;
                    }
                    else if(t.getColor() == TrainColor.yellow){
                        yellow++;
                    }

                }

            }

            if(playerTrainCards != null){
                for(int i = 0; i <
                playerTrainCards.size(); i++){
                    TrainCard t = playerTrainCards.get(i);
                    if(colorsUsed.contains(t.getColor())){
                        continue;
                    }
                    else{
                        colorsUsed.add(t.getColor());
                        temp = new JLabel(t.getImage());
                        if(t.getColor() == TrainColor.white){
                            //temp.setText
                            //(Integer.toString(white));
                            temp.setText(String.format(
                                    "<html><font color='white'"
                                    +" font size='9'>%s</font></html>", 
                                    Integer.toString(white)));
                        }
                        else if(t.getColor() == TrainColor.black){
                            
                            temp.setText(String.format(
                                    "<html><font color='black'"
                                    +" font size='9'>%s</font></html>", 
                                    Integer.toString(black)));
                        }
                        else if(t.getColor() == TrainColor.blue){
                          
                            temp.setText(String.format(
                                    "<html><font color='blue'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(blue)));
                        }
                        else if(t.getColor() == TrainColor.green){
                            
                            temp.setText(String.format(
                                    "<html><font color='green'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(green)));
                        }
                        else if(t.getColor() == TrainColor.red){
                     
                            temp.setText(String.format(
                                    "<html><font color='red'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(red)));
                        }
                        else if(t.getColor() == TrainColor.purple){
                            ;
                            temp.setText(String.format(
                                    "<html><font color='purple'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(purple)));
                        }
                        else if(t.getColor() == TrainColor.rainbow){
                            
                            temp.setText(String.format(
                                    "<html><font color='white'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(rainbow)));
                        }
                        else if(t.getColor() == TrainColor.orange){
                            
                            temp.setText(String.format(
                                    "<html><font color='orange'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(orange)));
                        }
                        else if(t.getColor() == TrainColor.yellow){
                            
                            temp.setText(String.format(
                                    "<html><font color='yellow'"+
                                    " font size='9'>%s</font></html>", 
                                    Integer.toString(yellow)));
                        }
                        showTrainCards.add(temp);
                        temp.addMouseListener(new MouseAdapter(){
                                public void mouseClicked
                                ( MouseEvent e ) {
                                    JLabel refLabel =
                                    (JLabel) e.getSource();
                                    int index = 
                                    showTrainCards.indexOf(refLabel);
                                    if(index != -1){

                                        TrainCard cardTemp =
                                        playerTrainCards.get(index);
                                        playerTrainCards.remove(cardTemp);
                                        selectedCards.add(cardTemp);

                                    }
                                    repaint();
                                }

                            });
                        add(temp);

                    }
                }
            }
        }

        /**
         * constructor for player hand
         * @param playerDestcards arraylist of destination
         * cards
         * @param k integer for number of cards
         */
        public PlayerHand(ArrayList<DestinationCard>
        playerDestCards, int k){
            String arrowleft = "icons/arrow-left.png";
            JLabel leftArrow = 
                new JLabel(new ImageIcon(arrowleft));
            setOpaque(false);
            String arrowright = "icons/arrow-right.png";
            JLabel rightArrow =
                new JLabel(new ImageIcon(arrowright));
            if(playerDestCards.size() > 5){

                leftArrow.addMouseListener(new MouseAdapter(){
                        /**
                         * if the mouse is clicked
                         * @param e mouseEvent
                         */
                        public void mouseClicked
                        (MouseEvent e){

                            if(start > 0){
                                start--; 
                                end--;
                                revalidate();
                                repaint();
                                remove(rightArrow);
                                for(JLabel j : 
                                showDestinationCards){
                                    remove(j);

                                }
                                for(int i = start; 
                                i < end ; i++){
                                    JLabel j = 
                                     showDestinationCards.get(i);
                                    add(j);

                                }
                                add(rightArrow);
                                revalidate();
                            }
                        }  
                    });
                add(leftArrow);
            }

            setPreferredSize(new Dimension(619, 180));
            setBackground(Color.black);
            if(playerDestCards != null){
                if(playerDestCards.size() < 6){
                    for(DestinationCard d : playerDestCards){

                        Destination d1 = d.getStart();
                        Destination d2 = d.getEnd();
                        String dest1 =
                            d1.toString().toLowerCase();
                        String dest2 = 
                            d2.toString().toLowerCase();
                        String pathName = "pics/de-" + 
                            dest1 + "-" + dest2 +
                            "-small.png";
                        //File f = new File(pathName);

                        JLabel card = 
                            new JLabel(new ImageIcon(pathName));
                        showDestinationCards.add(card);
                        add(card);

                    }
                }
                else{
                    for(int i = start; i < end; i++){
                        DestinationCard d =
                            playerDestCards.get(i);
                        Destination d1 = d.getStart();
                        Destination d2 = d.getEnd();
                        String dest1 = 
                            d1.toString().toLowerCase();
                        String dest2 = 
                            d2.toString().toLowerCase();
                        String pathName = "pics/de-" + 
                            dest1 + "-" + dest2 +
                            "-small.png";
                        //File f = new File(pathName);

                        JLabel card = 
                            new JLabel(new ImageIcon(pathName));
                        showDestinationCards.add(card);
                        add(card);

                    }

                }
            }   
            if(playerDestCards.size() > 5){

                rightArrow.addMouseListener(new MouseAdapter(){
                        /**
                         * if the mouse is clicked
                         * @param e mouseEvent
                         */
                        public void mouseClicked(MouseEvent e){

                            if(end < playerDestCards.size()){
                                start++; 
                                end++;
                                revalidate();
                                repaint();
                                remove(rightArrow);
                                for(JLabel j : 
                                showDestinationCards){
                                    remove(j);

                                }
                                for(int i = start; i < end; i++){
                                    DestinationCard d =
                                        playerDestCards.get(i);
                                    Destination d1 =
                                        d.getStart();
                                    Destination d2 =
                                        d.getEnd();
                                    String dest1 = 
                                        d1.toString().toLowerCase();
                                    String dest2 = 
                                        d2.toString().toLowerCase();
                                    String pathName = "pics/de-" + 
                                        dest1 + "-" + dest2 +
                                        "-small.png";
                                    //File f = new File(pathName);

                                    JLabel j = 
                                        new JLabel(
                                            new ImageIcon(pathName));
                                    showDestinationCards.add(j);
                                    //JLabel j = 
                                    //showDestinationCards.get(i);
                                    add(j);

                                }
                            }
                            add(rightArrow);
                            revalidate();

                        }

                    });
                add(rightArrow);
            }
        }

        /**
         * if the mouse is entered
         * @param e mouseEvent
         */
        @Override
        public void mouseEntered( MouseEvent e ) { }

        /**
         * if the mouse is exited
         * @param e mouseEvent
         */
        @Override
        public void mouseExited( MouseEvent e ) { }

        /**
         * if the mouse is clicked
         * @param e mouseEvent
         */
        @Override
        public void mouseClicked( MouseEvent e ) {
            JLabel refLabel = (JLabel)e.getSource();
            repaint();
        }

        /**
         * if the mouse is pressed
         * @param e mouseEvent
         */
        @Override
        public void mousePressed( MouseEvent e ) { }

        /**
         * if the mouse is relesed
         * @param e mouseEvent
         */
        @Override
        public void mouseReleased( MouseEvent e ) { }

    }
    /**
     * class to get a scoreboard of scores
     */
    public class ScoreBoard extends JPanel{

        private ArrayList<JLabel> meepleImages;
        JLabel red;
        JLabel blue;
        JLabel green;
        JLabel white;
        JLabel black;
        JLabel yellow;
        /**
         * Constructor for objects of class PlayerHand
         */
        public ScoreBoard()
        {
         
            setPreferredSize(new Dimension(619, 100));
            setBackground(Color.black);
           

            //paths of meeple images
            String redPath = "meeples/red.png";
            String bluePath = "meeples/blue.png";
            String greenPath = "meeples/green.png";
            String blackPath = "meeples/black.png";
            String whitePath = "meeples/white.png";
            String yellowPath = "meeples/yellow.png";
            //create JLabels out of meeples 
            red = new JLabel(new ImageIcon(redPath));
            blue = new JLabel(new ImageIcon(bluePath));
            green = new JLabel(new ImageIcon(greenPath));
            black = new JLabel(new ImageIcon(blackPath));
            white = new JLabel(new ImageIcon(whitePath));
            yellow = new JLabel(new ImageIcon(yellowPath));
            //set text = number of meeples for a player
            red.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getRed()));
            blue.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getBlue()));
            green.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getGreen()));
            black.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getBlack()));
            white.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getWhite()));
            yellow.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getYellow()));
            // add to panel
            add(red);
            add(green);
            add(black);
            add(blue);

            add(white);
            add(yellow);
        }

        /**
         * method to draw the player name
         * @param g Graphics
         */
        @Override
        public void paintComponent(Graphics g){
            red.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getRed()));
            blue.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getBlue()));
            green.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getGreen()));
            black.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getBlack()));
            white.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getWhite()));
            yellow.setText(
                Integer.toString(userNames.
                    get(currentPlayerNumber).getYellow()));

            // g.drawImage(Hi, 0, 0, null);
            // g.drawImage(Hi, 0, 0, 50, 50, 0, 50, 50, 50, null);
            g.setFont(new Font("default", Font.BOLD, 16));
            String content = "Player: " + currentPlayer.getName()
                + " \t Score: " + currentPlayer.getScore(); 
            content += " \t Trains: " + currentPlayer
            .getNumberOfTrains();
            g.setColor(currentPlayer.getColor());
            g.drawString(content, 50, 80);
        }
    }
    /**
     * Creates a train card panel
     *
     * 
     */
    public class UseTrainCardPanel extends JPanel 
    {

        volatile ArrayList<JLabel> displayTrainCards =
            new ArrayList<>();
        /**
         * Constructor for objects of class UseTrainCardPanel
         */
        public UseTrainCardPanel(ArrayList<TrainCard>
        playerTrainCards, boolean isPlayers)
        {
            if(isPlayers){
                setPreferredSize(new Dimension(619, 640));
            }
            else{
                setPreferredSize(new Dimension(619, 320));
            }
            setBackground(Color.black);

            JLabel temp = null;
            // selectedCards = new ArrayList<TrainCard>();
            // ArrayList<TrainCard> copy = 
            //(ArrayList<TrainCard>)
            // playerTrainCards.clone();
            for(int i = 0;
            i < playerTrainCards.size(); i++){
                TrainCard t = playerTrainCards.get(i);

                temp = new JLabel(t.getImage());
                displayTrainCards.add(temp);
                if(isPlayers){
                    temp.addMouseListener(new MouseAdapter(){
                            /**
                             * if the mouse is clicked
                             * @param e mouseEvent
                             */
                            public synchronized void 
                            mouseClicked( MouseEvent e ) {
                                JLabel refLabel = 
                                    (JLabel) e.getSource();
                                int index = displayTrainCards
                                    .indexOf(refLabel);
                                if(index != -1){

                                    TrainCard cardTemp = 
                                        playerTrainCards.get(index);
                                    playerTrainCards.
                                    remove(cardTemp);
                                    selectedCards.
                                    add(cardTemp);
                                    updateSelectionPanel();
                                    revalidate();
                                    selectionPanel.repaint();
                                    selectionPanel.revalidate();
                                }
                                repaint();
                                
                            }

                        });
                }
                else{
                    temp.addMouseListener(
                    new MouseAdapter(){
                            /**
                             * if the mouse is clicked
                             * @param e mouseEvent
                             */
                            public void mouseClicked(
                            MouseEvent e ) {
                                JLabel refLabel = 
                                    (JLabel) e.getSource();
                                int index = 
                                    displayTrainCards.
                                    indexOf(refLabel);
                                if(index != -1){

                                    TrainCard cardTemp =
                                        selectedCards.get(index);
                                    selectedCards.
                                    remove(cardTemp);
                                    userNames.
                                    get(currentPlayerNumber).
                                    addTrain(cardTemp);
                                    updateSelectionPanel();
                                    revalidate();
                                    selectionPanel.repaint();
                                    selectionPanel.
                                    revalidate();
                                    isSelectedCards = true;
                                    repaint();
                                    isSelectedCards = false;
                                }
                                repaint();
                            }

                        });
                }
                add(temp);

            }

        }

        @Override 
        public synchronized void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.white);
            if(isSelectedCards){
                g.drawString("Selected Cards:"
                ,100, 10);
            }
        }

        /**
         * updates the selection panel
         */
        public synchronized void updateSelectionPanel(){

            if(selectionPanel != null){
                cardPanel.hide();
                usePanel.hide();
                selectionPanel.remove(cardPanel);
                selectionPanel.remove(usePanel);
                moveMade = moveMade; 
                // possible volatility issue
                cardPanel = new UseTrainCardPanel(
                    userNames.get(currentPlayerNumber).
                    getTrainCards(), true);

                usePanel = new UseTrainCardPanel(
                    selectedCards, false);
                selectionPanel.add(cardPanel);
                selectionPanel.add(usePanel);
                selectionPanel.revalidate();
            }
        }
    }

}
