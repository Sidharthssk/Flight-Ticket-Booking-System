import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class SortedPriorityQueue extends JFrame implements ActionListener {

    class Node {
        LocalDate priority;
        Ticket data;
        Node next;

        Node(LocalDate priority, Ticket data) {
            this.priority = priority;
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void add(LocalDate priority, Ticket data) {
        Node newNode = new Node(priority, data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (newNode.priority.isBefore(head.priority)) {
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node currentNode = head;
            Node TicketListUI = head;
            int flag = 0;
            while (currentNode != tail) {
                currentNode = TicketListUI;
                TicketListUI = TicketListUI.next;
                if (TicketListUI != null && TicketListUI.priority.isAfter(newNode.priority)) {
                    newNode.next = TicketListUI;
                    currentNode.next = newNode;
                    size++;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                tail.next = newNode;
                tail = newNode;
                size++;
            }
        }
    }

    void remove() {
        Node current = ChatBot.ticketQueue.head;
        while (current != null) {
            if (LocalDate.now().isAfter(current.priority)) {
                head = current.next;
                size--;
            }
            current = current.next;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}

class PQueueUI extends SortedPriorityQueue {

    JLabel empty, number, number_lbl, passenger_lbl,flightno_lbl, from_lbl, to_lbl, date_lbl, departure_time_lbl, arrival_time_lbl,
            class_type_lbl, duration_lbl, passenger, flightno, from, to, date, departure_time, arrival_time, class_type, duration;
    JButton back, recent;
    Container c;

    PQueueUI() {

        setTitle("Booking.com");
        setSize(1100, 700);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        recent = new JButton("Active Tickets");
        recent.setBounds(950, 5, 130, 25);
        c.add(recent);
        recent.addActionListener(this);

        number = new JLabel("Number", JLabel.LEFT);
        number.setBounds(50, 50, 100, 30);
        number.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(number);

        passenger_lbl = new JLabel("Passenger", JLabel.LEFT);
        passenger_lbl.setBounds(150, 50, 100, 30);
        passenger_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(passenger_lbl);

        flightno_lbl = new JLabel("Flight No.", JLabel.LEFT);
        flightno_lbl.setBounds(250, 50, 100, 30);
        flightno_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(flightno_lbl);

        from_lbl = new JLabel("From", JLabel.LEFT);
        from_lbl.setBounds(350, 50, 100, 30);
        from_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(from_lbl);

        to_lbl = new JLabel("To", JLabel.LEFT);
        to_lbl.setBounds(450, 50, 100, 30);
        to_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(to_lbl);

        date_lbl = new JLabel("Date", JLabel.LEFT);
        date_lbl.setBounds(550, 50, 100, 30);
        date_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(date_lbl);

        departure_time_lbl = new JLabel("Departure Time", JLabel.LEFT);
        departure_time_lbl.setBounds(650, 50, 100, 30);
        departure_time_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(departure_time_lbl);

        arrival_time_lbl = new JLabel("Arrival Time", JLabel.LEFT);
        arrival_time_lbl.setBounds(750, 50, 100, 30);
        arrival_time_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(arrival_time_lbl);

        duration_lbl = new JLabel("Duration", JLabel.LEFT);
        duration_lbl.setBounds(850, 50, 100, 30);
        duration_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(duration_lbl);

        class_type_lbl = new JLabel("Class", JLabel.LEFT);
        class_type_lbl.setBounds(950, 50, 50, 30);
        class_type_lbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(class_type_lbl);

        int y = 100;
        Node current = ChatBot.ticketQueue.head;
        int no = 1;

        if (current == null) {
            empty = new JLabel("No Recent Bookings", JLabel.CENTER);
            empty.setBounds(250, 250, 500, 40);
            empty.setFont(new Font("Arial", Font.BOLD, 15));
            c.add(empty);
            number.setVisible(false);
            passenger_lbl.setVisible(false);
            flightno_lbl.setVisible(false);
            from_lbl.setVisible(false);
            to_lbl.setVisible(false);
            date_lbl.setVisible(false);
            departure_time_lbl.setVisible(false);
            arrival_time_lbl.setVisible(false);
            duration_lbl.setVisible(false);
            class_type_lbl.setVisible(false);
        } else {
            while (current != null) {
                number = new JLabel(Integer.toString(no) + ".", JLabel.LEFT);
                number.setBounds(50, y, 100, 30);
                number.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(number);

                passenger = new JLabel(current.data.passenger_name, JLabel.LEFT);
                passenger.setBounds(150, y, 100, 30);
                passenger.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(passenger);

                flightno = new JLabel(current.data.flightNo, JLabel.LEFT);
                flightno.setBounds(250, y, 10, 30);
                flightno.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(flightno);

                from = new JLabel(current.data.from, JLabel.LEFT);
                from.setBounds(350, y, 100, 30);
                from.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(from);

                to = new JLabel(current.data.to, JLabel.LEFT);
                to.setBounds(450, y, 100, 30);
                to.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(to);

                date = new JLabel(current.data.date.toString(), JLabel.LEFT);
                date.setBounds(550, y, 100, 30);
                date.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(date);

                departure_time = new JLabel(current.data.departure_time+":00", JLabel.LEFT);
                departure_time.setBounds(650, y, 100, 30);
                departure_time.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(departure_time);

                arrival_time = new JLabel(current.data.arrival_time+":00", JLabel.LEFT);
                arrival_time.setBounds(750, y, 100, 30);
                arrival_time.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(arrival_time);

                duration = new JLabel(Integer.toString(
                        Integer.parseInt(current.data.arrival_time) - Integer.parseInt(current.data.departure_time))+":00",
                        JLabel.LEFT);
                duration.setBounds(850, y, 100, 30);
                duration.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(duration);

                class_type = new JLabel(current.data.class_type, JLabel.LEFT);
                class_type.setBounds(950, y, 100, 30);
                class_type.setFont(new Font("Arial", Font.BOLD, 12));
                c.add(class_type);

                y += 35;
                current = current.next;
                no++;
            }
        }

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            new AdminUI();
        }
        if (e.getSource() == recent) {
            new Thread(new Runnable() {
                public void run() {
                    ChatBot.ticketQueue.remove();
                    dispose();
                    new PQueueUI();
                }
            }).start();

        }
    }
}