/**
 * File: PauseScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Pause Screen
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PauseScreen extends JPanel{
    
    private final JLabel pauseLabel = new JLabel("Game Paused");
    private final JButton resumeBtn = new JButton("Resume Game");
    private final JButton returnToTitleBtn = new JButton("Return To Title");
    
    PauseScreen(Main main)
    {
        JPanel titlePanel =  new JPanel();
        JPanel buttonPanel = new JPanel();
        this.setLayout(new GridLayout(2, 1));
        this.add(titlePanel);
        this.add(buttonPanel);
        
        pauseLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        titlePanel.add(pauseLabel);
        
        buttonPanel.add(resumeBtn);
        buttonPanel.add(returnToTitleBtn);
        
        resumeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.resumeGame();
            }
        });
        
        returnToTitleBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.switchScreen(ScreenEnum.TITLE);
            }
        });
    }// End Constructor
    
} // End Class
