package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a heal request.
 *
 * @author unyrg
 * @version 1.0
 */
public class HealRequest extends InputRequest<List<Integer>> {
    private static final String QUESTION = "Runa (%d/%d HP) can discard ability cards for healing (or none)\n";
    private static final String ANSWER_SINGLE = "Enter number [1--2]:";
    private static final String ANSWER_MULTIPLE = "Enter numbers [1--%d] separated by comma:";
    private static final int MINIMUM_CARDS = 2;

    private final List<Card> playerCards;
    private final Player player;

    /**
     * Creates a new HealRequest.
     *
     * @param player      the player to heal
     * @param playerCards the cards of the player
     */
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
        if (!input.endsWith(",")) {
            if (playerCards.size() == MINIMUM_CARDS) {
                singleAnswer(input);
            } else {
                multipleAnswer(input);
            }
        } else {
            setAnswerFlag(AnswerFlag.INVALID);
        }
    }

    private void singleAnswer(String input) {
        if (validInput(input) || !(input.split(",").length >= 1)) {
            setAnswerFlag(AnswerFlag.INVALID);
            return;
        }
        setAnswerFlag(AnswerFlag.VALID);
        setValue(new ArrayList<>(List.of(Integer.parseInt(input) - 1)));

    }

    private boolean validInput(String input) {
        try {
            Set<Integer> set = new HashSet<>();
            for (String s : input.split(",")) {
                int number = Integer.parseInt(s);
                if (!(number > 0 && number <= playerCards.size()) || set.contains(number)) {
                    return true;
                }
                set.add(number);
            }
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void multipleAnswer(String input) {
        String[] split = input.split(",");
        if (validInput(input) || (split.length == playerCards.size())) {
            setAnswerFlag(AnswerFlag.INVALID);
            return;
        }
        setAnswerFlag(AnswerFlag.VALID);
        List<Integer> cards = new ArrayList<>();
        for (String index : split) {
            cards.add(Integer.parseInt(index) - 1);
        }
        Collections.sort(cards);
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