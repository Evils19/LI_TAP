package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class KeyHandler implements KeyListener {
public boolean MiscareSus, MiscareJos, MiscareStanga, MiscareDreapta,tostart;

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {//Apasa tasta
int code = keyEvent.getKeyCode();

if (code ==KeyEvent.VK_SPACE){
            tostart=true;
}
if (code ==KeyEvent.VK_W){
    MiscareSus = true;
    }
if (code ==KeyEvent.VK_S){
MiscareJos=true;
    }
if (code ==KeyEvent.VK_A){
    MiscareStanga=true;
    }
if (code ==KeyEvent.VK_D){
    MiscareDreapta=true;
    }}

    @Override
    public void keyReleased(KeyEvent keyEvent) {//Tasta eliberata
        int code = keyEvent.getKeyCode();
        if (code ==KeyEvent.VK_SPACE){
            tostart = false;
        }
        if (code ==KeyEvent.VK_W){
            MiscareSus = false;
        }
        if (code ==KeyEvent.VK_S){
            MiscareJos=false;
        }
        if (code ==KeyEvent.VK_A){
            MiscareStanga=false;
        }
        if (code ==KeyEvent.VK_D){
            MiscareDreapta=false;
        }

    }
}
