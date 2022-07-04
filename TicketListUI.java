import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class TicketListUI extends JFrame implements ActionListener{
    Container c;
    JLabel passenger_lbl,from_lbl,to_lbl,date_lbl,departure_time_lbl,arrival_time_lbl,class_type_lbl,duration_lbl,passenger,from,to,date,departure_time,arrival_time,class_type,duration;
    JButton back;

    TicketListUI(){
        setTitle("Booking.com");
        setSize(1500,800);
        setLocation(25,25);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5,5,70,25);
        c.add(back);
        back.addActionListener(this);
        
        passenger_lbl = new JLabel("Passenger Name",JLabel.CENTER);
        passenger_lbl.setBounds(100,50,250,20);
        passenger_lbl.setFont(new Font("Arial",Font.BOLD,15));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        passenger_lbl.setBorder(border);
        c.add(passenger_lbl);

        from_lbl = new JLabel("From",JLabel.CENTER);
        from_lbl.setBounds(350,50,150,20);
        from_lbl.setFont(new Font("Arial",Font.BOLD,15));
        from_lbl.setBorder(border);
        c.add(from_lbl);

        to_lbl = new JLabel("To",JLabel.CENTER);
        to_lbl.setBounds(500,50,150,20);
        to_lbl.setFont(new Font("Arial",Font.BOLD,15));
        to_lbl.setBorder(border);
        c.add(to_lbl);

        date_lbl = new JLabel("Date",JLabel.CENTER);
        date_lbl.setBounds(650,50,150,20);
        date_lbl.setFont(new Font("Arial",Font.BOLD,15));
        date_lbl.setBorder(border);
        c.add(date_lbl);

        departure_time_lbl = new JLabel("Departure Time",JLabel.CENTER);
        departure_time_lbl.setBounds(800,50,150,20);
        departure_time_lbl.setFont(new Font("Arial",Font.BOLD,15));
        departure_time_lbl.setBorder(border);
        c.add(departure_time_lbl);

        arrival_time_lbl = new JLabel("Arrival Time",JLabel.CENTER);
        arrival_time_lbl.setBounds(950,50,150,20);
        arrival_time_lbl.setFont(new Font("Arial",Font.BOLD,15));
        arrival_time_lbl.setBorder(border);
        c.add(arrival_time_lbl);

        class_type_lbl = new JLabel("Class Type",JLabel.CENTER);
        class_type_lbl.setBounds(1100,50,150,20);
        class_type_lbl.setFont(new Font("Arial",Font.BOLD,15));
        class_type_lbl.setBorder(border);
        c.add(class_type_lbl);

        duration_lbl = new JLabel("Duration",JLabel.CENTER);
        duration_lbl.setBounds(1250,50,150,20);
        duration_lbl.setFont(new Font("Arial",Font.BOLD,15));
        duration_lbl.setBorder(border);
        c.add(duration_lbl);

        ChatBot.ticketQueue.printList();
        

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    

    
}