import java.util.ArrayList;

/**
 * Class to play the game. It handles the logic of the game. 
 */

public class Game {
    
    // Game constructor
    public Game(){
		playGame();
	}

    //Method to play the game 
    private void playGame(){

        /**
        * Variables 
        *
        * board                object of the Board class                  
        * ArrAllPlayers        array with Player objects that contains the subclasses HumanPlayer and Bot objects            
        * currentPlayer        Player object to store the current player
        * numPlayers           number of players (bots and human players) 
        * numCounter           number of counters in line to win the game              
        * draw                 boolean variable. If true, the players drew, false otherwise
        * win                  boolean variable. If true, the current player won, false otherwise
        * placed               boolean variable. If true, the current player placed the counter, false otherwise
        *  
        */
        Board board = new Board(6, 7);
        ArrayList<Player> ArrAllPlayers = new ArrayList<Player>();
        Player currentPlayer = new Player("current", 0, 'z');
        Integer numPlayers = 2;
        Integer numCounter = 4;
        boolean draw = false;
        boolean win = false;
        boolean placed = false;

        // Introduction to the game
		System.out.println("Welcome to Connect 4!");
		System.out.println("There are 2 players, red (r) and yellow (y).");
		System.out.println("Player 1 is Red, Player 2 is Yellow.");
		System.out.println("To play the game type in the number of the column you want to drop your counter in."); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");
		System.out.println("");
		
        board.printBoard();

        // Create the player objects
        ArrAllPlayers.add(new HumanPlayer("Mauro", 1, 'r'));
        ArrAllPlayers.add(new Bot("C3PO", 2, 'y'));

        // Start a round. Each loop while is a complete game round
        while(!win){

            // Loop for each player turn
			for (int i = 1; i <= numPlayers; i++) {

                // Define which player is the current player
                for (int t = 0; t < ArrAllPlayers.size(); t++){
                    if (ArrAllPlayers.get(t).getTurn() == i){
                        currentPlayer = ArrAllPlayers.get(t);
                    }
                }
                
                System.out.println(currentPlayer.getName());
                
                // Place the counter in the board and print it
                while (!placed){
                    placed = board.placeCounter(currentPlayer.getColour(), currentPlayer.move(board));
                    if (placed){
                        break;
                    } else {
                        System.out.println("The column is full. Please select a different column.");
                    }			
                }

                placed = false;
                board.printBoard();
                System.out.println("");

                // Determine by the state of the board if the current player won or produced a draw
                // If win or draw are true, print the state and finish the game
                win = board.hasWon(currentPlayer.getColour(), numCounter);
                draw = board.draw();
                
                if(win){
                    System.out.println("You Have Won!!!");
                    break;
                } else if (draw){
                    System.out.println("Draw!!!");
                    break;
                }

            }
	    }
	}
}