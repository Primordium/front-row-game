package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.Main;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Nuno extends NPC {

    private Bullet bullet = new Bullet(false);

    public Nuno(int x, int y, Picture picture) {
        super(new Position(x, y, picture.getWidth(), picture.getHeight()), NPCtype.NUNO, picture);
    }

    @Override
    public void attack() {

        if (Math.random() > 0.85) {
            if (!bullet.isFired())
                bullet = new Bullet(new Position(getPos().getX(), getPos().getY(), 15, 15));
            bullet.draw();
        }

        if (bullet.isFired()) {
            if (bullet.bulletSpeed()) {
                playerOne.damageTake(getStrenght(), NPCtype.NUNO);
            }
            if (bullet.checkHit()) {
                playerOne.damageTake(getStrenght(), NPCtype.NUNO);
            }

        }
    }

    @Override
    public void die() {
        bullet.bulletKill();
        super.die();
    }

    @Override
    public void move(Position pos) {
        if (pos.getX() > 650 && pos.getX() < 1125 && pos.getY() > 250 && pos.getY() < 825) {
            attack();
        }
    }
}
