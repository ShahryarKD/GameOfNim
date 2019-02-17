/**NimGUI Class
  * The GUI View for the Game of Nim
  * Date Created:  25/05/2010
  * @author      J.Burns
  */
//package SwingExample;
import javax.swing.*;
import java.awt.*;

public class NimGUI extends JPanel
{
  //Instance Variables
  private NimGame game;                        //The game Model
  
  private JTextField redRemoves = new JTextField(5);   //Red Player # tokens to remove
  private JLabel redWins = new JLabel("Winner!");      //Displays if red player wins
  
  private JTextField blackRemoves = new JTextField(5); //Black Player # tokens to remove
  private JLabel blackWins = new JLabel("Winner!");    //Displays if black player wins
  
  private JLabel pileSize = new JLabel();              //The number of tokens remaining
  
  /** Default constructor for the GUI.  Assigns Model and View, identifies controllers
    * and draws the layout
    * @param newGame        The Model for the game
    */ 
  public NimGUI(NimGame newGame)
  {
    super();
    this.game = newGame;
    this.game.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  /** Draws the initial layout for the game board
    */ 
  private void layoutView()
  {
    //The Red player
    JPanel red = new JPanel();
    red.add(this.redRemoves);
    red.add(this.redWins);
    red.setBorder(BorderFactory.createTitledBorder("Red"));
    
    //The Black Player
    JPanel black = new JPanel();
    black.add(this.blackRemoves);
    black.add(this.blackWins);
    black.setBorder(BorderFactory.createTitledBorder("Black"));
    
    //The number of tokens remaining
    JPanel pSize = new JPanel();
    pSize.add (this.pileSize);
    pSize.setBorder(BorderFactory.createTitledBorder("Pile Size"));
    
    //Red and black player boards
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(1,2));
    center.add(red);
    center.add(black);
    
    //The complete layout
    this.setLayout(new BorderLayout());
    this.add(center, BorderLayout.CENTER);
    this.add(pSize, BorderLayout.SOUTH);
  }
  
  /**Assigns the controllers to the remove tokens textboxes.
    */ 
  private void registerControllers()
  {
    //Red Player
    RemovesController redController = new RemovesController(this.game, this.redRemoves);
    this.redRemoves.addActionListener(redController);
    
    //Black Player
    RemovesController blackController = new RemovesController(this.game, this.blackRemoves);
    this.blackRemoves.addActionListener(blackController);
  }
  
  /** Redraws the game board according to the current game situation.  Requires data
    * from the Model.
    */ 
  public void update()
  {
    //Determine number of tokens remaining
    this.pileSize.setText("" + this.game.getPileSize());
    
    //Identify who's turn it is to remove tokens
    this.redRemoves.setEnabled(this.game.getPlayerTurn().equals("red"));
    this.blackRemoves.setEnabled(this.game.getPlayerTurn().equals("black"));
    
    //Display winner
    this.redWins.setVisible(this.game.getWinner().equals("red"));
    this.blackWins.setVisible(this.game.getWinner().equals("black"));
    
    //Set focus for current player
    if(this.game.getPlayerTurn().equals("red"))
    {
      this.redRemoves.requestFocusInWindow();
      this.redRemoves.setText("");
    }
    else if(this.game.getPlayerTurn().equals("black"))
    {
      this.blackRemoves.requestFocusInWindow();
      this.blackRemoves.setText("");
    }
  }
}