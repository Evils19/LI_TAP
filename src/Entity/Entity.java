package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Entity {


   protected GamePanel gp;
   public  int IndexS=0;
   public  int IndexJ=0;
   public  int IndexD=0;
   public  int IndexST=0;
    public  int Worldx, Worldy;
    public  int speed;
    String dialog[]=new String[20];



public BufferedImage objectImage;
    public BufferedImage [] sus = new BufferedImage[4];
    public BufferedImage [] jos = new BufferedImage[4];
    public BufferedImage [] stanga = new BufferedImage[4];
    public BufferedImage [] dreapta = new BufferedImage[4];
    public Rectangle coliziune= new Rectangle(10,18,25,25);
    public String direction="sus";
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
    public  void speak(){}

    public void update(){
        SetAcion();
    collision=false;
    StopColiziune();


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
}
