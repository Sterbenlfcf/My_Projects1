package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sample1 extends JFrame implements ActionListener {
    public static void main(String[] args) {
//        Practice.Sample1 frame = new Practice.Sample1("Practice.Game");
//        frame.setSize(1500, 1000);
//        frame.setLocationRelativeTo(null);
//        dis.setVisible(true);

        new Sample1();

        return;
    }

    private JFrame dis;
    private JPanel mid_panel;
    private JLabel lbl;

    Sample1() {

        dis = new JFrame("Practice.Game");
//        setTitle(title);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel p = new JPanel();
        JButton btn = new JButton("Push");
//        btn.addActionListener(this);

        this.mid_panel = new JPanel();
        Display.setPanel(mid_panel, Color.CYAN, null, new Dimension(480, 180));
        dis.add(mid_panel, BorderLayout.CENTER);

        Container contentPane = getContentPane();
//        contentPane.setBackground(Color.ORANGE);
        contentPane.add(btn, BorderLayout.NORTH);

//        p.add(btn);
//        getContentPane().add(p, BorderLayout.CENTER);

        dis.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JLabel label = new JLabel("Push A Button");
        JOptionPane.showMessageDialog(this, label);
    }

    public static ImageIcon getIcon(){

        ImageIcon icon;

        icon = new ImageIcon("./img/spade.jpeg");
        return icon;

    }

}
