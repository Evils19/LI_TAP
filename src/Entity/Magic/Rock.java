package Entity.Magic;

import Entity.Projectile;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends Projectile {
    public Rock(GamePanel gp) {
        super(gp);
        this.gp=gp;
        nameObject = "Rock";
        speed = 8;
        MaxLife = 80;
        Life = MaxLife;
        Power = 2;
        useCost = 2;
        Alivie = false;



        sus[0]=Fire("rock_down_1");
        sus[1]=sus[0];
        sus[2]=sus[0];
        sus[3]=sus[1];

        jos[0]=sus[0];
        jos[1]=sus[0];
        jos[2]=jos[0];
        jos[3]=jos[1];

        stanga[0]=sus[0];
        stanga[1]=sus[0];
        stanga[2]=stanga[0];
        stanga[3]=stanga[1];

        dreapta[0]=sus[0];;
        dreapta[1]=sus[0];
        dreapta[2]=dreapta[0];
        dreapta[3]=dreapta[1];

    }
    public void draw(Graphics2D g2d){
        //Calculam coordonatele obiectului pe ecran
        int screenX = Worldx - gp.player.Worldx + gp.player.screenX;
        int screenY = Worldy - gp.player.Worldy + gp.player.screenY;
        //Daca obiectul este in raza vizuala a jucatorului, il desenam
        if (Worldx+gp.titlesize>gp.player.Worldx - gp.player.screenX &&
                Worldx<gp.player.Worldx + gp.player.screenX + gp.screenWidth &&
                Worldy+gp.titlesize>gp.player.Worldy - gp.player.screenY &&
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight)
        {
            BufferedImage image = null;
            switch (direction) {
                case "sus":
                    if (sprintnum2==0) {
                        image = sus[0];}
                    else if (sprintnum2==1){
                        image = sus[1];}
                    else if (sprintnum2==2){
                        image = sus[2];}
                    break;
                case "jos":
                    if (sprintnum2==0) {
                        image = jos[0];}
                    else if (sprintnum2==1){
                        image = jos[1];}
                    else if (sprintnum2==2){
                        image = jos[2];}
                    break;
                case "stanga":

                    if (sprintnum2==0) {
                        image = stanga[0];}
                    else if (sprintnum2==1){
                        image = stanga[1];}
                    else if (sprintnum2==2){
                        image = stanga[2];}
                    break;
                case "dreapta":
                    if (sprintnum2==0) {
                        image = dreapta[0];}
                    else if (sprintnum2==1){
                        image = dreapta[1];}
                    else if (sprintnum2==2){
                        image = dreapta[2];}
                    break;
            }
            objectImage=image;




            g2d.drawImage(image, screenX, screenY, gp.titlesize, gp.titlesize, null);

        }
    }



}
