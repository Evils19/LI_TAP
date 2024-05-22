package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class ObiectManaCristal extends Entity {
    public ObiectManaCristal(GamePanel gp) {
        super(gp);
        nameObject = "ManaCristal";
        try {
            jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/manacrystal_blank.png"));
            jos[1] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/manacrystal_full.png"));

        }
        catch (Exception e){
            e.printStackTrace();



        }
    }
}
