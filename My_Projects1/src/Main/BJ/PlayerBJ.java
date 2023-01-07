package Main.BJ;

import Main.Card;
import Main.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerBJ {

    protected final String name;
    protected final ArrayList<Card> drawList; //= new ArrayList<>();

    public PlayerBJ(String name){
        this.name = name;
        drawList = new ArrayList<>();
    }

    public void DrawCard(Deck deck, Rule rule){
//        Scanner input = new Scanner(System.in);
//        int number;
//        while(true){
//            System.out.print("What card do you draw from the top：");
//            String n = input.nextLine();
//            if (rule.isDrawOK(n)) {
//                number = Integer.parseInt(n);
//                addDrawCard(deck.Draw(number));
//                break;
//            }
//        }
        addDrawCard(deck.Draw(1));
    }

    public void addDrawCard(Card card){
        this.drawList.add(card);
    }

    public void Show(){
        System.out.println(this.name + "'s hand");
        for(Card card : this.drawList){
            card.print();
        }
    }

    public int Sum(){
        int sum = 0;
        int num;
        for(Card card : drawList) {
            num = card.getNumber();
            if(num == 1){
                sum += 11;
                if(sum > 21){
                    sum -= 10;
                }
            }else{
                sum += Math.min(10, num);
            }
        }
        return sum;
    }

    public String getName(){
        return this.name;
    }

    public  int getSize(){
        return drawList.size();
    }

    public int getSuit(int index){
        return drawList.get(index).getSuit();
    }

    public int getNumber(int index){
        return drawList.get(index).getNumber();
    }

}
