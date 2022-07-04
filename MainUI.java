import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class MainUI extends Users implements ActionListener {

    JLabel welcome_User;
    JButton back, bookings, flight_status, holiday_planner,  Logout, Profile;
    Container c;

    MainUI() {

        setTitle("Booking.com");
        setSize(1000, 800);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        back.addActionListener(this);
        c.add(back);

        welcome_User = new JLabel("Hi " + currentUser.username + ". ", JLabel.CENTER);
        welcome_User.setBounds(0, 40, 1000, 50);
        welcome_User.setFont(new Font("Arial", Font.BOLD, 30));
        c.add(welcome_User);

        bookings = new JButton("Bookings");
        bookings.setBounds(200, 140, 100, 30);
        c.add(bookings);
        bookings.addActionListener(this);

        flight_status = new JButton("Flight Status");
        flight_status.setBounds(700, 140, 100, 30);
        c.add(flight_status);

        holiday_planner = new JButton("Holiday Planner");
        holiday_planner.setBounds(200, 240, 100, 30);
        c.add(holiday_planner);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bookings){
            dispose();
            new BookingUI();
        }
        else if (e.getSource() == back){
            dispose();
            new Login();
        }
    }

}
