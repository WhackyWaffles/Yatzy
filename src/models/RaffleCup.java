package models;

public class RaffleCup {
    private Die[] dice = new Die[4];

    public RaffleCup() {
        RaffleCup raflebaeger = new RaffleCup();
        for (int i = 0; i <= dice.length; i++) {
            dice[i] = new Die();
        }
        //DONE: Create an instance of RaffleCup.
    }

    public void throwDice() {
        for (int i = 0; i <= dice.length; i++) {
            dice[i].roll();
        }
        //DONE: implement throwDice method.
    }

    public Die[] getDice() {
        return dice;
    }
}
