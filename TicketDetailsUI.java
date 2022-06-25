import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicketDetailsUI extends JFrame implements ActionListener {

    Container c;
    JButton back, cancel, confirm;
    JRadioButton male, female, others;
    String[] relation = { "Father", "Mother", "Child", "Others" };
    String[] gender = { "Male", "Female", "Others" };
    JComboBox<String> cb_relation;
    JTextField[] passName = new JTextField[Integer.parseInt(BookingUI.selected_number)];
    JTextField[] passAge = new JTextField[Integer.parseInt(BookingUI.selected_number)];
    JComboBox<String>[] passGender = new JComboBox[Integer.parseInt(BookingUI.selected_number)];
    JComboBox<String>[] passRelation = new JComboBox[Integer.parseInt(BookingUI.selected_number)];

    static String[][] details = new String[Integer.parseInt(BookingUI.selected_number)][4];

    TicketDetailsUI() {

        setTitle("Ticket Details");
        setSize(1000, 800);
        setLocation(100, 100);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setBounds(5, 5, 70, 25);
        c.add(back);
        back.addActionListener(this);

        JLabel user = new JLabel("User Details", JLabel.LEFT);
        user.setBounds(50, 70, 200, 30);
        user.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(user);

        JLabel username = new JLabel("Name: " + Users.currentUser.username);
        username.setBounds(50, 100, 200, 30);
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(username);

        JLabel userGender = new JLabel("Gender: " + Users.currentUser.gender);
        userGender.setBounds(260, 100, 200, 30);
        userGender.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(userGender);

        JLabel userAge = new JLabel("Age: " + Users.currentUser.age);
        userAge.setBounds(470, 100, 200, 30);
        userAge.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(userAge);

        JLabel enterDetails = new JLabel("Enter Passenger Details:", JLabel.LEFT);
        enterDetails.setBounds(50, 150, 400, 30);
        enterDetails.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(enterDetails);

        int y_axis = 150;

        for (int i = 0; i < Integer.parseInt(BookingUI.selected_number); i++) {
            y_axis += 40;
            JLabel l1 = new JLabel("Passenger " + Integer.toString(i + 1), JLabel.LEFT);
            l1.setBounds(50, y_axis, 200, 30);
            l1.setFont(new Font("Arial", Font.BOLD, 20));
            c.add(l1);

            y_axis += 30;
            JLabel name1 = new JLabel("Name: ", JLabel.LEFT);
            name1.setBounds(50, y_axis, 60, 30);
            name1.setFont(new Font("Arial", Font.PLAIN, 18));
            c.add(name1);
            passName[i] = new JTextField();
            passName[i].setBounds(115, y_axis, 125, 30);
            passName[i].setFont(new Font("Arial", Font.PLAIN, 20));
            c.add(passName[i]);

            JLabel gender1 = new JLabel("Gender: ", JLabel.LEFT);
            gender1.setBounds(260, y_axis, 75, 30);
            gender1.setFont(new Font("Arial", Font.PLAIN, 18));
            c.add(gender1);
            passGender[i] = new JComboBox<>(gender);
            passGender[i].setBounds(340, y_axis, 75, 30);
            passGender[i].setFont(new Font("Arial", Font.PLAIN, 20));
            c.add(passGender[i]);

            JLabel age1 = new JLabel("Age: ", JLabel.LEFT);
            age1.setBounds(435, y_axis, 45, 30);
            age1.setFont(new Font("Arial", Font.PLAIN, 18));
            c.add(age1);
            passAge[i] = new JTextField();
            passAge[i].setBounds(485, y_axis, 40, 30);
            passAge[i].setFont(new Font("Arial", Font.PLAIN, 20));
            c.add(passAge[i]);

            JLabel relation1 = new JLabel("Relation: ", JLabel.LEFT);
            relation1.setBounds(545, y_axis, 80, 30);
            relation1.setFont(new Font("Arial", Font.PLAIN, 18));
            c.add(relation1);
            passRelation[i] = new JComboBox<>(relation);
            passRelation[i].setBounds(630, y_axis, 90, 30);
            passRelation[i].setFont(new Font("Arial", Font.PLAIN, 20));
            c.add(passRelation[i]);

        }

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 600, 90, 30);
        cancel.addActionListener(this);
        c.add(cancel);

        confirm = new JButton("Confirm");
        confirm.setBounds(450, 600, 90, 30);
        confirm.setBackground(Color.BLUE);
        confirm.addActionListener(this);
        c.add(confirm);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == confirm) {
            Ticket.additional_users = new Users[Integer.parseInt(BookingUI.selected_number)];
            for (int i = 0; i < Integer.parseInt(BookingUI.selected_number); i++) {
                Ticket.additional_users[i] = new Users(passName[i].getText(),passGender[i].getSelectedItem().toString(),passAge[i].getText(),passRelation[i].getSelectedItem().toString());
            }
        }
    }
}