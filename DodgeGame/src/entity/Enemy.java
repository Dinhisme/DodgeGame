package entity;

import java.awt.Rectangle;
import java.io.File;
import javax.imageio.ImageIO;
import main.GameLable;

/**
 *
 * @author MyPC
 */
public class Enemy extends Entity {

    public Rectangle soliArea = new Rectangle(0, 0, 30, 30);

    public Enemy(GameLable gl) {
        super(gl);
        getPlayerImage();
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            File file1 = new File("src\\image\\enemy.png");
            enemyRocket = ImageIO.read(file1);
            File file2 = new File("src\\image\\heart.png");
            enemyHeart = ImageIO.read(file2);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}