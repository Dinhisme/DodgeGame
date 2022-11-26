package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import main.GameLable;

/**
 *
 * @author MyPC
 */
public class Entity {

    GameLable gl;

    public int Ex, Ey;
    public int speed = 4;

    Random objGenerator = new Random();

    public String direction = "right";

    public BufferedImage player, enemyRocket, enemyHeart;

    public Rectangle solidArea = new Rectangle(0, 0, 32, 28);

    public int solidDefaultX, solidDefaultY;

    BufferedImage image = null, image2 = null;

    public Entity(GameLable gl) {
        this.gl = gl;
    }

    public void updateE() {
        Ex -= speed;

    }

    public void checkSpeed() {
        speed += 1;
    }

    public void draw(Graphics g) {
        //rocket
        if (gl.gameLevel == 0) {
            image = enemyRocket;
            for (int i = 0; i < gl.enemyNPC.length; i++) {
                if (i == i && Ex < 0) {
                    Ex = Ex + gl.titleSize * 20;
                    Ey = objGenerator.nextInt(550);
                }
                g.drawImage(image, Ex, Ey, gl.titleSize, gl.titleSize, null);
            }
        }
        //heart
//        if (gl.gameLevel == 1) {
//            image = enemyHeart;
//            for (int j = 0; j < gl.enemyNPC.length; j++) {
//                if (Ex < 0) {
//                    gl.aSetter.setNPCRocket();
//                    gl.gameLevel = 0;
//                }
//                g.drawImage(image, Ex, Ey, gl.titleSize, gl.titleSize, null);
//            }
//        }
    }

}
