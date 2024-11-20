package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("Simple GUI");
    private final SimpleController controller = new SimpleController();
    private static final int PROPORTION = 5;

    /**
     * Constructor of SimpleGUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        final JTextField textField = new JTextField("Text Field");
        panel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea("Text Area:\n");
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show history");
        final JPanel button = new JPanel();
        panel.add(button, BorderLayout.SOUTH);
        button.setLayout(new FlowLayout(FlowLayout.CENTER));
        button.add(show);
        button.add(print);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.setString(textField.getText());
                    controller.printCurrentString();
                    textField.setText("");
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    for (final String text : controller.getHistory()) {
                        textArea.append(text + "\n");
                    } 
                } catch (NoSuchElementException e2) {
                    JOptionPane.showMessageDialog(frame, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        //frame.pack();
    }

    /**
     * Method for set the dimentions of the screen.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Main method that starts the graphical application.
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI sGUI = new SimpleGUI();
        sGUI.display();
    }
}
