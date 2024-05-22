package main;

import Entity.Monster.Moster_Slime;
import Entity.NPC_Gargulia;
import Entity.NPC_Elf;
import Entity.NPC_Magician;
import Entity.Obiecte.ObiectDoor;
import Entity.Obiecte.ObiectKey;
import Entity.Obiecte.ObiectPotionRed;
import Entity.Obiecte.ObiectSukune;
import Entity.Weapon.Item_ShiedBlue;
import Entity.Weapon.Item_Topor;

public class SetObject {
    GamePanel gp;
    public SetObject(GamePanel gp){
        this.gp = gp;
    }



    public  void SetObject(){
int i =0;
//        gp.objects[i]=new ObiectDoor(gp);
//        gp.objects[i].Worldx=21*gp.titlesize;
//        gp.objects[i].Worldy=21*gp.titlesize;
//        i++;

        gp.objects[i]=new ObiectKey(gp);
        gp.objects[i].Worldx=25*gp.titlesize;
        gp.objects[i].Worldy=23*gp.titlesize;
        i++;
        gp.objects[i]=new ObiectKey(gp);
        gp.objects[i].Worldx=21*gp.titlesize;
        gp.objects[i].Worldy=19*gp.titlesize;
        i++;
        gp.objects[i]=new ObiectKey(gp);
        gp.objects[i].Worldx=26*gp.titlesize;
        gp.objects[i].Worldy=21*gp.titlesize;
        i++;

        gp.objects[i]=new Item_ShiedBlue(gp);
        gp.objects[i].Worldx=30*gp.titlesize;
        gp.objects[i].Worldy=21*gp.titlesize;
        i++;
        gp.objects[i]=new Item_Topor(gp);
        gp.objects[i].Worldx=31*gp.titlesize;
        gp.objects[i].Worldy=21*gp.titlesize;
        i++;

        gp.objects[i]=new ObiectPotionRed(gp);
        gp.objects[i].Worldx=32*gp.titlesize;
        gp.objects[i].Worldy=21*gp.titlesize;


}



public void SetNPS(){


        gp.NPC[0] = new NPC_Gargulia(gp);
        gp.NPC[0].Worldx=20*gp.titlesize;
        gp.NPC[0].Worldy=21*gp.titlesize;



    gp.NPC[2] = new NPC_Elf(gp);
    gp.NPC[2].Worldx=19*gp.titlesize;
    gp.NPC[2].Worldy=40*gp.titlesize;

//
    gp.NPC[3] = new NPC_Magician(gp);
    gp.NPC[3].Worldx=21*gp.titlesize;
    gp.NPC[3].Worldy=21*gp.titlesize;
}


public  void SetMonstrs(){
        gp.Monstr[0]= new Moster_Slime(gp);
        gp.Monstr[0].Worldx=23*gp.titlesize;
        gp.Monstr[0].Worldy=36*gp.titlesize;

    gp.Monstr[1]= new Moster_Slime(gp);
    gp.Monstr[1].Worldx=23*gp.titlesize;
    gp.Monstr[1].Worldy=37*gp.titlesize;

    gp.Monstr[2]= new Moster_Slime(gp);
    gp.Monstr[2].Worldx=23*gp.titlesize;
    gp.Monstr[2].Worldy=38*gp.titlesize;

    gp.Monstr[3]= new Moster_Slime(gp);
    gp.Monstr[3].Worldx=23*gp.titlesize;
    gp.Monstr[3].Worldy=39*gp.titlesize;

    gp.Monstr[4]= new Moster_Slime(gp);
    gp.Monstr[4].Worldx=23*gp.titlesize;
    gp.Monstr[4].Worldy=35*gp.titlesize;

    gp.Monstr[5]= new Moster_Slime(gp);
    gp.Monstr[5].Worldx=21*gp.titlesize;
    gp.Monstr[5].Worldy=39*gp.titlesize;

    gp.Monstr[6]= new Moster_Slime(gp);
    gp.Monstr[6].Worldx=20*gp.titlesize;
    gp.Monstr[6].Worldy=38*gp.titlesize;

    gp.Monstr[7]= new Moster_Slime(gp);
    gp.Monstr[7].Worldx=23*gp.titlesize;
    gp.Monstr[7].Worldy=34*gp.titlesize;

    gp.Monstr[8]= new Moster_Slime(gp);
    gp.Monstr[8].Worldx=22*gp.titlesize;
    gp.Monstr[8].Worldy=34*gp.titlesize;


}


}
