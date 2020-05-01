package org.academiadecodigo.ramsters.frontrowgame.gameobject.player;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.window.FieldLimits;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerMovement {

    private Player player;

    public PlayerMovement(Player player) {
        this.player = player;
    }

    public void move() {
        KeyboardManager keyboard = player.getKeyboard();

        if (keyboard.getKey() == KeyboardEvent.KEY_SPACE) {
            player.attack();
            keyboard.setKey(0);
        }

        if (keyboard.isMoving()) {

            switch (keyboard.getKey()) {

                case KeyboardEvent.KEY_UP:
                    if (FieldLimits.verifyY(player.getPos().getY() - 10) &&
                            player.colision(player.getLinkedList(), new Position(player.getPos().getX(),
                                    player.getPos().getY() - 7, player.getPos().getWidth(), player.getPos().getWidth()))) {
                        player.movePlayer(0, -7);
                        player.getPos().setY(-7);
                        player.setDirection(Direction.UP);
                        player.getPicture().load("resources/images/char_back.png");
                        break;
                    } else {
                        player.setDirection(Direction.UP);
                        player.getPicture().load("resources/images/char_back.png");
                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (FieldLimits.verifyY(player.getPos().getY() + 10) && player.colision(player.getLinkedList(), new Position(
                            player.getPos().getX(), player.getPos().getY() + 7, player.getPos().getWidth(),
                            player.getPos().getHeight()))) {
                        player.movePlayer(0, 7);
                        player.getPos().setY(7);
                        player.setDirection(Direction.DOWN);
                        player.getPicture().load("resources/images/char_front.png");
                        break;
                    } else {
                        player.setDirection(Direction.DOWN);
                        player.getPicture().load("resources/images/char_front.png");
                    }
                    break;

                case KeyboardEvent.KEY_LEFT:
                    if (FieldLimits.verifyX(player.getPos().getX() - 10) && player.colision(player.getLinkedList(), new Position(
                            player.getPos().getX() - 7, player.getPos().getY(), player.getPos().getWidth(), player.getPos().getHeight()))) {
                        player.movePlayer(-7, 0);
                        player.getPos().setX(-7);
                        player.setDirection(Direction.LEFT);
                        player.getPicture().load("resources/images/char_left.png");
                        break;
                    } else {
                        player.setDirection(Direction.LEFT);
                        player.getPicture().load("resources/images/char_left.png");
                    }
                    break;

                case KeyboardEvent.KEY_RIGHT:
                    if (FieldLimits.verifyX(player.getPos().getX() + 10) && player.colision(player.getLinkedList(), new Position(
                            player.getPos().getX() + 7, player.getPos().getY(), player.getPos().getWidth(), player.getPos().getHeight()))) {
                        player.getPos().setX(7);
                        player.movePlayer(7, 0);
                        player.setDirection(Direction.RIGHT);
                        player.getPicture().load("resources/images/char_right.png");
                        break;
                    } else {
                        player.setDirection(Direction.RIGHT);
                        player.getPicture().load("resources/images/char_right.png");
                    }
                    break;

                case KeyboardEvent.KEY_R:
                    Game game = new Game();
                    game.start();
                    break;
                case KeyboardEvent.KEY_Q:
                    System.exit(0);
            }
        }
        keyboard.stopMoving();
    }
}


