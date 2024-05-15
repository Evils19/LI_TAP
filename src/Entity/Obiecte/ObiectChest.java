package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;
import javax.imageio.ImageIO;

public class ObiectChest extends Entity {

    public ObiectChest(GamePanel gp) {
        super(gp);
        nameObject = "Сhest";
        try {
            jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/chest.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
