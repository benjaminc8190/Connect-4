///*
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
// */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Frontend of the game

public class Layout extends JFrame {
    private Game game; // Instance of the Game class to manage game logic

    public Layout(){
        game = new Game(); // Initialize the game logic

        //Set up for the grid layout
        setLayout(new GridLayout(5, 5, 5, 5));
        setTitle("Connect4 Game");
        JButton[][] buttons = new JButton[5][5];//2D array of buttons
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.WHITE);
                add(buttons[i][j]);//top left is (0,0) to bottom right (4,4)
            }
        }
        setSize(500, 500);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                final int col = j; // Need final variable for use in inner class

                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Handle each button click 
                        if(game.dropPiece(col)){// Drop piece in the selected column
                            int[][] b = game.getBoard();//grabs current board state
                            // Update button colors based on the game board state
                            for (int r = 0; r < 5; r++) {
                                for (int c = 0; c < 5; c++) {
                                    if (b[r][c] == 1) {
                                        buttons[r][c].setBackground(Color.RED);
                                    } else if (b[r][c] == 2) {
                                        buttons[r][c].setBackground(Color.YELLOW);
                                    } else {
                                        buttons[r][c].setBackground(Color.WHITE);
                                    }
                                }
                            }
                        }; 
                        game.printBoard();
                        if(game.stopGame()){// Check for win condition after each move
                            JOptionPane.showMessageDialog(null, "Player " + (game.getCurrentPlayer()-1) + " Wins!");
                            // Disable all buttons after game ends
                            for (int r = 0; r < 5; r++) {
                                for (int c = 0; c < 5; c++) {
                                    buttons[r][c].setEnabled(false);
                                }
                            } 
                        }
                    }
                });
            }
        }
    }
    public void repeat(){
        JOptionPane.showConfirmDialog(null, "Would you like to play Connect 4?", "Connect 4", JOptionPane.YES_NO_OPTION);
        game.resetGame();
    }
}
