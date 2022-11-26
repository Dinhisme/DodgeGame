package main;

import entity.Enemy;
import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *
 * @author MyPC
 */
public class GameLable extends JLabel implements Runnable {

    final int originalTitleSize = 16;
    final int scale = 3;

    public final int titleSize = originalTitleSize * scale; //48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    public final int ScreenWidth = titleSize * maxScreenCol; //768
    public final int ScreenHeight = titleSize * maxScreenRow; //576

    KeyPress key = new KeyPress(this);

    Thread gameThread;

    public Player player = new Player(this, key);

    public Enemy enemy = new Enemy(this);

    public TitleScreen title = new TitleScreen(this);

    public Entity enemyNPC[] = new Entity[20];

    //Vị trí đầu của tên lửa
    public SetFirstPosition aSetter = new SetFirstPosition(this);

    //Kiểm tra 2 vật thể chạm nhau
    public CollisonChecker checker = new CollisonChecker(this);

    //FPS
    int FPS = 60;

    //Đếm tg tăng tốc và kết thúc
    int countTime, countTimeEnd = 0;

    //Kiểm tra màn hình chờ
    public int gameScreen;
    public final int titleScreen = 0;
    public final int playScreen = 1;
    public final int pauseScreen = 2;
    public final int newScreen = 3;
    public final int loseScreen = 4;

    public int gameLevel = 0;

    public String imagePlayer;
    public final String imagePlayerV1 = "src\\image\\playerV1.png";
    public final String imagePlayerV2 = "src\\image\\playerV2.png";
    public final String imagePlayerV3 = "src\\image\\playerV3.png";
    public String iconPlayer;
    public final String iconPlayerV1 = "src\\image\\iconV1.png";
    public final String iconPlayerV2 = "src\\image\\iconV2.png";
    public final String iconPlayerV3 = "src\\image\\iconV3.png";
    public final String imageTitleScreen = "src\\image\\tt.png";
    public final String imagePlayScreen = "src\\image\\GameScreen.jpg";
    public String imageMainScreen = imageTitleScreen;

    public GameLable() {

        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));

        this.setBackground(Color.red);

        //this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);

    }

    public void setupGame() {
        aSetter.setNPCRocket();
        gameScreen = titleScreen;
        imagePlayer = imagePlayerV1;
        iconPlayer = iconPlayerV1;
        key.drawMainScreen();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {

                update();

                repaint();

                delta--;

                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void runThreadEnemyCheck() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        countTime++;
                        countTimeEnd++;
                        if (countTime == 30) {
                            for (int i = 0; i < enemyNPC.length; i++) {
                                if (enemyNPC[i] != null) {
                                    enemyNPC[i].speed++;
                                }
                            }
//                            gameLevel = -1;
//                            Thread.sleep(5000);
//                            gameLevel = 0;
//                            gameLevel++;
//                            aSetter.setNPCHeart();
//                            countTime = 0;
//                            System.out.println(enemy.speed + " level:" + gameLevel);
//                        }
//                        if (countTimeEnd == 120) {
//                            System.out.println("Win");
//                            gameScreen = newScreen;
                        }
                        Thread.sleep(1000);
                        //System.out.println(countTime);
                        while (gameScreen == pauseScreen || gameScreen == titleScreen) {
                            //System.out.println("sleep");
                        }
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        }.start();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        runThreadEnemyCheck();
    }

    public void update() {
        if (gameScreen == newScreen) {
            aSetter.setNPCRocket();
            player.setDefaultValues();
            countTime = 0;
            gameScreen = playScreen;
        }
        if (gameScreen == playScreen) {
            player.update();
            for (int i = 0; i < enemyNPC.length; i++) {
                if (enemyNPC[i] != null) {
                    enemyNPC[i].updateE();
                }
            }
        }
    }

    public void paintComponent(Graphics g1) {

        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        if (gameScreen == titleScreen) {
            title.draw(g);
            g.dispose();
        }

        player.draw(g);
        for (int i = 0; i < enemyNPC.length; i++) {
            if (enemyNPC[i] != null) {
                enemyNPC[i].draw(g);
            }
        }

        title.draw(g);

        g.dispose();
    }

}
