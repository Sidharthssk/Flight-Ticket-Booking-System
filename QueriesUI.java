import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class QueriesUI extends JFrame implements ActionListener {

    Container c;
    JLabel enter_query, success;
    JTextArea query_text;
    JButton back, submit , ok;

    //Queue q = new Queue();

    QueriesUI(){
            
            setTitle("Booking.com");
            setSize(1000, 700);
            setLocation(200, 50);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    
            c = getContentPane();
            c.setLayout(null);
    
            enter_query = new JLabel("Enter your query", JLabel.CENTER);
            enter_query.setBounds(30, 50, 940, 40);
            enter_query.setFont(new Font("Arial", Font.BOLD, 30));
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            enter_query.setBorder(border);
            c.add(enter_query);
    
            query_text = new JTextArea();
            query_text.setBounds(30, 110, 940, 400);
            c.add(query_text);
    
            back = new JButton("Back");
            back.setBounds(5, 5, 70, 25);
            c.add(back);
            back.addActionListener(this);
    
            submit = new JButton("Submit");
            submit.setBounds(450, 530, 100, 30);
            c.add(submit);
            submit.addActionListener(this);
    
            success = new JLabel("Query submitted successfully.", JLabel.CENTER);
            success.setBounds(300, 570, 400, 30);
            success.setFont(new Font("Arial", Font.BOLD, 15));
            c.add(success);
            success.setVisible(false);

            ok = new JButton("OK");
            ok.setBounds(470, 610, 60, 25);
            c.add(ok);
            ok.addActionListener(this);
            ok.setVisible(false);
    
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back){
            dispose();
            new MainUI();
        }
        else if(e.getSource() == submit){
            String query = query_text.getText();
            if(query.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your query.");
            }
            else{
                success.setVisible(true);
                ok.setVisible(true);
                String queryText = Users.currentUser.username+" - "+query;
                QueueUI.q.enqueue(queryText);
            }
        }
        else if(e.getSource() == ok){
            dispose();
            new MainUI();
        }
        
    }
    
}
