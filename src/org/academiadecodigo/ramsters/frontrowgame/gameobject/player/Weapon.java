package org.academiadecodigo.ramsters.frontrowgame.gameobject.player;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.ramsters.frontrowgame.gameobject.enemies.NPC;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Weapon {

    private Picture sword;
    private Position swordPos;
    private int damage = 100;

    public void attack(Direction a, Position pos) {

        switch (a) {
            case RIGHT:
                try {
                    sword = new Picture(pos.getX() + 34, pos.getY(), "resources/images/weapon_right.png");
                    sword.draw();
                    Thread.sleep(100);
                    sword.delete();
                    //sword = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case UP:
                try {
                    sword = new Picture(pos.getX(), pos.getY() - 34, "resources/images/weapon_right.png");
                    sword.draw();
                    Thread.sleep(100);
                    sword.delete();
                    //sword = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case DOWN:
                try {
                    sword = new Picture(pos.getX(), pos.getY() + 34, "resources/images/weapon_left_down.png");
                    sword.draw();
                    Thread.sleep(100);
                    sword.delete();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case LEFT:
                try {
                    sword = new Picture(pos.getX() - 34, pos.getY(), "resources/images/weapon_left.png");
                    sword.draw();
                    Thread.sleep(100);
                    sword.delete();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        swordPos = new Position(sword.getX(), sword.getY(), sword.getWidth(), sword.getHeight());
        attackDamage();
    }


    public void attackDamage() {
        LinkedList<NPC> Npcs = NPC.getNpcs();

        for (int i = 0; i< Npcs.size(); i++){
            if(!(Npcs.get(i) instanceof Player)){
                    if(Position.inter(swordPos, Npcs.get(i).getPos()))
                        Npcs.get(i).takeDamage(damage);
                    }
                }
            }
        }






