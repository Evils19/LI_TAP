package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class KeyHandler implements KeyListener, MouseListener {
public boolean MiscareSus, MiscareJos, MiscareStanga, MiscareDreapta,Hack,isXPressed, isEPressed, isEnter,IsAtack;

    public boolean MiscareMouseStanga = false;
GamePanel gp;

public KeyHandler(GamePanel gp){
    this.gp = gp;
}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {//Apasa tasta
int code = keyEvent.getKeyCode();

//State Title
        if(gp.gameState==gp.ui.TitleState){


            if (code ==KeyEvent.VK_W){
              gp.ui.ComandNumber--;
                gp.playSE(1);
              if (gp.ui.ComandNumber<0){
                  gp.ui.ComandNumber=2;

              }
            }
            if (code ==KeyEvent.VK_S){
                gp.ui.ComandNumber++;
                gp.playSE(1);
                if (gp.ui.ComandNumber>2){
                    gp.ui.ComandNumber=0;

                }

            }
            if (code == KeyEvent.VK_ENTER){

                if (gp.ui.ComandNumber==0){
                    gp.gameState=gp.PLAY_STATE;
                    gp.StopSound();
                    gp.PlaySound(0);
                }
                if (gp.ui.ComandNumber==1){

                }
                if (gp.ui.ComandNumber==2){
                    System.exit(0);
                }
            }
        }
  if (code ==KeyEvent.VK_P) {
      IsAtack = true;
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
    }
    if (code == KeyEvent.VK_ENTER) {
        isEnter = true;
    }
    if (code == KeyEvent.VK_Q) {
        gp.gameState=gp.ui.TitleState;
        gp.StopSound();
        gp.PlaySound(7);

    }
    if (code == KeyEvent.VK_X) {
        isXPressed = true;
    } else if (code == KeyEvent.VK_E) {
        isEPressed = true;
    }


    if (isXPressed && isEPressed) {
        // Ambele taste sunt apăsate simultan
        Hack = true;
    }

    if (code == KeyEvent.VK_ESCAPE) {
        if (gp.gameState == gp.PLAY_STATE){
            gp.gameState = gp.MENU_STATE;
        }
        else if (gp.gameState == gp.MENU_STATE){
            gp.gameState = gp.PLAY_STATE;
        }

    }



//Daca este in dialog si apasam enter
        if (gp.gameState == gp.Dialog_STATE){
            if (code==KeyEvent.VK_ENTER){
                gp.gameState = gp.PLAY_STATE;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {//Tasta eliberata
        int code = keyEvent.getKeyCode();

        if (code ==KeyEvent.VK_P) {
            IsAtack = false;
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
        if (code == KeyEvent.VK_X) {
            isXPressed = false;
        } else if (code == KeyEvent.VK_E) {
            isEPressed = false;
        }
        if (!isXPressed && !isEPressed) {
            // Niciuna dintre taste nu este apăsată
            Hack = false;
        }

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) { // BUTTON1 reprezintă butonul stâng al mouse-ului
            MiscareMouseStanga = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            MiscareMouseStanga = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
