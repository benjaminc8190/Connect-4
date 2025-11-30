///*
// * CSCI 185 M02
// * Fall 2025
// * Final Programming Project
// * Author: Benjamin Chau, Anthony Coates, Jeffrey Perez
// * Date: 11/24/2025
// */

import java.awt.*;
import javax.swing.*;

//Frontend of the game

public class Layout extends JFrame {
    public Layout(){
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
        setVisible(true);

        
    }
}