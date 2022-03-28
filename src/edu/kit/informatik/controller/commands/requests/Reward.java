package edu.kit.informatik.controller.commands.requests;

/**
 * This class represents a request to reward a player.
 *
 * @author unyrg
 * @version 1.0
 */
public enum Reward {
    /**
     * The Reward to get new Cards
     */
    ABILITY("new ability cards"),
    /**
     * The Reward to update dice
     */
    DICE("next player dice");


    private final String reward;

    private Reward(String reward) {
        this.reward = reward;
    }

    /**
     * Returns the string representation of the enum.
     *
     * @return the string representation of the enum
     */
    public String getReward() {
        return reward;
    }
}
