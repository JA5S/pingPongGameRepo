/**
 * File: GameScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Game Screen panel and draws graphics
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class GameScreen extends JPanel implements KeyListener, ActionListener{
    
    // Fields
    private final double LEFT = -100;
    private final double RIGHT = 100;
    private final double BOTTOM = -100;
    private final double TOP = 100;
    
    static int translateX = 0;
    static int translateY = 0;
    
    static int paddleY = -20;
    static int pongX = 0;
    static int pongY = 0;
    
    private final Main main;
    
    // Constructor
    public GameScreen(Main main)
    {
        this.main = main;
        enableKeys();
    }
    
    // Draws graphics for GameScreen class
    @Override
    protected void paintComponent(Graphics g) {
        // Graphics context
        Graphics2D g2 = (Graphics2D) g.create();

        // Turn on antialiasing in this graphics context.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill background with black.
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        // Maintains window ratio
        windowToViewportTransformation(g2);
        // Transform identity
        AffineTransform savedTransform = g2.getTransform();
        
        // Draw graphics here and on
        // Set object color
        g2.setPaint(Color.white);
        
        // Draw boundary line
        drawBoundaryLine(g2);
        g2.setTransform(savedTransform);
        
        // Draw Paddle1
        g2.translate(-75, 0);
        drawPaddle(g2);
        g2.setTransform(savedTransform);
        
        // Draw Paddle2
        g2.translate(75, 0);
        drawPaddle(g2);
        g2.setTransform(savedTransform);
        
        // Draw PingPong ball
        g2.translate(pongX, pongY);
        drawPingPong(g2);
        g2.setTransform(savedTransform);
        
        // Draw Scores
        g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        g2.drawString("0", -40, 95); //Score 1
        g2.drawString("0", 40, 95); //Score 2
        
    }//end method
    
    // Draws dotted line
    private void drawBoundaryLine(Graphics2D g2)
    {
        float dash[] = {10.0f};
        BasicStroke dashed = new BasicStroke(5.0f, 
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 
                10.0f, dash, 0.0f);
        g2.setStroke(dashed);
        g2.drawLine(0, -95, 0, 100);
    }
    
    // Draws paddle
    private void drawPaddle(Graphics2D g2)
    {
        //change x,y to Transform variables
        g2.fillRect(-10, paddleY, 20, 40);
    }
    
    //Draws PingPong
    private void drawPingPong(Graphics2D g2)
    {
        //change x,y to Transform variables
        g2.fillOval(0, 0, 15, 15);
    }
    
    // Transforms window's dimensions to viewport
    private void windowToViewportTransformation(Graphics2D g2) {
        // Pixel width/height of drawing area
        int width = getWidth(); int height = getHeight(); 

        g2.scale(width / (RIGHT - LEFT), height / (BOTTOM - TOP));
        g2.translate(-LEFT, -TOP);
    }
    
    // --------------------------- animation support ---------------------------
    /* You can call startAnimation() to run an animation.  A frame will be drawn every
     * 30 milliseconds. Call pauseAnimation() to stop animating.
     */
    private Timer animationTimer;
    private int frameNumber = 0;  // The current frame number for an animation.
    private boolean animating;  // True if animation is running.  Do not set directly.
                                // This is set by startAnimation() and pauseAnimation().
    
    public void startAnimation() {
        if ( ! animating ) {
            if (animationTimer == null) {
                animationTimer = new Timer(30, this);
            }
            animationTimer.start();
            animating = true;
            System.out.println("Animation started/resumed!");
        }
    }
    
    private void pauseAnimation() {
        if (animating) {
            animationTimer.stop();
            animating = false;
            System.out.println("Animation paused!");
        }
    }
    
    private void updateFrame() {
        frameNumber++;
        
        //Animations
        if(frameNumber % 4 == 0)
        {
            pongX -= 2;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        updateFrame();
        repaint();
    }
    

    // ----------------  Methods from the KeyListener interface --------------
    private void enableKeys()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        
        switch(key)
        {
            case KeyEvent.VK_P:
                System.out.println("Pressed Pause Key!");
                pauseAnimation();
                main.switchScreen(ScreenEnum.PAUSE);
                break;
            case KeyEvent.VK_UP:
                paddleY += 5;
                System.out.println("Moved Paddle Up!");
                break;
            case KeyEvent.VK_DOWN:
                paddleY -= 5;
                System.out.println("Moved Paddle Down!");
                break;
            default:
                break;
        }
        
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }
    
}//end class
