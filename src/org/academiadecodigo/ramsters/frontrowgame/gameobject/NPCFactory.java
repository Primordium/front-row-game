package org.academiadecodigo.ramsters.frontrowgame.gameobject;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NPCFactory {

/*    public static NPC getNewEnemy(Position pos, NPCtype enemy) {

        switch (enemy) {
            case PAULO:
                return  new Sid(pos);
            case SID:
                return new  Benny(pos);
            case BENNY:
                return new Paulo(pos);
            case NUNO:
                return new Nuno(pos);
            case JORGE:
                return new Jorge(pos);
                default:
                   return new Paulo(pos);
        }
    }*/

    public static void generateEnemies(){
        new Paulo(150, 600, new Picture(150,600,"resources/images/paulo.png"));
        new Benny(650,100, new Picture(650,100,"resources/images/benny.png"));
        new Sid(500,550, new Picture(500,550,"resources/images/sid.png"));
        new Nuno(950,300, new Picture(950,300, "resources/images/nuno.png"));
        new Jorge(800,600, new Picture(800,600,"resources/images/jorge.png"));

        GameObject.showALL();

    /*    for(NPC enemy: npcs) {
            enemy.show();
        }*/

        /*
        for (int i = 0; i < len; i++) {
            NPC enemy = new NPC(new Position(100*i, 100*i), NPCtype.values()[i], );
            enemy.show();
            npcs[i] = enemy;
        }*/
    }

}
