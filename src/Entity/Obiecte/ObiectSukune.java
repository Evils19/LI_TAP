package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class ObiectSukune extends Entity {




    public ObiectSukune(GamePanel gp) {
        super(gp);
        nameObject = "Sukune";

        try {
            jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/sukune.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
