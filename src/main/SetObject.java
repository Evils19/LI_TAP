package main;

import Obiecte.ObiectChest;
import Obiecte.ObiectDoor;
import Obiecte.ObiectKey;

public class SetObject {
    GamePanel gp;
    public SetObject(GamePanel gp){
        this.gp = gp;
    }



    public  void SetObject(){
        gp.objects[0]=  new ObiectKey();
        gp.objects[0].Worldx= 23*gp.titlesize;
        gp.objects[0].Worldy= 7*gp.titlesize;


        gp.objects[1]=  new ObiectKey();
        gp.objects[1].Worldx= 23*gp.titlesize;
        gp.objects[1].Worldy= 40*gp.titlesize;


        gp.objects[2]=  new ObiectKey();
        gp.objects[2].Worldx= 37*gp.titlesize;
        gp.objects[2].Worldy= 7*gp.titlesize;


        gp.objects[3]=  new ObiectDoor();
        gp.objects[3].Worldx= 10*gp.titlesize;
        gp.objects[3].Worldy= 11*gp.titlesize;

        gp.objects[4]=  new ObiectDoor();
        gp.objects[4].Worldx= 8*gp.titlesize;
        gp.objects[4].Worldy= 28*gp.titlesize;

        gp.objects[5]=  new ObiectDoor();
        gp.objects[5].Worldx= 12*gp.titlesize;
        gp.objects[5].Worldy= 22*gp.titlesize;


        gp.objects[7]=  new ObiectChest();
        gp.objects[7].Worldx= 10*gp.titlesize;
        gp.objects[7].Worldy= 8*gp.titlesize;




}

}
