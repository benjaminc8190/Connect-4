///*
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
// */
/* old code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Logic of the game

public class Game{
    private final int rows = 5;
    private final int cols = 5;
    private int[][] board;
    private int turns;

    public Game(){
        board = new int[rows][cols];
        System.out.println(board);
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

    public void dropPiece(int cols){
        for(int i=board.length; i>0; i--){
            if(board[i][cols]==0){
                board[i][cols]=this.getCurrentPlayer();
            }
        }
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

}
*/

package P1;
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
// */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

//Logic of the game

public class Game{
    private final int rows = 5;
    private final int cols = 5;
    private int[][] board;
    private int turns;

    public Game(){
        board = new int[rows][cols];
        System.out.println(board);
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

    public void dropPiece(int cols){
        for(int i=board.length; i>0; i--){
            if(board[i][cols]==0){
                board[i][cols]=this.getCurrentPlayer();
                turns++;
                return;
            }
        }
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
    
    
public void GameStart() {
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

    dropPiece(colChoice); //Uses dropPiece();
    break;
	}
}

public boolean CheckWin() {
    // Loop over every row and col
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {

            if (board[row][col] == 0) {
            	continue;
            }

            int hold = board[row][col];
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
            if (CheckWin() == true) {
            	System.out.println("Player" + getCurrentPlayer() + "Wins!");
            }
        }
    }
    return false;
}

public static void main(String[] args) {
	Game g = new Game();
	g.printBoard();
	g.GameStart();
	}
}
