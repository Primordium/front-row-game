package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Doors;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Key;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Benny extends NPC {


    public Benny(int x, int y, Picture picture) {
        super(new Position(x,y,picture.getWidth(),picture.getHeight()), NPCtype.BENNY, picture);
        Doors door = new Doors(810, 238, new Picture(810, 238, "resources/images/doorhorizontal.png"));
        Key key = new Key(810, 138, new Picture(810, 138, "resources/images/key.png"));
    }

    public void move(Position pos) {
        super.move(pos, 362, 1125, 10, 234);
    }

    @Override
    public void attack() {
        if (Math.random() < 0.2) {
            Game.getPlayerOne().damageTake(this.getStrenght(), NPCtype.BENNY);
        }
    }
}
