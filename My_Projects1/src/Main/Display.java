package Main;

import Main.BJ.DisplayBJ;
import Main.BJ.PlayerBJ;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display implements ActionListener {

    private JFrame dis;
    private JPanel top_panel, mid_panel, bottom_panel;
    private JLabel msg_lbl;
    private JButton mid_btn1, mid_btn2, mid_btn3, mid_btn4, mid_btn5, mid_btn6;
//    private PlayerBJ player;
//    private Computer dealer;

    public Display(){

//        this.player = player;
//        this.dealer = dealer;

        this.dis = new JFrame("Game");
        this.dis.setSize(1500, 1000);
        this.dis.setLocationRelativeTo(null);
        this.dis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dis.setResizable(false);

        this.top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(1500, 50));
        this.dis.add(top_panel, BorderLayout.NORTH);

        this.msg_lbl = new JLabel("Game");
        msg_lbl.setHorizontalAlignment(JLabel.CENTER);
        this.top_panel.add(this.msg_lbl);
        setLabelFont(msg_lbl, Color.BLACK, 700, 15, 100, 20, 20, false);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 475));
        this.dis.add(mid_panel, BorderLayout.CENTER);

        this.mid_btn1 = new JButton("BJ");
        setButton(mid_btn1, Color.yellow, this, 500, 475, 100);
        mid_panel.add(mid_btn1, BorderLayout.WEST);

        this.mid_btn2 = new JButton("Poker");
        setButton(mid_btn2, Color.cyan, this, 500, 475, 100);
        mid_panel.add(mid_btn2, BorderLayout.CENTER);

        this.mid_btn3 = new JButton("Speed");
        setButton(mid_btn3, Color.yellow, this, 500, 180, 100);
        mid_panel.add(mid_btn3, BorderLayout.EAST);

        this.bottom_panel = new JPanel();
        setPanel(bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 475));
        this.dis.add(bottom_panel, BorderLayout.SOUTH);

        this.mid_btn4 = new JButton("BJ");
        setButton(mid_btn4, Color.cyan, this, 500, 180, 100);
        bottom_panel.add(mid_btn4, BorderLayout.WEST);

        this.mid_btn5 = new JButton("Poker");
        setButton(mid_btn5, Color.yellow, this, 500, 180, 100);
        bottom_panel.add(mid_btn5, BorderLayout.CENTER);

        this.mid_btn6 = new JButton("Speed");
        setButton(mid_btn6, Color.cyan, this, 500, 180, 100);
        bottom_panel.add(mid_btn6, BorderLayout.EAST);



        this.dis.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();

        if(cmd.equals("BJ")){

            mid_btn1.setBackground(Color.GREEN);
            new DisplayBJ();
//            mid_btn1.setBackground(Color.GREEN);
//            if(parent_num < child_num){
//                msg_lbl.setText("You win!");
//            }else if(child_num < parent_num){
//                msg_lbl.setText("You lose!");
//            }else{
//                msg_lbl.setText("Draw!");
//            }
        }

    }

    public static void setPanel(JPanel panel, Color color, BorderLayout layout, Dimension dimension){

        panel.setBackground(color);
//        panel.setLocation(x_pos, y_pos);
        panel.setLayout(layout);
        panel.setPreferredSize(dimension);

    }

    public static void setLabelFont(JLabel label, Color color, int x_pos, int y_pos, int x_size, int y_size, int strSize, boolean opq){

        label.setBackground(color);
        label.setLocation(x_pos, y_pos);
        label.setSize(x_size, y_size);
        label.setFont(new Font("MS ゴッシク", Font.PLAIN, strSize));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setOpaque(opq);

    }

    public static void setButton(JButton btn, Color color, ActionListener al, int x_size, int y_size, int strSize){

        btn.setBackground(color);
        btn.setPreferredSize(new Dimension(x_size, y_size));
        btn.setFont(new Font("MS ゴシック", Font.PLAIN, strSize));
        btn.addActionListener(al);

    }

}
