package org.academiadecodigo.ramsters.frontrowgame.gameobject;

public enum NPCtype {
    PAULO(100, 5),
    BENNY(3000, 50),
    SID(1000, 10),
    NUNO(200, 30),
    JORGE(1000, 200),
    PLAYER(500, 50);


    private int life;
    private int strength;

    NPCtype(int life, int strength) {
        this.life = life;
        this.strength = strength;
    }

    public int getLife(){
        return life;
    }

    public int getStrength(){
        return strength;
    }
}
