package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class TitleScreen {

    GameLable gl;

    Graphics g;

    Font Arial_70, Arial_50, Arial_30;

    public int selectTabs = 0, selectIcon = 0;

    String text = "";

    public BufferedImage iconTile;

    public TitleScreen(GameLable gl) {
        this.gl = gl;

        Arial_30 = new Font("Arial", Font.BOLD, 30);
        Arial_50 = new Font("Arial", Font.BOLD, 50);
        Arial_70 = new Font("Arial", Font.BOLD, 70);
    }

    public void draw(Graphics g) {

        this.g = g;

        if (gl.gameScreen == gl.titleScreen) {
            drawTitleScreen();
        }

        if (gl.gameScreen == gl.pauseScreen) {
            drawPauseScreen();
        }

        if (gl.gameScreen == gl.loseScreen) {
            drawLoseScreen();
        }

    }

    public void drawTitleScreen() {

        gl.imageMainScreen = gl.imageTitleScreen;

//        text = "Dodge Game";
        g.setColor(Color.WHITE);
        g.setFont(Arial_70);
//        g.drawString(text, 170, gl.titleSize * 3 - 40);

        try {
            File file = new File(gl.iconPlayer);
            iconTile = ImageIO.read(file);
            BufferedImage image = null;
            image = iconTile;
            g.drawImage(image, 335, gl.titleSize * 4, gl.titleSize * 2, gl.titleSize * 2, null);
            if (selectTabs == 0) {
                g.drawString("<", 270, gl.titleSize * 5 + 30);
                g.drawString(">", 455, gl.titleSize * 5 + 30);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        text = "Play";
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, 350, (gl.titleSize * 7 + 20));
        if (selectTabs == 1) {
            g.drawString(">", 320, gl.titleSize * 7 + 20);
        }

        text = "Quit";
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, 350, gl.titleSize * 8 + 10);
        if (selectTabs == 2) {
            g.drawString(">", 320, gl.titleSize * 8 + 10);
        }

    }

    public void drawPauseScreen() {

        int x = gl.titleSize * 5;
        int y = gl.titleSize * 2;
        int width = gl.ScreenWidth - (gl.titleSize * 10);
        int height = gl.titleSize * 8;
        g.setColor(Color.BLACK);
        g.fillRoundRect(x, y, width, height, 35, 35);
        g.setColor(Color.WHITE);
        g.drawRoundRect(x + 10, y + 10, width - 20, height - 20, 25, 25);

        text = "PAUSE";
        x += gl.titleSize * 1.3;
        y += gl.titleSize * 2;
        g.setColor(Color.WHITE);
        g.setFont(Arial_50);
        g.drawString(text, x, y);

        text = "Resume";
        x += 25;
        y += gl.titleSize * 2;
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, x, y);
        if (selectTabs == 0) {
            g.drawString(">", x - (gl.titleSize - 10), y);
        }

        text = "Restart";
        x += 5;
        y += gl.titleSize;
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, x, y);
        if (selectTabs == 1) {
            g.drawString(">", x - (gl.titleSize - 10), y);
        }

        text = "Quit";
        x += 15;
        y += gl.titleSize;
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, x, y);
        if (selectTabs == 2) {
            g.drawString(">", x - (gl.titleSize - 10), y);
        }

    }

    public void drawLoseScreen() {

        int x = gl.titleSize * 3;
        int y = gl.titleSize * 3;
        int width = gl.ScreenWidth - (gl.titleSize * 6);
        int height = gl.titleSize * 6;
        g.setColor(Color.BLACK);
        g.fillRoundRect(x, y, width, height, 35, 35);
        g.setColor(Color.WHITE);
        g.drawRoundRect(x + 10, y + 10, width - 20, height - 20, 25, 25);

        text = "You Died";
        x += gl.titleSize * 2.6;
        y += gl.titleSize * 2;
        g.setColor(Color.WHITE);
        g.setFont(Arial_50);
        g.drawString(text, x, y);

        text = "Restart";
        x += 60;
        y += gl.titleSize * 1.5;
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, x, y);
        if (selectTabs == 0) {
            g.drawString(">", x - (gl.titleSize - 10), y);
        }

        text = "Quit";
        x += 15;
        y += gl.titleSize;
        g.setColor(Color.WHITE);
        g.setFont(Arial_30);
        g.drawString(text, x, y);
        if (selectTabs == 1) {
            g.drawString(">", x - (gl.titleSize - 10), y);
        }
    }

}
