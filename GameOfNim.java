/**  The Game of Nim
*    Players alternate turns removing 1-3 tokens from a pile.  The player to remove the last token wins
*    Date Created: 25/05/2010
*    @author J.Burns
*/ 

//package SwingExample;
import javax.swing.*;

public class GameOfNim
{
  public static void main (String [] args)
  {
    NimGame game = new NimGame();          //The game model
    NimGUI mainScreen = new NimGUI(game);  //The game view
    
    //Initialize the Frame
    JFrame f = new JFrame("The Game of Nim");
    f.setSize(250,200);
    f.setLocation(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(mainScreen);
    f.setVisible(true);
  }
}