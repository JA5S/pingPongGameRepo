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
    private final Main main;
    
    PauseScreen(Main main)
    {
        this.main = main;
        pauseLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(pauseLabel);
        
        this.add(resumeBtn);
        resumeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                resumeGame();
            }
        });
        
        this.add(returnToTitleBtn);
        returnToTitleBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                returnToTitle();
            }
        });
        
    }
    
    private void resumeGame()
    {
        main.switchScreen(ScreenEnum.GAME);
    }
    
    private void returnToTitle()
    {
        main.switchScreen(ScreenEnum.TITLE);
    }
}
