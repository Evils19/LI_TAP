package main;

import Entity.NPC_Gargulia;
import Entity.NPC_Elf;
import Entity.NPC_Magician;
import Entity.Obiecte.ObiectDoor;
import Entity.Obiecte.ObiectSukune;

public class SetObject {
    GamePanel gp;
    public SetObject(GamePanel gp){
        this.gp = gp;
    }



    public  void SetObject(){

        gp.objects[0]=new ObiectDoor(gp);
        gp.objects[0].Worldx=21*gp.titlesize;
        gp.objects[0].Worldy=21*gp.titlesize;

}


public void SetNPS(){


        gp.NPC[0] = new NPC_Gargulia(gp);
        gp.NPC[0].Worldx=21*gp.titlesize;
        gp.NPC[0].Worldy=21*gp.titlesize;



    gp.NPC[2] = new NPC_Elf(gp);
    gp.NPC[2].Worldx=19*gp.titlesize;
    gp.NPC[2].Worldy=40*gp.titlesize;

//
    gp.NPC[3] = new NPC_Magician(gp);
    gp.NPC[3].Worldx=21*gp.titlesize;
    gp.NPC[3].Worldy=21*gp.titlesize;
}


}
