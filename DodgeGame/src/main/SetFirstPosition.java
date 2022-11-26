package main;

import entity.Enemy;
import java.util.Random;

/**
 *
 * @author MyPC
 */
public class SetFirstPosition {

    GameLable gl;
    Random objGenerator = new Random();

    public SetFirstPosition(GameLable gl) {
        this.gl = gl;
    }

    public void setNPCRocket() {
        gl.enemyNPC[0] = new Enemy(gl);
        gl.enemyNPC[0].Ex = gl.titleSize * 20;
        gl.enemyNPC[0].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[1] = new Enemy(gl);
        gl.enemyNPC[1].Ex = gl.titleSize * 22;
        gl.enemyNPC[1].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[2] = new Enemy(gl);
        gl.enemyNPC[2].Ex = gl.titleSize * 24;
        gl.enemyNPC[2].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[3] = new Enemy(gl);
        gl.enemyNPC[3].Ex = gl.titleSize * 26;
        gl.enemyNPC[3].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[4] = new Enemy(gl);
        gl.enemyNPC[4].Ex = gl.titleSize * 28;
        gl.enemyNPC[4].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[5] = new Enemy(gl);
        gl.enemyNPC[5].Ex = gl.titleSize * 30;
        gl.enemyNPC[5].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[6] = new Enemy(gl);
        gl.enemyNPC[6].Ex = gl.titleSize * 32;
        gl.enemyNPC[6].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[7] = new Enemy(gl);
        gl.enemyNPC[7].Ex = gl.titleSize * 34;
        gl.enemyNPC[7].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[8] = new Enemy(gl);
        gl.enemyNPC[8].Ex = gl.titleSize * 36;
        gl.enemyNPC[8].Ey = objGenerator.nextInt(540);

        gl.enemyNPC[9] = new Enemy(gl);
        gl.enemyNPC[9].Ex = gl.titleSize * 38;
        gl.enemyNPC[9].Ey = objGenerator.nextInt(540);
    }

//    public void setNPCHeart() {
//        gl.enemyNPC[0] = new Enemy(gl);
//        gl.enemyNPC[0].Ex = gl.titleSize * (6 + 15);
//        gl.enemyNPC[0].Ey = gl.titleSize * 3 + 20;
//
//        gl.enemyNPC[1] = new Enemy(gl);
//        gl.enemyNPC[1].Ex = gl.titleSize * (5 + 15);
//        gl.enemyNPC[1].Ey = gl.titleSize * 4;
//
//        gl.enemyNPC[2] = new Enemy(gl);
//        gl.enemyNPC[2].Ex = gl.titleSize * (4 + 15) + 30;
//        gl.enemyNPC[2].Ey = gl.titleSize * 5;
//
//        gl.enemyNPC[3] = new Enemy(gl);
//        gl.enemyNPC[3].Ex = gl.titleSize * (5 + 15);
//        gl.enemyNPC[3].Ey = gl.titleSize * 6;
//
//        gl.enemyNPC[4] = new Enemy(gl);
//        gl.enemyNPC[4].Ex = gl.titleSize * (6 + 15);
//        gl.enemyNPC[4].Ey = gl.titleSize * 7 - 10;
//
//        gl.enemyNPC[5] = new Enemy(gl);
//        gl.enemyNPC[5].Ex = gl.titleSize * (7 + 15);
//        gl.enemyNPC[5].Ey = gl.titleSize * 8 - 20;
//
//        //giữa
//        gl.enemyNPC[6] = new Enemy(gl);
//        gl.enemyNPC[6].Ex = gl.titleSize * (8 + 15);
//        gl.enemyNPC[6].Ey = gl.titleSize * 9 - 30;
//
//        gl.enemyNPC[7] = new Enemy(gl);
//        gl.enemyNPC[7].Ex = gl.titleSize * (9 + 15); //7
//        gl.enemyNPC[7].Ey = gl.titleSize * 8 - 20;
//
//        gl.enemyNPC[8] = new Enemy(gl);
//        gl.enemyNPC[8].Ex = gl.titleSize * (10 + 15); //6
//        gl.enemyNPC[8].Ey = gl.titleSize * 7 - 10;
//
//        gl.enemyNPC[9] = new Enemy(gl);
//        gl.enemyNPC[9].Ex = gl.titleSize * (11 + 15);
//        gl.enemyNPC[9].Ey = gl.titleSize * 6;
//
//        gl.enemyNPC[10] = new Enemy(gl);
//        gl.enemyNPC[10].Ex = gl.titleSize * (12 + 15) - 30;
//        gl.enemyNPC[10].Ey = gl.titleSize * 5;
//
//        gl.enemyNPC[11] = new Enemy(gl);
//        gl.enemyNPC[11].Ex = gl.titleSize * (11 + 15);
//        gl.enemyNPC[11].Ey = gl.titleSize * 4;
//
//        gl.enemyNPC[12] = new Enemy(gl);
//        gl.enemyNPC[12].Ex = gl.titleSize * (10 + 15);
//        gl.enemyNPC[12].Ey = gl.titleSize * 3 + 20; //
//
//        gl.enemyNPC[13] = new Enemy(gl);
//        gl.enemyNPC[13].Ex = gl.titleSize * (9 + 15);
//        gl.enemyNPC[13].Ey = gl.titleSize * 4;
//
//        gl.enemyNPC[14] = new Enemy(gl);
//        gl.enemyNPC[14].Ex = gl.titleSize * (8 + 15);
//        gl.enemyNPC[14].Ey = gl.titleSize * 4 + 30;
//        
//        gl.enemyNPC[15] = new Enemy(gl);
//        gl.enemyNPC[15].Ex = gl.titleSize * (7 + 15);
//        gl.enemyNPC[15].Ey = gl.titleSize * 4;
//    }
}
