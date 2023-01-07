package Practice;

public class Card{

    String mark;    //トランプ1枚のマーク
    int number;     //トランプ1枚の数字

    public Card(String mark, int number){
        this.mark = mark;
        this.number = number;
    }

    public void print(){
        //拡張switch文で表示
        //マークと数字を標準出力に表示する(例:ハートのA)
        switch(this.number){
            case 1 -> System.out.println("A of " + this.mark + "s");
            case 11 -> System.out.println("J of " + this.mark + "s");
            case 12 -> System.out.println("Q of " + this.mark + "s");
            case 13 -> System.out.println("K of " + this.mark + "s");
            default -> System.out.println(this.number + " of " + this.mark + "s");
        }
    }

    public int getSuit(){
        if(this.mark.equals("spade")){
            return 0;
        }else if(this.mark.equals("heart")){
            return 1;
        }else if(this.mark.equals("diamond")){
            return 2;
        }else{
            return 3;
        }
    }

    public int getNumber(){
        return this.number;
    }

}
