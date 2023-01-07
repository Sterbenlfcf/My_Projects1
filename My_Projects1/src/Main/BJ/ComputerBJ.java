package Main.BJ;

import Main.Deck;

import java.util.Random;

public class ComputerBJ extends PlayerBJ {

    public ComputerBJ(String name){
        super(name);
    }

    @Override
    public void DrawCard(Deck deck, Rule rule) {
        Random random = new Random();
        int number;
        number = random.nextInt(deck.deckSize() - 1) + 1;
//        System.out.println("Drew the " + number + "th card from the top");
        addDrawCard(deck.Draw(number));
    }

    public void openCard() {
        System.out.println();
        String mark = this.drawList.get(0).getMark();
        int num = this.drawList.get(0).getNumber();
        if (num == 1) {
            System.out.println(super.getName() + "'s open card is A of " + mark + "s");
        } else if (num == 11) {
            System.out.println(super.getName() + "'s open card is J of " + mark + "s");
        } else if (num == 12) {
            System.out.println(super.getName() + "'s open card is Q of " + mark + "s");
        } else if (num == 13) {
            System.out.println(super.getName() + "'s open card is K of " + mark + "s");
        } else {
            System.out.println(super.getName() + "'s open card is " + num + " of " + mark + "s");
        }
    }

}
