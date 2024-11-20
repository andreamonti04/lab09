package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEP = File.separator;
    private static final String FILE_NAME = System.getProperty("user.home") + SEP + "output.txt";
    private File currentFile;

    /**
     * Constructor of Controller.
     * Set a @param FILE_NAME for the initial name of current file
     */
    public Controller() {
        this.currentFile = new File(FILE_NAME);
    }

    /**
     * Sets a File as a current file.
     * @param dfile
     */
    public void setCurrentFile(final File dfile) {
        this.currentFile = dfile;
    }

    /**
     * Gets the current File.
     * @return the current file
     */
    public File getcurrentFile() {
        return currentFile;
    }

    /**
     * Gets the path (in form of String) of the current `File`.
     * @return the current file path
     */
    public String getPathDestination() {
        return currentFile.getPath();
    }

    /**
     * Gets a `String` as input and saves its content on the current file.
     * @throws IOException
     * @param adder
     */
    public void save(final String adder) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            if (adder.isEmpty()) {
                ps.close();
                throw new IllegalArgumentException("The string is empty");
            }
            ps.println(adder);
        }
    }
}
