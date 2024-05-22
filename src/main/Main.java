package main;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Inchide aplicatia cand apasam pe X
        window.setResizable(false);//Nu spoate de schimbat marimea ferestrei
        window.setTitle("Lucru individual TAP");
        GamePanel gp = new GamePanel();
//
//        LoginForm loginForm = new LoginForm(window, gp);
//        loginForm.setVisible(true);


        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);











        gp.setupGame();
        gp.startGameThread();
    }
    }
