package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first Java graphical interface");
    private final Controller controller = new Controller();
    private final static int PROPORTION = 5;

    /**
     * Constructor of SimpleGUI
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);
        final JTextArea text = new JTextArea(10, 20);
        panel.add(text, BorderLayout.CENTER);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.save(text.getText());
                    JOptionPane.showMessageDialog(frame, "The string is saved!", "Modify file", JOptionPane.INFORMATION_MESSAGE);
                    text.setText("");
                } catch (IOException e1){
                    JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalAccessError e2){
                    JOptionPane.showMessageDialog(frame, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }  
        });
        this.frame.setContentPane(panel);
    }

    /**
     * Method for set the dimentions of the screen 
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI sGui = new SimpleGUI();
        sGui.display();
    }
}
