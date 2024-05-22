package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;

public class Entity {
//Obiecte
public BufferedImage objectImage;
public boolean  Krit=false;
    public String nameObject;
    public  boolean damage=false;
    public  boolean Invisible=false;
    public  int InvisibleCounter=0;
    protected   boolean  ActionAtack=false;
    public boolean   Dying=false;
    public   boolean   Alivie=true;
    protected  int  DyingCounter=0;

    public boolean  HpBar=false;
    public int  HpBarCounter=0;

    protected  BufferedImage [] AtackSus = new BufferedImage[2];
    protected  BufferedImage [] AtackJos = new BufferedImage[2];
    protected  BufferedImage [] AtackStanga = new BufferedImage[2];
    protected  BufferedImage [] AtackDreapta = new BufferedImage[2];

    public Rectangle AtackColiziune= new Rectangle(0,0,0,0);

    public boolean Isplayer = false;

    //NPC+Player
   protected GamePanel gp;
   public  int IndexS=0;
   public  int IndexJ=0;
   public  int IndexD=0;
   public  int IndexST=0;
    public  int Worldx, Worldy;
    public  int speed;
    String dialog[]=new String[20];
    //Haracteristici
    public  int MaxLife;
    public  int Life;
    public  int Power=1;
    public  int  Lvl;
    public  int KritPower=20;
    public  int  Exp=0;
    public int NextLvlExp=10;
    public  int Coin;
    public Entity CurentWeapon;
    public Entity CurentShield;
    public int Dexterty;
    public  int Defance;

    //Caracteristici Item
    public  int SwordPower;
    public int DefenseValue;
    public String Description;

    protected int indexDialog=0;
  protected   int sprintnum=0;
   protected int sprinterCoutner=0;
   protected   int sprintnum2=0;
   protected int sprinterCoutner2=0;
   public  int type;//0=player,1=NPC,2=Obiecte,3=Monstr
   public  int type_player=0;
    public  int type_npc=1;
    public  int type_obj=2;
    public  int type_monstr=3;
    public  int type_Sword=4;
    public  int type_Shield=5;
    public  int type_Axe=6;
    public  int type_Consumable=7;




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
                    if (gp.gameState== gp.PLAY_STATE) {
                        IndexS = (IndexS + 1) % 3;// Selectează imaginea corespunzătoare din setul pentru sus
                    }
                        break;
                case "jos":
                    image = jos[IndexJ];// Selectează imaginea corespunzătoare din setul pentru jos
                    if (gp.gameState== gp.PLAY_STATE)   IndexJ=(IndexJ+1)%3;
                    break;
                case "stanga":
                    image = stanga[IndexST]; // Selectează imaginea corespunzătoare din setul pentru stânga
                    if (gp.gameState== gp.PLAY_STATE)   IndexST=(IndexST+1)%3;
                    break;
                case "dreapta":
                    image = dreapta[IndexD]; // Selectează imaginea corespunzătoare din setul pentru dreapta
                    if (gp.gameState== gp.PLAY_STATE)     IndexD=(IndexD+1)%3;
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


        if (Invisible){
            InvisibleCounter++;
            if (InvisibleCounter>40){
                Invisible=false;
                InvisibleCounter=0;
            }


        }


if (gp.dc.ColiziunePlayer(this) && type==type_monstr){



    if (!gp.player.Invisible){


        gp.playSE(10);


        int damge = PowerAtak()-gp.player.Defance;
        if (damge<=0){
            damge=0;
        }
        gp.player.Life-=damge;
        gp.player.Invisible=true;}
}
    }



    public  void StopColiziune(){
        gp.dc.ColiziuneBloc(this);
        gp.dc.ColiziunePlayer(this);
        gp.dc.ColiziuneNPC(this, gp.Monstr);
        gp.dc.ColiziuneNPC(this, gp.NPC);
        int NpcIndex=gp.dc.ColiziuneNPC(this,gp.NPC);
        NPCInteraction(NpcIndex);
        //Coliziune Monster
        int MonsterIndex=gp.dc.ColiziuneNPC(this,gp.Monstr);
        MonstrInteraction(MonsterIndex);
        int objIndex=  gp.dc.ColoziuneObiect(this,true);
        ObjectInteraction(objIndex);

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




    public  BufferedImage SetupNPC(String path){
        BufferedImage image=null;
        InputStream is= getClass().getResourceAsStream("/Schin/NPC/"+path+".png");

        try {
            image = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
        }


        return image;
    }
    public  BufferedImage SetupObject(String path){
        BufferedImage image=null;
        InputStream is= getClass().getResourceAsStream("/Schin/Object/"+path+".png");

        try {
            image = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
        }


        return image;
    }

    public BufferedImage SetupMonster(String path){
        BufferedImage image=null;
        InputStream is= getClass().getResourceAsStream("/Schin/Monster/"+path+".png");

        try {
            image = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
        }

        return image;

}
    public  void ObjectInteraction(int index){
        if (index!=999){
          collision=true;

            }
        }



    public void NPCInteraction(int index){
        if (index!=999){
          collision=true;
    }
    }


    public void MonstrInteraction(int index){
        if (index!=999){

            collision=true;
            if (Isplayer){
                gp.player.Life--;
                direction=DirectionInverso(gp.player.direction);

                if (gp.player.Life<=0){
                   gp.player.Dead();

                   Exp+=gp.player.Exp;
                    if (Exp>=NextLvlExp){
                        Lvl++;
                        Exp=Exp-NextLvlExp;
                        NextLvlExp+=NextLvlExp+(NextLvlExp*NextLvlExp)/50;
                        MaxLife+=2;
                        Power+=10;
                        Defance+=1;
                        gp.ui.addMesage("Moster Lvl Up");

                    }

                }
            }



        }
    }



public  void DyingAnimation(Graphics2D g2d){
        DyingCounter++;
        if (DyingCounter<=5){
            ChangeAlpa(g2d,0f);}
        if ( DyingCounter>5 && DyingCounter<=10){
            ChangeAlpa(g2d,1f);        }
        if ( DyingCounter>10 && DyingCounter<=15){
            ChangeAlpa(g2d,0f);}
        if ( DyingCounter>15 && DyingCounter<=20){
            ChangeAlpa(g2d,1f);}
        if ( DyingCounter>25 && DyingCounter<=30){
            ChangeAlpa(g2d,0f);}
        if ( DyingCounter>30 && DyingCounter<=35){
            ChangeAlpa(g2d,1f);}
        if ( DyingCounter>35 && DyingCounter<=40){
            ChangeAlpa(g2d,0f);}


    if (DyingCounter>40){
        Dying=false;
        Alivie=false;
        DyingCounter=0;
        if (type==3){
            gp.playSE(11);
        }
    }
    }
    public  void ChangeAlpa(Graphics2D g2d,float alpha){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

    }

    public  String DirectionInverso(String direction){
        switch (direction){
            case "sus":
                return "jos";
            case "jos":
                return "sus";
            case "stanga":
                return "dreapta";
            case "dreapta":
                return "stanga";
        }
        return null;

    }



    public int PowerAtak() {
        int tempPower;
        Random rand = new Random();


        int Rand = rand.nextInt(20);

        if (Rand >= 16 && ActionAtack) {

            int AtackKrit = rand.nextInt(20,100);


            tempPower = AtackKrit;


            Krit = true;
            gp.ui.ShowMessage("Krit Atack " + tempPower, Color.WHITE);
        } else {
            tempPower = Power;


            Krit = false;
        }


        return tempPower;
    }



    public  void Consumable(Entity entity){}


}




