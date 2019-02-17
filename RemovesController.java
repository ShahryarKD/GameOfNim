/** RemovesController class
  * The controller for the removal of tokens from the pile
  * Date Created:  25/05/2010
  * @author  J.Burns
  */ 
//package SwingExample;
import javax.swing.*;
import java.awt.event.*;

public class RemovesController implements ActionListener
{
  private NimGame game;            //The Model used to describe the game
  private JTextField textField;    //The component linked to the controller
  
  /** Default constructor
    * Links the component to the Model
    * @param aGame          The Model describing game behaviour
    * @param aTextField     The component being interacted with
    */ 
  public RemovesController(NimGame aGame, JTextField aTextField)
  {
    this.game = aGame;
    this.textField = aTextField;
  }
  
  /** Removes tokens from the pile when a number is entered in the textbox
    * @param e      The event sent from the textbox component
    */ 
  public void actionPerformed(ActionEvent e)
  {
    try{
      int remove = Integer.parseInt(this.textField.getText());
      this.game.removeTokens(remove);
       } catch (NumberFormatException ex)
       {
     this.textField.selectAll();
       }
 
  }
}
