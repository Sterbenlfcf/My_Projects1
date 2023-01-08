package Main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final ArrayList<Card> cardList;

    public Deck(){
        //スペード･ハート･ダイヤ･クローバーの1～13のトランプをインスタンス化し、
        //cardListの要素として追加する(つまり、トランプを作り、トランプの山にする)
        String[] marks = new String[]{"spade", "heart", "diamond", "club"};
        ArrayList<Card> cardList = new ArrayList<>();
        for(String mark : marks){
            for(int j=1; j<11; j++){
                //iを元に選んだmarkと、トランプの数字jを使ってインスタンス化
                Card card = new Card(mark, j);
                cardList.add(card);
            }
            cardList.add(new Card(mark, 11));
            cardList.add(new Card(mark, 12));
            cardList.add(new Card(mark, 13));
        }
        //cardListの要素をランダム順に並び替える。(つまり、トランプのテンをきる)
        Collections.shuffle(cardList);
        //完成したcardListをフィールド変数が参照するようにする
        this.cardList = cardList;
    }

    public Card Draw(int index){

        Card draw = cardList.get(index);
        cardList.remove(index);

        return draw;

    }

    public int deckSize(){
        return cardList.size();
    }

    public ArrayList<Card> getCardList(){
        return this.cardList;
    }

}
