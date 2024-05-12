package main;

import Obiecte.ObiectKey;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    private  Graphics2D g2d;
    Font arial_40, arial_80B;
//    BufferedImage keyImage;
    public  boolean messageOn = false;
    public  String message = "";
    int messageTime = 0;
    double playTime;
    public String Dialog;


    public  boolean GameOver = false;
private Color colorMessage=Color.WHITE;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
        arial_80B = new Font("Arial", Font.BOLD, 80);
//        ObiectKey key = new ObiectKey();
//        keyImage = key.objectImage;
    }



    public  void  ShowMessage(String message,Color color){


        messageOn = true;
        this.message = message;
        colorMessage = color;


    }


    public void draw(Graphics2D gp2){
    this.g2d=gp2;
    g2d.setFont(arial_40);
    g2d.setColor(Color.WHITE);
    if (gp.gameState==gp.MENU_STATE){

        drawMenu();
    }
    if (gp.gameState==gp.PLAY_STATE){
    GameTime();
        if (messageOn) {

            g2d.setColor(colorMessage);
            g2d.setFont(g2d.getFont().deriveFont(20.0f));
            g2d.drawString(message, 50, 80);

            messageTime++;
            if (messageTime > 100) {
                messageOn = false;
                messageTime = 0;

            }
        }
    }
        if (gp.gameState==gp.Dialog_STATE){
            drawDialog();
        }


    }


public void drawDialog(){
        //Fereastra de dialog
    int x=gp.titlesize*2;
    int y=gp.titlesize*1;
    int width=gp.screenWidth-gp.titlesize*4;
    int height=gp.titlesize*4;

    drawSubWindow(x,y,width,height);

    x+=gp.titlesize;
    y+=gp.titlesize;
    g2d.drawString(Dialog,x,y);

}

public  void  drawSubWindow(int x,int y,int width,int height) {
        Color color = new Color(0, 0, 0, 200);
    g2d.setColor(color);
    g2d.fillRoundRect(x, y, width, height, 35, 35);
    color = new Color(255, 255, 255, 255);
    g2d.setColor(color);
    g2d.setStroke(new BasicStroke(5));
    g2d.drawRoundRect(x, y, width, height, 25, 25);

    }


    public void GameTime(){
        playTime+=(double)1/60;
        g2d.drawString("Timp: "+(int)playTime, gp.titlesize*14, 65);


    }

    public  void  drawMenu(){
        String text = "PAUSED";
        int x=getXForCenter(text);
        int y=gp.screenHeight/2;


        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN,80.0f));
        g2d.setColor(Color.white);
        g2d.drawString(text, x,y);
    }


    public  int getXForCenter(String text){
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        return gp.screenWidth/2-length-gp.titlesize*3/2;
    }


}














    //Versiunea veche in cautarea de comoara
//    public  void draw(Graphics2D g2d) {
//
//        if (GameOver) {
//            g2d.setFont(arial_40);
//            g2d.setColor(Color.WHITE);
//            String text = "Game Over";
//            int textLength = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
//            int x = gp.screenWidth / 2 - textLength / 2;
//            int y = gp.screenHeight / 2- gp.titlesize*3;
//
//            g2d.drawString(text, x, y);
//
//            g2d.setFont(arial_80B);
//            g2d.setColor(Color.GREEN);
//            text="Felicitari!";
//            textLength = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
//            x = gp.screenWidth / 2 - textLength / 2;
//            y = gp.screenHeight / 2;
//            g2d.drawString(text, x, y);
//
//
//            g2d.setFont(new Font("Arial", Font.PLAIN, 40));
//            g2d.setColor(Color.WHITE);
//            text="Timpul de trecere: "+String.format("%.2f", playTime);
//            x = gp.screenWidth / 2 - textLength / 2;
//            y = gp.screenHeight / 2;
//            g2d.drawString(text, x, y+gp.titlesize*4);
//            gp.StopSound();
//            gp.gamethread=null;
//
//
//        } else {
//
//
//            g2d.setFont(arial_40);
//            g2d.setColor(Color.WHITE);
////            g2d.drawImage(keyImage, gp.titlesize / 2, 20, gp.titlesize / 2, gp.titlesize / 2, null);
////            g2d.drawString("x " + gp.player.NrChei, 50, 40);
//
//            playTime+=(double)1/60;
//            g2d.drawString("Timp: "+(int)playTime, gp.titlesize*14, 65);
//            if (messageOn) {
//
//                g2d.setColor(colorMessage);
//                g2d.setFont(g2d.getFont().deriveFont(20.0f));
//                g2d.drawString(message, 50, 80);
//
//                messageTime++;
//                if (messageTime > 100) {
//                    messageOn = false;
//                    messageTime = 0;
//
//                }
//            }
//        }
//    }
//
//}
