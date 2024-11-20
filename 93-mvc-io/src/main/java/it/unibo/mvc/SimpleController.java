package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of interface Controller.
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history;

    /**
     * Constructor of SimpleController.
     */
    public SimpleController() {
        this.currentString = "";
        this.history = new LinkedList<>();
    }

    @Override
    public void setString(final String stringToPrint) {
        if (stringToPrint.isEmpty()) {
            throw new IllegalArgumentException("The string cannot be null");
        }
        this.currentString = stringToPrint;
        history.add(stringToPrint);
    }

    @Override
    public String getNextString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        return new LinkedList<>(history);
    }

    @Override
    public void printCurrentString() {
        if (currentString.isEmpty()) {
            throw new IllegalStateException("The current string is unset");
        }
        history.add(currentString);
        System.out.println(currentString); //NOPMD: print in stdout is allowed
    }

}
