package org.academiadecodigo.ramsters.frontrowgame.gameobject.player;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies.NPC;
import org.academiadecodigo.ramsters.frontrowgame.window.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends NPC {

    private KeyboardManager keyboard;
    private PlayerMovement nextMove = new PlayerMovement(this);
    private Direction direction;
    private Weapon weapon;
    private Field field;
    private int life;
    private boolean dead;
    private boolean hasKey;

    public Player(Field field) {
        super(new Position(150, 150, 32,32), NPCtype.PLAYER, new Picture(150, 150, "resources/images/char_front.png"));
        keyboard = new KeyboardManager();
        dead = false;
        direction = Direction.UP;
        weapon = new Weapon();
        this.field = field;
        this.life = getLife();
        super.setUpPlayer(this);
        field.getStatus().updateLife(getLife());
    }

    public void damageTake(int damage, NPCtype npcType) {
        life -=damage;
        field.getStatus().updateLife(life, npcType, damage);
        if (life <= 0) {
            dead = true;
        }
    }

    @Override
    public void attack() {
        weapon.attack(direction, this.getPos());
    }

    @Override
    public void move(Position pos) {

    }

    @Override
    public void setPicture(Picture pic) {
        super.setPicture(pic);
    }

    public boolean isDead() {
        return dead;
    }

    public KeyboardManager getKeyboard() {
        return keyboard;
    }

    public void movePlayer(int x, int y) {
        getPicture().translate(x, y);
    }

    public void checkMove() {
        nextMove.move();
    }

    public void setDirection(Direction e) {
        this.direction = e;
    }

    public void setHasKey(boolean key) {
        this.hasKey = key;
    }

    public boolean hasKey() {
        return hasKey;
    }
}

