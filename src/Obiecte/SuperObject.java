package Obiecte;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {


    public BufferedImage objectImage;
    public String name;
    public boolean collision = false;
    public int Worldx, Worldy;

    public  Rectangle SolidObject= new Rectangle(0,0,48,48);
    public  int SolidDefaultX=0, SolidDefaultY=0;



    public  void draw(Graphics2D g2d, GamePanel gp){

        //Calculam coordonatele obiectului pe ecran
        int screenX = Worldx - gp.player.Worldx + gp.player.screenX;
        int screenY = Worldy - gp.player.Worldy + gp.player.screenY;


        //Daca obiectul este in raza vizuala a jucatorului, il desenam
        if (Worldx+gp.titlesize>gp.player.Worldx - gp.player.screenX &&
                Worldx<gp.player.Worldx + gp.player.screenX + gp.screenWidth &&
                Worldy+gp.titlesize>gp.player.Worldy - gp.player.screenY &&
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight){
            g2d.drawImage(objectImage, screenX, screenY, gp.titlesize, gp.titlesize, null);
        }


    }


}
