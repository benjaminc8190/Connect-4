///*
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
// */

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
