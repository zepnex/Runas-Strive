package edu.kit.informatik.controller.commands.requests;

/**
 * This class represents a request to get input from the user.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class InputRequest<T> {
    private T value;
    private AnswerFlag answerFlag = AnswerFlag.INVALID;

    /**
     * This method is used to process the input.
     *
     * @param input the input to process
     */
    public abstract void process(String input);

    /**
     * This method returns the value of the processed input.
     *
     * @return the value of the processed input
     */
    public T getValue() {
        return value;
    }

    /**
     * This method sets the value of the processed input.
     *
     * @param value the value of the processed input
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * This method sets the answer flag.
     *
     * @param answerFlag the answer flag
     */
    public void setAnswerFlag(AnswerFlag answerFlag) {
        this.answerFlag = answerFlag;
    }

    /**
     * This method returns the answer flag.
     *
     * @return the answer flag
     */
    public AnswerFlag getAnswerFlag() {
        return answerFlag;
    }

    /**
     * This methode builds the question with its answer options.
     *
     * @return the question
     */
    public abstract String getQuestion();

    /**
     * This method returns the format, how the player should enter its answer.
     *
     * @return the format
     */
    public abstract String getAnswer();


}
