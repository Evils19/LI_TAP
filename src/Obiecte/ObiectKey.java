package Obiecte;

import javax.imageio.ImageIO;

public class ObiectKey extends SuperObject {
    public ObiectKey() {
      name = "Key";
      try {
          objectImage = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/key.png"));
      }
      catch (Exception e){
          e.printStackTrace();
      }



}
}
