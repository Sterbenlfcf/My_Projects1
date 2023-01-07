package Practice;

import javax.swing.*;
import java.awt.*;

public class Sample3 extends JFrame {
    public static void main(String[] args) {
        Sample3 frame = new Sample3("Practice.Game");
        frame.setVisible(true);
    }

    Sample3(String title){
        setTitle(title);
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon1 = new ImageIcon("/D:/MyProjects/My_Projects1/My_Projects1/src/img/spade.jpeg");

        JLabel label1 = new JLabel(icon1);

        JPanel p = new JPanel();
        p.add(label1);

        Container containerPane = getContentPane();
        containerPane.add(p, BorderLayout.CENTER);
    }

}
