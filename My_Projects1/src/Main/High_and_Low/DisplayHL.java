package Main.High_and_Low;

import Main.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Display.*;

public class DisplayHL implements ActionListener {

    private JFrame dis;
    private JPanel top_panel, mid_panel, bottom_panel;
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
    private JLabel msg_lbl1, msg_lbl2, msg_lbl3;
    private JButton btn1, btn2;
    private PlayerHL player = new PlayerHL("player");
    private Deck deck = new Deck();
    String str1, str2, str3;
    int num1, num2, num3;
    private int counter = 0;

    public DisplayHL(){

        dis = new JFrame("High & Low");
        dis.setSize(1500, 1000);
        dis.setLocationRelativeTo(null);
        dis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dis.setResizable(false);

        top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(1500, 50));
        dis.add(top_panel, BorderLayout.NORTH);

        JLabel msg_lbl = new JLabel("High & Low");
        setLabelFont(msg_lbl, Color.BLACK, 650, 15, 200, 25, 20, false);
        top_panel.add(msg_lbl);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.GREEN, null, new Dimension(1500, 1000));
        dis.add(mid_panel);

        lbl1 = new JLabel(getIcon(0, 0));
        setLabelFont(lbl1, Color.WHITE, 640, 30, 220, 300, 16, false);
        this.mid_panel.add(lbl1, BorderLayout.NORTH);

        lbl2 = new JLabel(getIcon(0, 0));
        setLabelFont(lbl2, Color.WHITE, 1150, 30, 220, 300, 16, false);
        this.mid_panel.add(lbl2, BorderLayout.NORTH);

        player.DrawCard(deck);

        lbl3 = new JLabel(getIcon(player.getSuit(player.getSize()-1), player.getNumber(player.getSize()-1)));
        setLabelFont(lbl3, Color.WHITE, 640,450, 220, 300, 16, false);
        this.mid_panel.add(lbl3, BorderLayout.NORTH);

        num1 = 0;
        str1 = String.valueOf(num1);
        lbl4 = new JLabel( str1 + "枚");
        setLabelFont(lbl4, Color.WHITE, 135, 500, 220, 300, 60, false);
        this.mid_panel.add(lbl4, BorderLayout.NORTH);

        num2 = 0;
        str2 = String.valueOf(num2);
        lbl5 = new JLabel(str2 + "枚");
        setLabelFont(lbl5, Color.WHITE, 1080, 500, 220, 300, 60, false);
        this.mid_panel.add(lbl5, BorderLayout.NORTH);

        msg_lbl1 = new JLabel("CORRECT");
        setLabelFont(msg_lbl1, Color.WHITE, 30,500, 450, 100, 60, false);
        this.mid_panel.add(msg_lbl1, BorderLayout.NORTH);

        msg_lbl2 = new JLabel("INCORRECT");
        setLabelFont(msg_lbl2, Color.WHITE, 970,500, 450, 100, 60, false);
        this.mid_panel.add(msg_lbl2, BorderLayout.NORTH);

        msg_lbl3 = new JLabel("");
        setLabelFont(msg_lbl3, Color.WHITE, 500,350, 500, 100, 80, false);
        this.mid_panel.add(msg_lbl3, BorderLayout.NORTH);

        this.bottom_panel = new JPanel();
        setPanel(bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 100));
        dis.add(bottom_panel, BorderLayout.SOUTH);

        this.btn1 = new JButton("HIGH");
        setButton(btn1, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn1, BorderLayout.WEST);

        this.btn2 = new JButton("LOW");
        setButton(btn2, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn2, BorderLayout.EAST);


        dis.setVisible(true);
    }

    public void actionPerformed (ActionEvent e){

        String cmd = e.getActionCommand();

        if(cmd.equals("HIGH")){
            str3 = cmd;
            judge();
        }

        if(cmd.equals("LOW")){
            str3 = cmd;
            judge();
        }

        if(cmd.equals("NEXT")){

            if(counter == 50){
                lbl2.hide();
            }

            btn2.hide();
            msg_lbl3.setText("");

            this.btn1 = new JButton("HIGH");
            setButton(btn1, Color.WHITE, this, 750, 100, 70);
            this.bottom_panel.add(btn1, BorderLayout.WEST);

            this.btn2 = new JButton("LOW");
            setButton(btn2, Color.WHITE, this, 750, 100, 70);
            this.bottom_panel.add(btn2, BorderLayout.EAST);

            lbl3.hide();
            lbl1.hide();

            lbl1 = new JLabel(getIcon(0, 0));
            setLabelFont(lbl1, Color.WHITE, 640, 30, 220, 300, 16, false);
            this.mid_panel.add(lbl1, BorderLayout.NORTH);

            lbl3 = new JLabel(getIcon(player.getSuit(player.getSize()-1), player.getNumber(player.getSize()-1)));
            setLabelFont(lbl3, Color.WHITE, 640,450, 220, 300, 16, false);
            this.mid_panel.add(lbl3, BorderLayout.NORTH);
        }

        if(cmd.equals("RESULT")){
            this.mid_panel.hide();
            this.mid_panel = new JPanel();
            setPanel(mid_panel, Color.GREEN, null, new Dimension(1500, 1000));
            dis.add(mid_panel);

            msg_lbl1 = new JLabel("CORRECT");
            setLabelFont(msg_lbl1, Color.WHITE, 180,100, 450, 100, 60, false);
            this.mid_panel.add(msg_lbl1, BorderLayout.NORTH);

            str1 = String.valueOf(num1);
            lbl4 = new JLabel(" ： " + str1 + " 枚");
            setLabelFont(lbl4, Color.WHITE, 480,100, 450, 100, 60, false);
            this.mid_panel.add(lbl4, BorderLayout.NORTH);

            msg_lbl2 = new JLabel("INCORRECT");
            setLabelFont(msg_lbl2, Color.WHITE, 180,300, 450, 100, 60, false);
            this.mid_panel.add(msg_lbl2, BorderLayout.NORTH);

            str2 = String.valueOf(num2);
            lbl5 = new JLabel(" ： " + str2 + " 枚");
            setLabelFont(lbl5, Color.WHITE, 480,300, 450, 100, 60, false);
            this.mid_panel.add(lbl5, BorderLayout.NORTH);

            msg_lbl3 = new JLabel("SAME");
            setLabelFont(msg_lbl3, Color.WHITE, 180,500, 450, 100, 60, false);
            this.mid_panel.add(msg_lbl3, BorderLayout.NORTH);

            str3 = String.valueOf(num3);
            lbl6 = new JLabel(" ： " + str3 + " 枚");
            setLabelFont(lbl6, Color.WHITE, 480,500, 450, 100, 60, false);
            this.mid_panel.add(lbl6, BorderLayout.NORTH);

            btn2.setText("CLOSE");
        }

        if(cmd.equals("CLOSE")){
            this.dis.setVisible(false);
        }

    }

    public void judge(){

        counter++;

        btn1.hide();
        btn2.hide();
        if(counter == 51){
//            lbl2.hide();
            btn2 = new JButton("RESULT");
        }else {
            btn2 = new JButton("NEXT");
        }
        setButton(btn2, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn2, BorderLayout.CENTER);

        player.DrawCard(deck);

        lbl1.hide();
        lbl1 = new JLabel(getIcon(player.getSuit(player.getSize()-1), player.getNumber(player.getSize()-1)));
        setLabelFont(lbl1, Color.WHITE, 550, 30, 400, 300, 16, false);
        this.mid_panel.add(lbl1, BorderLayout.NORTH);

        if(player.getNumber(player.getSize()-2) > player.getNumber(player.getSize()-1)){
            msg_lbl3.setText("HIGH");
            if(str3.equals("HIGH")){
                num1++;
                str1 = String.valueOf(num1);
                lbl4.setText(str1 + "枚");
            }else if(str3.equals("LOW")){
                num2++;
                str2 = String.valueOf(num2);
                lbl5.setText(str2 + "枚");
            }
        }else if(player.getNumber(player.getSize()-2) < player.getNumber(player.getSize()-1)){
            msg_lbl3.setText("LOW");
            if(str3.equals("LOW")){
                num1++;
                str1 = String.valueOf(num1);
                lbl4.setText(str1 + "枚");
            }else if(str3.equals("HIGH")) {
                num2++;
                str2 = String.valueOf(num2);
                lbl5.setText(str2 + "枚");
            }
        }else{
            num3++;
        }

    }

}
