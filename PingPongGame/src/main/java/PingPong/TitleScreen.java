/**
 * File: TitleScreen.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Title Screen
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen extends JPanel{
    
    private final JLabel title = new JLabel("Ping Pong");
    private final JButton startBtn = new JButton("Start Game");
    private final JButton setNumbPlayerBtn = new JButton("Set Number of Players");
    private final JButton exitBtn = new JButton("Exit Game");
    private final Main main;
    
    TitleScreen(Main main)
    {
        this.main = main;
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(title);
            
        this.add(startBtn);
        
        this.add(setNumbPlayerBtn);  
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                startGame();
            }
        });
    
        this.add(exitBtn);
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    private void startGame()
    {
        main.switchScreen(ScreenEnum.GAME);
    }
    
}
