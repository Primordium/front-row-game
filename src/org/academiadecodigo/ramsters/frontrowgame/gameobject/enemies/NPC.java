package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Doors;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Key;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.player.Player;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.player.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public abstract class NPC extends GameObject {
    private NPCtype npcType;
    private boolean dead;
    private int life;
    public static int MOVEMENT = 10;
    public static LinkedList<NPC> Npcs = new LinkedList<>();
    protected static Player playerOne;
    private int strenght;

    public NPC(Position position, NPCtype npcType, Picture picture) {
        super(position, picture);
        this.npcType = npcType;
        dead = false;
        life = npcType.getLife();
        strenght = npcType.getStrength();

        Npcs.add(this);

    }

    public void takeDamage(int damage) {
        life -= damage;
        if (life < 1) {
            die();
        }
    }

    public abstract void attack();

    public abstract void move(Position pos);

    public void move(Position pos, int left, int right, int top, int bottom) {
        int moveX = 0;
        int moveY = 0;
        if (!Position.inter(getPos(), pos)) {
            if (pos.getX() > left && pos.getX() < right && pos.getY() > top && pos.getY() < bottom) {
                if (Math.abs(pos.getX() - getPos().getX()) < 1) {
                    moveY = getPos().getY() - pos.getY() > 0 ? -1 : +1;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                    return;
                } else if (Math.abs(pos.getY() - getPos().getY()) < 1) {
                    moveX = getPos().getX() - pos.getX() > 0 ? -1 : +1;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                    return;
                } else {
                    moveX = getPos().getX() - pos.getX() > 0 ? -1 : +1;
                    moveY = getPos().getY() - pos.getY() > 0 ? -1 : +1;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                }
            }
            return;
        }
        attack();
    }

    public void move(Position pos, int left, int right, int top, int bottom, int speed) {
        int moveX = 0;
        int moveY = 0;
        //System.out.println(checkDistance(getPos(), pos));
        if (!Position.inter(getPos(), pos)) {
            if (pos.getX() > left && pos.getX() < right && pos.getY() > top && pos.getY() < bottom) {
                if (Math.abs(pos.getX() - getPos().getX()) <= 4) {
                    moveY = getPos().getY() - pos.getY() > 0 ? -speed : +speed;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                    return;
                } else if (Math.abs(pos.getY() - getPos().getY()) < 4) {
                    moveX = getPos().getX() - pos.getX() > 0 ? -speed : +speed;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                    return;
                } else {
                    moveX = getPos().getX() - pos.getX() > 0 ? -speed : +speed;
                    moveY = getPos().getY() - pos.getY() > 0 ? -speed : +speed;
                    setPos(moveX, moveY);
                    getPicture().translate(moveX, moveY);
                }
            }
            return;
        }
        attack();
    }

    public boolean colision(LinkedList<GameObject> gameObjects, Position nextPos) {
        for (GameObject gamo : gameObjects) {
            if (!this.equals(gamo)) {
                if (nextPos.equalsAA(gamo.getPos())) {
                    if(gamo instanceof Key) {
                        gamo.hide();
                        playerOne.setHasKey(true);
                        return true;
                    }
                    if(gamo instanceof Doors && playerOne.hasKey()) {
                        gamo.hide();
                        getLinkedList().remove(gamo);
                        playerOne.setHasKey(false);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static LinkedList<NPC> getNpcs(){
        return Npcs;
    }

    public Player getPlayer(){
        return playerOne;
    }

    public void setUpPlayer(Player playerOne){
        this.playerOne = playerOne;
    }

    public void die() {
        this.getPicture().delete();
        dead = true;
        GameObject.getLinkedList().remove(this);
        Npcs.remove(this);
    }

    public int getLife(){
        return life;
    }

    public int getStrenght() {
        return strenght;
    }

    public int checkDistance(Position pos, Position pos2){
        return (Math.abs(pos.getX() - pos2.getX()) + Math.abs(pos.getY() - pos2.getY()));
    }


    public boolean isDead() {
        return dead;
    }

    @Override
    public String toString() {
        return ("X: " + getPos().getX() + "\nY:" + getPos().getY());
    }
}

