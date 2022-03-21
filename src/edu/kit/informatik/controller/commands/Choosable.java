package edu.kit.informatik.controller.commands;


public abstract class Choosable {

    public abstract void printQuestion();

    public abstract void printAnswer();

    public abstract void printChoices();

    public abstract void execute(String input);

    public abstract boolean apply(String input);

}
