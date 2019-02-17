/** NimGame Class
*  The model for the Game of Nim
*  Date Created:  25/05/2010
*  @author J.Burns
*/

//package SwingExample;
public class NimGame extends Object
{
  //Variable Declarations
  private NimGUI gameView;                 //The view for the game
  public static final int MAX_REMOVE = 3;  //The maximum number of tokens that can be removed at once
  
  private int pileSize;                    //The number of tokens remaining
  private String playerTurn;               //The player whose turn it is to take a token.  Must be either "red", "black", or "none"
  private String winner = "none";          //The player that wins the game (takes the last token)
  
  /** Creates a default game with 10 tokens and red player going first
    */
  public NimGame()
  {
    super();
    this.pileSize = 10;
    this.playerTurn = "red";
  }
  
  /** Sets the view for the game
    * @param currentGUI        The View used to display the game
    */ 
  public void setGUI(NimGUI currentGUI)
  {
    this.gameView = currentGUI;
  }
  
  /** Get the number of tokens in the pile
    * @return number of tokens remaining*/
  public int getPileSize()
  {
    return this.pileSize;
  }
  
  /** Get the player who's turn it is 
    * @return the current player (red, black or none)*/
  public String getPlayerTurn()
  {
    return this.playerTurn;
  }
  
  /** Get the winning player
    * @return the player that took the last token in the pile (red, black, or none)*/
  public String getWinner()
  {
    return this.winner;
  }
  
  /** Determine if the game is over (all the tokens have been removed)
    * @return if the game is over (true or false)*/
  private boolean gameOver()
  {
    return this.pileSize == 0;
  }
  
  /** Removes tokens from the pile
    * @param howMany        The number of tokens to remove
    */ 
  public void removeTokens(int howMany)
  {
    if (this.isLegalMove(howMany))  //If the move is legal, remove the tokens
    {
      this.pileSize = this.pileSize - howMany;
      if (this.gameOver()) // If the game is over, determine the winner, otherwise switch to next player
      {
        this.winner = this.playerTurn;
        this.playerTurn = "none";
      }
      else
      {
        this.playerTurn = this.otherPlayer(playerTurn);
      }
      this.updateView();
    }
  }
  
  /** Determines if the move is legal (1-3 tokens, as long as there are enough tokens left)
    * @param howMany                The number of tokens the player wants to remove
    * @return                       Whether the move is legal or not*/
  private boolean isLegalMove(int howMany)
  {
    return howMany >= 1 && howMany <= MAX_REMOVE && howMany <= pileSize;
  }
  
  /** Determines who the next player is
    * @param currentPlayer          The player that is currently removing tokens (red, black, none)
    * @return                       The next player that should remove tokens (red, black, none)*/
  public String otherPlayer(String currentPlayer)
  {
    if (currentPlayer.equals("red"))
    {
      return "black";
    }
    else if (currentPlayer.equals("black"))
    {
      return "red";
    }
    else
    {
      return "none";
    }
  }
  
  /**  Updates the view in the GUI*/
  public void updateView()
  {
    gameView.update();
  }
}
     