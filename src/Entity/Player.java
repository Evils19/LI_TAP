package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class Player  extends Entity{



    GamePanel gamePanel;
    KeyHandler keyHandler;

   private int Playerx=64;
    private int Playery=64;

    private int susIndex = 0;
    private int josIndex = 0;
    private int stangaIndex = 0;
    private int dreaptaIndex = 0;

    //Poziția pe ecran a jucătorului
    public final  int screenX;
    public final  int screenY;
    public  int NrChei=0;
    public  int TempNrChei=0;
    public Player(GamePanel gp, KeyHandler kh){
        gamePanel = gp;
        keyHandler = kh;
        screenX = gamePanel.screenWidth/2- gamePanel.titlesize/2;
        screenY = gamePanel.screenHeight/2- gamePanel.titlesize/2;
        coliziune= new Rectangle(16,16,25,25);
        SolidDefaultX=coliziune.x;
        SolidDefaultY=coliziune.y;
        setDefaultPosition();
        importImage();
    }
    private void  importImage(){
        InputStream is= getClass().getResourceAsStream("/Schin/player2.png");

        try {
            objectImage = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
    }
    }
    public  void setDefaultPosition(){
        Worldx = gamePanel.titlesize*23;
        Worldy =gamePanel.titlesize*21;
        speed=4;
    }


    public void update() {
        if (keyHandler.MiscareSus) {
          if (!collision)
            Worldy -= speed;
            direction = "sus";
            susIndex = (susIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru sus
        } else if (keyHandler.MiscareJos) {
            if (!collision)
            Worldy += speed;
            direction = "jos";
            josIndex = (josIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru jos
        } else if (keyHandler.MiscareStanga) {
            if (!collision)
            Worldx -= speed;
            direction = "stanga";
            stangaIndex = (stangaIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru stânga
        } else if (keyHandler.MiscareDreapta) {
            if (!collision)
            Worldx += speed;
            direction = "dreapta";
            dreaptaIndex = (dreaptaIndex + 1) % 3;
            // Schimbă imaginea la următoarea din setul pentru dreapta
        }
        else if (keyHandler.Hack){
            if (speed==4){
                speed=8;
                TempNrChei=NrChei;
                NrChei=999;


            }
            else {
                speed=4;
                NrChei=TempNrChei;
            }


        }


        collision =false;
        gamePanel.dc.ColiziuneBloc(this);
        //Coloziune obiecte
      int objIndex=  gamePanel.dc.ColoziuneObiect(this,true);
      ObjectInteraction(objIndex);
        //Daca conditia de coliziune este falsa atunci jucatorul se poate misca


        if (Worldx>=416 && Worldy<508 && Worldx <516){
            gamePanel.label.setText("Comoara pierduta iarasi a gasit lumina zilei");
            gamePanel.label.setForeground(Color.red);
        }
        else{
//        gamePanel.label.setText("Cordonate "+ Worldx +" "+ Worldy);


       gamePanel.label2.setForeground(Color.WHITE);



        }




    }




    public  void ObjectInteraction(int index){
        if (index!=999){


        }

    }
















public  void draw(Graphics2D g2d){

    jos[0]= objectImage.getSubimage(0*Playerx,0*Playery,Playerx,Playery);
    jos[1]= objectImage.getSubimage(1*Playerx,0*Playery,Playerx,Playery);
    jos[2]= objectImage.getSubimage(2*Playerx,0*Playery,Playerx,Playery);
    jos[3]= objectImage.getSubimage(3*Playerx,0*Playery,Playerx,Playery);
 stanga[0]= objectImage.getSubimage(0*Playerx,1*Playery,Playerx,Playery);
    stanga[1]= objectImage.getSubimage(1*Playerx,1*Playery,Playerx,Playery);
    stanga[2]= objectImage.getSubimage(2*Playerx,1*Playery,Playerx,Playery);
    stanga[3]= objectImage.getSubimage(3*Playerx,1*Playery,Playerx,Playery);
    dreapta[0]= objectImage.getSubimage(0*Playerx,2*Playery,Playerx,Playery);
    dreapta[1]= objectImage.getSubimage(1*Playerx,2*Playery,Playerx,Playery);
    dreapta[2]= objectImage.getSubimage(2*Playerx,2*Playery,Playerx,Playery);
    dreapta[3]= objectImage.getSubimage(3*Playerx,2*Playery,Playerx,Playery);
    sus[0]= objectImage.getSubimage(0*Playerx,3*Playery,Playerx,Playery);
    sus[1]= objectImage.getSubimage(1*Playerx,3*Playery,Playerx,Playery);
    sus[2]= objectImage.getSubimage(2*Playerx,3*Playery,Playerx,Playery);
    sus[3]= objectImage.getSubimage(3*Playerx,3*Playery,Playerx,Playery);



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



    g2d.drawImage(image.getSubimage(0,0,64,64),screenX, screenY,gamePanel.titlesize*3/2,gamePanel.titlesize*3/2,null);



}
}
