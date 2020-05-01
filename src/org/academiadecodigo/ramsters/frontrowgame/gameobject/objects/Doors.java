package org.academiadecodigo.ramsters.frontrowgame.gameobject.objects;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Doors extends Obstacles {

    public Doors(int x, int y, Picture picture) {
        super(new Position(x,y,picture.getWidth(),picture.getHeight()), picture);
    }
}
