package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My second Java graphical interface");
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();

    /**
     * Constructor of Controller.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);
        final JTextArea text = new JTextArea(10, 20);
        panel.add(text, BorderLayout.CENTER);
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        frame.add(northPanel, BorderLayout.NORTH);
        final JTextField textField = new JTextField(controller.getPathDestination());
        textField.setEditable(false);
        final JButton browser = new JButton();
        browser.setText("Browse...");
        northPanel.add(browser, BorderLayout.LINE_END);
        northPanel.add(textField, BorderLayout.WEST);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.save(text.getText());
                    JOptionPane.showMessageDialog(frame, "The string is saved!", "Modify file", JOptionPane.INFORMATION_MESSAGE);
                    text.setText("");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        browser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(browser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooser.getSelectedFile());
                    textField.setText(controller.getPathDestination());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error has occured!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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

    /**
     * Main method that starts the graphical application.
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser sGUI2 = new SimpleGUIWithFileChooser();
        sGUI2.display();

    }
}
