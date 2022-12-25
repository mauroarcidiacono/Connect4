import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class to create human players and handle their game input. Subclass of Player.
 */

public class HumanPlayer extends Player{

    // Create an input variable to read and store user input
    private BufferedReader input;
    
    // HumanPlayer constructor
    public HumanPlayer(String name, int turn, char colour){
        super(name, turn, colour);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
    * Method that takes an user input 
    *
    * @param  board        character 2D array that represents the board
    * @return              string input 
    */
    public String getUserInput(Board board){
		String toReturn = null;
		try{
            boolean valid = false;			
			while (!valid){
                System.out.println("Input a column number:");
                toReturn = input.readLine();
                valid = isValidInput(toReturn, board);
            }
		}
		catch(Exception e){
			System.out.println(e);
		}
		return toReturn;
	}

    /**
    * Method that evaluates if a user input is valid 
    *
    * @param  input        string input to evaluate
    * @param  board        character 2D array that represents the board
    * @return              true if it is valid, false if it is not 
    */
    private boolean isValidInput(String input, Board board){

        input.trim();
        Integer i = 0;
        int max = board.getBoard()[0].length;

        try {
            i = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Wrong input. Please enter an integer value between 1 and 7.");
            return false;
        }

        if (i < 1 || i > max){
            System.out.println("The selected column is outside the board. Please select a value between 1 and 7 and try again.");
            return false;
        }
        
        return true;
    }

    /**
    * Method that returns the human player move 
    *
    * @param  board        character 2D array that represents the board
    * @return              integer with a column number that represents the player's move 
    */
    @Override
    public Integer move(Board board){
        int move = Integer.parseInt(getUserInput(board));
        return move;
    }
}
