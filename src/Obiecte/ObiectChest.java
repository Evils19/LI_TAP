package Obiecte;

import javax.imageio.ImageIO;

public class ObiectChest extends SuperObject {

    public ObiectChest() {
        name = "Сhest";
        try {
            objectImage = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/chest.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
