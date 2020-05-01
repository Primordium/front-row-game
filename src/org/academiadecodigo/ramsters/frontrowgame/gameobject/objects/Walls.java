package org.academiadecodigo.ramsters.frontrowgame.gameobject.objects;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Walls extends Obstacles {

    public Walls(int x,int y, Picture picture) {
        super(new Position(x,y,picture.getWidth(),picture.getHeight()), picture);
    }
}
