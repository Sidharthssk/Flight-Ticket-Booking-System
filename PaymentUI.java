import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class PaymentUI extends JFrame implements ActionListener {

    JLabel payment, numLbl, nameLbl, ageLbl, genderLbl, priceLbl1, priceLbl2, usernumberLbl, usernameLbl, userageLbl, usergenderLbl,
            userpriceLbl1, userpriceLbl2, num, name, age, gender, price1, price2, total, totalSum;
    JButton pay,cancel;
    Container c;

    PaymentUI() {

        setTitle("Booking.com");
        setSize(1000, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        payment = new JLabel("Payment", JLabel.CENTER);
        payment.setBounds(350, 50, 300, 40);
        payment.setFont(new Font("Arial", Font.BOLD, 20));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        payment.setBorder(border);
        c.add(payment);

        numLbl = new JLabel("Number", JLabel.LEFT);
        numLbl.setBounds(100, 100, 50, 20);
        numLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(numLbl);

        nameLbl = new JLabel("Name", JLabel.LEFT);
        nameLbl.setBounds(150, 100, 100, 20);
        nameLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(nameLbl);

        ageLbl = new JLabel("Age", JLabel.LEFT);
        ageLbl.setBounds(250, 100, 100, 20);
        ageLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(ageLbl);

        genderLbl = new JLabel("Gender", JLabel.LEFT);
        genderLbl.setBounds(350, 100, 100, 20);
        genderLbl.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(genderLbl);

        priceLbl1= new JLabel("Journey", JLabel.LEFT);
        priceLbl1.setBounds(450, 100, 150, 20);
        priceLbl1.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(priceLbl1);

        priceLbl2 = new JLabel("Return Journey", JLabel.LEFT);
        priceLbl2.setBounds(600, 100, 150, 20);
        priceLbl2.setFont(new Font("Arial", Font.BOLD, 13));
        c.add(priceLbl2);

        usernumberLbl = new JLabel("1.", JLabel.LEFT);
        usernumberLbl.setBounds(100, 130, 50, 20);
        usernumberLbl.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(usernumberLbl);

        usernameLbl = new JLabel(Users.currentUser.username, JLabel.LEFT);
        usernameLbl.setBounds(150, 130, 100, 20);
        usernameLbl.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(usernameLbl);

        userageLbl = new JLabel(Users.currentUser.age, JLabel.LEFT);
        userageLbl.setBounds(250, 130, 100, 20);
        userageLbl.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(userageLbl);

        usergenderLbl = new JLabel(Users.currentUser.gender, JLabel.LEFT);
        usergenderLbl.setBounds(350, 130, 100, 20);
        usergenderLbl.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(usergenderLbl);

        //forward journey ticket price1
        userpriceLbl1 = new JLabel(
                "Rs. " + Integer.toString(TicketDetailsUI.soloTotal),
                JLabel.LEFT);
        userpriceLbl1.setBounds(450, 130, 150, 20);
        userpriceLbl1.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(userpriceLbl1);

        //return journey ticket price1
        userpriceLbl2 = new JLabel(
                "Rs. " + Integer.toString(ReturnFlightShowingUI.soloTotal),
                JLabel.LEFT);
        userpriceLbl2.setBounds(600, 130, 150, 20);
        userpriceLbl2.setFont(new Font("Arial", Font.BOLD, 11));
        c.add(userpriceLbl2);

        int y = 160;
        for (int i = 0; i < Integer.parseInt(BookingUI.selected_number) - 1
                && Integer.parseInt(BookingUI.selected_number) > 1; i++) {

            num = new JLabel(Integer.toString(i + 2), JLabel.LEFT);
            num.setBounds(100, y, 50, 20);
            num.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(num);

            name = new JLabel(TicketDetailsUI.additional_users[i].username, JLabel.LEFT);
            name.setBounds(150, y, 100, 20);
            name.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(name);

            age = new JLabel(TicketDetailsUI.additional_users[i].age, JLabel.LEFT);
            age.setBounds(250, y, 100, 20);
            age.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(age);

            gender = new JLabel(TicketDetailsUI.additional_users[i].gender, JLabel.LEFT);
            gender.setBounds(350, y, 100, 20);
            gender.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(gender);

            price1 = new JLabel(
                    "Rs. " + Integer.toString(TicketDetailsUI.soloTotal),
                    JLabel.LEFT);
            price1.setBounds(450, y, 100, 20);
            price1.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(price1);

            price2 = new JLabel(
                    "Rs. " + Integer.toString(ReturnFlightShowingUI.soloTotal),
                    JLabel.LEFT);
            price2.setBounds(600, y, 100, 20);
            price2.setFont(new Font("Arial", Font.BOLD, 11));
            c.add(price2);

            y += 30;
        }

        total = new JLabel("Total : Rs. " + Integer.toString(TicketDetailsUI.total + ReturnFlightShowingUI.total), JLabel.LEFT);
        total.setBounds(500, y+50, 200, 30);
        total.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(total);

        pay = new JButton("Pay");
        pay.setBounds(500, y + 100, 75, 25);
        pay.setFont(new Font("Arial", Font.BOLD, 15));
        pay.addActionListener(this);
        c.add(pay);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, y + 100, 75, 25);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == pay) {
            // show dialogue box saying payment successful
            JOptionPane.showMessageDialog(this, "Payment Successful");
            dispose();
            new MainUI();
        }

    }
}