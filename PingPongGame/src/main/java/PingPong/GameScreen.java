/**
 * File: GameScreen.java
 * Group: Project Team 2
 * Author: Jonah Shuman Student
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Game Screen panel and draws graphics
 */

package PingPong;

import java.awt.*;
import javax.swing.*;

public class GameScreen extends JPanel{

    // Here GameScreen class graphics are drawn 
    @Override
    protected void paintComponent(Graphics g) {
        //graphics context
        Graphics2D g2 = (Graphics2D) g.create();

        // Turn on antialiasing in this graphics context, for better drawing.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill in the entire drawing area with white.
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight()); // From the old graphics API!

    }
}
