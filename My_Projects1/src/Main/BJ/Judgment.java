package Main.BJ;

import java.util.ArrayList;

public class Judgment{

    public void Judge(PlayerBJ player, ComputerBJ com){

        System.out.println("<Result>");
        int comSum = com.Sum();
        if(comSum <= 21 && player.Sum() <= 21){
            if(comSum < player.Sum()){
                System.out.println(player.getName() + ":Win");
            }else if(comSum > player.Sum()) {
                System.out.println(player.getName() + ":Lose");
            }
        }else if(comSum >21 && player.Sum() <= 21) {
            System.out.println(player.getName() + ":Win");
        }else if(comSum <=21 && player.Sum() > 21){
            System.out.println(player.getName() + ":Lose");
        }else{
            System.out.println(player.getName() + ":Draw");
        }
    }
}
