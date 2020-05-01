package org.academiadecodigo.ramsters.frontrowgame.window;

import org.academiadecodigo.ramsters.frontrowgame.Game;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.NPCtype;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Status {

    private Text healthPoints;
    private Picture[] hearts;
    private Picture[] heartsEmpty;
    private Text[] chat;
    private ArrayList<String> arrayChat;


    public Status() {
        Rectangle backgroundStatus = new Rectangle(1152,10,295,832);
        backgroundStatus.setColor(Color.BLACK);
        backgroundStatus.fill();

        Picture status1 = new Picture(1180, 10, "resources/images/status_frame.png");
        status1.draw();
        Picture status2 = new Picture(1180, 441, "resources/images/status_frame.png");
        status2.draw();

        Picture heart1 = new Picture(1200,50, "resources/images/heart.png");
        heart1.draw();
        Picture heart2 = new Picture(1270,50, "resources/images/heart.png");
        heart2.draw();
        Picture heart3 = new Picture(1340,50, "resources/images/heart.png");
        heart3.draw();
        Picture heart4 = new Picture(1235,100, "resources/images/heart.png");
        heart4.draw();
        Picture heart5 = new Picture(1305,100, "resources/images/heart.png");
        heart5.draw();

        hearts = new Picture[]{heart1, heart2, heart3, heart4, heart5};

        Picture heartEmpty1 = new Picture(1200,50, "resources/images/heartempty.png");
        Picture heartEmpty2 = new Picture(1270,50, "resources/images/heartempty.png");
        Picture heartEmpty3 = new Picture(1340,50, "resources/images/heartempty.png");
        Picture heartEmpty4 = new Picture(1235,100, "resources/images/heartempty.png");
        Picture heartEmpty5 = new Picture(1305,100, "resources/images/heartempty.png");
        heartsEmpty = new Picture[] {heartEmpty1, heartEmpty2, heartEmpty3, heartEmpty4, heartEmpty5};

        Text health = new Text(1290, 200, "Health");
        healthPoints = new Text(1290, 280, Integer.toString(NPCtype.PLAYER.getLife()));
        healthPoints.grow(50,50);
        health.grow(50,50);
        healthPoints.setColor(Color.WHITE);
        health.setColor(Color.WHITE);
        healthPoints.draw();
        health.draw();

        Picture keyStatus = new Picture(1290, 350, "resources/images/key.png");
        keyStatus.draw();

        Text chatLine1 = new Text(1200, 500, "-------------------------");
        Text chatLine2 = new Text(1200, 520, "-------------------------");
        Text chatLine3 = new Text(1200, 540, "-------------------------");
        Text chatLine4 = new Text(1200, 560, "-------------------------");
        Text chatLine5 = new Text(1200, 580, "-------------------------");
        Text chatLine6 = new Text(1200, 600, "-------------------------");
        Text chatLine7 = new Text(1200, 620, "-------------------------");
        Text chatLine8 = new Text(1200, 640, "-------------------------");
        Text chatLine9 = new Text(1200, 660, "-------------------------");
        Text chatLine10 = new Text(1200, 680, "-------------------------");
        Text chatLine11 = new Text(1200, 700, "-------------------------");
        Text chatLine12 = new Text(1200, 720, "-------------------------");
        Text chatLine13 = new Text(1200, 740, "-------------------------");
        Text chatLine14 = new Text(1200, 760, "-------------------------");


        chat = new Text[]{chatLine14, chatLine13, chatLine12, chatLine11, chatLine10, chatLine9, chatLine8, chatLine7, chatLine6, chatLine5, chatLine4, chatLine3, chatLine2, chatLine1};
        arrayChat = new ArrayList<>();

        for (Text txt: chat) {
            txt.setColor(Color.WHITE);
            txt.draw();
        }

    }

    public void removeHeart(int life) {
        if(life <= 0) {
            hearts[0].delete();
            heartsEmpty[0].draw();

        }
        for (int i = 0; i < hearts.length; i++) {
            if (life / 100 < i) {
                hearts[i].delete();
                heartsEmpty[i].draw();
            }
        }
    }

    public void textBoxDisplay(String s) {
        healthPoints.setText(s);
    }

    public void updateLife(int life){
        textBoxDisplay(Integer.toString(life));
    }

    public void updateLife(int life, NPCtype npc, int damage) {
        textBoxDisplay(Integer.toString(life));
        removeHeart(life);
        chat(damage, npc);
    }

    public void chat(int damage, NPCtype npc) {

        arrayChat.add(npc+" attack, you take "+damage+" damage");

        for (int i = 0; i < arrayChat.size(); i++) {
            chat[i].setText(arrayChat.get(i));
            if (arrayChat.size() == chat.length+1) arrayChat.remove(0);
        }
    }



}
