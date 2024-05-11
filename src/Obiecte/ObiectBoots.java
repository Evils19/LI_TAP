package Obiecte;

import javax.imageio.ImageIO;

public class ObiectBoots extends SuperObject{

    public ObiectBoots() {
        name = "Boots";
        try {
            objectImage = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/boots.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }


}
