import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class Queue extends JFrame implements ActionListener {

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue(String data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    void print() {
        Node current = front;

        while (current != null) {
            if (current == front) {
                System.out.print(current.data);
            } else {
                System.out.print(" -> " + current.data);
            }
            current = current.next;
        }
        System.out.println();
    }

    void dequeue() {
        front = front.next;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

class QueueUI extends Queue {

    JLabel query, queryText;
    JButton back, solve;
    Container c;

    static Queue q = new Queue();

    QueueUI() {

        setTitle("Queries");
        setSize(1000, 700);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        query = new JLabel("Recent Queries.", JLabel.CENTER);
        query.setBounds(400, 50, 200, 40);
        query.setFont(new Font("Arial", Font.BOLD, 20));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        query.setBorder(border);
        c.add(query);

        solve = new JButton("Solve");
        solve.setBounds(800, 120, 100, 40);
        c.add(solve);
        solve.addActionListener(this);
        solve.setVisible(false);

        Node current = q.front;
        int y = 120;
        int no = 1;

        if (current == null) {
            queryText = new JLabel("No queries.", JLabel.CENTER);
            queryText.setBounds(400, y, 200, 25);
            queryText.setFont(new Font("Arial", Font.BOLD, 15));
            queryText.setBorder(border);
            c.add(queryText);
        }

        else {
            while (current != null) {
                queryText = new JLabel("<html><span>" + no + ". " + "<br>" + current.data + "</span></html>",
                        JLabel.LEFT);
                queryText.setBounds(100, y, 700, 40);
                queryText.setFont(new Font("Arial", Font.PLAIN, 15));
                queryText.setBorder(border);
                c.add(queryText);

                solve.setVisible(true);

                current = current.next;
                y += 50;
                no++;
            }
        }

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == back) {
            dispose();
            new AdminUI();
        }
        if (e.getSource() == solve) {
            q.dequeue();
            dispose();
            new QueueUI();
        }
    }
}