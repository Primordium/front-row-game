package org.academiadecodigo.ramsters.frontrowgame.window;


import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Doors;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.objects.Walls;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.Queue;

public class Field {

    private Picture floor;
    private Walls[] walls;
    private LinkedList doors;
    private Status status;

    public Field() {
        status = new Status();
        floor = new Picture(10, 10, "resources/images/mapBack.png");
        walls = new Walls[]{new Walls(362, 10, new Picture(362, 10, "resources/images/wall1.png")),
                new Walls(17, 338, new Picture(17, 338, "resources/images/wall2&5.png")),
                new Walls(130, 338, new Picture(130, 338, "resources/images/wall3.png")),
                new Walls(394, 695, new Picture(394, 695, "resources/images/wall4.png")),
                new Walls(362, 234, new Picture(362, 234, "resources/images/wall2&5.png")),
                new Walls(394, 338, new Picture(394, 338, "resources/images/wall6.png")),
                new Walls(466, 234, new Picture(466, 234, "resources/images/wall7.png")),
                new Walls(650, 250, new Picture(650, 250, "resources/images/wall8.png")),
                new Walls(890, 234, new Picture(890, 234, "resources/images/wall9.png")),
        };


        draw();
    }


    public Status getStatus() {
        return status;
    }

    public void draw() {
        floor.draw();
    }


}
