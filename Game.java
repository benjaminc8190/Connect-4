// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/29/2025
// */

import java.util.Scanner;

//Logic of the game

public class Game{
    private final int rows = 5;
    private final int cols = 5;
    private int[][] board;
    private int turns;

    public Game(){
        board = new int[rows][cols];
        turns = 0;
    }

    public int getCurrentPlayer(){
        if(turns%2==0){
            System.out.println("Player 1 turn");
            return 1;
        } else {
            System.out.println("Player 2 turn");
            return 2;
        }
    }

    public boolean dropPiece(int col){
        for(int i=rows-1; i>=0; i--){ // Had to change .length to rows-1 in order for it to place pieces in 0 row
            if(board[i][col]==0){
                board[i][col]=this.getCurrentPlayer();
                turns++; // Goes to next turn
                System.out.println("dropPiece(): Piece placed at (" + i + ", " + col + ")");
                return true;
            }
        }
        System.out.println("dropPiece(): Column " + col + " is full");
        return false; // Column is full
    }

    public int[][] getBoard() {
        return board;
    }

    //Testing to see if board works 
    public void printBoard() {
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            System.out.print(board[row][col] + " ");
        }
        System.out.println();
    }
    System.out.println(); // extra line for spacing
    
}
    
// Anthony's Part
public void gameStart() {//Use scanner to test code before partners integrate to GUI
	Scanner scanner = new Scanner(System.in); // Reads User Input 	
	
	while (true) {
        System.out.println("Player " + getCurrentPlayer() + ", choose a column (0-4):");
        int colChoice = scanner.nextInt(); // Made colChoice as to differentiate with cols
        
    if (colChoice < 0 || colChoice >= cols) { // colChoice can't be -1 or over 4
        System.out.println("Invalid column. Try again.");
        continue; // ask again
    }

    if (board[0][colChoice] != 0) { // Needed a way to check the column is full.
        System.out.println("Column full. Choose another.");
        continue; // ask again
    }

    dropPiece(colChoice); // Uses dropPiece();
    printBoard(); // Prints the board
    if (checkWin() == true) { // If there is the win condition
    	turns--;  //Reverts the current turn order
    	System.out.println("Player " + getCurrentPlayer() + " Wins!"); // Prints the winner
    	break; //Breaks
    }
    else {
    	continue; // Otherwise play as normal
    	}
	}
}

public boolean checkWin() {
	
    // Loops and Checks every row and column
    for (int row = 0; row < rows; row++) { 
        for (int col = 0; col < cols; col++) {

            if (board[row][col] == 0) { // Empty Grid
            	continue;
            }

            int hold = board[row][col]; //Placeholder Variable that can store all conditions at once when checking
            // Horizontal
            if ( col <= cols - 4 &&
            board[row][col+1] == hold &&
            board[row][col+2] == hold &&
            board[row][col+3] == hold) {
            	return true; 
            }
            // Vertical
            if ( row <= rows - 4 &&
            board[row+1][col] == hold &&
            board[row+2][col] == hold &&
            board[row+3][col] == hold) {
            	return true;
            }
            // Dia-Left
            if ( row <= rows - 4 && col <= cols - 4 &&
            board[row+1][col+1] == hold &&
            board[row+2][col+2] == hold &&
            board[row+3][col+3] == hold) {
            	return true;
            }
            // Dia-Right
            if ( row <= rows - 4 && col >= 3 &&
            board[row+1][col-1] == hold &&
            board[row+2][col-2] == hold &&
            board[row+3][col-3] == hold) {
            	return true;
            }
        }
    }
  return false;
}

public static void main(String[] args) {
	Game g = new Game(); // Game Object
	g.printBoard(); // Prints Board
	g.gameStart(); // Starts Game
	}
}

// !! Updating with replay system !!
