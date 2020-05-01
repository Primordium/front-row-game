package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Doors;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Key;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paulo extends NPC {

    public Paulo(int x, int y, Picture picture) {
        super(new Position(x, y, picture.getWidth(), picture.getHeight()), NPCtype.PAULO, picture);
        Doors door = new Doors(398, 620, new Picture(398, 620, "resources/images/doorvert.png"));
        Key key = new Key(200, 700, new Picture(200, 700, "resources/images/key.png"));
    }

    @Override
    public void attack() {
        if (Math.random() < 0.4) {
            Game.getPlayerOne().damageTake(this.getStrenght(), NPCtype.PAULO);
        }
    }

    public void move(Position pos) {
        super.move(pos, 0, 394, 338, 825, 4);
    }

}
