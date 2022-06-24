/**
 * File: Paddle.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 23, 2022
 * Purpose: Main program
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Ball extends Rectangle{
    
    
    Random random;
	int xSpeed;
	int ySpeed;
	int initialSpeed = 2;
	
        //sets the ball direction in both X and Y directions
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);
		random = new Random();
		int randmDirection_X = random.nextInt(2);
		if(randmDirection_X == 0)
			randmDirection_X--;
		setDirection_X(randmDirection_X*initialSpeed);
		
		int randmDirection_Y = random.nextInt(2);
		if(randmDirection_Y == 0)
			randmDirection_Y--;
		setDirection_Y(randmDirection_Y*initialSpeed);
		
	}
	//Sets ball speed at X
	public void setDirection_X(int randomDirection_X) {
		xSpeed = randomDirection_X;
	}
        //Sets ball speed at Y
	public void setDirection_Y(int randomDirection_Y) {
		ySpeed = randomDirection_Y;
	}
	public void move() {
		x += xSpeed;
		y += ySpeed;
	}
        //Sets ball color and shape
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}
    