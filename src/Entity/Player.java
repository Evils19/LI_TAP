package Entity;

import Entity.Weapon.Item_Shield;
import Entity.Weapon.Item_Sword;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;


public class Player  extends Entity{




    public KeyHandler keyHandler;
    Graphics2D g2d;
   private int Playerx=64;
    private int Playery=64;


  public   int temppotionx = Worldx;
    public  int temppotiony = Worldy;

    private int susIndex = 0;
    private int josIndex = 0;
    private int stangaIndex = 0;
    private int dreaptaIndex = 0;

    //Poziția pe ecran a jucătorului
    public final  int screenX;
    public final  int screenY;

    public  int TempNrChei=0;
    public Player(GamePanel gp, KeyHandler kh){
        super(gp);

        keyHandler = kh;
        screenX = this.gp.screenWidth/2- this.gp.titlesize/2;
        screenY = this.gp.screenHeight/2- this.gp.titlesize/2;
        coliziune= new Rectangle(10,18,25,25);
        SolidDefaultX=coliziune.x;
        SolidDefaultY=coliziune.y;
        AtackColiziune.width=36;
        AtackColiziune.height=36;
        setDefaultPosition();
        importImage();


    }
    private void  importImage(){
        InputStream is= getClass().getResourceAsStream("/Schin/PlayerFinal.png");

        try {
            objectImage = ImageIO.read(is);
        }catch (Exception e){
            e.printStackTrace();//Afiseaza eroarea in caz ca nu se incarca imaginea
    }
    }
    public  void setDefaultPosition(){
        Worldx = gp.titlesize*23;
        Worldy = gp.titlesize*21;
        //Caracteristici
        CurentWeapon=new Item_Sword(gp);
        CurentShield=new Item_Shield(gp);
        Lvl=1;
        Power=GetAtack();
        MaxLife=6;
        Life=MaxLife;
        speed=4;
        KritPower=20;
        Exp=0;
        NextLvlExp=10;
        Coin=0;
        Dexterty=1;
      Defance = GetDefance();


    }
    private int attackCooldown = 0;


    public int GetDefance(){
        return Dexterty*CurentShield.DefenseValue;
    }
    public  int GetAtack(){
        return Power+CurentWeapon.SwordPower;
    }
    public void update() {


        if (attackCooldown > 0) {
            attackCooldown--;
        }
        if (keyHandler.IsAtack && !ActionAtack && attackCooldown == 0) {
            if (gp.dc.ColiziuneNPC(this, gp.NPC) == 999) {
                ActionAtack = true;
                int curentX = Worldx;
                int curentY = Worldy;
                int solidX = coliziune.x;
                int solidY = coliziune.y;

                switch (direction) {
                    case "sus":
                        Worldy -= AtackColiziune.height;
                        break;
                    case "jos":
                        Worldy += AtackColiziune.height;
                        break;
                    case "stanga":
                        Worldx -= AtackColiziune.width;
                        break;
                    case "dreapta":
                        Worldx += AtackColiziune.width;
                        break;
                }

                coliziune.width = AtackColiziune.width;
                coliziune.height = AtackColiziune.height;

                int monsterIndex = gp.dc.ColiziuneNPC(this, gp.Monstr);

                // Restore original positions
                Worldx = curentX;
                Worldy = curentY;
                coliziune.x = solidX;
                coliziune.y = solidY;

                MonstrDamage(monsterIndex);

                // Play sound effect once
                gp.playSE(9);
                attackCooldown = 10;
            }
        }



        if (keyHandler.MiscareSus) {
          if (!collision)
            Worldy -= speed;
            direction = "sus";
            susIndex = (susIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru sus
        } else if (keyHandler.MiscareJos) {
            if (!collision)
            Worldy += speed;
            direction = "jos";
            josIndex = (josIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru jos
        } else if (keyHandler.MiscareStanga) {
            if (!collision)
            Worldx -= speed;
            direction = "stanga";
            stangaIndex = (stangaIndex + 1) % 3; // Schimbă imaginea la următoarea din setul pentru stânga
        } else if (keyHandler.MiscareDreapta) {
            if (!collision)
            Worldx += speed;
            direction = "dreapta";
            dreaptaIndex = (dreaptaIndex + 1) % 3;
            // Schimbă imaginea la următoarea din setul pentru dreapta
        }


             if (keyHandler.Hack) {
                     TempNrChei=Life;
                     Life=6;
                     gp.ui.ShowMessage("Обратная техника", Color.red);
             }


        if (Invisible){
            InvisibleCounter++;
            if (InvisibleCounter>60){
                Invisible=false;
                InvisibleCounter=0;
            }
        }

//             gp.label.setText("Cordonata x "+Worldx+"Cordonata y "+Worldy);

        //Event
        gp.event.checkEvent();

        collision =false;
        gp.dc.ColiziuneBloc(this);

        //Coloziune obiecte
      int objIndex=  gp.dc.ColoziuneObiect(this,true);
      ObjectInteraction(objIndex);

      //Coliziune NPC
      int NpcIndex=gp.dc.ColiziuneNPC(this,gp.NPC);
        NPCInteraction(NpcIndex);
        //Coliziune Monster
        int MonsterIndex=gp.dc.ColiziuneNPC(this,gp.Monstr);
        MonstrInteraction(MonsterIndex);

        if (Life<3){
            speed=2;
                }
        if (Life<=0){
            gp.ui.ShowMessage("Ai murit",Color.RED);
            setDefaultPosition();
        }
        if (Life>3){
            speed=4;
        }






    }



    public  void ObjectInteraction(int index){
        if (index!=999){
if (gp.objects[index].nameObject=="Door"){
    if(Life==MaxLife){
        Life=1;
        Invisible=true;
        gp.objects[index]=null;
        gp.ui.ShowMessage("Din momentul dat viteza scade de doua ori",Color.RED);
    }
    else {
        collision=true;
    }}}}
    public void NPCInteraction(int index){
        if (index!=999){
            gp.ui.ShowMessage("Apasa Enter pentru a vorbi",Color.WHITE);
            if (gp.keyHandler.isEnter){
                gp.gameState=gp.Dialog_STATE;
                gp.NPC[index].speak();
            }
            if (gp.NPC[index].nameObject=="Magician" && gp.gameState==gp.Dialog_STATE){
                if (Life<3){
                gp.NPC[index].dialog[1]="Vad ca ai nevoie de ajutor te pot vindeca";
                     }
                else {
                    gp.NPC[index].dialog[1]="In orce caz iti urez succes si fii mai  atent";
                }
            }

        }
        gp.keyHandler.isEnter =false;
    }


    public void MonstrInteraction(int index){
        if (index!=999){

            if (!Invisible){
                gp.playSE(10);


                int damge = gp.Monstr[index].PowerAtak()-Defance;
                if (damge<=0){
                    damge=0;
                }
                Life-=damge;
                damage=true;
                Invisible=true;

            }



            collision=true;

    }
    }

public  void draw(Graphics2D g2d){
        this.g2d = g2d;


    jos[0]= objectImage.getSubimage(0*Playerx,0*Playery,Playerx,Playery);
    jos[1]= objectImage.getSubimage(1*Playerx,0*Playery,Playerx,Playery);
    jos[2]= objectImage.getSubimage(2*Playerx,0*Playery,Playerx,Playery);
    jos[3]= objectImage.getSubimage(3*Playerx,0*Playery,Playerx,Playery);

    AtackJos[0]= objectImage.getSubimage(4*Playerx,0*Playery,Playerx,Playery);
    AtackJos[1]= objectImage.getSubimage(5*Playerx,0*Playery,Playerx,Playery);



    stanga[0]= objectImage.getSubimage(0*Playerx,1*Playery,Playerx,Playery);
    stanga[1]= objectImage.getSubimage(1*Playerx,1*Playery,Playerx,Playery);
    stanga[2]= objectImage.getSubimage(2*Playerx,1*Playery,Playerx,Playery);
    stanga[3]= objectImage.getSubimage(3*Playerx,1*Playery,Playerx,Playery);

    AtackStanga[0]= objectImage.getSubimage(4*Playerx,1*Playery,Playerx,Playery);
    AtackStanga[1]= objectImage.getSubimage(5*Playerx,1*Playery,Playerx,Playery);

    dreapta[0]= objectImage.getSubimage(0*Playerx,2*Playery,Playerx,Playery);
    dreapta[1]= objectImage.getSubimage(1*Playerx,2*Playery,Playerx,Playery);
    dreapta[2]= objectImage.getSubimage(2*Playerx,2*Playery,Playerx,Playery);
    dreapta[3]= objectImage.getSubimage(3*Playerx,2*Playery,Playerx,Playery);

    AtackDreapta[0]= objectImage.getSubimage(4*Playerx,2*Playery,Playerx,Playery);
    AtackDreapta[1]= objectImage.getSubimage(5*Playerx,2*Playery,Playerx,Playery);

    sus[0]= objectImage.getSubimage(0*Playerx,3*Playery,Playerx,Playery);
    sus[1]= objectImage.getSubimage(1*Playerx,3*Playery,Playerx,Playery);
    sus[2]= objectImage.getSubimage(2*Playerx,3*Playery,Playerx,Playery);
    sus[3]= objectImage.getSubimage(3*Playerx,3*Playery,Playerx,Playery);

    AtackSus[0]= objectImage.getSubimage(4*Playerx,3*Playery,Playerx,Playery);
    AtackSus[1]= objectImage.getSubimage(5*Playerx,3*Playery,Playerx,Playery);






    BufferedImage image = null;


    if (ActionAtack){
        switch (direction){
            case "sus":
                image = AtackSus[0];
                ActionAtack=false;

                break;
            case "jos":
                image = AtackJos[0];
                ActionAtack=false;
                break;
            case "stanga":
                image = AtackStanga[0];
                ActionAtack=false;
                break;
            case "dreapta":
                image = AtackDreapta[0];
                ActionAtack=false;
                break;
        }
    }
    else {
        switch (direction) {
            case "sus":
                image = sus[susIndex];

                break;
            case "jos":
                image = jos[josIndex];
                break;
            case "stanga":
                image = stanga[stangaIndex];
                break;
            case "dreapta":
                image = dreapta[dreaptaIndex];
                break;
        }
    }





if (Invisible){
    Invisble();
    if (damage){
        damage=false;
}
}
    g2d.drawImage(image.getSubimage(0,0,64,64),screenX, screenY, gp.titlesize*3/2, gp.titlesize*3/2,null);

    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

}

public  void  Invisble(){
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
}


public void MonstrDamage(int monsterIndex){
    if (monsterIndex!=999){
        gp.Monstr[monsterIndex].direction=DirectionInverso(direction);
        if (!gp.Monstr[monsterIndex].Invisible){
            gp.playSE(10);

            int damge = PowerAtak()- gp.Monstr[monsterIndex].Defance;
            if (damge<=0){
                damge=0;
            }


        gp.Monstr[monsterIndex].Life-=damge;
        gp.Monstr[monsterIndex].Invisible=true;
        gp.Monstr[monsterIndex].damage=true;
        if (gp.Monstr[monsterIndex].Life<=0){
            Power+=10;
            gp.Monstr[monsterIndex].Dying=true;
        }
        }
    }

}


}

