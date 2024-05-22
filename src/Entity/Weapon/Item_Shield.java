package Entity.Weapon;
import Entity.Entity;
import main.GamePanel;

public class Item_Shield extends Entity{



    public Item_Shield(GamePanel gp){
        super(gp);
        type=type_Shield;
        DefenseValue =1;
        nameObject = "Shield";
        jos[0] =SetupObject("shield_wood");
        Description = "Scut obisnut optinut prin\nmostenire";

    }



}
