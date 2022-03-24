package edu.kit.informatik.controller.commands.requests;

public abstract class InputRequest<T> {
    private T value;
    private AnswerFlag answerFlag = AnswerFlag.UNUSABLE;


    public abstract void process(String input);

    public T getValue() {
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    public void setAnswerFlag(AnswerFlag answerFlag) {
        this.answerFlag = answerFlag;
    }

    public AnswerFlag getAnswerFlag() {
        return answerFlag;
    }

    public abstract String getQuestion();
    public abstract String getAnswer();



}
