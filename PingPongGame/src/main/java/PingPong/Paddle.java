/**
 * File: Paddle.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Main program
 */

package PingPong;

import java.awt.*;

public class Paddle extends Rectangle{

    private int left, right, top, bottom;
    
    public Paddle(int x, int y, int width, int height) 
    {
        super(x, y, width, height);
        left = x;
        right = x + width;
        top = y + height;
        bottom = y;
    }
    
    public void drawPaddle(Graphics2D g2)
    {
        g2.fillRect(x, y, width, height);
    }
    
    //updates the position of the paddle based on user activity
    private void update(){
         
        }
    

}
