package guitar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static guitar.Finding_Notes.getSolution;
import static guitar.Finding_Notes.instr;
import static guitar.Finding_Notes.nextTask;

public class Gui {
    private JTextArea taskField;
    private JTextArea solutionField;
    private JButton solutionNext;
    private JButton start;
    private JComboBox choices;
    private JButton instructions;
    private JPanel panel;

    private int mode = 99;
    private boolean started = false;



    public static void main(String[] args) {
        JFrame frame = new JFrame("One");
        frame.setContentPane(new Gui().panel);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.pack();
        frame.setVisible(true);
    }

    public Gui(){

        //Instructions
        instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, instr);
            }
        });

        //Start Knopf
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                started = true;

                switch (choices.getSelectedIndex()){
                    case 0: mode = 10;
                    break;
                    case 1: mode = 5;
                    break;
                    case 2: mode = 999999999;
                }

                taskField.setText(null);
                taskField.setText(nextTask());
            }
        });

        // Lösung / Weiter
        solutionNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!started){
                    JOptionPane.showMessageDialog(null, "Wähle zunächst einen Modus und drücke Start.");
                } else {
                    if(solutionField.getText().trim().equals("")){
                        solutionField.setText(getSolution());
                    } else {
                        solutionField.setText(null);
                        taskField.setText(null);
                        mode -= 1;
                        if(mode == 0){
                            started = false;
                            JOptionPane.showMessageDialog(null,"Bravo! Du hast diese Runde abgeschlossen.\nWähle einen Modus und drücke Start.");
                        } else {
                            taskField.setText(nextTask());
                        }
                    }

                }
            }
        });

        // Die Text Felder
        taskField.setFont(new Font("Arial", Font.PLAIN, 15));
        solutionField.setFont(new Font("Arial", Font.PLAIN, 15));

    }
}
