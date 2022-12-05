package GameMaterial;

import Gameplay.Player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public static final int numberofDice = 6;

    private int dice;

    public void rollDice() {
        this.dice = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    public int getDice() {
        return this.dice;
    }

    public Dice(int num) {
        this.dice = num;
    }

    public Dice() {
    }

    public void throwDice() {
    }

    public static class DicesOut {
        private ArrayList<Dice> dicesArray = new ArrayList<Dice>();

        public DicesOut() {

        }

        public ArrayList<Dice> getDicesArray() {
            return this.dicesArray;
        }

        public void addDice(Dice dice) {
            this.dicesArray.add(dice);
        }

        public void removeDice(int position) {
            this.dicesArray.remove(position);
        }
    }

    public static class DicesIn {
        private ArrayList<Dice> dicesArray = new ArrayList<Dice>();

        public DicesIn(){
            for (int i = 0; i < Player.TOTALNUMDICES; i++){
                Dice d=new Dice();
                this.dicesArray.add(d);
            }
        }

        public ArrayList<Dice> getDicesArray(){
            return this.dicesArray;
        }

        public void addDice(Dice dice){
            this.dicesArray.add(dice);
        }

        public void removeDice(int diceN){
            for (int i=0;i<dicesArray.size();i++) {
                if (diceN==dicesArray.get(i).getDice()) {
                    dicesArray.remove(i);
                    return;
                }
            }
        }
    }
}
