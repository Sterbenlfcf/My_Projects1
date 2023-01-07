package Practice;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//表示クラス
public class Display implements ActionListener {

    private JFrame dis;
    private JPanel top_panel, mid_panel, bottom_panel;
    private JLabel msg_lbl;
    private JLabel parent_lbl, parent_suit_lbl, parent_num_lbl;
    private JLabel child_lbl,child_suit_lbl, child_num_lbl;
    private JButton btn_high, btn_low;
    private Player parent, child;

    public Display(Player parent, Player child){

        this.parent = parent;
        this.child = child;

        this.dis = new JFrame("HIGH & LOW");
        this.dis.setSize(1500, 1000);
        this.dis.setLocationRelativeTo(null);
        this.dis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dis.setResizable(false);

        this.top_panel = new JPanel();
        setPanel(top_panel, Color.ORANGE, null, new Dimension(480, 50));
        this.dis.add(top_panel, BorderLayout.NORTH);

        this.msg_lbl = new JLabel("HIGH or LOW");
        this.top_panel.add(this.msg_lbl);
        setLabelFont(msg_lbl, Color.BLACK, 250, 15, 480, 20, 20, false);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.CYAN, null, new Dimension(480, 180));
        this.dis.add(mid_panel, BorderLayout.CENTER);

        this.parent_lbl = new JLabel("My Practice.Card");
//        this.parent_suit_lbl = new JLabel(getSuitIcon(parent.getSuit()));
        this.parent_suit_lbl = new JLabel(getSuitIcon(0));
        this.parent_num_lbl = new JLabel(getNumStr(parent.getNumber()));

        this.mid_panel.add(parent_lbl);
        this.mid_panel.add(parent_suit_lbl);
        this.mid_panel.add(parent_num_lbl);

        setLabelFont(parent_lbl, Color.WHITE, 100, 30, 100, 20, 14, false);
        setLabelFont(parent_suit_lbl, Color.WHITE, 100, 50, 400, 600, 16, false);
        setLabelFont(parent_num_lbl, Color.WHITE, 100, 500, 50, 80, 16, true);

        this.child_lbl = new JLabel("Your Practice.Card");
        this.child_suit_lbl = new JLabel("");
        this.child_num_lbl = new JLabel(" ? ");

        this.mid_panel.add(child_lbl);
        this.mid_panel.add(child_suit_lbl);
        this.mid_panel.add(child_num_lbl);

        setLabelFont(child_lbl, Color.WHITE, 265, 30, 100, 20, 14, false);
        setLabelFont(child_suit_lbl, Color.WHITE, 800, 50, 300, 500, 16, false);
        setLabelFont(child_num_lbl, Color.WHITE, 850, 500, 50, 80, 16, true);

        this.bottom_panel = new JPanel();
        setPanel(bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(480, 50));
        this.dis.add(bottom_panel, BorderLayout.SOUTH);

        this.btn_high = new JButton("HIGH");
        setButton(btn_high, this, 240, 50, 20);
        bottom_panel.add(btn_high, BorderLayout.WEST);

        this.btn_low = new JButton("LOW");
        setButton(btn_low, this, 240, 50, 20);
        bottom_panel.add(btn_low, BorderLayout.EAST);

        this.dis.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();
        int parent_num = parent.getNumber();
        int child_num = child.getNumber();
        int child_suit = child.getSuit();

        child_num_lbl.setBackground(Color.WHITE);
        child_num_lbl.setText(getNumStr(child.getNumber()));
        child_suit_lbl.setBackground(Color.WHITE);
        child_suit_lbl.setIcon(getSuitIcon(child_suit));

        if(cmd.equals("HIGH")){
            btn_high.setBackground(Color.GREEN);
            if(parent_num < child_num){
                msg_lbl.setText("You win!");
            }else if(child_num < parent_num){
                msg_lbl.setText("You lose!");
            }else{
                msg_lbl.setText("Draw!");
            }
        }else{
            btn_low.setBackground(Color.GREEN);
            if(parent_num > child_num){
                msg_lbl.setText("You win!");
            }else if(child_num > parent_num){
                msg_lbl.setText("You lose!");
            }else{
                msg_lbl.setText("Draw!");
            }
        }
    }

    public static void setPanel(JPanel panel, Color color, BorderLayout layout, Dimension dimension){

        panel.setBackground(color);
        panel.setLayout(layout);
        panel.setPreferredSize(dimension);

        return;

    }

    public static void setLabelFont(JLabel label, Color color, int x_pos, int y_pos, int x_size, int y_size, int strSize, boolean opq){

        label.setBackground(color);
        label.setLocation(x_pos, y_pos);
        label.setSize(x_size, y_size);
        label.setFont(new Font("MS ゴッシク", Font.PLAIN, strSize));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setOpaque(opq);

        return;

    }

    public static void setButton(JButton btn, ActionListener al, int x_size, int y_size, int strSize){

        btn.setPreferredSize(new Dimension(x_size, y_size));
        btn.setFont(new Font("MS ゴシック", Font.PLAIN, strSize));
        btn.addActionListener(al);

        return;

    }

    public static ImageIcon getSuitIcon(int suit){

        ImageIcon icon;
        ImageIcon icon1;
        Image smallIcon;

        System.out.println(suit);

        switch(suit){
            case 0:
                icon = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/img/spade.jpeg");
                smallIcon = icon.getImage().getScaledInstance((int)(icon.getIconWidth() * 0.5), -1, Image.SCALE_SMOOTH );
                icon1 = new ImageIcon(smallIcon);
                return icon1;

            case 1:
                icon = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/img/heart.jpeg");
                return icon;

            case 2:
                icon = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/img/diamond.jpeg");
                return icon;

            case 3:
                icon = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/img/crab.jpeg");
                return icon;

            default:
                return null;

        }
    }

    public static String getNumStr(int num){
        switch(num){
            case 1:
                return "A";

            case 11:
                return "J";

            case 12:
                return "Q";

            case 13:
                return "K";

            default:
                return String.valueOf(num);
        }
    }

}
