package org.academiadecodigo.ramsters.frontrowgame;


import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCFactory;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.player.KeyboardManager;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.player.Player;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies.NPC;
import org.academiadecodigo.ramsters.frontrowgame.window.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Field field;
    private static Player playerOne;
    private Sound sound;


    public Game() {
        field = new Field();
        playerOne = new Player(field);
        playerOne.setUpPlayer(playerOne);
        this.sound = new Sound("/resources/music/endgame.wav");
    }

    public static Player getPlayerOne() {
        return playerOne;
    }

    public void start() {
        NPCFactory.generateEnemies();
        sound.play(true);
        sound.loopIndef();
        playerOne.show();
        while (!playerOne.isDead()) {

            playerOne.checkMove();
            for (int i = 0; i < NPC.getNpcs().size(); i++) {
                NPC.getNpcs().get(i).move(playerOne.getPos());
            }
            checkWin();


            // Nuno Solution
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
            Picture gameOver = new Picture(500, 302, "resources/images/gameover.png");
            gameOver.grow(300, 300);
            gameOver.draw();
        } catch (InterruptedException e) {
            System.out.println("Game Over");
        }
    }

    public void checkWin() {
        int count = 0;
        for (NPC npc : NPC.getNpcs()) {
            if (npc.isDead()) {
                if(npc instanceof Player){
                    continue;
                }
                count++;
            }
        }
        if (count == NPC.getNpcs().size() - 1) {
            Picture win = new Picture(350, 102, "resources/images/win.png");
            win.draw();
        }

        Text endGame = new Text(200, 800, "Press R to Restart game or Q to quit.");
        endGame.setColor(Color.BLACK);
        endGame.grow(150,10);
        endGame.draw();
    }
}

