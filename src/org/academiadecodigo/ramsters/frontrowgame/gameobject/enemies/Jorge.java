package org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Jorge extends NPC {

    public Jorge(int x, int y, Picture picture) {
        super(new Position(x, y, picture.getWidth(), picture.getHeight()), NPCtype.JORGE,picture);
    }

    public void move(Position pos) {
        super.move(pos, 650, 1125, 250, 825);
    }

    @Override
    public void attack() {
        if (Math.random() < 0.1) {
            Game.getPlayerOne().damageTake(this.getStrenght(),NPCtype.JORGE);
        }
    }
}
