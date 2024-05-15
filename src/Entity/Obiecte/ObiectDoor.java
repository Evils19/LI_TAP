package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ObiectDoor  extends Entity {
    private BufferedImage jos;

    public ObiectDoor(GamePanel gp) {
        super(gp);
        nameObject = "Door";
        try {
            this.jos = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/door.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        collision = true;
        coliziune.x = 0;
        coliziune.y = 16;
        coliziune.width = 48;
        coliziune.height = 32;
        SolidDefaultX=coliziune.x;
        SolidDefaultY=coliziune.y;



    }


    public  void draw(Graphics2D g){
        int screenX = Worldx - gp.player.Worldx + gp.player.screenX;//Calculam coordonatele obiectului pe ecran
        int screenY = Worldy - gp.player.Worldy + gp.player.screenY;//Calculam coordonatele obiectului pe ecran

        if (Worldx+gp.titlesize>gp.player.Worldx - gp.player.screenX &&
                Worldx<gp.player.Worldx + gp.player.screenX + gp.screenWidth &&
                Worldy+gp.titlesize>gp.player.Worldy - gp.player.screenY &&
                Worldy<gp.player.Worldy + gp.player.screenY + gp.screenHeight){



            BufferedImage image = jos;


            g.drawImage(image, screenX, screenY, gp.titlesize, gp.titlesize, null);



        }
        }

}
