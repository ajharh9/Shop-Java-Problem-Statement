package Java_Problem_Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//User this class to start the app;
public class Main extends JFrame implements ActionListener {
    JButton click;

    Main() {
        setTitle("SHOP");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/shop.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(300, 1, 200, 200);
        add(label);

        JLabel text = new JLabel("Welcome to Stationary Shop");
        text.setFont(new Font("OSWALD", Font.BOLD, 50));
        text.setBounds(50, 220, 700, 60);
        add(text);

        JLabel clickText = new JLabel("CLICK HERE TO START SHOPPING");
        clickText.setFont(new Font("OSWALD", Font.BOLD, 30));
        clickText.setBounds(130, 320, 600, 40);
        add(clickText);

        click = new JButton("CLICK HERE");
        click.setFont(new Font("OSWALD", Font.BOLD, 15));
        click.setBounds(340, 380, 130, 30);
        click.setBackground(Color.BLUE);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        add(click);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setLocation(350, 80);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == click) {
            setVisible(false);
            new Order().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
