package main;

import java.awt.*;

public class Event {

    GamePanel gp;
EventReact eventRect[][];
int previusEventCol,previusEventRow;
boolean canTouchEvent = true;
    public Event(GamePanel gp){
        this.gp = gp;
        eventRect = new EventReact[gp.maxWorldCol][gp.maxWorldRow];
        int col=0;
        int row=0;
        while (col<gp.maxWorldCol && row<gp.maxWorldRow){
            eventRect[col][row] = new EventReact();
          eventRect[col][row].x=23;
            eventRect[col][row].y=23;
            eventRect[col][row].width=2;
            eventRect[col][row].height=2;
            eventRect[col][row].eventRectDefaultX=eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY=eventRect[col][row].y;
            col++;
            if (col==gp.maxWorldCol){
                col=0;
                row++;
            }
        }
    }

    public  void checkEvent(){

        int xDistance = Math.abs(gp.player.Worldx-previusEventCol);
        int yDistance = Math.abs(gp.player.Worldy-previusEventRow);
        int distance = Math.max(xDistance,yDistance);
        if (distance>gp.titlesize){
            canTouchEvent=true;
        }
        if (canTouchEvent){
            if (hit(23, 12, "any")) {Heal(27,16,gp.Dialog_STATE);}

        }



        }


        public void damagePlayer(int col,int row,int gameState){
        gp.gameState=gameState;
        gp.ui.Dialog="Ai fost lovit de o fiiara a insulei ";
        gp.player.Life-=1;
//        eventRect[col][row].EventDone=true;
        canTouchEvent=false;
        }

    public boolean hit(int eventcol,int eventrow,String reqDirection){
        boolean hit = false;

        gp.player.coliziune.x = gp.player.Worldx+gp.player.coliziune.x;
        gp.player.coliziune.y = gp.player.Worldy+gp.player.coliziune.y;
        eventRect[eventcol][eventrow].x = eventcol*gp.titlesize+eventRect[eventcol][eventrow].x;
        eventRect[eventcol][eventrow].y = eventrow*gp.titlesize+eventRect[eventcol][eventrow].y;

        if (gp.player.coliziune.intersects(eventRect[eventcol][eventrow]) && eventRect[eventcol][eventrow].EventDone==false){
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.equals("any")){
                hit = true;

                previusEventCol=gp.player.Worldx;
                previusEventRow=gp.player.Worldy;
            }

        }

        gp.player.coliziune.x = gp.player.SolidDefaultX;
        gp.player.coliziune.y = gp.player.SolidDefaultY;
        eventRect[eventcol][eventrow].x = eventRect[eventcol][eventrow].eventRectDefaultX;
        eventRect[eventcol][eventrow].y = eventRect[eventcol][eventrow].eventRectDefaultY;
        return hit;
    }


    public void Heal(int col,int row,int gameState){


    if (gp.keyHandler.isEnter){
        if (gp.player.Life<=gp.player.MaxLife-1){
        gp.gameState=gameState;
        gp.ui.Dialog="Acest izvor necunoscut a vindecat\n toate ranile tale";
        gp.playSE(1);
        gp.player.Life=gp.player.MaxLife;
}
}
}
}
