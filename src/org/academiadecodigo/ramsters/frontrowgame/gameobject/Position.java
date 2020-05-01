package org.academiadecodigo.ramsters.frontrowgame.gameobject;

import java.awt.*;

public class Position {

    private int x;
    private int y;
    private int width;
    private int height;

    public Position(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {// to change the position by x pixels
        this.x += x;
    }

    public void setY(int y) {
        this.y += y;
    }

    public static boolean inter(Position pos1, Position pos) {
        Rectangle r1 = new Rectangle(pos1.getX(), pos1.getY(), pos1.getWidth(), pos1.getHeight());
        Rectangle r2 = new Rectangle(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight());
        return (r1.intersects(r2));
    }

    public boolean equalsAA(Position pos) {
        Rectangle r1 = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        Rectangle r2 = new Rectangle(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight());
        return (r1.intersects(r2));
    }


/*    public boolean equalsAA(Position pos) {

        return (pos.getX() + pos.width >= this.getX() &&
                pos.getY() + pos.height >= this.getY() &&
                this.getX() + this.width >= pos.getX() &&
                this.getY() + this.height >= pos.getY());
    }*/


/*    public boolean equalsAA(Position pos) {
       return ((this.getX() >= pos.getX() && this.getX() <= pos.getX() + pos.getWidth())||
               this.getX() + this.getWidth() >= pos.getX() && this.getX() + this.getWidth() <= pos.getX() + pos.getWidth()) &&

               ((this.getY() >= pos.getY() && this.getY() <= pos.getY() + pos.getHeight()) ||
               this.getY() + this.getHeight() >= pos.getY() && this.getY()  + this.getHeight() <= pos.getY() + pos.getHeight());
    }*/

}
