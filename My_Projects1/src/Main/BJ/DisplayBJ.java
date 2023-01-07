package Main.BJ;

import Main.Computer;
import Main.Deck;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Main.Display.*;

public class DisplayBJ implements ActionListener {

    private final JFrame dis;
    private final JPanel top_panel, mid_panel, bottom_panel;
    private final JLabel msg_lbl;
    private final ArrayList<JLabel> lbl = new ArrayList<>();
    private final ArrayList<JLabel> lbl_player = new ArrayList<>();
    private  JButton btn1, btn2, btn3, btn4, btn5, btn6;
    private final PlayerBJ player = new PlayerBJ("player");
    private ComputerBJ dealer = new ComputerBJ("dealer");
    private Rule rule;
    private final Deck deck = new Deck();


    public DisplayBJ(){

        this.dis = new JFrame("BlackJack");
        this.dis.setSize(1500, 1000);
        this.dis.setLocationRelativeTo(null);
        this.dis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dis.setResizable(false);

        this.top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(1500, 50));
        this.dis.add(top_panel, BorderLayout.NORTH);

        this.msg_lbl = new JLabel("BlackJack");
        setLabelFont(msg_lbl, Color.BLACK, 650, 15, 200, 20, 20, false);
        this.top_panel.add(this.msg_lbl);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.GREEN, null, new Dimension(1500, 450));
        this.dis.add(mid_panel);

        JLabel lbl0 = new JLabel("Dealer's Card");
        setLabelFont(lbl0, Color.BLACK, 650, 10, 200, 30, 30, false);
        lbl.add(lbl0);
        this.mid_panel.add(lbl.get(0), BorderLayout.NORTH);

        JLabel lbl1 = new JLabel("Player's Card");
        setLabelFont(lbl1, Color.BLACK, 650, 400, 200, 30, 30, false);
        lbl.add(lbl1);
        this.mid_panel.add(lbl.get(1), BorderLayout.CENTER);

        for(int i=0; i<2; i++) {
            dealer.DrawCard(deck, rule);
            player.DrawCard(deck, rule);
        }

        JLabel lbl2 = new JLabel(getIcon(0, 0));
        setLabelFont(lbl2, Color.WHITE, 490, 50, 400, 300, 16, false);
        lbl.add(lbl2);
        this.mid_panel.add(lbl.get(2), BorderLayout.NORTH);

        JLabel lbl3 = new JLabel(getIcon(dealer.getSuit(1), dealer.getNumber(1)));
        setLabelFont(lbl3, Color.WHITE, 600, 50, 400, 300, 16, false);
        lbl.add(lbl3);
        this.mid_panel.add(lbl.get(3), BorderLayout.NORTH);

        JLabel lbl4 = new JLabel(getIcon(player.getSuit(0), player.getNumber(0)));
        setLabelFont(lbl4, Color.WHITE, 440, 440, 400, 300, 16, false);
        lbl.add(lbl4);
        lbl_player.add(lbl4);
        this.mid_panel.add(lbl.get(4), BorderLayout.NORTH);

        JLabel lbl5 = new JLabel(getIcon(player.getSuit(1), player.getNumber(1)));
        setLabelFont(lbl5, Color.WHITE, 660, 440, 400, 300, 16, false);
        lbl.add(lbl5);
        lbl_player.add(lbl5);
        this.mid_panel.add(lbl.get(5), BorderLayout.NORTH);

        String str = String.valueOf(player.Sum());

        JLabel lbl7 = new JLabel(str);
        setLabelFont(lbl7, Color.LIGHT_GRAY, 1150, 490, 200, 200, 70, true);
        lbl.add(lbl7);
        this.mid_panel.add(lbl.get(6), BorderLayout.NORTH);

        this.bottom_panel = new JPanel();
        setPanel(bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 100));
        this.dis.add(bottom_panel, BorderLayout.SOUTH);

        this.btn1 = new JButton("HIT");
        setButton(btn1, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn1, BorderLayout.WEST);

        this.btn2 = new JButton("STAND");
        setButton(btn2, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn2, BorderLayout.EAST);

        this.dis.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();
        JLabel label;
        int hitCounter = 0;

        if(cmd.equals("HIT")) {
            setLabelFont(lbl_player.get(lbl_player.size()-2), Color.BLACK, 100, 440, 400, 300, 16, false);
            setLabelFont(lbl_player.get(lbl_player.size()-1), Color.BLACK, 100, 440, 400, 300, 16, false);
            player.DrawCard(deck, rule);
            String str = String.valueOf(player.Sum());
            lbl.get(6).setText(str);
            if(player.Sum() > 21) {
                lbl.get(6).setBackground(Color.RED);
                this.bottom_panel.hide();
                label = new JLabel("BURST");
                setLabelFont(label, Color.WHITE, 550, 440, 400, 300, 16, false);
                lbl.add(label);
                this.bottom_panel.add(label, BorderLayout.SOUTH);
            }
            label = new JLabel(getIcon(player.getSuit(player.getSize()-1), player.getNumber(player.getSize()-1)));
            setLabelFont(label, Color.WHITE, 550, 440, 400, 300, 16, false);
            lbl.add(label);
            lbl_player.add(label);
            this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);
        }else if(cmd.equals("STAND")){

        }

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
