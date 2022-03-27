package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Player;

import java.util.ArrayList;
import java.util.List;

public class HealRequest extends InputRequest<List<Card>> {
    private static final String QUESTION = "Runa (%d/%d HP) can discard ability cards for healing (or none)\n";
    private static final String ANSWER_SINGLE = "Enter number [1--2]:";
    private static final String ANSWER_MULTIPLE = "Enter numbers [1--%d] separated by comma:";
    private static final String REGEX = "(\\d+,)*\\d";
    private static final String SINGLE_REGEX = "[1-2]";
    private static final String MULTIPLE_REGEX = "[1-%d]";

    private final List<Card> playerCards;
    private final Player player;

    public HealRequest(Player player, List<Card> playerCards) {
        this.playerCards = playerCards;
        this.player = player;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
            return;
        }
        if (input.isEmpty()) {
            setAnswerFlag(AnswerFlag.VALID);
            setValue(new ArrayList<>());
            return;
        }
        if (input.matches(REGEX)) {
            if (playerCards.size() == 2) {
                singleAnswer(input);
            } else {
                multipleAnswer(input);
            }
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
    }

    private void singleAnswer(String input) {
        if (!input.matches(SINGLE_REGEX) && !(input.split(",").length == 1)) {
            setAnswerFlag(AnswerFlag.UNUSABLE);
            return;
        }
        setAnswerFlag(AnswerFlag.VALID);
        setValue(new ArrayList<>(List.of(playerCards.get(Integer.parseInt(input) - 1))));

    }

    private void multipleAnswer(String input) {
        String[] split = input.split(",");
        if (!input.matches(String.format(MULTIPLE_REGEX, playerCards.size())) && !(split.length < playerCards.size())) {
            setAnswerFlag(AnswerFlag.UNUSABLE);
            return;
        }
        setAnswerFlag(AnswerFlag.VALID);
        List<Card> cards = new ArrayList<>();
        for (String index : split) {
            cards.add(playerCards.get(Integer.parseInt(index) - 1));
        }
        setValue(cards);
        setAnswerFlag(AnswerFlag.VALID);
    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(
                String.format(QUESTION, this.player.getCurrentHp(), this.player.getMaxHp()));
        for (int i = 0; i < playerCards.size(); i++) {
            builder.append(String.format("%d) %s\n", i + 1, playerCards.get(i).toString()));
        }
        return builder.toString();
    }

    @Override
    public String getAnswer() {
        if (playerCards.size() > 2) {
            return String.format(ANSWER_MULTIPLE, playerCards.size());
        }
        return ANSWER_SINGLE;
    }
}