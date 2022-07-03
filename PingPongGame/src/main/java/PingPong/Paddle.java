/**
 * File: Paddle.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Paddle object for 
 * drawing and updating paddles
 */

package PingPong;

import java.awt.*;

public class Paddle extends Rectangle{
    // Fields
    private int left, right, top, bottom;
    private int originalY;
    private int speed = 5;
    private int direction = 1;
    private boolean isRight;
    
    // Constructor
    public Paddle(int x, int y, int width, int height, boolean isRight) 
    {
        super(x, y, width, height);
        left = x;
        right = x + width;
        top = y + height;
        bottom = y;
        originalY = y;
        this.isRight = isRight;
    }
    
    public void drawPaddle(Graphics2D g2)
    {
        g2.fillRect(x, y, width, height);
    }
    
    public void bouncePong(PingPong pong)
    {
        int pongX;
        if(isRight)
            pongX = pong.x + pong.width - 1;
        else
            pongX = pong.x + 1;
        
        if(pongX >= left && pongX <= right
                && pong.y + pong.height/2 <= top && pong.y + pong.height >= bottom)
        {
            pong.setXDirection(-1);
            //set pong Spd to bounce at an angle
            int centerY = bottom + height/2;
            if(pong.y + pong.height <= centerY + height/4
                    && pong.y + pong.height >= centerY + height/4)
            {
                pong.setYSpeed(0);
            }
            else if(pong.y + pong.height > centerY + height/4)
            {
                pong.setYSpeed(2);
                pong.setYDirection(pong.getYDirection() * -1);
            }
            else
            {
                pong.setYSpeed(2);
                pong.setYDirection(pong.getYDirection() * -1);
            }
            
        }
    }
    
    public void update()
    {
        top = y + height;
        bottom = y;
    }
    
    public void reset()
    {
        y = originalY;
    }
    
    //Getter methods
    public int getSpeed()
    {
        return speed;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    //Setter methods
    public void setSpeed(int spd)
    {
        speed = spd;
    }
    
    public void setDirection(int dir)
    {
        direction = dir;
    }
} // End class
