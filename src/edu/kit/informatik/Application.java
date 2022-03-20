package edu.kit.informatik;

import edu.kit.informatik.controller.Session;


public final class Application {
    private static final String ERROR_UTILITY_CLASS_INSTANTIATION = "Utility class cannot be instantiated.";

    private Application() {
        throw new AssertionError(ERROR_UTILITY_CLASS_INSTANTIATION);
    }


    public static void main(String[] args) {
        if (args.length > 0) {
            throw new IllegalArgumentException("Error: can't handle any arguments");
        } else {
            Session session = new Session();
            session.start();
        }

    }


}
