package Entity.Monster;

import Entity.Entity;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Moster_Slime extends Entity {


    public Moster_Slime(GamePanel gp) {
        super(gp);
        nameObject = "Green Slime";
        type=3;
        speed = 1;
        MaxLife = 4;
        Life = MaxLife;
        Defance=4;
        coliziune.x = 3;
        coliziune.y = 18;
        coliziune.width = 42;
        coliziune.height = 30;
        SolidDefaultX =coliziune.x;
        SolidDefaultY =coliziune.y;
        Exp=5;
        direction = "dreapta";
            getImage();
    }
    @Override
    public void update() {
        super.update();
        setAction();




    }

    public void getImage(){

       sus[0]=SetupMonster("greemslime_down1");
       sus[1]=SetupMonster("greemslime_down2");
       sus[2]=SetupMonster("greemslime_down1");
       sus[3]=SetupMonster("greemslime_down2");

       jos[0]=SetupMonster("greemslime_down1");
       jos[1]=SetupMonster("greemslime_down2");
       jos[2]=SetupMonster("greemslime_down1");
       jos[3]=SetupMonster("greemslime_down2");

       stanga[0]=SetupMonster("greemslime_down1");
       stanga[1]=SetupMonster("greemslime_down2");
       stanga[2]=SetupMonster("greemslime_down1");
       stanga[3]=SetupMonster("greemslime_down2");

         dreapta[0]=SetupMonster("greemslime_down1");
         dreapta[1]=SetupMonster("greemslime_down2");
         dreapta[2]=SetupMonster("greemslime_down1");
         dreapta[3]=SetupMonster("greemslime_down2");

    }
    public  void  setAction(){


            actionLockCounter++;
            if (actionLockCounter>120){

                Random rand = new Random();
                int direction = rand.nextInt(102);
                if (direction<25){
                    this.direction="sus";
                }
                if (direction>25 && direction<50){
                    this.direction="jos";
                }
                if (direction>50 && direction<=75){
                    this.direction="stanga";
                }
                if (direction>75 && direction<=100){
                    this.direction="dreapta";
                }
                actionLockCounter=0;
        }

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
            if (gp.gameState!= gp.MENU_STATE && HpBar) {
                double onscale=(double)gp.titlesize/(double)MaxLife;
                double HpBarValue = Life*onscale;

                g2d.setColor(new Color(35, 35, 35));
                g2d.fillRect(screenX-1, screenY - 16, gp.titlesize+2, 12);
                g2d.setColor(new Color(185, 1, 23));
                g2d.fillRect(screenX, screenY - 15, (int)HpBarValue, 10);


                HpBarCounter++;
                if (HpBarCounter>500){
                    HpBar=false;
                    MaxLife*=3;
                    Life=MaxLife;
                    HpBarCounter=0;
                }

            }


            if (Invisible){
                HpBar=true;
                HpBarCounter=0;

                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                }
            if (Dying){
                DyingAnimation(g2d);
            }




            g2d.drawImage(image, screenX, screenY, gp.titlesize, gp.titlesize, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        }
    }
}
