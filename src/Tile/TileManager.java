package Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
   public Tile[] tiles;
   public int mapTileNum [][];//Harta

    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[50];//50 blocuri
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
        getTileImaege();
        loadMap();

    }



    public  void  getTileImaege(){


        try {
            tiles[0] = new Tile();
            tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[0].collision = false;
            tiles[1] = new Tile();
            tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[1].collision = false;
            tiles[2] = new Tile();
            tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[2].collision = false;
            tiles[3] = new Tile();
            tiles[3].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[3].collision = false;
            tiles[4] = new Tile();
            tiles[4].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[4].collision = false;
            tiles[5] = new Tile();
            tiles[5].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[5].collision = false;
            tiles[6] = new Tile();
            tiles[6].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[6].collision = false;
            tiles[7] = new Tile();
            tiles[7].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[7].collision = false;
            tiles[8] = new Tile();
            tiles[8].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[8].collision = false;
            tiles[9] = new Tile();
            tiles[9].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[9].collision = false;
            tiles[10] = new Tile();
            tiles[10].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass00.png"));
            tiles[10].collision = false;
            tiles[11] = new Tile();
            tiles[11].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass01.png"));
            tiles[11].collision = false;
            tiles[12] = new Tile();
            tiles[12].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water00.png"));
            tiles[12].collision = true;
            tiles[13] = new Tile();
            tiles[13].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water01.png"));
            tiles[13].collision = true;
            tiles[14] = new Tile();
            tiles[14].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water02.png"));
            tiles[14].collision = true;
            tiles[15] = new Tile();
            tiles[15].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water03.png"));
            tiles[15].collision = true;
            tiles[16] = new Tile();
            tiles[16].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water04.png"));
            tiles[16].collision = true;
            tiles[17] = new Tile();
            tiles[17].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water05.png"));
            tiles[17].collision = true;
            tiles[18] = new Tile();
            tiles[18].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water06.png"));
            tiles[18].collision = true;
            tiles[19] = new Tile();
            tiles[19].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water07.png"));
            tiles[19].collision = true;
            tiles[20] = new Tile();
            tiles[20].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water08.png"));
            tiles[20].collision = true;
            tiles[21] = new Tile();
            tiles[21].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water09.png"));
            tiles[21].collision = true;
            tiles[22] = new Tile();
            tiles[22].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water10.png"));
            tiles[22].collision = true;
            tiles[23] = new Tile();
            tiles[23].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water11.png"));
            tiles[23].collision = true;
            tiles[24] = new Tile();
            tiles[24].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water12.png"));
            tiles[24].collision = true;
            tiles[25] = new Tile();
            tiles[25].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water13.png"));
            tiles[25].collision = true;
            tiles[26] = new Tile();
            tiles[26].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road00.png"));
            tiles[26].collision = false;
            tiles[27] = new Tile();
            tiles[27].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road01.png"));
            tiles[27].collision = false;
            tiles[28] = new Tile();
            tiles[28].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road02.png"));
            tiles[28].collision = false;
            tiles[29] = new Tile();
            tiles[29].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road03.png"));
            tiles[29].collision = false;
            tiles[30] = new Tile();
            tiles[30].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road04.png"));
            tiles[30].collision = false;
            tiles[31] = new Tile();
            tiles[31].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road05.png"));
            tiles[31].collision = false;
            tiles[32] = new Tile();
            tiles[32].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road06.png"));
            tiles[32].collision = false;
            tiles[33] = new Tile();
            tiles[33].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road07.png"));
            tiles[33].collision = false;
            tiles[34] = new Tile();
            tiles[34].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road08.png"));
            tiles[34].collision = false;
            tiles[35] = new Tile();
            tiles[35].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road09.png"));
            tiles[35].collision = false;
            tiles[36] = new Tile();
            tiles[36].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road10.png"));
            tiles[36].collision = false;
            tiles[37] = new Tile();
            tiles[37].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road11.png"));
            tiles[37].collision = false;
            tiles[38] = new Tile();
            tiles[38].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/road12.png"));
            tiles[38].collision = false;
            tiles[39] = new Tile();
            tiles[39].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/earth.png"));
            tiles[39].collision = false;
            tiles[40] = new Tile();
            tiles[40].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/wall.png"));
            tiles[40].collision = true;
            tiles[41] = new Tile();
            tiles[41].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/tree.png"));
            tiles[41].collision = true;






}
catch (Exception e){
    e.printStackTrace();
}

}



public  void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/worldV2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col<gp.maxWorldCol && row<gp.maxWorldRow){
              String line = br.readLine();//Citeste linie cu linie

                while (col<gp.maxWorldCol){
                    String numbers[]= line.split(" ");//Imparte linia in numere

                    int num = Integer.parseInt(numbers[col]);//Converteste numarul in int
                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col==gp.maxWorldCol){
                    col=0;
                    row++;
            }

        }
        }

        catch (Exception e){


}

}


public  void draw(Graphics2D g2){
      int worldCol=0;
      int worldRow=0;


        while (worldCol<gp.maxWorldCol && worldRow< gp.maxWorldRow){
            int num = mapTileNum[worldRow][worldCol];
            int worldX=worldCol*gp.titlesize;
            int worldY=worldRow*gp.titlesize;
            int screenX=worldX+gp.player.screenX-gp.player.Worldx;
            int screenY=worldY+gp.player.screenY-gp.player.Worldy;

            //Verificam daca blocul este in raza de vizibilitate daca da il desenam
            if (worldX+gp.titlesize>gp.player.Worldx-gp.player.screenX &&
            worldX-gp.titlesize<gp.player.Worldx+gp.player.screenX&&
            worldY+gp.titlesize>gp.player.Worldy-gp.player.screenY &&
            worldY-gp.titlesize<gp.player.Worldy+gp.player.screenY){

                g2.drawImage(tiles[num].image,screenX,screenY,gp.titlesize,gp.titlesize,null);

            }


            worldCol++;

            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;


            }

        }

}

}
