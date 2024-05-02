package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Player  extends Entity{


    GamePanel gamePanel;
    KeyHandler keyHandler;
    String direction="sus";

    private int susIndex = 0;
    private int josIndex = 0;
    private int stangaIndex = 0;
    private int dreaptaIndex = 0;

    public Player(GamePanel gp, KeyHandler kh){
        gamePanel = gp;
        keyHandler = kh;
        setDefaultPosition();
        importImage();
    }
    private void  importImage(){
        InputStream is= getClass().getResourceAsStream("/Schin/player.png");

        try {
            objectImage = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
    }
    }
    public  void setDefaultPosition(){
        x=100;
        y=100;
        speed=4;
    }


    public void update() {
        if (keyHandler.MiscareSus) {
            y -= speed;
            direction = "sus";
            susIndex = (susIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru sus
        } else if (keyHandler.MiscareJos) {
            y += speed;
            direction = "jos";
            josIndex = (josIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru jos
        } else if (keyHandler.MiscareStanga) {
            x -= speed;
            direction = "stanga";
            stangaIndex = (stangaIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru stânga
        } else if (keyHandler.MiscareDreapta) {
            x += speed;
            direction = "dreapta";
            dreaptaIndex = (dreaptaIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru dreapta
        }


        if (y<-56 && x<116 && x>20 ){
            x=100;
            y=100;
        }


        gamePanel.label.setText("Cordonate "+x+" "+y);
       gamePanel.label.setForeground(Color.WHITE);


        if (x>gamePanel.screenWidth){
            x=0;
        }
        if (y>gamePanel.screenHeight){
            y=0;
        }
        if (x<-72){
            x=gamePanel.screenWidth;
        }
        if (y<-72){
            y=gamePanel.screenHeight;
        }



    }

public  void draw(Graphics2D g2d){

    jos[0]= objectImage.getSubimage(0*180,0*180,180,180);
    jos[1]= objectImage.getSubimage(1*180,0*180,180,180);
    jos[2]= objectImage.getSubimage(2*180,0*180,180,180);
    stanga[0]= objectImage.getSubimage(0*180,1*180,180,180);
    stanga[1]= objectImage.getSubimage(1*180,1*180,180,180);
    stanga[2]= objectImage.getSubimage(2*180,1*180,180,180);
    dreapta[0]= objectImage.getSubimage(0*180,2*180,180,180);
    dreapta[1]= objectImage.getSubimage(1*180,2*180,180,180);
    dreapta[2]= objectImage.getSubimage(2*180,2*180,180,180);
    sus[0]= objectImage.getSubimage(0*180,3*180,180,180);
    sus[1]= objectImage.getSubimage(1*180,3*180,180,180);
    sus[2]= objectImage.getSubimage(2*180,3*180,180,180);

    BufferedImage image = null;

    switch (direction) {
        case "sus":
            image = sus[susIndex]; // Selectează imaginea corespunzătoare din setul pentru sus
            break;
        case "jos":
            image = jos[josIndex]; // Selectează imaginea corespunzătoare din setul pentru jos
            break;
        case "stanga":
            image = stanga[stangaIndex]; // Selectează imaginea corespunzătoare din setul pentru stânga
            break;
        case "dreapta":
            image = dreapta[dreaptaIndex]; // Selectează imaginea corespunzătoare din setul pentru dreapta
            break;
    }



    g2d.drawImage(image.getSubimage(0,0,180,180),x,y,gamePanel.titlesize*3/2,gamePanel.titlesize*3/2,null);



}
}
