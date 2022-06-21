/**
 * File: PauseScreen.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Pause Screen
 */

package PingPong;

import java.awt.*;
import javax.swing.*;

public class PauseScreen extends JPanel{
    
    private final JLabel pauseLbl = new JLabel("Game Paused");
    private final JButton pauseResume = new JButton("pauseResume Game");
    private final JButton returnToTitle = new JButton("Return To Title");
    private final Main main;
    
    PauseScreen(Main main)
    {
        this.main = main;
        pauseLbl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(pauseLbl);
        this.add(pauseResume);
        this.add(returnToTitle);
    }
}
