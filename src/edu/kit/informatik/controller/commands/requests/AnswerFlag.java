package edu.kit.informatik.controller.commands.requests;

/**
 * This class represents AnswerFlag for requests.
 */
public enum AnswerFlag {
    /**
     * The flag is set to UNUSABLE if the answer is correct.
     */
    INVALID,
    /**
     * The flag is set to QUIT if the input is quit.
     */
    QUIT,
    /**
     * The flag is set to VALID if the answer is correct.
     */
    VALID
}

