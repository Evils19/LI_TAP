package Entity.Obiecte;

import Entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class ObiectKey extends Entity {

    public ObiectKey(GamePanel gp) {
        super(gp);
        nameObject = "Key";
        Description= "Cheie necunocuta";
      try {
          jos[0] = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/key.png"));
      }
      catch (Exception e){
          e.printStackTrace();      }



}
}
