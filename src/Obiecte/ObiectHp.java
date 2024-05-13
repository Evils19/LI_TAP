package Obiecte;

import javax.imageio.ImageIO;

public class ObiectHp extends SuperObject {


    public ObiectHp() {
        name = "Hp";
        try {
            objectImage = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_full.png"));
            objectImage2 = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_half.png"));
            objectImage3 = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/heart_blank.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

}
