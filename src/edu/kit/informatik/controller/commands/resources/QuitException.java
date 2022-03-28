package edu.kit.informatik.controller.commands.resources;

/**
 * This exception is thrown when the user unexpectedly wants to quit instead of the expected input
 */
public class QuitException extends Exception {

    /**
     *  The Constructor for the Exception
     */
    public QuitException() {
        super();
    }
}
