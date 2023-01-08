package Main.BJ;

import Main.Deck;

public class ComputerBJ extends PlayerBJ {

    public ComputerBJ(String name){
        super(name);
    }

    public int getNumber_d(int index){
        if(drawList.get(index).getNumber() > 10){
            return 10;
        }else if(drawList.get(index).getNumber() == 1){
            return 11;
        }else{
            return drawList.get(index).getNumber();
        }
    }

}
