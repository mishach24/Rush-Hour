//Name:Mahrosh Chaudhry
//Date: November 19, 2021
//Purpose: to code rush hour
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import
    java.applet.Applet;

public class ChaudhrymahroshRushHour extends Applet implements ActionListener
{
    Panel p_card; //to hold all of the cards
    Panel card1, card2, card3, card4; //the four screens
    CardLayout cdLayout = new CardLayout ();
    //grid
    int row = 6;
    int col = 6;

    //current Car information
    JLabel currentPic;
    int whichCar = 0;
    int curX = 2;
    int curY = 1;
    int number = 1;
    JButton a[] = new JButton [row * col];
    //sound file
    AudioClip soundFile;
    //Date
    Date now = new Date ();
    DateFormat df = DateFormat.getDateInstance ();
    String s = df.format (now);
    boolean gameover = false;
    //arrays for levels. type and type 1 are identical.
    //level 1
    char type[] [] = {{'c', 'n', 'n', 'n', 'c', 'c'},
	    {'c', 'n', 'n', 'c', 'n', 'n'},
	    {'c', 'c', 'c', 'c', 'n', 'x'},
	    {'c', 'n', 'n', 'c', 'n', 'n'},
	    {'c', 'c', 'c', 'n', 'n', 'c'},
	    {'n', 'n', 'c', 'c', 'c', 'c'}};
    int car[] [] = {{8, 0, 0, 0, 2, 2},
	    {8, 0, 0, 9, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {6, 0, 0, 9, 0, 0},
	    {6, 1, 1, 0, 0, 5},
	    {0, 0, 4, 4, 4, 5}};
    char slice[] [] = {{'f', 'n', 'n', 'n', 'f', 'b'},
	    {'m', 'n', 'n', 'f', 'n', 'n'},
	    {'b', 'f', 'b', 'm', 'n', 'n'},
	    {'f', 'n', 'n', 'b', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'f'},
	    {'n', 'n', 'f', 'm', 'b', 'b'}};
    //identical to level 1
    char type1[] [] = {{'c', 'n', 'n', 'n', 'c', 'c'},
	    {'c', 'n', 'n', 'c', 'n', 'n'},
	    {'c', 'c', 'c', 'c', 'n', 'x'},
	    {'c', 'n', 'n', 'c', 'n', 'n'},
	    {'c', 'c', 'c', 'n', 'n', 'c'},
	    {'n', 'n', 'c', 'c', 'c', 'c'}};
    int car1[] [] = {{8, 0, 0, 0, 2, 2},
	    {8, 0, 0, 9, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {6, 0, 0, 9, 0, 0},
	    {6, 1, 1, 0, 0, 5},
	    {0, 0, 4, 4, 4, 5}};
    char slice1[] [] = {{'f', 'n', 'n', 'n', 'f', 'b'},
	    {'m', 'n', 'n', 'f', 'n', 'n'},
	    {'b', 'f', 'b', 'm', 'n', 'n'},
	    {'f', 'n', 'n', 'b', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'f'},
	    {'n', 'n', 'f', 'm', 'b', 'b'}};
    // level 2
    char type2[] [] = {{'c', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'c', 'c', 'n', 'n', 'x'},
	    {'c', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'c', 'c', 'n', 'n', 'c'},
	    {'n', 'n', 'c', 'c', 'c', 'c'}};
    int car2[] [] = {{9, 0, 0, 0, 0, 0},
	    {9, 0, 0, 0, 0, 0},
	    {9, 0, 0, 0, 0, 0},
	    {5, 0, 0, 0, 0, 0},
	    {5, 1, 1, 0, 0, 6},
	    {0, 0, 4, 4, 4, 6}};
    char slice2[] [] = {{'f', 'n', 'n', 'n', 'n', 'n'},
	    {'m', 'n', 'n', 'n', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'n'},
	    {'f', 'n', 'n', 'n', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'f'},
	    {'n', 'n', 'f', 'm', 'b', 'b'}};
    //level 3
    char type3[] [] = {{'n', 'n', 'c', 'n', 'n', 'n'},
	    {'n', 'n', 'c', 'n', 'n', 'n'},
	    {'n', 'n', 'c', 'n', 'n', 'n'},
	    {'n', 'n', 'c', 'c', 'n', 'x'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'}};
    int car3[] [] = {{0, 0, 9, 0, 0, 0},
	    {0, 0, 9, 0, 0, 0},
	    {0, 0, 9, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0}};
    char slice3[] [] = {{'n', 'n', 'f', 'n', 'n', 'n'},
	    {'n', 'n', 'm', 'n', 'n', 'n'},
	    {'n', 'n', 'b', 'n', 'n', 'n'},
	    {'n', 'n', 'f', 'b', 'n', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'}};
    //level 4
    char type4[] [] = {{'n', 'c', 'c', 'c', 'n', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'x', 'n', 'n', 'c', 'c', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'n', 'n', 'n', 'n', 'n'}};
    int car4[] [] = {{0, 4, 4, 4, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {6, 0, 0, 0, 0, 0},
	    {6, 0, 0, 0, 0, 0}};
    char slice4[] [] = {{'n', 'f', 'm', 'b', 'n', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'n', 'n', 'n', 'f', 'b', 'n'},
	    {'n', 'n', 'n', 'n', 'n', 'n'},
	    {'f', 'n', 'n', 'n', 'n', 'n'},
	    {'b', 'n', 'n', 'n', 'n', 'n'}};
    //level 5
    char type5[] [] = {{'n', 'n', 'c', 'n', 'n', 'n'},
	    {'n', 'n', 'c', 'c', 'c', 'c'},
	    {'n', 'n', 'c', 'n', 'n', 'n'},
	    {'n', 'n', 'c', 'c', 'n', 'x'},
	    {'c', 'n', 'n', 'n', 'n', 'n'},
	    {'c', 'n', 'n', 'n', 'n', 'n'}};
    int car5[] [] = {{0, 0, 9, 0, 0, 0},
	    {0, 0, 9, 4, 4, 4},
	    {0, 0, 9, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0},
	    {5, 0, 0, 0, 0, 0},
	    {5, 0, 0, 0, 0, 0}};
    char slice5[] [] = {{'n', 'n', 'f', 'n', 'n', 'n'},
	    {'n', 'n', 'm', 'f', 'm', 'b'},
	    {'n', 'n', 'b', 'n', 'n', 'n'},
	    {'n', 'n', 'f', 'b', 'n', 'n'},
	    {'f', 'n', 'n', 'n', 'n', 'n'},
	    {'b', 'n', 'n', 'n', 'n', 'n'}};
    
    //hold all game screens.
    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//make the 4 screens
	initOpening ();
	initRules ();
	initGame ();
	initHelp ();
	//size of app.
	resize (600, 680);
	setLayout (new BorderLayout ());
	initMenu (); //<--------- holds all information for 'navigate button'
	add ("Center", p_card);
	//music
	soundFile = getAudioClip (getDocumentBase (), "music.snd");
	soundFile.loop ();

    }

   //menu bar for game. File and navigate.
    public void initMenu ()
    {
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Close");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("Close");
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s1");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Instructions");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s2");
	menu.add (menuItem);
	//game screen
	menuItem = new JMenuItem ("Play Game");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s3");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Exit");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s4");
	menu.add (menuItem);
	add ("North", menuBar);
    }

    //welcome screen
    public void initOpening ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card1 = new Panel ();
	card1.setBackground (Color.gray);
	JLabel title = new JLabel (createImageIcon ("title.png"));
	JLabel sun = new JLabel (createImageIcon ("sunglass.png"));
	JButton next = new JButton ("Next");
	next.setPreferredSize (new Dimension (300, 50));
	next.setBackground (Color.gray);
	next.setForeground (new Color (254, 220, 236));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (sun);
	card1.add (next);
	p_card.add ("1", card1);
	//Welcome formalities before game
	String input = JOptionPane.showInputDialog ("What is an accessory people wear when it's sunny?");
	JOptionPane.showMessageDialog (null, s, "Date", JOptionPane.ERROR_MESSAGE);
	String input1 = JOptionPane.showInputDialog ("Player name:");
	JOptionPane.showMessageDialog (null, createImageIcon ("sunglass.png"), "Welcome to the game " + input1, JOptionPane.INFORMATION_MESSAGE);
    }

  
    //instructions screen
    public void initRules ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card2 = new Panel ();
	card2.setBackground (Color.gray);
	JButton next = new JButton (createImageIcon ("instruct.png"));
	next.setPreferredSize (new Dimension (600, 650));
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (next);
	p_card.add ("2", card2);
    }

    // game board and levels located here.
    public void initGame ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card3 = new Panel ();
	card3.setBackground (Color.gray);
	JButton next = new JButton ("Next");
	next.setBackground (Color.gray);
	next.setForeground (new Color (254, 220, 236));
	next.setActionCommand ("s4");
	next.addActionListener (this);
	currentPic = new JLabel (createImageIcon ("little0.png"));
	JButton up = new JButton ("Up");
	up.setBackground (Color.gray);
	up.setForeground (new Color (254, 220, 236));
	up.setActionCommand ("up");
	up.addActionListener (this);
	JButton down = new JButton ("Down");
	down.setBackground (Color.gray);
	down.setForeground (new Color (254, 220, 236));
	down.setActionCommand ("down");
	down.addActionListener (this);
	JButton right = new JButton ("Right");
	right.setBackground (Color.gray);
	right.setForeground (new Color (254, 220, 236));
	right.setActionCommand ("right");
	right.addActionListener (this);
	JButton left = new JButton ("Left");
	left.setBackground (Color.gray);
	left.setForeground (new Color (254, 220, 236));
	left.setActionCommand ("left");
	left.addActionListener (this);
	JButton nextLevel = new JButton ("Next Level");
	nextLevel.setBackground (Color.gray);
	nextLevel.setForeground (new Color (254, 220, 236));
	nextLevel.setActionCommand ("nextLevel");
	nextLevel.addActionListener (this);
	JButton reset = new JButton ("Reset");
	reset.setBackground (Color.gray);
	reset.setForeground (new Color (254, 220, 236));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	JButton run = new JButton ("Instructions");
	run.setBackground (Color.gray);
	run.setForeground (new Color (254, 220, 236));
	run.addActionListener (this);
	run.setActionCommand ("instruct");
	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		//add in when you have pictures
		a [move] = new JButton (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
		//change to be your size
		a [move].setPreferredSize (new Dimension (85, 85));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}

	card3.add (up);
	card3.add (down);
	card3.add (currentPic);
	card3.add (left);
	card3.add (right);
	card3.add (p);

	p_card.add ("3", card3);
	card3.add (next);
	card3.add (nextLevel);
	card3.add (reset);
	card3.add (next);
	card3.add (run);
	p_card.add ("3", card3);
    }

    //Exit screen. 
    public void initHelp ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card4 = new Panel ();
	card4.setBackground (Color.gray);
	JLabel title = new JLabel ("Thank You For Playing");
	title.setForeground (new Color (254, 220, 236));
	JButton next = new JButton ("Back To Home");
	next.setBackground (Color.gray);
	next.setPreferredSize (new Dimension (300, 50));
	next.setForeground (new Color (254, 220, 236));
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JLabel sun3 = new JLabel (createImageIcon ("sunglass1.png"));
	JButton exit = new JButton ("Exit");
	exit.setPreferredSize (new Dimension (300, 50));
	exit.setBackground (Color.gray);
	exit.setForeground (new Color (254, 220, 236));
	exit.setActionCommand ("s6");
	exit.addActionListener (this);
	card4.add (title);
	card4.add (sun3);
	card4.add (next);
	card4.add (exit);
	p_card.add ("4", card4);
    }

    //call image method
    protected static ImageIcon createImageIcon (String path)
    { //change the red to your class name
	java.net.URL imgURL = ChaudhrymahroshRushHour.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }

    //redraw method
    public void redraw ()
    {
	if (type [2] [5] != 'c')
	    type [2] [5] = 'x';
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
		move++;
	    }
	}

    }

    //find car method.
    public void findFront (int x, int y)

    {

	if (slice [x] [y] == 'f')

	    {

		curX = x;

		curY = y;

	    }

	//2 piece cars, go left-right

	else if (whichCar <= 2 && slice [x] [y] == 'b')

	    {

		curX = x;

		curY = y - 1;

	    }

	//3 piece trucks, go left-right

	else if (whichCar <= 4 && slice [x] [y] == 'm')

	    {

		curX = x;

		curY = y - 1;

	    }

	else if (whichCar <= 4 && slice [x] [y] == 'b')

	    {

		curX = x;

		curY = y - 2;

	    }

	//2 piece cars, go up-down

	else if (whichCar <= 7 && slice [x] [y] == 'b')

	    {

		curX = x - 1;

		curY = y;

	    }

	//3 piece trucks, go up-down

	else if (whichCar <= 9 && slice [x] [y] == 'm')

	    {

		curX = x - 1;

		curY = y;

	    }

	else if (whichCar <= 9 && slice [x] [y] == 'b')

	    {

		curX = x - 2;

		curY = y;

	    }

	showStatus (curX + ", " + curY);
    }

   //method for up button.
    public void moveUp ()

    {

	if (whichCar <= 4)

	    showStatus ("Can't move up or down");
	else if (curX - 1 >= 0 && slice [curX - 1] [curY] != 'n')
	    showStatus ("There is a car there!");

	//2 piece cars, go up-down

	else if (whichCar <= 7 && curX - 1 >= 0)

	    {

		type [curX - 1] [curY] = 'c';

		type [curX] [curY] = 'c';

		type [curX + 1] [curY] = 'n';


		slice [curX - 1] [curY] = 'f';

		slice [curX] [curY] = 'b';

		slice [curX + 1] [curY] = 'n';


		car [curX - 1] [curY] = whichCar;

		car [curX] [curY] = whichCar;

		car [curX + 1] [curY] = 0;

		curX--;


	    }

	//3 piece trucks, go up

	else if (whichCar <= 9 && curX - 1 >= 0)

	    {

		type [curX - 1] [curY] = 'c';

		type [curX] [curY] = 'c';

		type [curX + 1] [curY] = 'c';

		type [curX + 2] [curY] = 'n';


		slice [curX - 1] [curY] = 'f';

		slice [curX] [curY] = 'm';

		slice [curX + 1] [curY] = 'b';

		slice [curX + 2] [curY] = 'n';


		car [curX - 1] [curY] = whichCar;

		car [curX] [curY] = whichCar;

		car [curX + 1] [curY] = whichCar;

		car [curX + 2] [curY] = 0;

		curX--;


	    }

    }

    //method for down button.
    public void moveDown ()

    {

	if (whichCar <= 4)

	    showStatus ("Can't move up or down");

	else if (whichCar <= 7 && curX + 2 < row && slice [curX + 2] [curY] != 'n')

	    showStatus ("There is a car there!");

	else if (whichCar > 7 && whichCar <= 9 && curX + 3 < row && slice
		[curX + 3] [curY] != 'n')

	    showStatus

		("There is a car there!");

	//2 piece cars, go down

	else if (whichCar <= 7 && curX + 2 < row)

	    {

		type [curX] [curY] = 'n';

		type [curX + 1] [curY] = 'c';

		type [curX + 2] [curY] = 'c';


		slice [curX] [curY] = 'n';

		slice [curX + 1] [curY] = 'f';

		slice [curX + 2] [curY] = 'b';


		car [curX] [curY] = 0;

		car [curX + 1] [curY] = whichCar;

		car [curX + 2] [curY] = whichCar;

		curX++;


	    }

	//3 piece trucks, go down

	else if (whichCar <= 9 && curX + 3 < row)

	    {

		type [curX] [curY] = 'n';

		type [curX + 1] [curY] = 'c';

		type [curX + 2] [curY] = 'c';

		type [curX + 3] [curY] = 'c';


		slice [curX] [curY] = 'n';

		slice [curX + 1] [curY] = 'f';

		slice [curX + 2] [curY] = 'm';

		slice [curX + 3] [curY] = 'b';


		car [curX] [curY] = 0;

		car [curX + 1] [curY] = whichCar;

		car [curX + 2] [curY] = whichCar;

		car [curX + 3] [curY] = whichCar;

		curX++;


	    }

    }


    //method for left button.
    public void moveLeft ()

    {

	if (whichCar >= 5)
	    showStatus ("Can't move left or right");
	else if (curY - 1 >= 0 && slice [curX] [curY - 1] != 'n')
	    showStatus ("There is a car there!");

	//2 piece cars, go left

	else if (whichCar <= 2 && curY - 1 >= 0)

	    {
		type [curX] [curY - 1] = 'c';
		type [curX] [curY] = 'c';
		type [curX] [curY + 1] = 'n';
		slice [curX] [curY - 1] = 'f';
		slice [curX] [curY] = 'b';
		slice [curX] [curY + 1] = 'n';
		car [curX] [curY - 1] = whichCar;
		car [curX] [curY] = whichCar;
		car [curX] [curY + 1] = 0;
		curY--;

	    }

	//3 piece trucks, go left

	else if (whichCar <= 4 && curY - 1 >= 0)
	{
	    type [curX] [curY - 1] = 'c';
	    type [curX] [curY] = 'c';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'n';
	    slice [curX] [curY - 1] = 'f';
	    slice [curX] [curY] = 'm';
	    slice [curX] [curY + 1] = 'b';
	    slice [curX] [curY + 2] = 'n';
	    car [curX] [curY - 1] = whichCar;
	    car [curX] [curY] = whichCar;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = 0;
	    curY--;

	}

    }

    //method for right button.
    public void moveRight ()
    {
	if (whichCar >= 5)
	    showStatus ("Can't move left or right");
	else if (whichCar <= 2 && curY + 2 < col && slice [curX] [curY + 2] != 'n')
	    showStatus ("There is a car there!");
	else if (whichCar > 2 && whichCar <= 4 && curY + 3 < col && slice [curX] [curY + 3] != 'n')
	    showStatus ("There is car there!");
	//2 piece cars, go up-down

	else if (whichCar <= 2 && curY + 2 < col)
	{
	    type [curX] [curY] = 'n';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX] [curY + 1] = 'f';
	    slice [curX] [curY + 2] = 'b';
	    car [curX] [curY] = 0;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = whichCar;
	    curY++;
	}
	//3 piece trucks, go up-down
	else if (whichCar <= 4 && curY + 3 < col)
	{
	    type [curX] [curY] = 'n';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'c';
	    type [curX] [curY + 3] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX] [curY + 1] = 'f';
	    slice [curX] [curY + 2] = 'm';
	    slice [curX] [curY + 3] = 'b';
	    car [curX] [curY] = 0;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = whichCar;
	    car [curX] [curY + 3] = whichCar;
	    curY++;

	}

    }




   //Outputs button calls.
    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("s6"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("up"))
	    moveUp ();
	else if (e.getActionCommand ().equals ("down"))
	    moveDown ();
	else if (e.getActionCommand ().equals ("left"))
	    moveLeft ();
	else if (e.getActionCommand ().equals ("right"))
	    moveRight ();
	else if (e.getActionCommand ().equals ("nextLevel"))
	    next ();
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
	else if (e.getActionCommand ().equals ("Close"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("instruct"))
	{
	    //instructions for game screen
	    JOptionPane.showMessageDialog (null, "* * * I N S T R U C T I O N S *    * * \n \n"
		    + "The point of this game is to take the yellow sunglasses out \n"
		    + "Use the movement buttons to move other colored glasses around \n"
		    + "in order to make room for the yellow sunglasses. \n"
		    + "Use the 'Reset' button to start the gameboard again.\n"
		    + "Use the menu bar to navigate between screens. \n"
		    + "Use the Next Level button to move between screens. \n"
		    + "Use the next button to move to the exit game screen. \n \n"
		    + "Enjoy!!", "Instructions", JOptionPane.QUESTION_MESSAGE);
	}

	else
	{ //code to handle the game
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;
	    if (type [x] [y] == 'c')
	    {
		whichCar = car [x] [y];
		findFront (x, y);
		currentPic.setIcon (createImageIcon ("little" + whichCar + ".png"));
	    }

	}
	redraw ();
	win ();
    }


    public void copyOver (int a[] [], int b[] [])
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [i] [j] = b [i] [j];
	    }
	}
    }


    public void copyOver (char a[] [], char b[] [])
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [i] [j] = b [i] [j];
	    }
	}
    }

    //next level.
    public void next ()
    {
	number++;
	gameover = false;
	if (number == 2)
	{
	    copyOver (type, type2);
	    copyOver (car, car2);
	    copyOver (slice, slice2);
	}
	else if (number == 3)
	{
	    copyOver (type, type3);
	    copyOver (car, car3);
	    copyOver (slice, slice3);
	}
	else if (number == 4)
	{
	    copyOver (type, type4);
	    copyOver (car, car4);
	    copyOver (slice, slice4);
	}
	else if (number == 5)
	{
	    copyOver (type, type5);
	    copyOver (car, car5);
	    copyOver (slice, slice5);
	}

	else
	{
	    copyOver (type, type1);
	    copyOver (car, car1);
	    copyOver (slice, slice1);
	    number = 1;
	}


	redraw ();
	whichCar = 0;
	curX = 2;
	curY = 1;
	currentPic.setIcon (createImageIcon ("little0.png"));
    }

    //reset board game.
    public void reset ()
    {
	if (number == 1)
	{
	    copyOver (type, type1);
	    copyOver (car, car1);
	    copyOver (slice, slice1);
	}


	else if (number == 2)
	{
	    copyOver (type, type2);
	    copyOver (car, car2);
	    copyOver (slice, slice2);
	}
	else if (number == 3)
	{
	    copyOver (type, type3);
	    copyOver (car, car3);
	    copyOver (slice, slice3);
	}
	else if (number == 4)
	{
	    copyOver (type, type4);
	    copyOver (car, car4);
	    copyOver (slice, slice4);
	}
	else if (number == 5)
	{
	    copyOver (type, type5);
	    copyOver (car, car5);
	    copyOver (slice, slice5);
	}


	redraw ();
	whichCar = 0;
	curX = 2;
	curY = 1;
	gameover = false;
	currentPic.setIcon (createImageIcon ("little0.png"));
    }

    //win game
    public void win ()
    {
	if (type [2] [5] == 'c' && car [2] [5] == 0 && gameover == false)
	{
	    gameover = true;
	    JOptionPane.showMessageDialog (null, "You got the yellow sunglasses out!",
		    "Good Job", JOptionPane.INFORMATION_MESSAGE);
	}
	else if (type [3] [5] == 'c' && car [3] [5] == 0 && gameover == false)
	{
	    gameover = true;
	    JOptionPane.showMessageDialog (null, "You got the yellow sunglasses out!",
		    "Good Job", JOptionPane.INFORMATION_MESSAGE);
	}
	else if (type [2] [0] == 'c' && car [2] [0] == 0 && gameover == false)
	{
	    gameover = true;
	    JOptionPane.showMessageDialog (null, "You got the yellow sunglasses out!",
		    "Good Job", JOptionPane.INFORMATION_MESSAGE);
	}
    }
}



