import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class Deque extends JFrame implements ActionListener {

    // deque using doubly linked list
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

        if (tail == null) {
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

    void remove() {
        tail = tail.prev;

        if (tail == null) {
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

class DequeUI extends Deque implements ActionListener {

    JLabel history, empty, number, numberLbl, passLbl, flightnoLbl, fromLbl, toLbl, dateLbl, departureTimeLbl,
            arrivalTimeLbl, classLbl, durationLbl, pass, flightno, from, to, date, departureTime, arrivalTime, duration,
            sclass;

    JButton back, cancel;
    Container c;

    DequeUI() {

        setTitle("History");
        setSize(1300, 700);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        history = new JLabel("Booking History", JLabel.CENTER);
        history.setBounds(450, 50, 200, 25);
        history.setFont(new Font("Arial", Font.BOLD, 13));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        history.setBorder(border);
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

        int index = Users.usersList.indexOf(Users.currentUser);

        Node current = Users.usersList.get(index).d.tail;
        int no = 1;
        int y = 150;

        if (current == null) {
            empty = new JLabel("No Bookings", JLabel.CENTER);
            empty.setBounds(500, 250, 100, 30);
            empty.setFont(new Font("Arial", Font.BOLD, 15));
            c.add(empty);

            numberLbl.setVisible(false);
            passLbl.setVisible(false);
            flightnoLbl.setVisible(false);
            fromLbl.setVisible(false);
            toLbl.setVisible(false);
            dateLbl.setVisible(false);
            departureTimeLbl.setVisible(false);
            arrivalTimeLbl.setVisible(false);
            classLbl.setVisible(false);
            durationLbl.setVisible(false);
        } else {
            while (current != null) {
                number = new JLabel(Integer.toString(no), JLabel.LEFT);
                number.setBounds(50, y, 100, 30);
                number.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(number);

                pass = new JLabel(current.data.passenger_name, JLabel.LEFT);
                pass.setBounds(150, y, 100, 30);
                pass.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(pass);

                flightno = new JLabel(current.data.flightNo, JLabel.LEFT);
                flightno.setBounds(250, y, 100, 30);
                flightno.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(flightno);

                from = new JLabel(current.data.from, JLabel.LEFT);
                from.setBounds(350, y, 100, 30);
                from.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(from);

                to = new JLabel(current.data.to, JLabel.LEFT);
                to.setBounds(450, y, 100, 30);
                to.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(to);

                date = new JLabel(current.data.date.toString(), JLabel.LEFT);
                date.setBounds(550, y, 100, 30);
                date.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(date);

                departureTime = new JLabel(current.data.departure_time + ":00", JLabel.LEFT);
                departureTime.setBounds(650, y, 100, 30);
                departureTime.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(departureTime);

                arrivalTime = new JLabel(current.data.arrival_time + ":00", JLabel.LEFT);
                arrivalTime.setBounds(750, y, 100, 30);
                arrivalTime.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(arrivalTime);

                duration = new JLabel(Integer.toString(
                        Integer.parseInt(current.data.arrival_time) - Integer.parseInt(current.data.departure_time))
                        + ":00",
                        JLabel.LEFT);
                duration.setBounds(850, y, 100, 30);
                duration.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(duration);

                sclass = new JLabel(current.data.class_type, JLabel.LEFT);
                sclass.setBounds(950, y, 100, 30);
                sclass.setFont(new Font("Arial", Font.BOLD, 13));
                c.add(sclass);

                current = current.prev;
                no++;
                y += 50;

            }

            cancel = new JButton("Cancel");
            cancel.setBounds(1100, 150, 100, 30);
            cancel.setFont(new Font("Arial", Font.BOLD, 13));
            cancel.addActionListener(this);
            c.add(cancel);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == back) {
            dispose();
            new MainUI();
        }
        if (e.getSource() == cancel) {
            // Users.usersList.get(index).d.add(t);
            new Thread(new Runnable() {
                public void run() {
                    int index = Users.usersList.indexOf(Users.currentUser);
                    Ticket t = Users.usersList.get(index).d.tail.data;
                    FlightDetails selectedFlight = t.flight;
                    int flightIndex = FlightDetails.flightlist.indexOf(selectedFlight);
                    FlightBook.ticketQueue.remove(Users.usersList.get(index), t);
                    Users.usersList.get(index).d.remove();

                    // if(t.class_type.equals("Economy Class")){
                    //     for(int i=0;i<t.additional_users.length;i++){
                    //         int front = FlightDetails.flightlist.get(flightIndex).getFront2();
                    //         int rear = FlightDetails.flightlist.get(flightIndex).getRear2();
                    //         int size = FlightDetails.flightlist.get(flightIndex).getEconomySeats();
                    //         if(front == rear){
                    //             FlightDetails.flightlist.get(flightIndex).setfront2(-1);
                    //             FlightDetails.flightlist.get(flightIndex).setrear2(-1);
                    //         }
                    //         else if(front == size-1){
                    //             front = 0;
                    //             FlightDetails.flightlist.get(flightIndex).setfront2(front);
                    //         }
                    //         else{
                    //             front++;
                    //             FlightDetails.flightlist.get(flightIndex).setfront2(front);
                    //         }
                    //     }
                    // }

                    // else if(t.class_type.equals("Business Class")){
                    //     for(int i=0;i<t.additional_users.length;i++){
                    //         int front = FlightDetails.flightlist.get(flightIndex).getFront1();
                    //         int rear = FlightDetails.flightlist.get(flightIndex).getRear1();
                    //         int size = FlightDetails.flightlist.get(flightIndex).getBusinessSeats();
                    //         if((front+1)%size == rear){
                    //             FlightDetails.flightlist.get(flightIndex).setfront1(-1);
                    //             FlightDetails.flightlist.get(flightIndex).setrear1(-1);
                    //         }
                    //         else{
                    //             front = (front+1)%size;
                    //             FlightDetails.flightlist.get(flightIndex).setfront1(front);
                    //         }
                    //     }
                    // }

                    dispose();
                    new DequeUI();
                }
            }).start();

        }

    }
}