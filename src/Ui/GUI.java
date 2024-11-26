package Ui;

import Domain.Ki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private Willkomensnachricht uiLogik;
    int count = 0;
    JLabel label;
    private int errateZahl;
    private ArrayList<Integer> versuchHistory;
    private Ki quantom;
    JTextField inputField;
    JLabel resultLabel;
    JFrame frame;
    JButton submitButton;
    private JTextArea outputArea;
    JButton restartButton;


    public GUI() {
        uiLogik = new Willkomensnachricht();
        versuchHistory = new ArrayList<>();
        quantom = new Ki();
        frame = new JFrame();

        JPanel panel = new JPanel();

        inputField = new JTextField();
        inputField.setBounds(100,20,165,25);
        inputField.setToolTipText("Gib eine Zahl zwischen 1 und 100 ein");
        panel.add(inputField);

        submitButton = new JButton("Raten");
        submitButton.setBounds(100,22,165,25);
        panel.add(submitButton);

        outputArea = new JTextArea(20,30);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        panel.add(new JScrollPane(outputArea));

        label = new JLabel("Versuch History : 0 ");
        panel.add(label);

        restartButton = new JButton("restart");
        restartButton.setBounds(100,22,165,25);
        restartButton.setBackground(Color.orange);
        panel.add(restartButton);

        //create new border object to create a new border
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,10,40));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zahlenraten Spiel");
        frame.pack();
        frame.setVisible(true);

        outputArea.append("Ich habe eine Zahl zwischen 1 und 100 gewählt. Kannst du sie erraten?\n");

        restartButton.addActionListener(e -> resetGame());

            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Hole Benutzereingabe und konvertiere in eine Zahl
                        errateZahl = Integer.parseInt(inputField.getText());
                        versuchHistory.add(errateZahl);
                        count++;
                        label.setText("Versuch History : " + count);
                        if (errateZahl < quantom.zahlRandomErraten()) {
                            outputArea.append("Dein Tipp: " + errateZahl + " ist zu niedrig! Versuche es erneut.\n");
                        } else if (errateZahl > quantom.zahlRandomErraten()) {
                            outputArea.append("Dein Tipp: " + errateZahl + " ist zu hoch! Versuche es erneut.\n");
                        } else {
                            outputArea.append("Herzlichen Glückwunsch! Du hast die Zahl erraten in " + count + " Versuchen.\n");
                            outputArea.append("Deine Versuche: " + versuchHistory + "\n");
                            return; // Spiel beenden
                        }

                        // Maximale Versuche erreicht
                        if (count >= 10) {
                            outputArea.append("Du hast die maximale Anzahl von Versuchen erreicht. Das Spiel ist vorbei.\n");
                            submitButton.setEnabled(false);
                        }

                    } catch (NumberFormatException ex) {
                        outputArea.append("Bitte gib eine gültige Zahl ein.\n");
                    } finally {
                        inputField.setText(""); // Eingabefeld leeren
                    }

                }
            });
    }
        private void resetGame(){
            count = 0;
            errateZahl = 0;
            versuchHistory.clear();
            quantom = new Ki();
            outputArea.setText("Neues Spiel gestartet! Ich habe eine Zahl zwischen 1 und 100 gewählt.\n");
            inputField.setText("");
        }

    public static void main(String[] args){
        new GUI();

    }


}
