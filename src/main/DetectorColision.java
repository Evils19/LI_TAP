package main;

import Entity.Entity;

public class DetectorColision {

    GamePanel gp;
    public DetectorColision(GamePanel gp){
        this.gp = gp;
    }

    public  void ColiziuneBloc(Entity entity){
        //Partea solida a  personajului
int entityLeftWorldX= entity.Worldx+entity.coliziune.x;//Coltul stanga al personajului
int entityRightWorldX= entity.Worldx+entity.coliziune.x+entity.coliziune.width;//Coltul dreapta al personajului
int entityTopWorldY= entity.Worldy+entity.coliziune.y;//Coltul de sus al personajului
int entityBottomWorldY= entity.Worldy+entity.coliziune.y+entity.coliziune.height;//Coltul de jos al personajului

int entituLeftCol= entityLeftWorldX/gp.titlesize;
int entityRightCol= entityRightWorldX/gp.titlesize;
int entityTopRow= entityTopWorldY/gp.titlesize;
int entityBottomRow= entityBottomWorldY/gp.titlesize;

int tilenum1, tilenum2;

switch (entity.direction){

case "sus":
    entityTopRow=(entityTopWorldY-entity.speed)/gp.titlesize;
tilenum1= gp.tm.mapTileNum[entityTopRow][entituLeftCol];
tilenum2= gp.tm.mapTileNum[entityTopRow][entityRightCol];
if (gp.tm.tiles[tilenum1].collision==true || gp.tm.tiles[tilenum2].collision==true){
    entity.collision=true;
}
    break;
case "jos":
entityBottomRow=(entityBottomWorldY+entity.speed)/gp.titlesize;
tilenum1= gp.tm.mapTileNum[entityBottomRow][entituLeftCol];
tilenum2= gp.tm.mapTileNum[entityBottomRow][entityRightCol];
if (gp.tm.tiles[tilenum1].collision==true || gp.tm.tiles[tilenum2].collision==true){
    entity.collision=true;
}
    break;
case "stanga":


  entituLeftCol=(entityLeftWorldX-entity.speed)/gp.titlesize;
    tilenum1= gp.tm.mapTileNum[entityBottomRow][entituLeftCol];
    tilenum2= gp.tm.mapTileNum[entityBottomRow][entityRightCol];
    if (gp.tm.tiles[tilenum1].collision==true || gp.tm.tiles[tilenum2].collision==true){
        entity.collision=true;
    }
    break;
case "dreapta":
    entityRightCol=(entityRightWorldX+entity.speed)/gp.titlesize;
    tilenum1= gp.tm.mapTileNum[entityTopRow][entityRightCol];
    tilenum2= gp.tm.mapTileNum[entityBottomRow][entityRightCol];
    if (gp.tm.tiles[tilenum1].collision==true || gp.tm.tiles[tilenum2].collision==true){
        entity.collision=true;
    }

    break;
    }
}



public  int ColoziuneObiect(Entity entity,boolean player){
int index=999;

for (int i=0;i<gp.objects.length; i++){
if (gp.objects[i]!=null){
//Partea solida a  personajului
    entity.coliziune.x=entity.Worldx+entity.coliziune.x;//Coltul stanga al personajului
    entity.coliziune.y=entity.Worldy+entity.coliziune.y;//Coltul de sus al personajului
//Partea solida a obiectului
    gp.objects[i].SolidObject.x=gp.objects[i].Worldx+gp.objects[i].SolidDefaultX;
    gp.objects[i].SolidObject.y=gp.objects[i].Worldy+gp.objects[i].SolidDefaultY;


    switch (entity.direction){
    case "sus":

        entity.coliziune.y-=entity.speed;//Are scopul de a verifica coliziunea in directia in care se misca personajul
        if (entity.coliziune.intersects(gp.objects[i].SolidObject)){
            entity.ObjCollision=true;
            if (gp.objects[i].collision) entity.ObjCollision=true;
            if (player)index= i;


        }
        break;
case "jos":
    entity.coliziune.y+=entity.speed;
    if (entity.coliziune.intersects(gp.objects[i].SolidObject)){
        if (gp.objects[i].collision) entity.ObjCollision=true;
        if (player)index= i;



    }
    break;
case "stanga":
    entity.coliziune.x-=entity.speed;
    if (entity.coliziune.intersects(gp.objects[i].SolidObject)){
        if (gp.objects[i].collision) entity.ObjCollision=true;
        if (player)index= i;



    }
    break;
case "dreapta":
    entity.coliziune.x+=entity.speed;
    if (entity.coliziune.intersects(gp.objects[i].SolidObject)){
        if (gp.objects[i].collision) entity.ObjCollision=true;
        if (player)index= i;

    }
    break;
}
entity.coliziune.x= entity.SolidDefaultX;
entity.coliziune.y= entity.SolidDefaultY;
gp.objects[i].SolidObject.x=gp.objects[i].SolidDefaultX;
gp.objects[i].SolidObject.y=gp.objects[i].SolidDefaultY;
}
}




return index;
}
}
