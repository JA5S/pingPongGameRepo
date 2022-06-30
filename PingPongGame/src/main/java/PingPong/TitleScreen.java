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
    private final JButton exitBtn = new JButton("Exit Game");
    private final JCheckBox multiplayerCheck = new JCheckBox("Multiplayer");
    private boolean isMultiplayer = false;
    
    
    TitleScreen(Main main)
    {
        JPanel titlePanel =  new JPanel();
        JPanel buttonPanel = new JPanel();
        this.setLayout(new GridLayout(2, 1));
        this.add(titlePanel);
        this.add(buttonPanel);
        
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        titlePanel.add(title);
        
        buttonPanel.add(exitBtn);
        buttonPanel.add(startBtn);
        buttonPanel.add(multiplayerCheck);
        
        //Button methods
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.startGame(isMultiplayer);
            }
        });
    
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        multiplayerCheck.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    isMultiplayer = true;
                else
                    isMultiplayer = false;
            }
        });
    } //end constructor
    
} //end class
