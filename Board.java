/**
 * Class to create a board and define its functionality. 
 * It handles the display, the counter placement and if the board indicates a winner.
 */

public class Board {
    
    /**
    * Fields 
    *
    * board       character 2D array that represents the board                  
    * rows        number of rows of the board            
    * cols        number of cols of the board
    */
    private char[][] board;
    private int rows;
    private int cols;

    // Board class constructor
    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        board = new char[rows][cols]; 
    }

    // Board class constructor
    public Board (char[][] board){
        this.board = board; 
    }

    /**
    * Accesor 
    * @return    number of rows
    */
    public Integer rowNumber(){
        return this.rows;
    }

    /**
    * Accesor 
    * @return    number of columns
    */
    public Integer colNumber(){
        return this.cols;
    }

    /**
    * Accesor 
    * @return    board array
    */
    public char[][] getBoard(){
        return this.board;
    }

    /**
    * Method that prints the board. 
    *
    */
    public void printBoard(){
		for(int i=0; i<=board.length-1; i++){
			for(int j=0; j<=board[i].length-1; j++){
                char playerCounter = board[i][j];
				if(board[i][j] != 0){
					System.out.print("| " + playerCounter + " ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
        for(int l = 1; l <= this.cols; l++){
            if (l == 1){
                System.out.print("  " + l);
            } else if (l == this.cols) {
                System.out.println("   " + l);
            } else {
                System.out.print("   " + l);
            } 
        }	
	}

    /**
    * Method that places the counter if possible. 
    *
    * @param  playerCounter        character that represents the counter of the player
    * @param  position             column in the board
    * @return                      true if placed, false if not placed
    */
    public boolean placeCounter(char playerCounter, int position){
		boolean placed = false;
        for(int i=board.length-1; i>=0; i--){
            if(!placed){
                if(board[i][position-1] == 0){
                    board[i][position-1] = playerCounter;
                    placed = true;
                }
            }
        }
        return placed;
	}

    /**
    * Method that evaluates if a player won. 
    *
    * @param  playerCounter        character that represents the counter of the player
    * @param  numCounter           number of counters in line to win the game
    * @return                      true if player won, false if not
    */
    public boolean hasWon(char playerCounter, Integer numCounter){

        boolean hasWon = false;
        int count = 0;
        
        // check horizontal
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == playerCounter){
                    count = count + 1;
                    if(count == numCounter){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        
        // check vertical 
        count = 0;
        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i] == playerCounter){
                    count = count + 1;
                    if(count == numCounter){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        
        // check diagonal (right to left, bottom to top)
        count = 0;
        for (int i = 0; i < board[0].length; i++){ //7
			for (int j = 0; j < board.length; j++){ //6
				int indexRow = i - (numCounter-1);
				int indexCol = j + (numCounter-1);
				if (indexRow >= 0 && indexRow < board[0].length){
					if (indexCol >= 0 && indexCol < board.length){
                        int l = j;
                        for (int k = i; k >= indexRow; k--){
                            if (board[l][k] == playerCounter){
                                count = count + 1;
                                if(count == numCounter){
                                    hasWon = true;
                                }
                            }
                            else{
                                count = 0;
                            }
                            l = l + 1;
                        }
					}
				}
			}
		}

        // check diagonal (left to right, bottom to top)
        count = 0;
        for (int i = 0; i < board[0].length; i++){
			for (int j = 0; j < board.length; j++){
				int indexRow = i + (numCounter-1);
				int indexCol = j + (numCounter-1);
				if (indexRow >= 0 && indexRow < board[0].length){
					if (indexCol >= 0 && indexCol < board.length){
                        int l = j;
                        for (int k = i; k <= indexRow; k++){
                            if (board[l][k] == playerCounter){
                                count = count + 1;
                                if(count == numCounter){
                                    hasWon = true;
                                }
                            }
                            else{
                                count = 0;
                            }
                            l = l + 1;
                        }
					}
				}
			}
		}

        return hasWon;
    }

    /**
    * Method that evaluates if the players drew. 
    *
    * @return                      true if players drew, false if not
    */
    public boolean draw(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
