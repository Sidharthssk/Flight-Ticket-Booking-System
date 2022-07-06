import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class Deque extends JFrame implements ActionListener {
    
    //deque using doubly linked list
    class Node {
        Ticket data;
        Node next;
        Node prev;
        
        Node(Ticket data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void add(Ticket data) {
        Node newNode = new Node(data);

        if (tail == null){
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    void remove(){
        tail = tail.prev;

        if (tail == null){
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

class DequeUI extends Deque {

    JLabel history, empty, number, numberLbl, passLbl, flightnoLbl, fromLbl, toLbl, dateLbl, departureTimeLbl,
            arrivalTimeLbl, classLbl, durationLbl;
    
    JButton back;
    Container c;

    DequeUI() {

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

        history = new JLabel("History", JLabel.CENTER);
        history.setBounds(500, 50, 100, 25);
        history.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(history);

        numberLbl = new JLabel("Number", JLabel.LEFT);
        numberLbl.setBounds(50, 100, 100, 30);
        numberLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(numberLbl);

        passLbl = new JLabel("Passenger", JLabel.LEFT);
        passLbl.setBounds(150, 100, 100, 30);
        passLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(passLbl);

        flightnoLbl = new JLabel("Flight No.", JLabel.LEFT);
        flightnoLbl.setBounds(250, 100, 100, 30);
        flightnoLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(flightnoLbl);

        fromLbl = new JLabel("From", JLabel.LEFT);
        fromLbl.setBounds(350, 100, 100, 30);
        fromLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(fromLbl);

        toLbl = new JLabel("To", JLabel.LEFT);
        toLbl.setBounds(450, 100, 100, 30);
        toLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(toLbl);

        dateLbl = new JLabel("Date", JLabel.LEFT);
        dateLbl.setBounds(550, 100, 100, 30);
        dateLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(dateLbl);

        departureTimeLbl = new JLabel("Departure Time", JLabel.LEFT);
        departureTimeLbl.setBounds(650, 100, 100, 30);
        departureTimeLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(departureTimeLbl);

        arrivalTimeLbl = new JLabel("Arrival Time", JLabel.LEFT);
        arrivalTimeLbl.setBounds(750, 100, 100, 30);
        arrivalTimeLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(arrivalTimeLbl);
        
        durationLbl = new JLabel("Duration", JLabel.LEFT);
        durationLbl.setBounds(850, 100, 100, 30);
        durationLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(durationLbl);

        classLbl = new JLabel("Class", JLabel.LEFT);
        classLbl.setBounds(950, 100, 100, 30);
        classLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(classLbl);
    }
    
}
