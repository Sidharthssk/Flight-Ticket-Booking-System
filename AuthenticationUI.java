import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends Users implements ActionListener {

    Container c;
    JLabel usernameLabel;
    JLabel l2;
    JLabel successLabel;
    JLabel passkeylbl;
    JTextField user;
    JPasswordField pass, passkey;
    JButton back1;
    JButton logiButton;
    JButton ok;
    JButton tryAgain;

    int flag = 0; // for logiButton confirmation

    Login() {

        setSize(400, 400);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        back1 = new JButton("Back");
        back1.setBounds(5, 5, 70, 25);
        c.add(back1);
        back1.addActionListener(this);

        usernameLabel = new JLabel("Username : ");
        l2 = new JLabel("Password : ");

        usernameLabel.setBounds(10, 50, 100, 20);
        l2.setBounds(10, 100, 100, 20);

        c.add(usernameLabel);
        c.add(l2);

        user = new JTextField();
        user.setBounds(120, 50, 120, 20);
        c.add(user);

        pass = new JPasswordField();
        pass.setBounds(120, 100, 120, 20);
        c.add(pass);

        logiButton = new JButton("Login");
        logiButton.setBounds(100, 150, 70, 20);
        c.add(logiButton);
        logiButton.addActionListener(this);

        successLabel = new JLabel("", SwingConstants.CENTER);
        successLabel.setBounds(0, 200, 400, 30);
        c.add(successLabel);

        tryAgain = new JButton("Try Again");
        tryAgain.setBounds(75, 250, 90, 20);
        c.add(tryAgain);
        tryAgain.addActionListener(this);
        tryAgain.setVisible(false);

        ok = new JButton("Ok");
        ok.addActionListener(this);
        ok.setVisible(false);

        passkey = new JPasswordField();
        passkey.setVisible(false);

        passkeylbl = new JLabel("", SwingConstants.CENTER);
        passkeylbl.setBounds(0, 270, 400, 30);
        c.add(passkeylbl);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back1) {
            dispose();
            new WelcomeUI();
        } else if (e.getSource() == logiButton) {
            String username1 = user.getText();
            String password = String.valueOf(pass.getPassword());

            Users user1 = new Users(username1, password);
            int result1 = user1.authentication(1, user1);

            if (result1 == 0) {
                successLabel.setText("Login Successfull !!");
                ok.setBounds(170, 250, 60, 20);
                c.add(ok);
                ok.setVisible(true);
                flag = 0;
            } else if (result1 == 1) {
                successLabel.setText("User does not exist !!  Please Signup");
                ok.setBounds(270, 250, 60, 20);
                c.add(ok);
                ok.setVisible(true);
                tryAgain.setVisible(true);

                flag = 1;
            } else if (result1 == -1) {
                successLabel.setText("Password is incorrect !! Please try again");
                ok.setBounds(270, 250, 60, 20);
                c.add(ok);
                ok.setVisible(true);
                tryAgain.setVisible(true);
                flag = -1;
            } else if (result1 == 2) {
                successLabel.setText("Enter Admin Passcode : ");
                successLabel.setBounds(0, 200, 250, 20);
                passkey.setBounds(230, 200, 100, 20);
                c.add(passkey);
                passkey.setVisible(true);
                ok.setBounds(170, 250, 60, 20);
                c.add(ok);
                ok.setVisible(true);
                flag = 2;
            }
        }
        if (e.getSource() == ok) {
            if (flag == 0) {
                dispose();
                ok.setBounds(170, 250, 60, 20);
                new MainUI();
            } else if (flag == 1) {
                dispose();
                new SignUp();
            } else if (flag == -1) {
                dispose();
                new Login();
            } else if (flag == 2) {
                String passcode = String.valueOf(passkey.getPassword());
                if (passcode.equals("737")) {
                    dispose();
                    new AdminUI();
                } else {
                    passkeylbl.setText("Incorrect Passcode");
                    // disappear after 3 seconds
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                Thread.currentThread().interrupt();
                            }
                            passkeylbl.setText("");
                        }
                    }.start();
                    passkey.setText("");
                }

            }

        }
        if (e.getSource() == tryAgain) {
            dispose();
            new Login();
        }

    }
}

class SignUp extends Users implements ActionListener {
    JLabel username_lbl, email_lbl, password_lbl, phone_lbl, gender_lbl, age_lbl, country_lbl, success_lbl;
    JPasswordField pass;
    JTextField usernameLabel, emaField, pField, ageField, countryField;
    JRadioButton male, female, others;
    JButton cancel, submit, back, ok;
    Container c;
    ButtonGroup gen = new ButtonGroup();

    SignUp() {

        setTitle("Sign Up");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        username_lbl = new JLabel("Username : ");
        username_lbl.setBounds(20, 50, 100, 20);
        c.add(username_lbl);

        usernameLabel = new JTextField();
        usernameLabel.setBounds(130, 50, 150, 20);
        c.add(usernameLabel);

        email_lbl = new JLabel("Email : ");
        email_lbl.setBounds(20, 100, 100, 20);
        c.add(email_lbl);

        emaField = new JTextField();
        emaField.setBounds(130, 100, 150, 20);
        c.add(emaField);

        password_lbl = new JLabel("Password : ");
        password_lbl.setBounds(20, 150, 100, 20);
        c.add(password_lbl);

        pass = new JPasswordField();
        pass.setBounds(130, 150, 150, 20);
        c.add(pass);

        phone_lbl = new JLabel("Phone Number");
        phone_lbl.setBounds(20, 200, 100, 20);
        c.add(phone_lbl);

        pField = new JTextField();
        pField.setBounds(130, 200, 150, 20);
        c.add(pField);

        gender_lbl = new JLabel("Gender : ");
        gender_lbl.setBounds(20, 250, 100, 20);
        c.add(gender_lbl);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");
        male.setBounds(130, 250, 80, 20);
        female.setBounds(220, 250, 80, 20);
        others.setBounds(310, 250, 80, 20);
        male.setSelected(true);
        c.add(male);
        c.add(female);
        c.add(others);

        gen.add(male);
        gen.add(female);
        gen.add(others);

        age_lbl = new JLabel("Age : ");
        age_lbl.setBounds(20, 300, 100, 20);
        c.add(age_lbl);

        ageField = new JTextField();
        ageField.setBounds(130, 300, 100, 20);
        c.add(ageField);

        country_lbl = new JLabel("Country : ");
        country_lbl.setBounds(20, 350, 100, 20);
        c.add(country_lbl);

        countryField = new JTextField();
        countryField.setBounds(130, 350, 100, 20);
        c.add(countryField);

        submit = new JButton("Submit");
        submit.setBounds(20, 400, 100, 30);
        c.add(submit);
        submit.addActionListener(this);

        success_lbl = new JLabel("", SwingConstants.CENTER);
        success_lbl.setBounds(0, 450, 700, 30);
        c.add(success_lbl);

        ok = new JButton("OK");
        ok.setBounds(320, 480, 60, 30);
        c.add(ok);
        ok.addActionListener(this);
        ok.setVisible(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String password1 = String.valueOf(pass.getPassword());
        String gender;

        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        } else {
            gender = "Others";
        }

        Users users = new Users(usernameLabel.getText(), emaField.getText(), password1, pField.getText(), gender,
                ageField.getText(),
                countryField.getText());

        int result = authentication(2, users);
        if (result == 0) {
            success_lbl.setText("Registration Successfull !!");
        } else {
            success_lbl.setText("Registration Failed !!");
        }

        if (e.getSource() == submit) {
            success_lbl.setText("Registration Successfull !!");
            ok.setVisible(true);
        } else if (e.getSource() == ok) {
            dispose();
            new Login();
        } else if (e.getSource() == back) {
            dispose();
            new WelcomeUI();
        }
    }
}