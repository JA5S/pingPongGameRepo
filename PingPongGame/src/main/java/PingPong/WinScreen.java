/**
 * File: WinScreen.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Win/Lose Screen
 */

package PingPong;

import java.awt.*;
import javax.swing.*;

public class WinScreen extends JPanel{

    private final JLabel winStatus = new JLabel("Player 1 Won!");
    private final Main main;
    
    WinScreen(Main main)
    {
        this.main = main;
        winStatus.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(winStatus);
    }
}
