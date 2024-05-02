package Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    Tile[] tiles;
    int mapTileNum [][];//Harta

    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[10];//10 blocuri
        mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];
        getTileImaege();
        loadMap();

    }



    public  void  getTileImaege(){


        try {
            tiles[0] = new Tile();
            tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/wall.png"));

            tiles[2] = new Tile();
            tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/Blocuri/water00.png"));


        }
        catch (Exception e){
            e.printStackTrace();
    }
}

public  void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/maps.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col<gp.maxScreenCol && row<gp.maxScreenRow){
              String line = br.readLine();//Citeste linie cu linie

                while (col<gp.maxScreenCol){
                    String numbers[]= line.split(" ");//Imparte linia in numere

                    int num = Integer.parseInt(numbers[col]);//Converteste numarul in int
                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col==gp.maxScreenCol){
                    col=0;
                    row++;
            }

        }
        }

        catch (Exception e){


}

}


public  void draw(Graphics2D g2){
      int col=0;
        int row=0;
        int x=0;
        int y=0;


        while (col<gp.maxScreenCol && row< gp.maxScreenRow){
            int num = mapTileNum[row][col];

            g2.drawImage(tiles[num].image,x,y,gp.titlesize,gp.titlesize,null);
            col++;
            x+=gp.titlesize;
            if(col==gp.maxScreenCol){
                col=0;
                row++;
                x=0;
                y+=gp.titlesize;
            }
        }

}

}
