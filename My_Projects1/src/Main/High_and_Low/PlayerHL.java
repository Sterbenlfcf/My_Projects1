package Main.High_and_Low;

import Main.Card;
import Main.Deck;

import java.util.ArrayList;

public class PlayerHL {

    protected final String name;
    protected final ArrayList<Card> drawList; //= new ArrayList<>();

    public PlayerHL(String name){
        this.name = name;
        drawList = new ArrayList<>();
    }

    public void DrawCard(Deck deck){
        addDrawCard(deck.Draw(0));
    }

    public void addDrawCard(Card card){
        this.drawList.add(card);
    }

    public int Sum(){
        int sum = 0;
        int num;

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
