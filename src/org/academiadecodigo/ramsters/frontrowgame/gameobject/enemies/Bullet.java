package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies.NPC.playerOne;

public class Bullet {

    private Position position;
    private Picture bullet;
    private boolean fired;
    private int targetX;
    private int targetY;
    private Position playerPos;


    public Bullet(boolean a) {
        fired = false;
    }

    public Bullet(Position position) {
        this.fired = true;
        this.position = position;
        bullet = new Picture(position.getX(), position.getY(), "resources/images/bullet.png");
        playerPos = playerOne.getPos();
        targetX = playerPos.getX();
        targetY = playerPos.getY();
    }

    public boolean isFired() {
        return fired;
    }

    public boolean bulletSpeed() {
        int moveX = 0;
        int moveY = 0 ;
        if (Math.abs(targetX - position.getX()) <= 4) {
           moveY = position.getX() - targetX > 0 ? -5 : +5;
        } else if (Math.abs(position.getY() - targetY) < 4) {
           moveX = position.getX() - targetX > 0 ? -5 : +5;
        } else {
           moveX = position.getX() - targetX > 0 ? -5 : +5;
           moveY = position.getY() - targetY > 0 ? -5 : +5;
        }
        position.setY(moveY);
        position.setX(moveX);
        bullet.translate(moveX, moveY);
        if(Position.inter(position, new Position(targetX, targetY, 32,32))){
            if(checkHit()){
            bullet.delete();
            fired = false;
            return true;
            }
            bullet.delete();
            fired = false;
        }
        return false;
    }

    public boolean checkHit() {
        java.awt.Rectangle r1 = new java.awt.Rectangle(position.getX(), position.getY(), position.getWidth(), position.getHeight());
        java.awt.Rectangle r2 = new java.awt.Rectangle(playerOne.getPos().getX(), playerOne.getPos().getY(), playerOne.getPos().getWidth(), playerOne.getPos().getHeight());
        if(r1.intersects(r2)){
            bullet.delete();
            fired = false;
            return true;
        }
        return false;
    }

    public void draw(){
        bullet.draw();
    }

    public void bulletKill(){
         bullet.delete();
    }
}
