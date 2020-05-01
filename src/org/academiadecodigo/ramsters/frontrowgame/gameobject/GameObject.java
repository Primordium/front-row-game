package org.academiadecodigo.ramsters.frontrowgame.gameobject;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public abstract class GameObject{
    private Picture picture;
    private Position pos;
    private static LinkedList<GameObject> listObjects = new LinkedList<>();


    public GameObject(Position position, Picture picture) {
        this.pos = new Position(position.getX(),position.getY(),picture.getWidth(),picture.getHeight());
        this.picture = picture;
        listObjects.add(this);
    }

    public Position getPos(){
        return pos;
    }

    public void setPos(int x, int y){
        pos.setX(x);
        pos.setY(y);
    }

    public void show(){
        picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture pic){
        picture = pic;
        show();
    }

    public static void showALL(){
        listObjects.forEach(GameObject::show);
    }

    public void hide(){
        picture.delete();
    }

    public static LinkedList<GameObject> getLinkedList() {
        return listObjects;
    }

}
