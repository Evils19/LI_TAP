package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class NPC_Elf extends Entity {

    int indexDialog=0;
    public NPC_Elf(GamePanel gp){
        super(gp);


        direction="dreapta";
        speed=2;
        Playerx=64;
        Playery=64;
        coliziune= new Rectangle(10,10,25,40);

        importImage("elf");
        GetPplayerImage();
        setDialog();

    }


    public  void setDialog(){
        dialog[0]="Nu te cunosc esti nou aici?";
        dialog[1]="Sincer imi pare rau sa mai vad oameni noi\npe aici multi ca tine au venit dar toti far urma au disparut";

    }
    public  void GetPplayerImage(){



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

    }


    @Override
    public void SetAcion() {
        actionLockCounter++;

        if (actionLockCounter>160){

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


    public void update() {
        super.update();

        sprinterCoutner2++;
        if (sprinterCoutner2>10){

            if (sprintnum2==0){
                sprintnum2=1;
            }
            else if (sprintnum2==1){
                sprintnum2=2;
            }
            else if (sprintnum2==2){
                sprintnum2=0;
            }
            sprinterCoutner2=0;
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
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight){



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


            g2d.drawImage(image, screenX, screenY, gp.titlesize*3/2, gp.titlesize*3/2, null);





        }
    }



}
