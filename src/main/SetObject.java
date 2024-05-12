package main;

import Entity.NPC_Gargulia;
import Obiecte.ObiectBoots;
import Obiecte.ObiectChest;
import Obiecte.ObiectDoor;
import Obiecte.ObiectKey;

public class SetObject {
    GamePanel gp;
    public SetObject(GamePanel gp){
        this.gp = gp;
    }



    public  void SetObject(){

}


public void SetNPS(){
        gp.NPC[0] = new NPC_Gargulia(gp);
        gp.NPC[0].Worldx=21*gp.titlesize;
        gp.NPC[0].Worldy=21*gp.titlesize;
}

}
