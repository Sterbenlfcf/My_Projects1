package Main;

import Main.BJ.DisplayBJ;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display implements ActionListener {

    public Display(){

        JFrame dis;
        JPanel top_panel, mid_panel;
        JLabel msg_lbl;
        JButton mid_btn1, mid_btn2, mid_btn3;

        dis = new JFrame("Game");
        dis.setSize(1500, 1000);
        dis.setLocationRelativeTo(null);
        dis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dis.setResizable(false);

        top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(1500, 50));
        dis.add(top_panel, BorderLayout.NORTH);

        msg_lbl = new JLabel("Game");
        msg_lbl.setHorizontalAlignment(JLabel.CENTER);
        top_panel.add(msg_lbl);
        setLabelFont(msg_lbl, Color.BLACK, 700, 15, 100, 20, 20, false);

        mid_panel = new JPanel();
        setPanel(mid_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 475));
        dis.add(mid_panel, BorderLayout.CENTER);

        mid_btn1 = new JButton("Black Jack");
        setButton(mid_btn1, Color.green, this, 500, 475,   80);
        mid_panel.add(mid_btn1, BorderLayout.WEST);

        mid_btn2 = new JButton("Poker");
        setButton(mid_btn2, Color.cyan, this, 500, 475, 100);
        mid_panel.add(mid_btn2, BorderLayout.CENTER);

        mid_btn3 = new JButton("High & Low");
        setButton(mid_btn3, Color.yellow, this, 500, 475, 80);
        mid_panel.add(mid_btn3, BorderLayout.EAST);

        dis.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();

        if(cmd.equals("Black Jack")){

            new DisplayBJ();
        }

    }

    public static void setPanel(JPanel panel, Color color, BorderLayout layout, Dimension dimension){

        panel.setBackground(color);
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
