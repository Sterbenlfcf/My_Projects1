import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sample1 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        Sample1 frame = new Sample1("Game");
//        frame.setSize(1500, 1000);
//        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Sample1(String title) {
        setTitle(title);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel p = new JPanel();
        JButton btn = new JButton("Push");
//        btn.addActionListener(this);

        Container contentPane = getContentPane();
//        contentPane.setBackground(Color.ORANGE);
        contentPane.add(btn, BorderLayout.NORTH);

//        p.add(btn);
//        getContentPane().add(p, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        JLabel label = new JLabel("Push A Button");
        JOptionPane.showMessageDialog(this, label);
    }
}
