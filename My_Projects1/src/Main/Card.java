package Main;

public class Card{
    private final String mark;    //トランプ1枚のマーク
    private final int number;     //トランプ1枚の数字

    public Card(String mark, int number){
        this.mark = mark;
        if(number == 11){
            this.number = 11;
        }else {
            this.number = number;
        }
    }

    public int getSuit(){
        if(this.mark.equals("spade")){
            return 1;
        }else if(this.mark.equals("heart")){
            return 2;
        }else if(this.mark.equals("diamond")){
            return 3;
        }else{
            return 4;
        }
    }

    public int getNumber(){
        return this.number;
    }

}
