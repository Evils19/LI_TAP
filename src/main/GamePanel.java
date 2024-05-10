package main;

import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel  implements Runnable{

//FPS-ul jocului
    int FPS = 60;
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


    Thread gamethread;
    KeyHandler keyHandler = new KeyHandler();


   public Player player = new Player(this,keyHandler);
    TileManager tm = new TileManager(this);

  public  JLabel label = new JLabel();

    public GamePanel(){
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);//Dubleaza bufferul pentru a evita flickering-ul
        this.add(label);



    }


    public  void startGameThread(){
        gamethread = new Thread(this);//Creaza un nou thread care primeste acesata clasa
        gamethread.start();
    }
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

        player.update();


    }







    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2d2 = (Graphics2D) g;


        tm.draw(g2d);
        player.draw(g2d2);


    }
}
