package it.unibo.mvc;

import java.util.List;

/**
 * It must model a simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * A method for setting the next string to print. 
     * Null values are not acceptable, and an exception should be produced
     * @param stringToPrint
     */
    void setString (String stringToPrint);

    /**
     * A method for getting the next string to print.
     * @return the next string to print
     */
    String getNextString ();

    /**
     * A method for getting the history of the printed strings.
     * @return a list of printed strings.
     */
    List<String> getHistory();

    /**
     * A method that prints the current string.
     * @throws IllegalStateException if the current string is unset.
     */
    void getCurrentString();
    

}
