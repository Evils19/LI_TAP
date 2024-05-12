package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
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
        dialog[0]="Salut, sunt Gargulia";

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
        gp.ui.Dialog=dialog[0];
    }
}
