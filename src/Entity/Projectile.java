package Entity;

import main.GamePanel;

public class Projectile extends Entity{


    Entity user;
protected Projectile(GamePanel gp){
    super(gp);
}
public  void set(int WorldX,int WorldY,String direction,boolean alieve,Entity player){
this.Worldx=WorldX;
this.Worldy=WorldY;
this.direction=direction;
this.Alivie=alieve;
this.user=player;

}


public  void update(){

    if (user==gp.player){
    int monstrindex= gp.dc.ColiziuneNPC(this,gp.Monstr);
    if (monstrindex!=999){
        gp.player.MonstrDamageMagic(monstrindex,Power);
        Alivie=false;
    }
    else if (user!=gp.player){
boolean ConatactPlayer =gp.dc.ColiziunePlayer(this);
if(!gp.player.Invisible && ConatactPlayer){
    gp.player.Life-=Power-gp.player.Defance;
    Alivie=false;
}
    }

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



Life--;
if (Life<=0) {
    Alivie = false;
    Life=MaxLife;
}
sprinterCoutner++;
if(sprinterCoutner>=12){
if (sprintnum==0){
    sprintnum=1;
}
else if (sprintnum==1){
    sprintnum=0;
}
sprinterCoutner=0;
}
}
}
}
