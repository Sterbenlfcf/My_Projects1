package Main;

import Main.BJ.Rule;

import java.util.ArrayList;

public class Player {

    protected final String name;
    protected final ArrayList<Card> drawList; //= new ArrayList<>();

    public Player(String name){
        this.name = name;
        drawList = new ArrayList<>();
    }

    public void DrawCard(Deck deck, Rule rule){

    }

}
