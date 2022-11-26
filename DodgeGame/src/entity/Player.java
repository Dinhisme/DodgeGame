package entity;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.GameLable;
import main.KeyPress;

/**
 *
 * @author MyPC
 */
public class Player extends Entity {

    KeyPress key;

    public Player(GameLable gl, KeyPress key) {

        super(gl);

        this.key = key;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 48;

        setDefaultValues();
    }

    public void setDefaultValues() {
        Ex = 100;
        Ey = 250;
        speed = 4;
    }

    public void update() {
        if (key.upPressed == true) {
            Ey -= speed;
            direction = "up";
            if (Ey < 0) {
                Ey = 0;
            }
        }
        if (key.downPressed == true) {
            Ey += speed;
            direction = "down";
            if (Ey > 529) {
                Ey = 529;
            }
        }
        if (key.leftPressed == true) {
            Ex -= speed;
            direction = "left";
            if (Ex < 0) {
                Ex = 0;
            }
        }
        if (key.rightPressed == true) {
            direction = "right";
            Ex += speed;
            if (Ex > 710) {
                Ex = 710;
            }
        }
        gl.checker.checkEntity(this, gl.enemyNPC);
    }

    public void draw(Graphics g) {
        try {
            if (gl.iconPlayer == gl.iconPlayerV1) {
                gl.imagePlayer = gl.imagePlayerV1;
            } else if (gl.iconPlayer == gl.iconPlayerV2) {
                gl.imagePlayer = gl.imagePlayerV2;
            } else {
                gl.imagePlayer = gl.imagePlayerV3;
            }
            File file = new File(gl.imagePlayer);
            player = ImageIO.read(file);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        BufferedImage image = null;
        image = player;
        g.drawImage(image, Ex, Ey, gl.titleSize, gl.titleSize, null);
    }

}
