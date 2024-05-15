package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;

public class NPC_Gargulia extends Entity {


    public NPC_Gargulia(GamePanel gp){
        super(gp);


        direction="dreapta";
        speed=2;

        importImage("player");
        GetPplayerImage();
        setDialog();

    }


    public  void setDialog(){
        dialog[0]="";
        dialog[1]="Bine venit  pe insula Insula regilor uitați";
        dialog[2]="La prima vedere aici totul pare normal\ndar daca o sa cauti comoara insulei vei fi oprit";
        dialog[3]="Succes sper sa te mai vad";
    }
    public  void GetPplayerImage(){



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

    }


    @Override
    public void SetAcion() {
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

    public  void speak(){

        if (dialog[indexDialog]==null){
            indexDialog=0;
            gp.gameState=gp.PLAY_STATE;
            return;
        }
        gp.ui.Dialog=dialog[indexDialog];
        indexDialog++;

    super.speak();

    }


    public void draw(Graphics2D g2d){
        super.draw(g2d);

        //Calculam coordonatele obiectului pe ecran
        int screenX = Worldx - gp.player.Worldx + gp.player.screenX;
        int screenY = Worldy - gp.player.Worldy + gp.player.screenY;


        //Daca obiectul este in raza vizuala a jucatorului, il desenam
        if (Worldx+gp.titlesize>gp.player.Worldx - gp.player.screenX &&
                Worldx<gp.player.Worldx + gp.player.screenX + gp.screenWidth &&
                Worldy+gp.titlesize>gp.player.Worldy - gp.player.screenY &&
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight){



            BufferedImage image = null;
//
//            switch (direction) {
//                case "sus":
//
//                    image = sus[IndexS];
//                    if (gp.gameState!= gp.MENU_STATE) {
//                        IndexS = (IndexS + 1) % 3;// Selectează imaginea corespunzătoare din setul pentru sus
//                    }
//                    break;
//                case "jos":
//
//                    image = jos[IndexJ];// Selectează imaginea corespunzătoare din setul pentru jos
//                    if (gp.gameState!= gp.MENU_STATE)   IndexJ=(IndexJ+1)%3;
//                    break;
//                case "stanga":
//
//                    image = stanga[IndexST]; // Selectează imaginea corespunzătoare din setul pentru stânga
//                    if (gp.gameState!= gp.MENU_STATE)   IndexST=(IndexST+1)%3;
//                    break;
//                case "dreapta":
//
//                    image = dreapta[IndexD]; // Selectează imaginea corespunzătoare din setul pentru dreapta
//                    if (gp.gameState!= gp.MENU_STATE)     IndexD=(IndexD+1)%3;
//                    break;
//            }


            objectImage=image;


            g2d.drawImage(image, screenX, screenY, gp.titlesize*3/2, gp.titlesize*3/2, null);





        }

    }




}
