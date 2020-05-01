package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Doors;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Key;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sid extends NPC {

    public Sid(int x, int y, Picture picture) {
        super(new Position(x,y,picture.getWidth(),picture.getHeight()), NPCtype.SID, picture);
        Doors door = new Doors(384, 238, new Picture(384, 238, "resources/images/doorhorizontal.png"));
        Key key = new Key(500, 300, new Picture(500, 300, "resources/images/key.png"));
    }

    public void move(Position pos) {
        super.move(pos, 394, 650, 234, 825);
    }

    @Override
    public void attack() {
        if (Math.random() < 0.3) {
            Game.getPlayerOne().damageTake(this.getStrenght(), NPCtype.SID);
        }
    }
}
