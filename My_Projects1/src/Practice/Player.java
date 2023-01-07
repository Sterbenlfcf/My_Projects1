package Practice;

import Practice.Card;
import Practice.Deck;

public class Player {

    private Card card;
//
    public Player(){

        this.card = new Card("spade", 0);

    }

    public void Draw(Deck deck){

        card = deck.Draw(1);
        return;

    }

    public int getNumber(){
        return card.number;
    }

    public int getSuit(){
        return card.getSuit();
    }
//
//    protected final String name;
//    protected final ArrayList<Practice.Card> drawList; //= new ArrayList<>();
//
//    public Practice.Player(String name){
//        this.name = name;
//        drawList = new ArrayList<>();
//    }
//
//    public int getNumber(){
//        return drawList.get(0).getNumber();
//    }
//
//    public int getSuit(){
//        return drawList.get(1).getSuit();
//    }
}
