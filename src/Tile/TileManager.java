package Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
   public Tile[] tiles;
   public int mapTileNum [][];//Harta

    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[10];//10 blocuri
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
        getTileImaege();
        loadMap();

    }



    public  void  getTileImaege(){


        try {
            tiles[0] = new Tile();
            tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/wall.png"));
            tiles[1].collision = true;//Blocul este solid si nu poate fi trecut peste

            tiles[2] = new Tile();
            tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water00.png"));
            tiles[2].collision = true;

            tiles[3] = new Tile();
            tiles[3].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/earth.png"));

            tiles[4] = new Tile();
            tiles[4].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/tree.png"));
            tiles[4].collision = true;
            tiles[5] = new Tile();
            tiles[5].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/sand.png"));




        }
        catch (Exception e){
            e.printStackTrace();
    }
}

public  void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/world01.txt");
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
