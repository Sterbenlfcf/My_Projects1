package Main;

public class Card{
    private final String mark;    //トランプ1枚のマーク
    private final int number;     //トランプ1枚の数字

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

    public String getMark(){
        return this.mark;
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
