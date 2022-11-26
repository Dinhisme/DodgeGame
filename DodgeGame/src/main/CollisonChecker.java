package main;

import entity.Entity;

/**
 *
 * @author MyPC
 */
public class CollisonChecker {

    GameLable gl;

    public CollisonChecker(GameLable gl) {
        this.gl = gl;
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int k = 999;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                target[i].solidArea.x = target[i].Ex + target[i].solidArea.x;
                target[i].solidArea.y = target[i].Ey + target[i].solidArea.y;
                entity.solidArea.x = entity.Ex + entity.solidArea.x;
                entity.solidArea.y = entity.Ey + entity.solidArea.y;
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            gl.gameScreen = gl.loseScreen;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            gl.gameScreen = gl.loseScreen;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            gl.gameScreen = gl.loseScreen;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            gl.gameScreen = gl.loseScreen;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidDefaultX;
                entity.solidArea.y = entity.solidDefaultX;
                target[i].solidArea.x = target[i].solidDefaultX;
                target[i].solidArea.y = target[i].solidDefaultY;
            }
        }
        return k;
    }

}
