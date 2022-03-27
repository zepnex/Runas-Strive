package edu.kit.informatik;

import edu.kit.informatik.controller.Session;
import edu.kit.informatik.controller.commands.resources.QuitException;


public final class Main {
    private static final String ERROR_UTILITY_CLASS_INSTANTIATION = "Utility class cannot be instantiated.";

    private Main() {
        throw new AssertionError(ERROR_UTILITY_CLASS_INSTANTIATION);
    }


    public static void main(String[] args) {

        if (args.length > 0) {
            System.err.println("Error, Invalid number of arguments.");
        } else {
            Session session = new Session();
            try {
                session.start();
            } catch (QuitException e) {
                return;
            }
        }
    }
}
