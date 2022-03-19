package edu.kit.informatik.controller.commands.resources;

public enum ErrorMessage {
    /**
     * The error message printed if a player enters an blank string as command.
     */
    EMPTY_COMMAND("please enter a command."),
    ILLEGAL_ARGUMENT_COUNT("expected %d argument(s) but got %d."),
    COMMAND_NOT_FOUND("there is no command called '%s'.");

    private static final String PREFIX = "Error, ";
    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return PREFIX + String.format(this.message, args);
    }

    @Override
    public String toString() {
        return PREFIX + this.message;
    }
}
