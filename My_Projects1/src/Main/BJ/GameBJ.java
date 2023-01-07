package Main.BJ;

import Main.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class GameBJ {

    private final Deck deck = new Deck();
    private final Rule rule = new Rule(this.deck.getCardList());

    public void run() {

        PlayerBJ player = new PlayerBJ("player");
        ComputerBJ com = new ComputerBJ("dealer");

        deck.printCardList();
        System.out.println();

        System.out.println(player.getName() + "'s turn");
        player.DrawCard(this.deck, this.rule);

        System.out.println(com.getName() + "'s turn");
        com.DrawCard(this.deck, this.rule);

        com.openCard();

        System.out.println();
        System.out.println(player.getName() + "'s turn");
        player.Show();
        System.out.println(player.getName() + "'s total value is " + player.Sum());
        if(player.Sum() == 21){
            System.out.println("\"BJ\"");
        }
        while(replenishment(player)){
            System.out.println();
            player.Show();
            System.out.println(player.getName() + "'s total value is " + player.Sum());
        }

        System.out.println();
        System.out.println(com.getName() + "'s turn");
        com.Show();
        System.out.println(com.getName() + "'s total value is " + com.Sum());
        if(com.Sum() < 17) {
            replenishment(com);
        }else if(com.Sum() == 21){
                System.out.println("\"BJ\"");
        }

        showDown(player, com);
        Judgment judgment = new Judgment();
        judgment.Judge(player, com);

    }



    public boolean replenishment(PlayerBJ player) {

        Scanner input = new Scanner(System.in);

        if(player.Sum() == 21){
            System.out.println("\"BJ\"");
            return false;
        }

        if(player.getName().equals("dealer")){
            while(player.Sum()<17){
                player.DrawCard(this.deck, this.rule);
            }
            player.Show();
            if(!rule.isUnder21(player)){
                return false;
            }
            if(player.Sum() == 21) {
                System.out.println(player.getName() + "'s total value is " + player.Sum());
                System.out.println("\"BJ\"");
                return false;
            }
            System.out.println(player.getName() + "'s total value is " + player.Sum());
            return false;
        }
        System.out.print("<hit or stand>：");
        String answer = input.nextLine();
        if(answer.equals("hit")) {
            player.DrawCard(this.deck, this.rule);
            return rule.isUnder21(player);
        }else if(answer.equals("stand")) {
            return false;
        }else{
            return false;
        }

    }

    public void showDown(PlayerBJ player, ComputerBJ com){

        System.out.println();
        System.out.println(player.getName() + " : " + player.Sum());
        System.out.println(com.getName() + " : " + com.Sum());
        System.out.println();
    }

}
