package main;

import Entity.Entity;

public class DetectorColision {

    GamePanel gp;
    public DetectorColision(GamePanel gp){
        this.gp = gp;
    }

    public  void ColiziuneBloc(Entity entity){
int entityLeftWorldX= entity.Worldx+entity.coliziune.x;
int entityRightWorldX= entity.Worldx+entity.coliziune.x+entity.coliziune.width;
int entityTopWorldY= entity.Worldy+entity.coliziune.y;
int entityBottomWorldY= entity.Worldy+entity.coliziune.y+entity.coliziune.height;

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
}
