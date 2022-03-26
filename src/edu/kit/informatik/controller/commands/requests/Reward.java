package edu.kit.informatik.controller.commands.requests;

public enum Reward {
    ABILITY("new ability cards"),
    DICE("next player dice");


    private final String reward;

    private Reward(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }
}
