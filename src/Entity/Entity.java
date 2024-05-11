package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public  int Worldx, Worldy;
    public  int speed;


public BufferedImage objectImage;
    public BufferedImage [] sus = new BufferedImage[4];
    public BufferedImage [] jos = new BufferedImage[4];
    public BufferedImage [] stanga = new BufferedImage[4];
    public BufferedImage [] dreapta = new BufferedImage[4];
    public Rectangle coliziune;
    public String direction="sus";
    public  boolean collision = false;
    public  boolean ObjCollision = false;

    public int  SolidDefaultX, SolidDefaultY;

}
