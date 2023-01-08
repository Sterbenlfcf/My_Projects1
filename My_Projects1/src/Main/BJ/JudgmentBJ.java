package Main.BJ;

public class JudgmentBJ {

    public String Judge(PlayerBJ player, ComputerBJ com){

        String str;
        int comSum = com.Sum();
        if(comSum <= 21 && player.Sum() <= 21){
            if(comSum < player.Sum()){
                str = "You Win";
                return str;
            }else if(comSum > player.Sum()) {
                str = "You Lose";
                return str;
            }else{
                str = "Draw";
                return str;
            }
        }else if(comSum >21 && player.Sum() <= 21) {
            str = "You Win";
            return str;
        }else if(comSum <=21 && player.Sum() > 21){
            str = "You Lose";
            return str;
        }else{
            str = "Draw";
            return str;
        }
    }
}
