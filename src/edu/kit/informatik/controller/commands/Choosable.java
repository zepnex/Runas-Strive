package edu.kit.informatik.controller.commands;


import java.util.List;

public abstract class Choosable {
    public String question;
    public List<String> answers;

    public abstract void printQuestion();

    public abstract void printAnswer();

    public abstract void printChoices();

    public abstract void execute(String input);

    public abstract boolean apply(String input);

}
