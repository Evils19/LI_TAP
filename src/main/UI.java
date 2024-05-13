package main;

import Obiecte.ObiectHp;
import Obiecte.ObiectKey;
import Obiecte.SuperObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UI {

    GamePanel gp;
    private  Graphics2D g2d;
    Font arial_40, arial_80B;
    BufferedImage HeartImage[]  = new BufferedImage[3];
//    BufferedImage keyImage;
    public  boolean messageOn = false;
    public  String message = "";
    int messageTime = 0;
    double playTime;
    public String Dialog;
    public  final  int TitleState=0;
    BufferedImage bgImage;
    BufferedImage objectImage;
    private  Font customFont;
    public  int ComandNumber=0;
    Color violet = new Color(49, 8, 117);

    URL url;
    ImageIcon icon;
    JLabel gifLabel;
    public  boolean GameOver = false;
private Color colorMessage=Color.WHITE;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 20);
        arial_80B = new Font("Arial", Font.BOLD, 80);
//        ObiectKey key = new ObiectKey();
//        keyImage = key.objectImage;


        try {
           url = new URL("file:src/Schin/YPQc9ad.gif");
            icon = new ImageIcon(url);
            gifLabel = new JLabel(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bgImage = ImageIO.read(new File("src/Schin/Title.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        importImage();

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Resurce/Minecraft.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        SuperObject heart= new ObiectHp();
        HeartImage[0]= heart.objectImage;
        HeartImage[1]= heart.objectImage2;
        HeartImage[2]= heart.objectImage3;


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
    if (gp.gameState==TitleState){
drawTitle();
    }


    if (gp.gameState==gp.MENU_STATE){

        drawMenu();
    }
    if (gp.gameState==gp.PLAY_STATE){
    GameTime();
    drawHpPlayer();
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
            drawHpPlayer();
            drawDialog();
        }


    }
  public  void  drawHpPlayer(){
int x=gp.titlesize/2;
int y=gp.titlesize/2;
int i=0;
while (i<gp.player.MaxLife/2){
    g2d.drawImage(HeartImage[2],x,y,gp.titlesize/2,gp.titlesize/2,null);
    x+=gp.titlesize/2;
    i++;

}
x=gp.titlesize/2;
y=gp.titlesize/2;
i=0;

while (i<gp.player.Life){
    g2d.drawImage(HeartImage[1],x,y,gp.titlesize/2,gp.titlesize/2,null);
    i++;
    if (i<gp.player.Life){
        g2d.drawImage(HeartImage[0],x,y,gp.titlesize/2,gp.titlesize/2,null);
    }
    i++;
    x+=gp.titlesize/2;

}


    }

public  void  drawTitle(){
    g2d.setFont(customFont.deriveFont(Font.BOLD,70.0f));


    String text = "Insula Regilor Uitati";
    int x = gp.screenWidth/2 - (int)g2d.getFontMetrics().getStringBounds(text,g2d).getWidth()/2;
    int y = gp.titlesize*3;
    //Punem fundal ca imagine
  //  g2d.drawImage(bgImage, 0, 0, null);img
    Image image = icon.getImage();
    g2d.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);

//    g2d.drawImage(bgImage,0,0,gp.screenWidth,gp.screenHeight,null);

BufferedImage temp;
    g2d.setColor(Color.BLACK);
    g2d.drawString(text,x+5,y+5);
    g2d.setColor(Color.WHITE);
    g2d.drawString(text,x,y);
    temp= objectImage.getSubimage(0,0,64,64);
    g2d.drawImage(temp.getSubimage(0,0,64,64),gp.screenWidth/2-32,gp.screenHeight/2-100, gp.titlesize*3, gp.titlesize*3,null);

    g2d.setFont(customFont.deriveFont(Font.PLAIN,50.0f));
    //Joc nou
    text = "Joc Nou";
    x = getXForCenter2(text);
    y = gp.screenHeight/2+gp.titlesize*3;
    g2d.setColor(Color.BLACK);
    g2d.drawString(text,x+5,y+5);
    g2d.setColor(Color.WHITE);
    g2d.drawString(text,x,y);
    if (ComandNumber==0){
        g2d.setColor(violet);
       g2d.drawString(">",x-gp.titlesize,y);
    }

    text = "Incarca Joaca";
    x = getXForCenter2(text);
    y+=gp.titlesize;
    g2d.setColor(Color.BLACK);
    g2d.drawString(text,x+5,y+5);
    g2d.setColor(Color.WHITE);
    g2d.drawString(text,x,y);
    if (ComandNumber==1){
        g2d.setColor(violet);
        g2d.drawString(">",x-gp.titlesize,y);
    }

    text = "Iesire";
    x = getXForCenter2(text);
    y+=gp.titlesize;
    g2d.setColor(Color.BLACK);
    g2d.drawString(text,x+5,y+5);
    g2d.setColor(Color.WHITE);
    g2d.drawString(text,x,y);
    if (ComandNumber==2){
        g2d.setColor(violet);
        g2d.drawString(">",x-gp.titlesize,y);
    }


}

    private void  importImage(){
        InputStream is= getClass().getResourceAsStream("/Schin/player2.png");

        try {
            objectImage = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
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

    for(String line : Dialog.split("\n")){
        g2d.drawString(line,x,y);
        y+=gp.titlesize;

    }



}

public  void  drawSubWindow(int x,int y,int width,int height) {
        Color color = new Color(0, 0, 0, 200);
    g2d.setColor(color);
    g2d.fillRoundRect(x, y, width, height,35,35);
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
    public  int getXForCenter2(String text){
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        return gp.screenWidth/2-length/2;
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
