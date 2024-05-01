package main;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

JFrame window = new JFrame();
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Inchide aplicatia cand apasam pe X
window.setResizable(false);//Nu spoate de schimbat marimea ferestrei
window.setTitle("Snake Game");
GamePanel gamePanel = new GamePanel();
window.add(gamePanel);
window.pack();//Face fereastra sa fie de dimensiunea main.GamePanel

window.setLocationRelativeTo(null);//Fixam fereastra in mijlocul ecranului
        window.setVisible(true);
        gamePanel.startGameThread();




        }
    }
