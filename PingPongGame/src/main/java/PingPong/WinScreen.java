/**
 * File: WinScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Win/Lose Screen
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WinScreen extends JPanel{

    private final JLabel winStatus = new JLabel();
    private final JLabel scoreOneLbl = new JLabel();
    private final JLabel scoreTwoLbl = new JLabel();
    private final JButton restartGame = new JButton("Restart Game");
    private final JButton returnToTitle = new JButton("Return To Title");
    private Font titleFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    private Font scoreFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
    private final JPanel titlePanel =  new JPanel();
    private final JPanel scorePanel =  new JPanel();
    private final JPanel buttonPanel = new JPanel();
    
    WinScreen(Main main)
    {
        this.setLayout(new GridLayout(3, 1));
        this.add(titlePanel);
        this.add(scorePanel);
        this.add(buttonPanel);
        
        winStatus.setFont(titleFont);  
        scoreTwoLbl.setFont(scoreFont);
        scoreOneLbl.setFont(scoreFont);
        scorePanel.setLayout(new FlowLayout(
                    FlowLayout.CENTER, 100, 5));
        
        buttonPanel.add(restartGame);
        buttonPanel.add(returnToTitle);
        
        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                main.restartGame();
            }
        });
        returnToTitle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.switchScreen(ScreenEnum.TITLE);
            }
        });
       
    } //End Constructor
    
    public void setScores(int scoreOne, int scoreTwo)
    {
        scoreOneLbl.setText(String.valueOf(scoreOne));
        scoreTwoLbl.setText(String.valueOf(scoreTwo));
        scorePanel.add(scoreTwoLbl);
        scorePanel.add(scoreOneLbl);
        
        if(scoreOne == 5)
            winStatus.setText("Player 1 Won!");
        else
            winStatus.setText("Player 2 Won!");
        
        titlePanel.add(winStatus);
    }

} // End Class
