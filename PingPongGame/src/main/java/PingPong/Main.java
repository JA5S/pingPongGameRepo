/**
 * File: Main.java
 * Group: Project Team 2
 * Authors: Jonah Shuman,
 * Zeleke Werssa, and
 * Asha Azariah-Kribbs
 * Project: PingPongGame
 * Date: June 18, 2022
 * Purpose: Main program
 */

package PingPong;

import javax.swing.*;

public class Main{
    
    //fields
    private final JFrame window;
    private final GameScreen gameScreen = new GameScreen(this);
    private final TitleScreen titleScreen = new TitleScreen(this);
    private final WinScreen winScreen = new WinScreen(this);
    private final PauseScreen pauseScreen = new PauseScreen(this);
    private final int WIDTH = 500;
    private final int HEIGHT = 370;
    
    //constructor
    Main()
    {
        window = new JFrame("Ping Pong Game");
        setFrame(WIDTH, HEIGHT); 
        window.setContentPane(titleScreen);
    }
    
    //frame methods
    private void setFrame(int width, int height) {
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void display()
    {
        window.setVisible(true);
    }
    
    public void startGame()
    {
        switchScreen(ScreenEnum.GAME);
        gameScreen.startAnimation();
    }
    
    public void switchScreen(ScreenEnum panelEnum)
    {
        JPanel panel;
        switch(panelEnum)
        {
            case TITLE:
                panel = titleScreen;
                break;
            case GAME:
                panel = gameScreen;
                break;
            case PAUSE:
                panel = pauseScreen;
                break;
            case WIN:
                panel = winScreen;
                break;
            default:
                panel = titleScreen;
                break;
        }
        window.setContentPane(panel);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        window.repaint();
        window.revalidate();
    }

    //main method
    public static void main(String[] args) {
        Main game = new Main();
        game.display();
    }
}
