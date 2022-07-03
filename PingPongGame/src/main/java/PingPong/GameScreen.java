/**
 * File: GameScreen.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 16, 2022
 * Purpose: Game Screen panel and paints graphics
 */

package PingPong;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class GameScreen extends JPanel implements KeyListener, ActionListener {
    // Fields
    private final double LEFT = -100;
    private final double RIGHT = 100;
    private final double BOTTOM = -100;
    private final double TOP = 100;
    
    private final PingPong pong;
    private final Paddle paddleOne, paddleTwo;
    private boolean isMultiplayer = false;

    private int scoreOne;
    private int scoreTwo;
    private final int maxScore = 5;

    private final Main main;

    // Constructor
    public GameScreen(Main main) {
        this.main = main;
        enableKeys();
        
        paddleOne = new Paddle(75, -20, 10, 40, true);
        paddleTwo = new Paddle(-85, -20, 10, 40, false);
        pong = new PingPong(0, 0, 10, 15);
    }
    
    // Setter
    public void setIsMultiplayer(boolean isMulti)
    {
        isMultiplayer = isMulti;
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

        // Draw Paddles and PingPong
        paddleOne.drawPaddle(g2);
        g2.setTransform(savedTransform);
        paddleTwo.drawPaddle(g2);
        g2.setTransform(savedTransform);
        pong.drawPingPong(g2);
        g2.setTransform(savedTransform);

        // Draw Scores
        g2.translate(0, 85);
        g2.scale(-1, 1);
        g2.rotate(180 * Math.PI / -180);
        g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        g2.drawString(String.valueOf(scoreOne), 40, 0); //Score 1
        g2.drawString(String.valueOf(scoreTwo), -40, 0); //Score 2

    }//end method

    // Draws dotted line
    private void drawBoundaryLine(Graphics2D g2) {
        float dash[] = {10.0f};
        BasicStroke dashed = new BasicStroke(5.0f,
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10.0f, dash, 0.0f);
        g2.setStroke(dashed);
        g2.drawLine(0, -95, 0, 100);
    }

    // Transforms window's dimensions to viewport
    private void windowToViewportTransformation(Graphics2D g2) {
        // Pixel width/height of drawing area
        int width = getWidth();
        int height = getHeight();

        g2.scale(width / (RIGHT - LEFT), height / (BOTTOM - TOP));
        g2.translate(-LEFT, -TOP);
    }
    
    // Resets game
    public void resetGame()
    {
        pong.respawn();
        paddleOne.reset();
        paddleTwo.reset();
        scoreOne = 0;
        scoreTwo = 0;
    }

    // --------------------------- Animation Support ---------------------------
    /* Call startAnimation()/pauseAnimation() to run/stop an animation.
     * A frame will be drawn every 30 milliseconds.
     */
    private Timer animationTimer;
    private int frameNumber = 0;
    private boolean animating;  //Set by startAnimation()/pauseAnimation() only

    public void startAnimation() {
        if (!animating) {
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
        if (frameNumber % 2 == 0) {
            //bounce off top/bottom
            if (pong.y + pong.height > TOP || pong.y <= BOTTOM) {
                pong.setYDirection(pong.getYDirection() * -1);
                if(pong.x <= 0 || pong.x >= 0)
                {
                   pong.setYSpeed(1); 
                }
            }

            //bounce off paddle
            paddleOne.bouncePong(pong);
            paddleTwo.bouncePong(pong);

            //scoring
            if (pong.x >= RIGHT - pong.width/2 || pong.x <= LEFT) {
                if (pong.x >= RIGHT - pong.width/2) {
                    scoreTwo++;
                }
                if (pong.x <= LEFT + pong.width/2) {
                    scoreOne++;
                }
                //check for game win
                if(scoreOne == maxScore || scoreTwo == maxScore)
                {                   
                    //pass scores to winScreen
                    main.finishGame(scoreOne, scoreTwo);
                }
                
                //respawn pong
                pong.respawn();
            }

            //animate pong
            pong.update();

            //AI paddle
            if(!isMultiplayer)
                moveAI();
        }
    }

    //Sets animation for AI paddle
    private void moveAI() {
        if (pong.y > paddleTwo.y + paddleTwo.height/2) {
            paddleTwo.setDirection(1);
            paddleTwo.setSpeed(2);
        } else if (pong.y < paddleTwo.y) {
            paddleTwo.setDirection(-1);
            paddleTwo.setSpeed(2);
        } else {
            paddleTwo.setSpeed(0);
        }

        paddleTwo.y += paddleTwo.getSpeed() * paddleTwo.getDirection();
        paddleTwo.update();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        updateFrame();
        repaint();
    }

    // ----------------  Methods from the KeyListener interface --------------
    private void enableKeys() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();

        switch (key) {
            case KeyEvent.VK_P: // Pause
                System.out.println("Pressed Pause Key!");
                pauseAnimation();
                main.switchScreen(ScreenEnum.PAUSE);
                break;
            case KeyEvent.VK_UP: // Paddle One
                paddleOne.y += paddleOne.getSpeed();
                paddlesBoundaryCheck(paddleOne);
                paddleOne.update();
                break;
            case KeyEvent.VK_DOWN:
                paddleOne.y -= paddleOne.getSpeed();
                paddlesBoundaryCheck(paddleOne);
                paddleOne.update();
                break;
            case KeyEvent.VK_W: //Paddle Two
                if(isMultiplayer)
                {
                    paddleTwo.y += paddleTwo.getSpeed();
                    paddlesBoundaryCheck(paddleTwo);
                    paddleTwo.update();
                }
                break;
            case KeyEvent.VK_S:
                if(isMultiplayer)
                {
                    paddleTwo.y -= paddleTwo.getSpeed();
                    paddlesBoundaryCheck(paddleTwo);
                    paddleTwo.update();
                }
                break;
            default:
                break;
        }

        repaint();
    }
    
    // Stops paddle from moving past top/bottom of screen
    public void paddlesBoundaryCheck(Paddle paddle) {
        if (paddle.y >= TOP - paddle.height ) {
            paddle.y = (int) TOP - paddle.height;
            System.out.println("Paddle reached top of screen.");
        }
        if (paddle.y <= BOTTOM) {
            paddle.y = (int) BOTTOM;
            System.out.println("Paddle reached bottom of screen.");
        }
    } //end of method

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

}//end class
