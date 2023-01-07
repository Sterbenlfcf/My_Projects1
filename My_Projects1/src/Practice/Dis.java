package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dis implements ActionListener {

    private JFrame dis;
    private JPanel mid_panel;
    private JLabel msg_lbl;
    private JLabel suit_lbl;
    private JButton btn_high, btn_low;

    public Dis(){

        this.dis = new JFrame("HIGH & LOW");
        this.dis.setSize(1000, 800);
        this.dis.setLocationRelativeTo(null);
        this.dis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.dis.setResizable(false);

        this.mid_panel = new JPanel();
        setPanel(mid_panel, Color.CYAN, null, new Dimension(480, 180));
        this.dis.add(mid_panel, BorderLayout.CENTER);

//        this.suit_lbl = new JLabel(getSuitIcon(0));

        this.suit_lbl = new JLabel(getSuitIcon((0)));
        this.mid_panel.add(suit_lbl);

        setLabelFont(suit_lbl, Color.WHITE, 300, 10, 80, 100, 16, false);

        this.dis.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

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

    public static ImageIcon getSuitIcon(int suit) {

        ImageIcon icon;

        switch (suit) {
            case 0:
                icon = new ImageIcon("spade.jpeg");
                System.out.println(icon);
                return icon;

            case 1:
                icon = new ImageIcon("./img/heart.jpeg");
                return icon;

            case 2:
                icon = new ImageIcon("./img/diamond.jpeg");
                return icon;

            case 3:
                icon = new ImageIcon("./img/crab.jpeg");
                return icon;

            default:
                return null;

        }
    }

}
