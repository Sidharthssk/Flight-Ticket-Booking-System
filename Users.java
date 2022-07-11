import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class Users extends JFrame implements Serializable{

    String username;
    String email;
    String password;
    String phone_number;
    String gender;
    String age;
    String country;
    String relation;

    //For user history
    Deque d;

    // Constructor for User
    Users(String username, String email, String password, String phone_number, String gender, String age,
            String country) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.d = new Deque();
    }

    Users() {

    }

    Users(String username,String password){
        this.username = username;
        this.password = password;
    }

    Users(String username, String gender, String age, String relation){
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.relation = relation;
    }

    //for testing change at last
    static Users currentUser;

    int authentication(int opt, Users user) {

        switch (opt) {
            case 1:
                int flag = 0;
                if(user.username.equals("admin") && user.password.equals("admin737")){
                    return 2;
                }
                for (Users tempUser : usersList) {
                    if (tempUser.username.equals(user.username)) {
                        flag = 1;
                        currentUser = tempUser;
                        break;
                    }
                }
                if (flag == 0) {
                    return 1;
                }
                if(user.username.equals(currentUser.username) && user.password.equals(currentUser.password)){
                    return 0;
                }
                
                else{
                    return -1;
                }

            case 2:
                // try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("users.txt"),true))){
                //     obj.writeObject(user);
                // }
                // catch(IOException e){
                //     e.printStackTrace();
                // }
                usersList.add(user);
                return 0;
        }
        return 100;
    }

    // ArrayList for storing user data
    static ArrayList<Users> usersList = new ArrayList<>();
}

class ProfileUI extends JFrame implements ActionListener {

    JButton back, logout;
    JLabel username, email, number, age, country, gender;
    Container c;

    ProfileUI(){

        setTitle("Booking.com");
        setSize(1000, 600);
        setLocation(200, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        logout = new JButton("Logout");
        logout.setBounds(880, 5, 100, 25);
        c.add(logout);
        logout.addActionListener(this);

        username = new JLabel("Username: " + Users.currentUser.username, JLabel.LEFT);
        username.setBounds(350, 100, 300, 40);
        username.setFont(new Font("Arial", Font.BOLD, 20));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        username.setBorder(border);
        c.add(username);

        email = new JLabel("Email: " + Users.currentUser.email, JLabel.LEFT);
        email.setBounds(350, 150, 300, 40);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBorder(border);
        c.add(email);

        number = new JLabel("Phone Number: " + Users.currentUser.phone_number, JLabel.LEFT);
        number.setBounds(350, 200, 300, 40);
        number.setFont(new Font("Arial", Font.BOLD, 20));
        number.setBorder(border);
        c.add(number);

        age = new JLabel("Age: " + Users.currentUser.age, JLabel.LEFT);
        age.setBounds(350, 250, 300, 40);
        age.setFont(new Font("Arial", Font.BOLD, 20));
        age.setBorder(border);
        c.add(age);

        country = new JLabel("Country: " + Users.currentUser.country, JLabel.LEFT);
        country.setBounds(350, 300, 300, 40);
        country.setFont(new Font("Arial", Font.BOLD, 20));
        country.setBorder(border);
        c.add(country);

        gender = new JLabel("Gender: " + Users.currentUser.gender, JLabel.LEFT);
        gender.setBounds(350, 350, 300, 40);
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBorder(border);
        c.add(gender);

        setVisible(true);        
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == back){
            dispose();
            new MainUI();
        }

        if(e.getSource() == logout){
            dispose();
            new Login();
        }
    }
}
