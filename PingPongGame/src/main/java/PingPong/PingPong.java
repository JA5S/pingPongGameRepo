/**
 * File: PingPong.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: PingPong object for 
 * drawing and updating ping pong
 */

package PingPong;

import java.awt.*;

public class PingPong extends Rectangle {

    // Fields
    private int left, right, top, bottom;
    private int xSpeed = 3;
    private int ySpeed = 0;
    private int xDirection = -1;
    private int yDirection = 1;

    // Constructor
    public PingPong(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void drawPingPong(Graphics2D g2) {
        g2.fillOval(x, y, width, height);
    }
    
    //updates the position of the ping pong
    public void update() 
    {
        this.x -= xSpeed * xDirection;
        this.y -= ySpeed * yDirection;
        left = this.x;
        right = this.x + width;
    }
    
    public void respawn()
    {
        x = 0;
        y = 0;
        xSpeed = 3;
        ySpeed = 0;
        xDirection *= -1;
        yDirection = 1;
    }
    
    // Getter methods
    public int getXSpeed()
    {
        return xSpeed;
    }
    
    public int getXDirection()
    {
        return xDirection;
    }
    
    public int getYSpeed()
    {
        return ySpeed;
    }
    
    public int getYDirection()
    {
        return yDirection;
    }
    
    // Setter methods
    public void setYSpeed(int spd)
    {
        ySpeed = spd;
    }
    
    public void setYDirection(int dir)
    {
        yDirection = dir;
    }
    
    public void setXSpeed(int spd)
    {
        xSpeed = spd;
    }
    
    public void setXDirection(int dir)
    {
        xDirection *= dir;
    }
}
