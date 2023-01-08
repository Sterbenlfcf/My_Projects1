package Main.BJ;

import Main.Card;
import Main.Deck;

import java.util.ArrayList;

public class PlayerBJ {

    protected final String name;
    protected final ArrayList<Card> drawList; //= new ArrayList<>();

    public PlayerBJ(String name){
        this.name = name;
        drawList = new ArrayList<>();
    }

    public void DrawCard(Deck deck, RuleBJ rule){
        addDrawCard(deck.Draw(0));
    }

    public void addDrawCard(Card card){
        this.drawList.add(card);
    }

    public int Sum(){
        int sum = 0;
        int num;
        int count = 0;
        for(Card card : drawList) {
            num = card.getNumber();
            if(num == 1){
                count += 1;
                sum += 11;
                if(sum > 21){
                    sum -= 10;
                    count -= 1;
                }
            }else if(num == 11){
                sum += 10;
            }else{
                sum = sum + Math.min(10, num);
            }
        }
        if(count > 0 && sum >21){
            sum -= 10;
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
