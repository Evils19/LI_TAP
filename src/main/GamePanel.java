package main;

import Entity.Entity;
import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel  implements Runnable{

//FPS-ul jocului
    int FPS = 60;
//Varibile pentru operatii_____________________________________________________
    int i;
//____________________________________________________________________________


//Sistemul jocului______________________________________________________________
final int  originalTileSize = 16;//16x16 pixels marimea obiectelor
final int scale = 3;//Este scara cu care marim jocul 16*3=48
  public  final int titlesize= originalTileSize*scale;//48X48  este marimea obiectelor
   public final int maxScreenCol = 16;//16 coloane
   public final  int maxScreenRow = 12;//12 randuri
   public final int screenWidth= maxScreenCol*titlesize;//16*48=768 pixeli
   public final int screenHeight= maxScreenRow*titlesize;//12*48=576 pixeli

    //Setarile pentru Harta lumii
    public  final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = maxWorldCol*titlesize;//50*48=2400 pixeli
    public final int worldHeight = maxWorldRow*titlesize;//50*48=2400 pixeli

    public UI ui = new UI(this);
    public  Sound sound = new Sound();
    Thread gamethread;
    public Event event = new Event(this);
  public   KeyHandler keyHandler = new KeyHandler(this);

    public  DetectorColision dc = new DetectorColision(this);
   public Player player = new  Player(this,keyHandler);
    TileManager tm = new TileManager(this);
  public   SetObject so = new SetObject(this);
    public Entity[] objects = new Entity[10];

    public Entity NPC[]= new Entity[10];
    public Entity Monstr[] = new Entity[20];
    public ArrayList<Entity> ProjectileList = new ArrayList<>();
    ArrayList<Entity> EntityList = new ArrayList<>();


    //________________________________________________________________________________


//Statult jocului_____________________________________________________________________
    public  int gameState;
    public  final int MENU_STATE = 1;
    public  final int PLAY_STATE = 2;
    public  final int Dialog_STATE = 3;
    public  final int CHARACTERIC_STATE = 4;



//____________________________________________________________________________________
  public  JLabel label = new JLabel();

    public GamePanel(){
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);//Dubleaza bufferul pentru a evita flickering-ul
        this.add(label);





    }



    public  void  setupGame(){
        so.SetObject();
        so.SetNPS();
        so.SetMonstrs();


        gameState = ui.TitleState;
        PlaySound(7);



    }//Seteaza obiectele in joc
//Thread-ul jocului
    public  void startGameThread(){
        gamethread = new Thread(this);//Creaza un nou thread care primeste acesata clasa
        gamethread.start();
    }

    //Thread-ul jocului_________________________________________________________
    @Override
    public void run() {
      double  Interval = 1000000000/FPS;
      long  TimpTrecut = System.nanoTime();
      long TimpCurent;
      double delta =0;//Cate cadre s-au facut
      int Cadre = 0;
      long timer=0;
        while(gamethread!=null){
    TimpCurent = System.nanoTime();
    delta+= (TimpCurent-TimpTrecut)/Interval;
    timer+= (TimpCurent-TimpTrecut);
    TimpTrecut = TimpCurent;

    if (delta>=1){
        update();
        repaint();
        delta--;
        Cadre++;
    }

    if (timer>=1000000000){
        System.out.println("FPS "+Cadre);
        Cadre=0;
        timer=0;
    }
        }



}
    public void update(){
        if (gameState == PLAY_STATE){

            for (int i=0;i<NPC.length;i++){
                if (NPC[i]!=null){
                    NPC[i].update();
                }
            }
            for (int i=0;i<Monstr.length;i++){
                if (Monstr[i]!=null){


                    if (Monstr[i].Alivie && !Monstr[i].Dying){
                        Monstr[i].update();
                    }
                    if (!Monstr[i].Alivie){
                        Monstr[i]=null;
                    }

                }
            }
            for(int i=0;i<ProjectileList.size();i++){
                if(ProjectileList.get(i)!=null){
                    if (ProjectileList.get(i).Alivie){
                        ProjectileList.get(i).update();
                    }
                    if (!ProjectileList.get(i).Alivie){
                       ProjectileList.remove(i);
                    }
                }
            }


            player.update();
        }





    }
    //____________________________________________________________________________

//Music______________________________________________________________

    public void PlaySound(int i){
        sound.SetFile(i);
        sound.Play();
        sound.Loop();
    }
    public void StopSound(){
        sound.Stop();
    }
    public  void playSE(int i){
        sound.SetFile(i);
        sound.Play();
    }



//____________________________________________________________________



//Desenarea jocului___________________________________________________
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2d2 = (Graphics2D) g;
//Title Display



        if (gameState==ui.TitleState) {

        ui.draw(g2d);
        }
        else {
//Blocuri
            tm.draw(g2d);

            EntityList.add(player);
            for (int i=0;i<NPC.length;i++){
                if (NPC[i]!=null){
                    EntityList.add(NPC[i]);
                }
            }

            for(int i=0;i<objects.length;i++){
                if (objects[i]!=null){
                    EntityList.add(objects[i]);
                }
            }

         for(int i=0;i<Monstr.length;i++){
             if(Monstr[i]!=null){
                 EntityList.add(Monstr[i]);
             }
         }
         for (int i=0;i<ProjectileList.size();i++){
                 if (ProjectileList.get(i)!=null){
                      EntityList.add(ProjectileList.get(i));
                 }
                }


            //Sort
            Collections.sort(EntityList,new Comparator<Entity>(){
                @Override
                public int compare(Entity o1, Entity o2) {
                 int result = Integer.compare(o1.Worldy, o2.Worldy);
                return result;

                }
            });

for (int i=0;i<EntityList.size();i++){
    EntityList.get(i).draw(g2d);
}
            EntityList.clear();



            //Jucator
          //  player.draw(g2d2);
            //UI
            ui.draw(g2d);


    }
}
}
//___________________________________________________________________