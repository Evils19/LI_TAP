package Entity.Weapon;

import Entity.Entity;
import main.GamePanel;

public class Item_Sword extends Entity {
    public Item_Sword(GamePanel gp) {
        super(gp);
        nameObject = "Normal_Sword";
        SwordPower = 3;
        jos[0] =SetupObject("sword_normal");
        Description = "Sabie obisnuta optinuta prin\nmostenire";

    }




}
