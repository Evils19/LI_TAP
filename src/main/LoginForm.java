package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JTextField GrupaAcadem;
    private JLabel statusLabel;

    public LoginForm(JFrame frame, GamePanel gp) {
        setTitle("Login Form");
        setSize(520, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Autentificare in joc");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(titleLabel, constraints);

        JLabel emailLabel = new JLabel("Posta Corporativa:");
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(emailLabel, constraints);

        emailField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(emailField, constraints);

        JLabel passwordLabel = new JLabel("Grupa Academica:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(passwordLabel, constraints);

        GrupaAcadem = new JTextField(20);
        constraints.gridx = 1;
        panel.add(GrupaAcadem, constraints);

        JButton loginButton = new JButton("Intra in joc");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);

        statusLabel = new JLabel("", SwingConstants.CENTER);
        constraints.gridy = 4;
        panel.add(statusLabel, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    shakeForm();
                }
                else if (!matcher2.matches()) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Grupa academica gresita!");
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
