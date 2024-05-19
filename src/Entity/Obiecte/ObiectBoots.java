package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class ObiectBoots extends Entity {


    public ObiectBoots(GamePanel gp) {
        super(gp);
        nameObject = "Boots";
        try {
            jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/boots.png"));
        }
        catch (Exception e){

            e.printStackTrace();
        }



    }
}
