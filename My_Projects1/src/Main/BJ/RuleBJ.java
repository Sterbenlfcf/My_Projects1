package Main.BJ;

import Main.Card;

import java.util.ArrayList;

public class RuleBJ {

    private final ArrayList<Card> cardList;

    public RuleBJ(ArrayList<Card> cardList){
        this.cardList = cardList;
    }

    public boolean isDrawOK(String n){
        return isIntegerInputted(n) && isRange(n);
    }

    public boolean isIntegerInputted(String n){
        try{
            Integer.parseInt(n);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Please enter a number");
            return false;
        }
    }

    public boolean isRange(String n) {
        int number = Integer.parseInt(n);
        if (1 <= number && number <= cardList.size()) {
            return true;
        }
        System.out.println("Please enter a number between 1 and " + cardList.size());
        return false;
    }

    public void isRange(int number) {
        if (1 > number || number > 5) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isUnder21(PlayerBJ player){
        if(22 > player.Sum()){
            return true;
        }else{
            System.out.println(player.getName() + "'s total value is " + player.Sum());
            System.out.println("Burst");
            return false;
        }
    }

}
