/**
 * File: TitleScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Title Screen
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen extends JPanel{
    
    private final JLabel title = new JLabel("Ping Pong", JLabel.CENTER);
    private final JButton startBtn = new JButton("Start Game");
    private final JButton setNumbPlayerBtn = new JButton("Set Number of Players");
    private final JButton exitBtn = new JButton("Exit Game");
    
    TitleScreen(Main main)
    {
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
            
        this.add(startBtn, BorderLayout.CENTER);
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.startGame();
            }
        });
    
        this.add(exitBtn, BorderLayout.WEST);
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        this.add(setNumbPlayerBtn, BorderLayout.EAST);  
    } //end constructor
    
} //end class
