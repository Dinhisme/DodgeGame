package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author MyPC
 */
public class KeyPress implements KeyListener {

    GameLable gl;

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyPress(GameLable gl) {
        this.gl = gl;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //man hinh cho
        if (gl.gameScreen == gl.titleScreen) {
            if (code == KeyEvent.VK_W) {
                gl.title.selectTabs--;
                if (gl.title.selectTabs < 0) {
                    gl.title.selectTabs = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gl.title.selectTabs++;
                if (gl.title.selectTabs > 2) {
                    gl.title.selectTabs = 0;
                }
            }
            if (code == KeyEvent.VK_A) {
                gl.title.selectIcon--;
                if (gl.title.selectTabs == 0) {
                    if (gl.title.selectIcon < 0) {
                        gl.title.selectIcon = 2;
                        gl.iconPlayer = gl.iconPlayerV1;
                    }
                    if (gl.title.selectIcon == 2) {
                        gl.iconPlayer = gl.iconPlayerV3;
                    }
                    if (gl.title.selectIcon == 1) {
                        gl.iconPlayer = gl.iconPlayerV2;
                    }
                    if (gl.title.selectIcon == 0) {
                        gl.iconPlayer = gl.iconPlayerV1;
                    }
                }
            }
            if (code == KeyEvent.VK_D) {
                gl.title.selectIcon++;
                if (gl.title.selectTabs == 0) {
                    if (gl.title.selectIcon == 0) {
                        gl.iconPlayer = gl.iconPlayerV1;
                    }
                    if (gl.title.selectIcon == 1) {
                        gl.iconPlayer = gl.iconPlayerV2;
                    }
                    if (gl.title.selectIcon == 2) {
                        gl.iconPlayer = gl.iconPlayerV3;
                    }
                    if (gl.title.selectIcon > 2) {
                        gl.title.selectIcon = 0;
                        gl.iconPlayer = gl.iconPlayerV1;
                    }
                }
            }
            if (code == KeyEvent.VK_UP) {
                gl.title.selectTabs--;  
                if (gl.title.selectTabs < 0) {
                    gl.title.selectTabs = 2;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gl.title.selectTabs++;
                if (gl.title.selectTabs > 2) {
                    gl.title.selectTabs = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gl.title.selectTabs == 1) {
                    gl.gameScreen = gl.playScreen;
                    gl.title.selectTabs = 0;
                    gl.imageMainScreen = gl.imagePlayScreen;
                    drawMainScreen();
                }
                if (gl.title.selectTabs == 2) {
                    System.exit(0);
                }
            }
        }
        //game screen        
        if (gl.gameScreen == gl.playScreen) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                if (gl.gameScreen == gl.playScreen) {
                    gl.gameScreen = gl.pauseScreen;
                    gl.title.selectTabs = 0;
                } else if (gl.gameScreen == gl.pauseScreen) {
                    gl.gameScreen = gl.playScreen;
                    gl.title.selectTabs = 0;
                }
            }
        }

        //pause screen
        if (gl.gameScreen == gl.pauseScreen) {
            if (code == KeyEvent.VK_W) {
                gl.title.selectTabs--;
                if (gl.title.selectTabs < 0) {
                    gl.title.selectTabs = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gl.title.selectTabs++;
                if (gl.title.selectTabs > 2) {
                    gl.title.selectTabs = 0;
                }
            }
            if (code == KeyEvent.VK_UP) {
                gl.title.selectTabs--;
                if (gl.title.selectTabs < 0) {
                    gl.title.selectTabs = 2;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                gl.title.selectTabs++;
                if (gl.title.selectTabs > 2) {
                    gl.title.selectTabs = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gl.title.selectTabs == 0) {
                    gl.gameScreen = gl.playScreen;
                }
                if (gl.title.selectTabs == 1) {
                    gl.gameScreen = gl.newScreen;
                }
                if (gl.title.selectTabs == 2) {
                    gl.imageMainScreen = gl.imageTitleScreen;
                    drawMainScreen();
                    gl.gameScreen = gl.titleScreen;
                    gl.title.selectTabs = 0;
                }
            }
        }
        //man hinh chet
        if (gl.gameScreen == gl.loseScreen) {
            if (code == KeyEvent.VK_W) {
                gl.title.selectTabs--;
                if (gl.title.selectTabs < 0) {
                    gl.title.selectTabs = 1;
                }
            }
            if (code == KeyEvent.VK_S) {
                gl.title.selectTabs++;
                if (gl.title.selectTabs > 1) {
                    gl.title.selectTabs = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gl.title.selectTabs == 0) {
                    gl.gameScreen = gl.newScreen;
                }
                if (gl.title.selectTabs == 1) {
                    gl.imageMainScreen = gl.imageTitleScreen;
                    drawMainScreen();
                    gl.gameScreen = gl.titleScreen;
                    gl.title.selectTabs = 0;
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void drawMainScreen() {
        try {
            File file = new File(gl.imageMainScreen);
            Image backgr = ImageIO.read(file);
            gl.setIcon(new ImageIcon(backgr.getScaledInstance(gl.ScreenWidth, gl.ScreenHeight, 0)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
