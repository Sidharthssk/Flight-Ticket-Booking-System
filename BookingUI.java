import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class BookingUI extends JFrame implements ActionListener {

    String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December" };
    String[] year = { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };

    JLabel booking, lbl_date, lbl_dest, lbl_flight;
    JButton back, destination, flight, confirm;
    JComboBox cb_day, cb_month, cb_year;

    Container c;

    BookingUI() {

        setTitle("Ticket Booking");
        setSize(1000, 800);
        setLocation(100, 100);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        booking = new JLabel("Booking", JLabel.CENTER);
        booking.setBounds(0, 40, 1000, 50);
        booking.setFont(new Font("Arial", Font.BOLD, 30));
        c.add(booking);

        lbl_date = new JLabel("Date of Journey", JLabel.LEFT);
        lbl_date.setBounds(50, 130, 200, 30);
        lbl_date.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_date);

        cb_year = new JComboBox(year);
        cb_year.setBounds(300, 130, 100, 30);
        cb_year.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_year);

        cb_month = new JComboBox(month);
        cb_month.setBounds(410, 130, 150, 30);
        cb_month.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_month);

        cb_day = new JComboBox(day);
        cb_day.setBounds(570, 130, 50, 30);
        cb_day.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_day);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==back) {
            MainUI main = new MainUI();
            dispose();
            return;
        }

    }
}