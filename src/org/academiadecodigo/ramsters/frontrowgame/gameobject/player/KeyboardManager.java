package org.academiadecodigo.ramsters.frontrowgame.gameobject.player;

import org.academiadecodigo.ramsters.frontrowgame.gameobject.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager implements KeyboardHandler {


    private boolean moving;
    private KeyboardEvent event;
    private int key;
    private Keyboard keyboard;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent left;
    private KeyboardEvent right;
    private KeyboardEvent attack;
    private KeyboardEvent restart;
    private KeyboardEvent quit;


    public KeyboardManager() {
        keyboard = new Keyboard(this);
        up = new KeyboardEvent();
        down = new KeyboardEvent();
        left = new KeyboardEvent();
        right = new KeyboardEvent();
        attack = new KeyboardEvent();
        restart = new KeyboardEvent();
        quit = new KeyboardEvent();

        keyboardEvents();
    }


    public void keyboardEvents() {
        attack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


/*        KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upRelease.setKey(KeyboardEvent.KEY_UP);*/

        attack.setKey(KeyboardEvent.KEY_SPACE);
        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        restart.setKey(KeyboardEvent.KEY_R);
        quit.setKey(KeyboardEvent.KEY_Q);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(attack);
        keyboard.addEventListener(restart);
        keyboard.addEventListener(quit);
    }


    public boolean isMoving() {
        return moving;
    }

    public void stopMoving() {
        moving = false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public KeyboardEvent getEvent() {
        return event;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        moving = true;
        key = event.getKey();
        this.event = event;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
       // moving = true;
       // key  = keyboardEvent.getKey();
       // this.event = keyboardEvent;
    }
}



