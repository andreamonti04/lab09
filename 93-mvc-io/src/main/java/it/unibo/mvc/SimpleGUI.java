package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();
    private static final int PROPORTION = 5;

    public SimpleGUI(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        final JPanel southPanel = new JPanel(new BorderLayout());
        final JButton print = new JButton("Print");
        southPanel.add(print, BorderLayout.SOUTH);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.setString(textField.getText());
                    controller.getCurrentString();
                    textField.setText("");
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final JButton show = new JButton("Show history");
        southPanel.add(show, BorderLayout.SOUTH);
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (final String text : controller.getHistory()) {
                        textArea.append(text + "\n");
                    } 
                } catch (NoSuchElementException e2) {
                    JOptionPane.showMessageDialog(frame, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(panel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
    }

    /**
     * Method for set the dimentions of the screen.
     */
    public void display() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        final SimpleGUI sGUI = new SimpleGUI();
        sGUI.display();
    }
}
