package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;

public class NPC_Magician extends Entity{

private BufferedImage Sus1;
private BufferedImage Sus2;
private BufferedImage Jos1;
private BufferedImage Jos2;
private BufferedImage Stanga1;
private BufferedImage Stanga2;
private BufferedImage Dreapta1;
private BufferedImage Dreapta2;
    public NPC_Magician(GamePanel gp) {
        super(gp);
        direction = "jos";
        speed = 1;
        getPlayerImage();
        setDialog();


    }

    public  void setDialog(){
        dialog[0]="Fara puteri magice nu vei putea trece de aici";

    }

    public void getPlayerImage(){
        Sus1 = Setup("oldman_up_1");
        Sus2 = Setup("oldman_up_2");
        Jos1 = Setup("oldman_down_1");
        Jos2 = Setup("oldman_down_2");
        Stanga1 = Setup("oldman_left_1");
        Stanga2 = Setup("oldman_left_2");
        Dreapta1 = Setup("oldman_right_1");
        Dreapta2 = Setup("oldman_right_2");


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


    @Override
    public void update() {
        super.update();






    }

    public  void draw(Graphics2D g2d){

        int screenX = Worldx - gp.player.Worldx + gp.player.screenX;//Calculam coordonatele obiectului pe ecran
        int screenY = Worldy - gp.player.Worldy + gp.player.screenY;//Calculam coordonatele obiectului pe ecran

        if (Worldx+gp.titlesize>gp.player.Worldx - gp.player.screenX &&
                Worldx<gp.player.Worldx + gp.player.screenX + gp.screenWidth &&
                Worldy+gp.titlesize>gp.player.Worldy - gp.player.screenY &&
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight){



            BufferedImage image = null;

    switch (direction) {
        case "sus":
            if (sprintnum == 0) {
                image = Sus1;
                sprintnum = 1;
            } else {
                image = Sus2;
                sprintnum = 0;
            }
            break;
        case "jos":

            if (sprintnum == 0) {
                image = Jos1;
                sprintnum = 1;
            } else {
                image = Jos2;
                sprintnum = 0;
            }
            break;
        case "stanga":

            if (sprintnum == 0) {
                image = Stanga1;
                sprintnum = 1;
            } else {
                image = Stanga2;
                sprintnum = 0;
            }
            break;
        case "dreapta":

            if (sprintnum == 0) {
                image = Dreapta1;
                sprintnum = 1;
            } else {
                image = Dreapta2;
                sprintnum = 0;
            }
            break;
    }


    objectImage = image;



            g2d.drawImage(image, screenX, screenY, gp.titlesize, gp.titlesize, null);

    }
    }

    }










