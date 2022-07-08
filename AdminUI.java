import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class AdminUI extends JFrame implements ActionListener {

    Container c;
    JLabel welcome;
    JButton back, view_tickets, view_query;

    AdminUI() {

        setTitle("Booking.com");
        setSize(1000, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        welcome = new JLabel("Admin Controls", JLabel.CENTER);
        welcome.setBounds(350, 50, 300, 40);
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        welcome.setBorder(border);
        c.add(welcome);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        view_tickets = new JButton("View Tickets");
        view_tickets.setBounds(200, 200, 150, 30);
        c.add(view_tickets);
        view_tickets.addActionListener(this);

        view_query = new JButton("View Queries");
        view_query.setBounds(700, 200, 150, 30);
        c.add(view_query);
        view_query.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == back) {
            dispose();
            new Login();
        } else if (e.getSource() == view_tickets) {
            dispose();
            new PQueueUI();
        } else if (e.getSource() == view_query) {
            dispose();
            new QueueUI();
        }
        
    }

}