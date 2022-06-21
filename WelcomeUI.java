
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class WelcomeUI extends JFrame implements ActionListener {

    JLabel Welcome_msg, Options;
    JButton login,signup;
    Container c;

    WelcomeUI() {

        setTitle("Booking.com");
        setSize(1000, 800);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        Welcome_msg = new JLabel("Welcome to Booking.com", JLabel.CENTER);
        Welcome_msg.setBounds(30, 50, 940, 40);
        Welcome_msg.setFont(new Font("Arial", Font.BOLD, 30));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Welcome_msg.setBorder(border);
        c.add(Welcome_msg);

        Options = new JLabel("Select an option", JLabel.CENTER);
        Options.setBounds(30, 110, 940, 25);
        Options.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(Options);

        login = new JButton("Login");
        login.setBounds(200, 200, 100, 30);
        c.add(login);
        login.addActionListener(this);

        signup = new JButton("Signup");
        signup.setBounds(700, 200, 100, 30);
        c.add(signup);
        signup.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            Login login = new Login();
            dispose();
        }
        else if(e.getSource() == signup){
            SignUp signup = new SignUp();
            dispose();
        }

    }

}
