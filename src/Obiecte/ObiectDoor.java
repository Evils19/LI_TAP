package Obiecte;

import javax.imageio.ImageIO;

public class ObiectDoor  extends SuperObject{

    public ObiectDoor() {
        name = "Door";
        try {
            objectImage = ImageIO.read(getClass().getResourceAsStream("/Schin/Object/door.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        collision = true;



    }

}
