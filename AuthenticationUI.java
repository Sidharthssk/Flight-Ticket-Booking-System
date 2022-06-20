
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Login extends Users implements ActionListener {

    Container c;
    JLabel username, l2, successLabel;
    JTextField user;
    JPasswordField pass;
    JButton bn;

    Login() {

        setSize(400, 300);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        username = new JLabel("Username : ");
        l2 = new JLabel("Password : ");

        username.setBounds(10, 50, 100, 20);
        l2.setBounds(10, 100, 100, 20);

        c.add(username);
        c.add(l2);

        user = new JTextField();
        user.setBounds(120, 50, 120, 20);
        c.add(user);

        pass = new JPasswordField();
        pass.setBounds(120, 100, 120, 20);
        c.add(pass);

        bn = new JButton("Login");
        bn.setBounds(100, 150, 70, 20);
        c.add(bn);
        bn.addActionListener(this);

        successLabel = new JLabel("", JLabel.CENTER);
        successLabel.setBounds(0, 200, 700, 30);
        c.add(successLabel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String username1 = user.getText();
        String password = String.valueOf(pass.getPassword());

        Users user1 = new Users(username1, password);
        int result1 = user1.authentication(1, this);

        if (result1 == 0) {
            successLabel.setText("Login Successfull !!");
            try {
                Thread.sleep(2000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            dispose();
        } else if (result1 == 1) {
            successLabel.setText("User does not exist !!  Please Signup");
            try {
                Thread.sleep(2000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            SignUp signUp = new SignUp();
            dispose();
        } else if (result1 == -1) {
            successLabel.setText("Password is incorrect !! Please try again");
            try {
                Thread.sleep(2000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            Login l = new Login();
        }

    }
}

 class SignUp extends Users implements ActionListener{
    JLabel username,email,password,phone,gender,age,country,success;
    JPasswordField pass;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton male,female,others;
    JButton submit;
    Container c;
    ButtonGroup gen = new ButtonGroup();

    SignUp(){

        setTitle("Sign Up");
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);

        username = new JLabel("Username : ");
        username.setBounds(20,50,100,20);
        c.add(username);

        t1 = new JTextField();
        t1.setBounds(130,50,150,20);
        c.add(t1);

        email = new JLabel("Email : ");
        email.setBounds(20,100,100,20);
        c.add(email);

        t2 = new JTextField();
        t2.setBounds(130,100,150,20);
        c.add(t2);

        password = new JLabel("Password : ");
        password.setBounds(20,150,100,20);
        c.add(password);

        pass = new JPasswordField();
        pass.setBounds(130,150,150,20);
        c.add(pass);


        phone = new JLabel("Phone Number");
        phone.setBounds(20,200,100,20);
        c.add(phone);

        t3 = new JTextField();
        t3.setBounds(130,200,150,20);
        c.add(t3);

        gender = new JLabel("Gender : ");
        gender.setBounds(20,250,100,20);
        c.add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");
        male.setBounds(130,250,80,20);
        female.setBounds(220,250,80,20);
        others.setBounds(310,250,80,20);
        male.setSelected(true);
        c.add(male);
        c.add(female);
        c.add(others);

        
        gen.add(male);
        gen.add(female);
        gen.add(others);

        age = new JLabel("Age : ");
        age.setBounds(20,300,100,20);
        c.add(age);

        t4 = new JTextField();
        t4.setBounds(130,300,100,20);
        c.add(t4);

        country = new JLabel("Country : ");
        country.setBounds(20,350,100,20);
        c.add(country);

        t5 = new JTextField();
        t5.setBounds(130,350,100,20);
        c.add(t5);

        submit = new JButton("Submit");
        submit.setBounds(20,400,100,30);
        c.add(submit);
        submit.addActionListener(this);
        
        success = new JLabel("",JLabel.CENTER);
        success.setBounds(0,450,700,30);
        c.add(success);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String password1 = String.valueOf(pass);
        String gender;

        if(male.isSelected()){
           gender = "male";
        }
        else if(female.isSelected()){
            gender = "female";
        }
        else{
            gender = "Others";
        }
      
        Users users = new Users(username.getText(),email.getText(),password1,phone.getText(),gender,age.getText(),country.getText());
        
        int result = users.authentication(2, this);
        if(result == 0){
            success.setText("Registration Successfull !!");
            try{
                Thread.sleep(2000);
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
            Login login = new Login();
            dispose();
        }
        else{
            success.setText("Registration Failed !!");
        }
     }
}