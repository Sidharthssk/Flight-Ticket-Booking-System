import javax.swing.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;

public class BookingUI extends JFrame implements ActionListener {

    String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December" };
    String[] year = { "2022", "2023"};
    String[] depart = {"Kochi", "Trivandrum", "Kozhikode"};
    String[] dest = {"New York", "New Jersey", "London"};
    String[] class1 = {"Economy", "Business", "First Class"};
    String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    JLabel booking, lbl_date, lbl_depart, lbl_dest, lbl_class, lbl_number;
    JButton back, destination, flight, ok, cancel;
    JComboBox cb_day, cb_month, cb_year, cb_depart, cb_dest, cb_flight, cb_class, cb_number;

    Container c;

    static String selected_date,selected_month,selected_year;

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
        cb_year.addActionListener(this);
        

        cb_month = new JComboBox(month);
        cb_month.setBounds(410, 130, 150, 30);
        cb_month.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_month);
        cb_month.addActionListener(this);
        
        cb_day = new JComboBox(day);
        cb_day.setBounds(570, 130, 80, 30);
        cb_day.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_day);
        cb_day.addActionListener(this);

        lbl_depart = new JLabel("Departure", JLabel.LEFT);
        lbl_depart.setBounds(50, 170, 200, 30);
        lbl_depart.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_depart);

        cb_depart = new JComboBox(depart);
        cb_depart.setBounds(300, 170, 340, 30);
        cb_depart.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_depart);

        lbl_dest = new JLabel("Destination", JLabel.LEFT);
        lbl_dest.setBounds(50, 210, 200, 30);
        lbl_dest.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_dest);

        cb_dest = new JComboBox(dest);
        cb_dest.setBounds(300, 210, 340, 30);
        cb_dest.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_dest);

        lbl_class = new JLabel("Class", JLabel.LEFT);
        lbl_class.setBounds(50, 250, 200, 30);
        lbl_class.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_class);

        cb_class = new JComboBox(class1);
        cb_class.setBounds(300, 250, 340, 30);
        cb_class.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_class);

        lbl_number = new JLabel("Number of Tickets", JLabel.LEFT);
        lbl_number.setBounds(50, 290, 200, 30);
        lbl_number.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_number);

        cb_number = new JComboBox(number);
        cb_number.setBounds(300, 290, 340, 30);
        cb_number.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_number);

        cancel = new JButton("Cancel");
        cancel.setBounds(50, 400, 100, 30);
        c.add(cancel);

        ok = new JButton("OK");
        ok.setBounds(200, 400, 100, 30);
        c.add(ok);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==back) {
            MainUI main = new MainUI();
            dispose();
            return;
        }
        if(e.getSource() == cb_year){
            selected_year = cb_year.getSelectedItem().toString();
        }
        if(e.getSource() == cb_month){
            selected_month = cb_month.getSelectedItem().toString();
        }
        if(e.getSource() == cb_day){
            selected_date = cb_day.getSelectedItem().toString();
        }

        if(e.getSource() == cb_depart){
            String selected_depart = cb_depart.getSelectedItem().toString();
        }

        if(e.getSource() == cb_dest){
            String selected_dest = cb_dest.getSelectedItem().toString();
        }

        if(e.getSource() == cb_flight){
            String selected_flight = cb_flight.getSelectedItem().toString();
        }

        if(e.getSource() == cb_class){
            String selected_class = cb_class.getSelectedItem().toString();
        }

        if(e.getSource() == cb_number){
            String selected_number = cb_number.getSelectedItem().toString();
        }

        if(e.getSource() == ok){
            BookingUI booking = new BookingUI();
            dispose();
            return;
        }
        
        if(e.getSource() == cancel){
            MainUI main = new MainUI();
            dispose();
            return;
        }
        
    }

    static Date selectedDate(){

        Date date = new Date();
        
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(selected_date+"/"+selected_month+"/"+selected_year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
    
}
