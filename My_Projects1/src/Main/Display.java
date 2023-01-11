package Main;

import Main.BJ.DisplayBJ;
import Main.High_and_Low.DisplayHL;

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

        if(cmd.equals("High & Low")){

            new DisplayHL();
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

    public static ImageIcon getIcon(int suit, int num){

        ImageIcon icon1;
        ImageIcon icon2;
        Image smallIcon;

        switch(suit){
            case 0:
                icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/card.jpeg");
                smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.9), -1, Image.SCALE_SMOOTH);
                icon2 = new ImageIcon(smallIcon);
                return icon2;
            case 1:
                switch(num) {
                    case 1:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/1.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 2:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/2.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 3:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/3.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 4:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/4.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 5:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/5.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 6:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/6.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 7:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/7.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 8:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/8.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 9:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/9.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 10:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/10.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 11:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/11.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 12:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/12.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 13:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/13.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    default:
                        return null;
                }

            case 2:
                switch(num) {
                    case 1:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/1.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 2:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/2.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 3:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/3.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 4:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/4.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 5:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/5.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 6:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/6.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 7:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/7.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 8:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/8.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 9:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/9.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 10:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/10.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 11:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/11.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 12:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/12.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 13:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/13.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    default:
                        return null;
                }
            case 3:
                switch(num) {
                    case 1:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/1.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 2:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/2.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 3:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/3.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 4:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/4.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 5:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/5.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 6:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/6.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 7:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/7.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 8:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/8.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 9:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/9.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 10:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/10.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 11:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/11.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 12:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/12.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 13:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/13.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    default:
                        return null;
                }
            case 4:
                switch(num) {
                    case 1:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/1.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 2:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/2.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 3:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/3.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 4:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/4.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 5:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/5.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 6:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/6.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 7:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/7.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 8:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/8.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 9:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/9.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 10:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/10.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 11:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/11.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 12:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/12.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    case 13:
                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/13.png");
                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
                        icon2 = new ImageIcon(smallIcon);
                        return icon2;
                    default:
                        return null;
                }
            default:
                return null;

        }

    }

}
