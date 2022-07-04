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

    // void printList() {
    // Node current = head;

    // while (current != null) {
    // if (current == head) {
    // System.out.print("(" + current.priority + "," + current.data + ")");
    // } else {
    // System.out.print(" -> " + "(" + current.priority + "," + current.data + ")");
    // }
    // current = current.next;
    // }
    // System.out.println();
    // }

    void printList() {
        TicketListUI t = new TicketListUI();

        Node current = head;
        int y = 70;
        while (current != null) {

            Border border = BorderFactory.createLineBorder(Color.BLACK);

            t.passenger = new JLabel(current.data.passenger_name, JLabel.CENTER);
            t.passenger.setBounds(100, y, 250, 20);
            t.passenger.setFont(new Font("Arial", Font.BOLD, 15));
            t.passenger.setBorder(border);
            t.c.add(t.passenger);

            t.from = new JLabel(current.data.from, JLabel.CENTER);
            t.from.setBounds(350, y, 150, 20);
            t.from.setFont(new Font("Arial", Font.BOLD, 15));
            t.from.setBorder(border);
            t.c.add(t.from);

            t.to = new JLabel(current.data.to, JLabel.CENTER);
            t.to.setBounds(500, y, 150, 20);
            t.to.setFont(new Font("Arial", Font.BOLD, 15));
            t.to.setBorder(border);
            t.c.add(t.to);

            t.date = new JLabel(current.data.date.toString(), JLabel.CENTER);
            t.date.setBounds(650, y, 150, 20);
            t.date.setFont(new Font("Arial", Font.BOLD, 15));
            t.date.setBorder(border);
            t.c.add(t.date);

            t.departure_time = new JLabel(current.data.departure_time, JLabel.CENTER);
            t.departure_time.setBounds(800, y, 150, 20);
            t.departure_time.setFont(new Font("Arial", Font.BOLD, 15));
            t.departure_time.setBorder(border);
            t.c.add(t.departure_time);

            t.arrival_time = new JLabel(current.data.arrival_time, JLabel.CENTER);
            t.arrival_time.setBounds(950, y, 150, 20);
            t.arrival_time.setFont(new Font("Arial", Font.BOLD, 15));
            t.arrival_time.setBorder(border);
            t.c.add(t.arrival_time);

            t.class_type = new JLabel(current.data.class_type, JLabel.CENTER);
            t.class_type.setBounds(1100, y, 150, 20);
            t.class_type.setFont(new Font("Arial", Font.BOLD, 15));
            t.class_type.setBorder(border);
            t.c.add(t.class_type);

            int dur = Integer.parseInt(current.data.arrival_time.substring(0, 2)) - Integer.parseInt(current.data.departure_time.substring(0, 2));

            t.duration = new JLabel(Integer.toString(dur), JLabel.CENTER);
            t.duration.setBounds(1250, y, 150, 20);
            t.duration.setFont(new Font("Arial", Font.BOLD, 15));
            t.duration.setBorder(border);
            t.c.add(t.duration);

            current = current.next;
            y = y + 20;


        }
        System.out.println();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    // int len(){
    // return size;
    // }

    // int [] min(){
    // int [] array = new int[2];

    // array[0] = head.priority;
    // array[1] = head.data;

    // return array;
    // }

    // int [] remove_min(){
    // int [] array = new int[2];

    // array[0] = head.priority;
    // array[1] = head.data;

    // head = head.next;

    // size--;

    // return array;
    // }

    // boolean is_empty(){
    // if(size == 0){
    // return true;
    // }
    // return false;
    // }

}