//*
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
//* Notes for our code:
//* Run in this file(Runner)
//* Ignore the J-Connect4 file
//* Only include Game, Layout, and Runner file when running our code
// */

import javax.swing.*;

public class Runner{
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Welcome to Connect 4! Player 1 is Red and Player 2 is Yellow. Click on the column you want to drop your piece in. First to connect 4 pieces wins!");
        Layout game = new Layout();
        game.setVisible(true);
    }
}
