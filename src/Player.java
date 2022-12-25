/**
 * Class to handle the players of Connect4. Superclass of HumanPlayer and Bot.
 */

public class Player {

    /**
    * Fields 
    *
    * name        name of the player                  
    * turn        turn to play of the player            
    * colour      colour of the counter defined by a character (e.g., 'r' is red)   
    */
    private String name;
    private int turn;
    private char colour;

    // Player class constructor
    public Player(String name, int turn, char colour){
        this.name = name;
        this.turn = turn;
        this.colour = colour;
    }

    /**
    * Accesor 
    * @return    player name
    */
    public String getName(){
        return this.name;
    }

    /**
    * Accesor 
    * @return    player turn
    */
    public int getTurn(){
        return this.turn;
    }

    /**
    * Accesor 
    * @return    player counter colour
    */
    public char getColour(){
        return this.colour;
    }

    /**
    * Method that will be overridden in derived class. 
    *
    * @param board        character 2D array that represents the board
    * @return             0 (will be overriden)
    */
    public Integer move(Board board){
        return 0;
    } 
}
