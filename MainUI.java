import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class MainUI extends Users implements ActionListener {

    JLabel welcome_User;
    JButton back, bookings, query, history, Logout, Profile;
    Container c;

    MainUI() {

        setTitle("Ace Travels");
        setSize(1000, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        back.addActionListener(this);
        c.add(back);

        Logout = new JButton("Logout");
        Logout.setBounds(880, 5, 100, 25);
        Logout.addActionListener(this);
        c.add(Logout);

        welcome_User = new JLabel("Hi " + currentUser.username + ". ", JLabel.CENTER);
        welcome_User.setBounds(0, 40, 1000, 50);
        welcome_User.setFont(new Font("Arial", Font.BOLD, 30));
        c.add(welcome_User);

        bookings = new JButton("Bookings");
        bookings.setBounds(300, 140, 100, 30);
        c.add(bookings);
        bookings.addActionListener(this);

        query = new JButton("Add Query");
        query.setBounds(450, 140, 100, 30);
        c.add(query);
        query.addActionListener(this);

        history = new JButton("View History");
        history.setBounds(600, 140, 120, 30);
        c.add(history);
        history.addActionListener(this);

        Profile = new JButton("Profile");
        Profile.setBounds(770, 5, 100, 25);
        c.add(Profile);
        Profile.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookings) {
            dispose();
            new BookingUI();
        } else if (e.getSource() == back) {
            dispose();
            new Login();
        } else if (e.getSource() == query) {
            dispose();
            new QueriesUI();
        } else if (e.getSource() == Logout) {
            dispose();
            new Login();
        } else if (e.getSource() == Profile) {
            dispose();
            new ProfileUI();
        } else if (e.getSource() == history) {
            dispose();
            new DequeUI();
        }

    }
}