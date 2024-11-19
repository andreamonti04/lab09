package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    public static final String SEP = File.separator;
    public static final String FILE_NAME = System.getProperty("user.home") + SEP + "output.txt";
    private File destination;

    public Controller(){
        this.destination = new File(FILE_NAME);
    }

    /**
     * A method for setting a File as a current file
     * @return setting file
     */
    public void setDestination(final File dfile){
        setDestination(dfile);
    }

    /**
     * A method for getting the current File
     * @return the current file
     */
    public File getDestination() {
        return destination;
    }

    /**
     * A method for getting the path (in form of String) 
     * of the current `File`
     * @return the current file path
     */
    public String getPathDestination(){
        return destination.getPath();
    }

    /**
     * A method that gets a `String` as input and 
     * saves its content on the current file.
     * @throws IOException
     */
    public void save (final String adder) throws IOException{
        try(PrintStream ps = new PrintStream(destination)){
    
        }

    }

    
    





}
