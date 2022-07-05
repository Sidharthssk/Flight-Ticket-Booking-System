import javax.swing.*;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;

public class BookingUI extends JFrame implements ActionListener {

    String[] day = { "day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" };
    String[] month = { "month", "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October",
            "November", "December" };
    // to map month into number
    static HashMap<String, String> month_number = new HashMap<>();
    {
        month_number.put("January", "01");
        month_number.put("February", "02");
        month_number.put("March", "03");
        month_number.put("April", "04");
        month_number.put("May", "05");
        month_number.put("June", "06");
        month_number.put("July", "07");
        month_number.put("August", "08");
        month_number.put("September", "09");
        month_number.put("October", "10");
        month_number.put("November", "11");
        month_number.put("December", "12");
    }

    String[] year = { "year", "2022", "2023" };
    String[] depart = { "select", "Cochin", "Trivandrum", "Kozhikode", "Mumbai", "NewDelhi" };
    String[] dest = { "select", "Dammam", "Riyadh", "Qatar", "Kuwait", "Dubai" };
    String[] class1 = { "select", "Economy", "Business" };
    String[] number = { "select", "1", "2", "3", "4"};

    JLabel booking, lbl_date, lbl_depart, lbl_dest, lbl_class, lbl_number;
    JButton back, destination, ok, cancel;
    JComboBox cb_day, cb_month, cb_year, cb_depart, cb_dest, cb_flight, cb_class, cb_number;

    Container c;

    static String selected_date, selected_month, selected_year, selected_dest, selected_depart, selected_number, final_selected_date;

    BookingUI() {

        setTitle("Ticket Booking");
        setSize(1000, 600);
        setLocation(200, 50);

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
        lbl_date.setBounds(175, 130, 200, 30);
        lbl_date.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_date);

        cb_year = new JComboBox(year);
        cb_year.setBounds(425, 130, 100, 30);
        cb_year.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_year);

        cb_month = new JComboBox(month);
        cb_month.setBounds(535, 130, 150, 30);
        cb_month.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_month);
        cb_month.addActionListener(this);

        cb_day = new JComboBox(day);
        cb_day.setBounds(695, 130, 100, 30);
        cb_day.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_day);

        lbl_depart = new JLabel("Departure", JLabel.LEFT);
        lbl_depart.setBounds(175, 180, 200, 30);
        lbl_depart.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_depart);

        cb_depart = new JComboBox(depart);
        cb_depart.setBounds(425, 180, 370, 30);
        cb_depart.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_depart);

        lbl_dest = new JLabel("Destination", JLabel.LEFT);
        lbl_dest.setBounds(175, 230, 200, 30);
        lbl_dest.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_dest);

        cb_dest = new JComboBox(dest);
        cb_dest.setBounds(425, 230, 370, 30);
        cb_dest.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_dest);

        lbl_number = new JLabel("Number of Tickets", JLabel.LEFT);
        lbl_number.setBounds(175, 280, 200, 30);
        lbl_number.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(lbl_number);

        cb_number = new JComboBox(number);
        cb_number.setBounds(425, 280, 370, 30);
        cb_number.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(cb_number);

        cancel = new JButton("Cancel");
        cancel.setBounds(390, 350, 100, 30);
        c.add(cancel);
        cancel.addActionListener(this);

        ok = new JButton("OK");
        ok.setBounds(500, 350, 100, 30);
        c.add(ok);
        ok.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new MainUI();
            dispose();
            return;
        }
        if (e.getSource() == cb_month) {
            selected_month = cb_month.getSelectedItem().toString();
            if (selected_month.equals("January") || selected_month.equals("March") || selected_month.equals("May")
                    || selected_month.equals("July") || selected_month.equals("August")
                    || selected_month.equals("October") || selected_month.equals("December")) {
                cb_day.removeAllItems();
                for (int i = 1; i <= 31; i++) {
                    cb_day.addItem(i);
                }
            } else if (selected_month.equals("February")) {
                cb_day.removeAllItems();
                for (int i = 1; i <= 28; i++) {
                    cb_day.addItem(i);
                }
            } else {
                cb_day.removeAllItems();
                for (int i = 1; i <= 30; i++) {
                    cb_day.addItem(i);
                }
            }
        }

        if (e.getSource() == ok) {
            new Thread(new Runnable() {
                public void run() {
                    selected_year = cb_year.getSelectedItem().toString();
                    selected_date = cb_day.getSelectedItem().toString();
                    selected_depart = cb_depart.getSelectedItem().toString();
                    selected_dest = cb_dest.getSelectedItem().toString();
                    selected_number = cb_number.getSelectedItem().toString();

                    if (Integer.parseInt(selected_date) < 10) {
                        selected_date = "0" + selected_date;
                    }
                    final_selected_date = selected_date+"/"+month_number.get(selected_month)+"/"+selected_year;
                    new FlightShowingUI();
                    dispose();
                }
            }).start();
        }

        if (e.getSource() == cancel) {
          new MainUI();
            dispose();
        }

    }

    static LocalDate selectedDate() {
        return LocalDate.of(Integer.parseInt(selected_year),
                Integer.parseInt(month_number.get(selected_month)), Integer.parseInt(selected_date));
    }

}