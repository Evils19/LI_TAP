package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class ObiectHp extends Entity {

    public ObiectHp(GamePanel gp) {
          super(gp);
            nameObject = "Hp";
            try {
                jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_full.png"));
                jos[1] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_half.png"));
                jos[2] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_blank.png"));
            }
            catch (Exception e){
                e.printStackTrace();



    }

}
}
