package main;

import Entity.Entity;
import Entity.Obiecte.ObiectHp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class UI {

    GamePanel gp;
    private  Graphics2D g2d;
    Font arial_40, arial_80B;
    BufferedImage HeartImage[]  = new BufferedImage[3];

    ArrayList<String> messages = new ArrayList<>();
    ArrayList<Integer> mesageCounter = new ArrayList<>();
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
    public int SlotCol=0;
    public int SlotRow=0;

    Color violet = new Color(94, 9, 9);

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

        Entity heart= new ObiectHp(gp);
        HeartImage[0]= heart.jos[0];
         HeartImage[1]= heart.jos[1];
         HeartImage[2]= heart.jos[2];


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
    drawNewMessage();
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
        if (gp.gameState==gp.CHARACTERIC_STATE){
            drawCharactericScreen();
            drawInvenroty();
            drawNewMessage();


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


    public void  drawCharactericScreen(){
    final int frameX=gp.titlesize*2;
    final int frameY=gp.titlesize*2;
    final int frameWidth=gp.titlesize*5;
    final int frameHeight=gp.titlesize*8;
    drawSubWindow(frameX,frameY,frameWidth,frameHeight);

    g2d.setColor(Color.WHITE);
    g2d.setFont(g2d.getFont().deriveFont(19F));

    int textX=frameX+20;
    int textY=frameY+gp.titlesize;
    final  int LineHeight=36;

    g2d.drawString("Nivel: "+gp.player.Lvl,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Hp: "+gp.player.Life+" / "+gp.player.MaxLife,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Protectie: "+gp.player.Defance+" / "+gp.player.MaxLife,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Forta: "+gp.player.Power,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Crit: "+gp.player.Krit,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Exp: "+gp.player.Exp,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Experienta + LVL: "+gp.player.NextLvlExp,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Aur: "+gp.player.Coin,textX,textY);
    textY+=LineHeight;
    g2d.drawString("Arma: ",textX,textY);
    g2d.drawImage(gp.player.CurentWeapon.jos[0],textX+100,textY-28,40,40,null);
    textY+=LineHeight;
    g2d.drawString("Scut: ",textX,textY);
    g2d.drawImage(gp.player.CurentShield.jos[0],textX+100,textY-28,40,40,null);
    textY+=LineHeight;


    //



    int TailX=(frameX-frameWidth-30);
    textY=frameY+gp.titlesize;
    String value;
    value=String.valueOf(gp.player.Lvl);
    textX=getXforAlingnToRight(value,TailX);
    g2d.drawString(value,textX,textY);

    }


    public  void addMesage(String text){
        messages.add(text);
        mesageCounter.add(0);
    }


    public int getXforAlingnToRight(String text,int Talix){
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        return Talix-length;

}




public void drawNewMessage(){
        int  mesageX=gp.titlesize;
        int mesageY=gp.titlesize*4;
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD,20.0f));


        for (int i =0;i<messages.size();i++){

          if (messages.get(i)!=null){
              g2d.setColor(Color.WHITE);
                g2d.drawString(messages.get(i),mesageX,mesageY);
                int counter = mesageCounter.get(i)+1;
                mesageCounter.set(i,counter);
                mesageY+=50;
                if (mesageCounter.get(i)>180){
                    messages.remove(i);
                    mesageCounter.remove(i);
                }


        }


}
}


    public  void  drawInvenroty(){
        int frameX=gp.titlesize*8;
        int frameY=gp.titlesize;
        int frameWidth=gp.titlesize*6;
        int frameHeight=gp.titlesize*5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        final int slotXStart=frameX+20;
        final int slotYStart=frameY+20;
        int slotX=slotXStart;
        int slotY=slotYStart;
        int slotSize=gp.titlesize+3;


        //Draw Object Ibentory
        for (int i=0;i<gp.player.Inventory.size();i++){


            if(gp.player.Inventory.get(i)==gp.player.CurentWeapon || gp.player.Inventory.get(i)==gp.player.CurentShield){
                g2d.setColor(new Color(245, 171, 10, 255));
                g2d.fillRoundRect(slotX,slotY,gp.titlesize,gp.titlesize,10,10);
            }
            g2d.drawImage(gp.player.Inventory.get(i).jos[0],slotX,slotY,gp.titlesize,gp.titlesize,null);

            slotX+=slotSize;

            if (i==4 || i==9 || i==14){
                slotX=slotXStart;
                slotY+=slotSize;
            }


        }



        int CursorX=slotXStart+(slotSize*SlotCol);
        int CursorY=slotYStart+(slotSize*SlotRow);
        int CursorWidth=gp.titlesize;
        int CursorHeight=gp.titlesize;

        g2d.setColor(Color.WHITE);
        g2d.drawRect(CursorX,CursorY,CursorWidth,CursorHeight);




        //Description Window
        int indexItem=getItemIndexOnSlot();

            int DframeX=frameX;
            int DframeY=frameY+frameHeight+10;
            int DframeWidth=frameWidth;
            int DframeHeight=gp.titlesize*2;



            if (indexItem<gp.player.Inventory.size())  drawSubWindow(DframeX, DframeY, DframeWidth, DframeHeight);

// Text Description
            g2d.setColor(Color.WHITE);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 19.0f));
            int textX = DframeX + 20;
            int textY = DframeY + gp.titlesize;


            if (indexItem < gp.player.Inventory.size()) {
                for(String line : gp.player.Inventory.get(indexItem).Description.split("\n")){
                    g2d.drawString(line,textX,textY);
                    textY+=gp.titlesize/2;
                }

            }


        }








    public int getItemIndexOnSlot() {
        return SlotRow * 5 + SlotCol;
    }




}













