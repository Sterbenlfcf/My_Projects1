package Practice;

import Practice.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

//    final int TOTAL_CARD = 52;
//    private List<int> card_list;
//    private int card_index = 0;
//
//    public Practice.Deck(){
//
//        this.card_index = 0;
//        this.card_list = new ArrayList<>();
//
//        Collections.shuffle(card_list);
//
//    }
//
//    public Practice.Card getCard(){
//
//        Practice.Card card = new Practice.Card();
//        int card_nam;
//
//        card_nam = card_list.get(card_index);
//
//    }

    private final ArrayList<Card> cardList;

    public Deck(){
        //スペード･ハート･ダイヤ･クローバーの1～13のトランプをインスタンス化し、
        //cardListの要素として追加する(つまり、トランプを作り、トランプの山にする)
        String[] marks = new String[]{"spade", "heart", "diamond", "club"};
        ArrayList<Card> cardList = new ArrayList<>();
        for(String mark : marks){
            for(int j=1; j<=13; j++){
                //iを元に選んだmarkと、トランプの数字jを使ってインスタンス化
                Card card = new Card(mark, j);
                cardList.add(card);
            }
        }
        //cardListの要素をランダム順に並び替える。(つまり、トランプのテンをきる)
        Collections.shuffle(cardList);
        //完成したcardListをフィールド変数が参照するようにする
        this.cardList = cardList;
    }

    public void printCardList(){
        //cardListの要素をすべて表示する
        for(Card card : cardList){
            card.print();
        }
    }

    public Card Draw(int index){

        Card draw = cardList.get(index-1);
        cardList.remove(index-1);

        return draw;

    }

    public int deckSize(){
        return cardList.size();
    }

    public ArrayList<Card> getCardList(){
        return this.cardList;
    }

}
