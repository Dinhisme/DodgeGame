package main;

import javax.swing.JFrame;

/**
 *
 * @author MyPC
 */
public class main {
    
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Dinhisme");
        
        
        
        GameLable gameLable = new GameLable();
        window.add(gameLable);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gameLable.startGameThread();
        gameLable.setupGame();
        
    }
}
