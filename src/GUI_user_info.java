import javax.swing.*;
import java.awt.*;
import javax.swing.*;
public class GUI_user_info extends JFrame {
    GUI_user_info() {
        setTitle("user_info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("ID "));
        c.add(new JTextField("whyuk47",20));
        c.add(new JLabel("name "));
        c.add(new JTextField("민우혁",20));
        c.add(new JLabel("nick "));
        c.add(new JTextField("Minner",20));
        c.add(new JLabel("email "));
        c.add(new JTextField("whyuk7545@gmail.com",20));
        c.add(new JLabel("sns "));
        c.add(new JTextField("Null",20));
        c.add(new JLabel("game_record"));
        c.add(new JTextField("5승 5패",20));

        setSize(300,150);
        setVisible(true);
    }
    public static void main(String [] args) {
        new GUI_user_info();
    }

}
/*
ID
PW
name
nick
email
sns
game_record
my_access
 */