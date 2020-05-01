package org.academiadecodigo.ramsters.frontrowgame.gameobject.objects;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.GameObject;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract class Obstacles extends GameObject {

    public Obstacles(Position position, Picture picture) {
       super(position,picture);
    }

}
