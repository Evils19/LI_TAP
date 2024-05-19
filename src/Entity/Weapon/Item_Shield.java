package Entity.Weapon;
import Entity.Entity;
import main.GamePanel;

public class Item_Shield extends Entity{



    Item_Shield(GamePanel gp){
        super(gp);
        DefenseValue =5;
        nameObject = "Shield";
        jos[0] =SetupObject("shield_wood");
        jos[1] =jos[0];
        jos[2] =jos[0];
        jos[3] =jos[0];

    }



}
