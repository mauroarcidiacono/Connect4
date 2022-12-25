/**
 * Class to handle the functionality of bots. Subclass of Player.
 */

import java.util.Random;

public class Bot extends Player{

    // Define a random object to generate random moves.
    private Random random = new Random();

    // Bot constructor
    public Bot(String name, int turn, char colour){
        super(name, turn, colour);
    }
    
    /**
    * Method that generates a random number 
    *
    * @return        random number
    */
    public Integer randomColumn(){
        return random.ints(1, 8).findFirst().getAsInt();
    }

    /**
    * Method that generates an integer that represents the bot move.
    * The Bot code was created in this way in order to leave space to implement intelligence in the bot.
    * The move method could be used to implement AI to decide which move is the best one. 
    *
    * @return        random number
    */
    @Override
    public Integer move(Board board){
        return randomColumn();
    }
}
