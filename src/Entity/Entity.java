package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Entity {
//Obiecte
public BufferedImage objectImage,objectImage2,objectImage3;
    public String nameObject;



    //NPC+Player
   protected GamePanel gp;
   public  int IndexS=0;
   public  int IndexJ=0;
   public  int IndexD=0;
   public  int IndexST=0;
    public  int Worldx, Worldy;
    public  int speed;
    String dialog[]=new String[20];
    public  int MaxLife;
    public  int Life;
    protected int indexDialog=0;
  protected   int sprintnum=0;
   protected int sprinterCoutner=0;
   protected   int sprintnum2=0;
   protected int sprinterCoutner2=0;




    public BufferedImage [] sus = new BufferedImage[4];
    public BufferedImage [] jos = new BufferedImage[4];
    public BufferedImage [] stanga = new BufferedImage[4];
    public BufferedImage [] dreapta = new BufferedImage[4];
    public Rectangle coliziune= new Rectangle(10,18,25,25);
    public String direction="jos";
    public  boolean collision = false;
    public  boolean ObjCollision = false;
    public  int actionLockCounter=0;
public int  Playerx=48,Playery=48;
    public int  SolidDefaultX, SolidDefaultY;



    public Entity(GamePanel gp){
        this.gp = gp;


    }

    protected void  importImage(String path){
        InputStream is= getClass().getResourceAsStream("/Schin/"+path+".png");

        try {
            objectImage = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
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

                    image = sus[IndexS];
                    if (gp.gameState!= gp.MENU_STATE) {
                        IndexS = (IndexS + 1) % 3;// Selectează imaginea corespunzătoare din setul pentru sus
                    }
                        break;
                case "jos":

                    image = jos[IndexJ];// Selectează imaginea corespunzătoare din setul pentru jos
                    if (gp.gameState!= gp.MENU_STATE)   IndexJ=(IndexJ+1)%3;
                    break;
                case "stanga":

                    image = stanga[IndexST]; // Selectează imaginea corespunzătoare din setul pentru stânga
                    if (gp.gameState!= gp.MENU_STATE)   IndexST=(IndexST+1)%3;
                    break;
                case "dreapta":

                    image = dreapta[IndexD]; // Selectează imaginea corespunzătoare din setul pentru dreapta
                    if (gp.gameState!= gp.MENU_STATE)     IndexD=(IndexD+1)%3;
                    break;
            }


objectImage=image;


            g2d.drawImage(image, screenX, screenY, gp.titlesize*3/2, gp.titlesize*3/2, null);





    }
    }


    public void SetAcion() {}
    public  void speak(){
        switch (gp.player.direction){
            case "sus":
                direction="jos";
                break;
            case "jos":
                direction="sus";
                break;
            case "stanga":
                direction="dreapta";
                break;
            case "dreapta":
                direction="stanga";
                break;
        }
    }

    public void update(){
        SetAcion();
    collision=false;
    StopColiziune();
        sprinterCoutner++;
        if (sprinterCoutner>10){
            if (sprintnum==0) {
                sprintnum=1;
            }
            else if (sprintnum==1){
                sprintnum=0;
            }
            sprinterCoutner=0;
        }





        sprinterCoutner2++;




    }


    public  void StopColiziune(){
        gp.dc.ColiziuneBloc(this);
        gp.dc.ColiziunePlayer(this);

    if (!collision){

        switch (direction){
            case "sus":
                Worldy-=speed;
                break;
            case "jos":
                Worldy+=speed;
                break;
            case "stanga":
                Worldx-=speed;
                break;
            case "dreapta":
                Worldx+=speed;
                break;
        }



    }


    }




    public  BufferedImage  Setup(String path){
        BufferedImage image=null;
        InputStream is= getClass().getResourceAsStream("/Schin/NPC/"+path+".png");

        try {
            image = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
        }


        return image;
    }


}
