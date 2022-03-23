package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;
import edu.kit.informatik.model.enteties.PlayerClass;

import java.util.List;

public class CombatRound extends Choosable {
    private static final String ABILITY = "Runa uses";
    private static final String QUESTION = "Enter dice roll [1--6]:";
    private List<PlayerClass> answers;
    private Player player;
    private List<Monster> monsters;
    private Monster target;

    public CombatRound(Player player, List<Monster> monsters, Monster target) {
        this.player = player;
        this.monsters = monsters;
        this.target = target;

    }

    @Override
    public void printQuestion() {

    }

    @Override
    public void printAnswer() {
        System.out.printf("%s %s(%d) \n", ABILITY, this.player.getCurrentAttackCard().getName(),
            this.player.getAbilityLevel());
    }

    @Override
    public void printChoices() {
        System.out.println(QUESTION);
    }

    private void monsterAttack() {
        for (Monster monster : this.monsters) {
            Card ability = monster.getAbilities().element();
            if (ability.getType().equals(CardType.OFFENSIVE)) {
                monster.getAbilities().add(monster.getAbilities().poll());
                this.player.dealDamage(((OffensiveCard) ability).getDamage(ability.getAbilityLevel(), 0));
                System.out.printf("");
            } else {
                //Focus or defensive card

            }
        }
    }

    @Override
    public void execute(String input) {

        Card card = this.player.getCurrentAttackCard();
        if (card.getType().equals(CardType.OFFENSIVE)) {
            target.dealDamage(((OffensiveCard) card).getDamage(this.player.getAbilityLevel(), Integer.parseInt(input)));
            if(card.getType().equals())
            System.out.printf("%s\n takes phy. dm", this.target.getName());
        } else {
            //Focus or defensive card\
            //TODO: well just do nothing


        }
    }

    @Override
    public boolean apply(String input) {
        //TODO: properly set dice
        if (input.matches("[1-6]")) {
            execute(input);
            return true;
        }
        return false;
    }
}
