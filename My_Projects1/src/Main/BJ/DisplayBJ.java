package Main.BJ;

import Main.Deck;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Main.Display.*;

public class DisplayBJ implements ActionListener {

    private final JFrame dis;
    private final JPanel bottom_panel;
    private JPanel mid_panel;
    private final ArrayList<JLabel> lbl = new ArrayList<>();
    private final ArrayList<JLabel> lbl_player = new ArrayList<>();
    private final ArrayList<JLabel> lbl_dealer = new ArrayList<>();
    private final JButton btn1;
    private JButton btn2;
    private final PlayerBJ player = new PlayerBJ("player");
    private final ComputerBJ dealer = new ComputerBJ("dealer");
    private final Deck deck = new Deck();
    private final RuleBJ rule = new RuleBJ(deck.getCardList());

    int nextCounter = 0;

    public DisplayBJ(){

        this.dis = new JFrame("BlackJack");
        this.dis.setSize(1500, 1000);
        this.dis.setLocationRelativeTo(null);
        this.dis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dis.setResizable(false);

        JPanel top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(1500, 50));
        this.dis.add(top_panel, BorderLayout.NORTH);

        JLabel msg_lbl = new JLabel("BlackJack");
        setLabelFont(msg_lbl, Color.BLACK, 650, 15, 200, 20, 20, false);
        top_panel.add(msg_lbl);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.GREEN, null, new Dimension(1500, 450));
        this.dis.add(mid_panel);

        lbl_dealer.add(new JLabel("Dealer's Card"));
        setLabelFont(lbl_dealer.get(lbl_dealer.size()-1), Color.BLACK, 650, 10, 200, 30, 30, false);
        this.mid_panel.add(lbl_dealer.get(0), BorderLayout.NORTH);

        lbl_player.add(new JLabel("Player's Card"));
        setLabelFont(lbl_player.get(lbl_player.size()-1), Color.BLACK, 650, 400, 200, 30, 30, false);
        this.mid_panel.add(lbl_player.get(0), BorderLayout.CENTER);

        for(int i=0; i<2; i++) {
            dealer.DrawCard(deck, rule);
            player.DrawCard(deck, rule);
        }

        lbl.add(new JLabel(getIcon(0, 0)));
        setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 490, 50, 400, 300, 16, false);
        this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

        lbl_dealer.add(new JLabel(getIcon(dealer.getSuit(0), dealer.getNumber(0))));

        lbl_dealer.add(new JLabel(getIcon(dealer.getSuit(1), dealer.getNumber(1))));
        setLabelFont(lbl_dealer.get(lbl_dealer.size()-1), Color.WHITE, 600, 50, 400, 300, 16, false);
        this.mid_panel.add(lbl_dealer.get(lbl_dealer.size()-1), BorderLayout.NORTH);

        int dealer_sum = dealer.Sum() - dealer.getNumber_d(0);
        String str;
        if(dealer_sum == 1){
            str = "11";
        }else{
            str = String.valueOf(dealer_sum);
        }
        lbl.add(new JLabel(str));
        setLabelFont(lbl.get(lbl.size()-1), Color.LIGHT_GRAY, 1120, 50, 200, 200, 70, true);
        this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

        lbl_player.add(new JLabel(getIcon(player.getSuit(0), player.getNumber(0))));
        setLabelFont(lbl_player.get(lbl_player.size()-1), Color.WHITE, 440, 440, 400, 300, 16, false);
        this.mid_panel.add(lbl_player.get(lbl_player.size()-1), BorderLayout.NORTH);

        lbl_player.add(new JLabel(getIcon(player.getSuit(1), player.getNumber(1))));
        setLabelFont(lbl_player.get(lbl_player.size()-1), Color.WHITE, 660, 440, 400, 300, 16, false);
        this.mid_panel.add(lbl_player.get(lbl_player.size()-1), BorderLayout.NORTH);

        String str2 = String.valueOf(player.Sum());

        lbl.add(new JLabel(str2));
        setLabelFont(lbl.get(lbl.size()-1), Color.LIGHT_GRAY, 1120, 450, 200, 200, 70, true);
        this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

        this.bottom_panel = new JPanel();
        setPanel(bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(1500, 100));
        this.dis.add(bottom_panel, BorderLayout.SOUTH);

        this.btn1 = new JButton("HIT");
        setButton(btn1, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn1, BorderLayout.WEST);

        this.btn2 = new JButton("STAND");
        setButton(btn2, Color.WHITE, this, 750, 100, 70);
        this.bottom_panel.add(btn2, BorderLayout.EAST);

        if(player.Sum() == 21){
            this.btn1.hide();
            this.btn2.hide();

            lbl.add(new JLabel("Black Jack"));
            setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 1020, 650, 400, 100, 40, false);
            this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

            this.btn2 = new JButton("NEXT");
            setButton(btn2, Color.WHITE, this, 750, 100, 70);
            this.bottom_panel.add(btn2, BorderLayout.CENTER);
        }

        this.dis.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();

        if(cmd.equals("HIT")){
            lbl_player.get(lbl_player.size()-2).hide();
            setLabelFont(lbl_player.get(lbl_player.size()-1), Color.BLACK, 100, 440, 400, 300, 16, false);
            player.DrawCard(deck, rule);
            String str = String.valueOf(player.Sum());
            this.lbl.get(lbl.size()-1).setText(str);
            if(player.Sum() > 21) {
                lbl.get(lbl.size()-1).setBackground(Color.RED);
                this.btn1.hide();
                this.btn2.hide();
                lbl.add(new JLabel("BURST"));
                setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 1120, 650, 200, 100, 45, false);
                this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

                this.btn2 = new JButton("NEXT");
                setButton(btn2, Color.WHITE, this, 750, 100, 70);
                this.bottom_panel.add(btn2, BorderLayout.CENTER);
            }else if(player.Sum() == 21){
                this.btn1.hide();
                this.btn2.hide();
                lbl.add(new JLabel("Black Jack"));
                setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 1020, 650, 400, 100, 40, false);
                this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

                this.btn2 = new JButton("NEXT");
                setButton(btn2, Color.WHITE, this, 750, 100, 70);
                this.bottom_panel.add(btn2, BorderLayout.CENTER);
            }

            lbl_player.add(new JLabel(getIcon(player.getSuit(player.getSize()-1), player.getNumber(player.getSize()-1))));
            setLabelFont(lbl_player.get(lbl_player.size()-1), Color.WHITE, 550, 440, 400, 300, 16, false);
            this.mid_panel.add(lbl_player.get(lbl_player.size()-1), BorderLayout.NORTH);
        }

        if(cmd.equals("STAND")){
            this.btn1.hide();
            this.btn2.hide();
            this.btn2 = new JButton("NEXT");
            setButton(btn2, Color.WHITE, this, 750, 100, 70);
            this.bottom_panel.add(btn2, BorderLayout.CENTER);
        }

        if(cmd.equals("NEXT")){
            if(nextCounter == 0) {
                lbl.get(0).hide();
                setLabelFont(lbl_dealer.get(lbl_dealer.size() - 2), Color.WHITE, 440, 50, 400, 300, 16, false);
                this.mid_panel.add(lbl_dealer.get(lbl_dealer.size() - 2), BorderLayout.NORTH);

                setLabelFont(lbl_dealer.get(lbl_dealer.size() - 1), Color.WHITE, 660, 50, 400, 300, 16, false);

            }else{
                DealerPlay();
            }

            String str = String.valueOf(dealer.Sum());

            this.lbl.get(1).setText(str);
            setLabelFont(lbl.get(1), Color.LIGHT_GRAY, 1120, 50, 200, 200, 70, true);
            this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);

            nextCounter += 1;

            if(dealer.Sum() > 16){
                if(dealer.Sum() > 21){
                    lbl.get(1).setBackground(Color.RED);
                    lbl.add(new JLabel("BURST"));
                    setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 1120, 250, 200, 100, 40, false);
                    this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);
                }else if(dealer.Sum() == 21){
                lbl.add(new JLabel("Black Jack"));
                setLabelFont(lbl.get(lbl.size()-1), Color.WHITE, 1020, 250, 400, 100, 40, false);
                this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.NORTH);
                }
                btn2.setText("RESULT");
            }
        }

        if(cmd.equals("RESULT")){
            mid_panel.hide();
            this.mid_panel = new JPanel();
            setPanel(mid_panel, Color.GREEN, null, new Dimension(1500, 450));
            this.dis.add(mid_panel);
            String str3;
            JudgmentBJ j = new JudgmentBJ();
            str3 = j.Judge(player, dealer);

            lbl.add(new JLabel(str3));
            setLabelFont(lbl.get(lbl.size()-1), Color.GREEN, 350, 330, 800, 100, 100, false);
            this.mid_panel.add(lbl.get(lbl.size()-1), BorderLayout.CENTER);

            btn2.setText("CLOSE");
        }

        if(cmd.equals("CLOSE")){
            this.dis.setVisible(false);
        }
    }

    public void DealerPlay(){

        lbl_dealer.get(lbl_dealer.size()-2).hide();
        setLabelFont(lbl_dealer.get(lbl_dealer.size()-1), Color.BLACK, 100, 50, 400, 300, 16, false);

        dealer.DrawCard(deck, rule);

        lbl_dealer.add(new JLabel(getIcon(dealer.getSuit(dealer.getSize()-1), dealer.getNumber(dealer.getSize()-1))));
        setLabelFont(lbl_dealer.get(lbl_dealer.size()-1), Color.WHITE, 550, 50, 400, 300, 16, false);
        this.mid_panel.add(lbl_dealer.get(lbl_dealer.size()-1), BorderLayout.NORTH);

    }

//    public static ImageIcon getIcon(int suit, int num){
//
//        ImageIcon icon1;
//        ImageIcon icon2;
//        Image smallIcon;
//
//        switch(suit){
//            case 0:
//                icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/card.jpeg");
//                smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.9), -1, Image.SCALE_SMOOTH);
//                icon2 = new ImageIcon(smallIcon);
//                return icon2;
//            case 1:
//                switch(num) {
//                    case 1:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/1.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 2:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/2.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 3:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/3.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 4:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/4.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 5:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/5.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 6:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/6.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 7:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/7.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 8:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/8.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 9:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/9.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 10:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/10.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 11:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/11.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 12:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/12.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 13:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/spade/13.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    default:
//                        return null;
//                }
//
//            case 2:
//                switch(num) {
//                    case 1:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/1.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 2:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/2.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 3:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/3.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 4:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/4.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 5:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/5.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 6:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/6.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 7:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/7.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 8:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/8.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 9:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/9.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 10:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/10.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 11:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/11.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 12:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/12.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 13:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/heart/13.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    default:
//                        return null;
//                }
//            case 3:
//                switch(num) {
//                    case 1:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/1.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 2:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/2.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 3:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/3.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 4:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/4.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 5:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/5.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 6:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/6.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 7:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/7.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 8:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/8.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 9:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/9.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 10:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/10.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 11:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/11.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 12:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/12.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 13:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/diamond/13.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    default:
//                        return null;
//                }
//            case 4:
//                switch(num) {
//                    case 1:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/1.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 2:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/2.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 3:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/3.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 4:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/4.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 5:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/5.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 6:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/6.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 7:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/7.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 8:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/8.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 9:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/9.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 10:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/10.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 11:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/11.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 12:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/12.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    case 13:
//                        icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/Illustration/crab/13.png");
//                        smallIcon = icon1.getImage().getScaledInstance((int) (icon1.getIconWidth() * 0.3), -1, Image.SCALE_SMOOTH);
//                        icon2 = new ImageIcon(smallIcon);
//                        return icon2;
//                    default:
//                        return null;
//                }
//            default:
//                return null;
//
//        }
//
//    }

}
