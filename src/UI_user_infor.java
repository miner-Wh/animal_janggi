import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class UI_user_infor {
    private JPanel User_info;
    private JButton editButton;
    private JTextField whyuk47TextField;
    private JTextField minnerTextField;
    private JTextField 민우혁TextField;
    private JTextField whyuk7545GmailComTextField;
    private JTextField kakaoWhyuk47TextField;
    private JTextField a24TextField;
    private JButton exitButton;
    private JButton goAccessButton;

    public static void main(String args[]) {
        JFrame frame = new JFrame("user_infor");
        frame.setContentPane(new UI_user_infor().User_info);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
