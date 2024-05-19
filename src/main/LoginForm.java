package main;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginForm extends JFrame {
    private JTextField emailField;
    private JTextField GrupaAcadem;
    private JLabel statusLabel;
    private Font font;
    private KeyHandler keyHandler;
    GamePanel gp;
    private BufferedImage bgImage;
    public LoginForm(JFrame frame, GamePanel gp) {
        setTitle("Login Form");
        setResizable(false);
        setSize(520, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            font= Font.createFont(Font.TRUETYPE_FONT, new File("src/Resurce/Minecraft.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        gp.playSE(8);

        try {
            bgImage = ImageIO.read(new File("src/Schin/Title.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        //Background transparet 50% pentru conteiner grid
        panel.setBackground(new Color(200, 200, 200, 200)); // 128 reprezintă 50% opacitate

        //Adaugam fundal
        JLabel background = new JLabel(new ImageIcon(bgImage));//Acest label va contine imaginea de fundal in format ImageIcon deoaerece aceasta clasa nu accepta BufferedImage ca parametru
        background.setLayout(new GridBagLayout());//Setam layout-ul label-ului ca GridBagLayout asta pentru a putea adauga alte componente in el
        setContentPane(background);//Setam ca panel-ul principal sa fie label-ul cu imaginea de fundal





        JLabel titleLabel = new JLabel("AUTENTIFICARE");

        titleLabel.setFont(font.deriveFont(Font.BOLD, 36.0f));

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;



        panel.add(titleLabel, constraints);


        JLabel emailLabel = new JLabel("EMAIL-UTM:");
        emailLabel.setFont(font.deriveFont(Font.BOLD, 15.0f));
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(emailLabel, constraints);

        emailField = new JTextField(20);
        constraints.gridx = 1;
        //Coloarea alba a textului
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Adaugă un contur
        emailField.setBackground(Color.LIGHT_GRAY); // Schimbă culoarea fundalului
        emailField.setForeground(Color.BLACK); // Schimbă culoarea textului


        panel.add(emailField, constraints);


        JLabel passwordLabel = new JLabel("GRUPA:");
        passwordLabel.setFont(font.deriveFont(Font.BOLD, 15.0f));
        constraints.gridx = 0;
        constraints.gridy = 2;


        panel.add(passwordLabel, constraints);

        GrupaAcadem = new JTextField(20);
        constraints.gridx = 1;

        GrupaAcadem.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Adaugă un contur
        GrupaAcadem.setBackground(Color.LIGHT_GRAY); ; // Schimbă culoarea fundalului
        GrupaAcadem.setForeground(Color.BLACK); // Schimbă culoarea textului

        panel.add(GrupaAcadem, constraints);


        JLabel loginLabel = new JLabel("CONECTARE");
        loginLabel.setFont(font.deriveFont(Font.BOLD, 15.0f));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(loginLabel, constraints);




        statusLabel = new JLabel("", SwingConstants.CENTER);
        constraints.gridy = 4;
        panel.add(statusLabel, constraints);



        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = emailField.getText();
                String GrupaAad = GrupaAcadem.getText();
                String regex = "^(FAF|[AICRMT]{2})(-\\d{3}(?:\\.\\d{1,2})?)$";

                // Verificarea email-ului și a parolei
                Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]{2,3}\\.utm\\.md$");
                Matcher matcher = pattern.matcher(email);
                Pattern pattern2 = Pattern.compile(regex);
                Matcher matcher2 = pattern2.matcher(GrupaAad);

                if (matcher.matches() && matcher2.matches()) {
                    statusLabel.setForeground(Color.GREEN);
                    statusLabel.setText("Login successful!");

                    gp.StopSound();
                    dispose();

                    frame.add(gp);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    gp.setupGame();
                    gp.startGameThread();

                } else if (!matcher.matches()) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Posta corporativa gresita!");
                    statusLabel.setFont(font.deriveFont(Font.BOLD, 25.0f));
                    shakeForm();
                } else if (!matcher2.matches()) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Grupa academica gresita!");
                    statusLabel.setFont(font.deriveFont(Font.BOLD, 25.0f));
                    shakeForm();
                }
            }
        });

        add(panel);
    }

    private void shakeForm() {
        Point originalLocation = getLocation();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
                setLocation(originalLocation.x + 5, originalLocation.y);
                Thread.sleep(20);
                setLocation(originalLocation.x - 5, originalLocation.y);
                Thread.sleep(20);
                setLocation(originalLocation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
