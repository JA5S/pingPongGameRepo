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
import javax.swing.*;

public class TitleScreen extends JPanel{
    
    private final JLabel title = new JLabel("Ping Pong");
    private final JButton startGameBtn = new JButton("Start Game");
    private final Main main;
    
    TitleScreen(Main main)
    {
        this.main = main;
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(title);
        this.add(startGameBtn);
    }
    
    public void startGame()
    {
        main.switchScreen(ScreenEnum.GAME);
    }
    
}
