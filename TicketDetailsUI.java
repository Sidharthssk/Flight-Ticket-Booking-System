import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicketDetailsUI extends ChatBot implements ActionListener {

    Container c;
    JButton back, cancel, confirm;
    JRadioButton bClass, eClass;
    String[] relation = { "Father", "Mother", "Child", "Others" };
    String[] gender = { "Male", "Female", "Others" };
    JComboBox<String> cb_relation;
    JTextField[] passName = new JTextField[Integer.parseInt(BookingUI.selected_number)];
    JTextField[] passAge = new JTextField[Integer.parseInt(BookingUI.selected_number)];
    JComboBox<String>[] passGender = new JComboBox[Integer.parseInt(BookingUI.selected_number)];
    JComboBox<String>[] passRelation = new JComboBox[Integer.parseInt(BookingUI.selected_number)];

    static String selectedClass;
    static Users[] additional_users = new Users[Integer.parseInt(BookingUI.selected_number)];

    static int total = 0;
    static int soloTotal = 0;

    TicketDetailsUI() {

        setTitle("Ticket Details");
        setSize(1000, 700);
        setLocation(200, 50);

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

        int y_axis = 150;

        if (Integer.parseInt(BookingUI.selected_number) != 1) {
            JLabel enterDetails = new JLabel("Enter Passenger Details:", JLabel.LEFT);
            enterDetails.setBounds(50, 150, 400, 30);
            enterDetails.setFont(new Font("Arial", Font.BOLD, 20));
            c.add(enterDetails);

            for (int i = 0; i < Integer.parseInt(BookingUI.selected_number) - 1; i++) {
                y_axis += 40;
                JLabel l1 = new JLabel("Passenger " + Integer.toString(i + 2), JLabel.LEFT);
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
        }

        eClass = new JRadioButton("Economy Class");
        eClass.setBounds(295, y_axis + 100, 200, 30);
        eClass.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(eClass);

        bClass = new JRadioButton("Business Class");
        bClass.setBounds(505, y_axis + 100, 200, 30);
        bClass.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(bClass);

        ButtonGroup bg = new ButtonGroup();
        bg.add(eClass);
        bg.add(bClass);
        eClass.setSelected(true);

        cancel = new JButton("Cancel");
        cancel.setBounds(350, y_axis + 150, 90, 30);
        cancel.addActionListener(this);
        c.add(cancel);

        confirm = new JButton("Confirm");
        confirm.setBounds(510, y_axis + 150, 90, 30);
        confirm.addActionListener(this);
        c.add(confirm);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == back) {
            // Remove everything from the FlightShowingUI.c
            dispose();
            new BookingUI();
        }

        if (e.getSource() == confirm) {

            for (int i = 0; i < Integer.parseInt(BookingUI.selected_number) - 1; i++) {
                additional_users[i] = new Users(passName[i].getText(), passGender[i].getSelectedItem().toString(),
                        passAge[i].getText(), passRelation[i].getSelectedItem().toString());
            }

            if (eClass.isSelected()) {

                soloTotal = FlightShowingUI.selectedFlight.economyclass_ticket_fare;
                total = FlightShowingUI.selectedFlight.economyclass_ticket_fare * Integer.parseInt(BookingUI.selected_number);

                selectedClass = "Economy Class";
                int index = FlightDetails.flightlist.indexOf(FlightShowingUI.selectedFlight);
                int front = FlightDetails.flightlist.get(index).front2;
                int rear = FlightDetails.flightlist.get(index).rear2;
                int size = FlightDetails.flightlist.get(index).economyclass_seats;

                if ((rear + 1) % size == front) {
                    JOptionPane.showMessageDialog(null, "No seats available");
                    return;
                }

                Ticket t = new Ticket(Users.currentUser.username, BookingUI.selected_depart, BookingUI.selected_dest,
                        BookingUI.selectedDate(), Integer.toString(FlightShowingUI.selectedFlight.departureTime),
                        Integer.toString(FlightShowingUI.selectedFlight.arrivalTime), "Economy Class",
                        FlightShowingUI.selectedFlight.flightNo,
                        additional_users);
                if (front == -1 && rear == -1) {
                    front = rear = 0;
                    FlightDetails.flightlist.get(index).economyTickets[rear] = t;
                    FlightDetails.flightlist.get(index).front2 = front;
                    FlightDetails.flightlist.get(index).rear2 = rear;

                } else {
                    rear = (rear + 1) % size;
                    FlightDetails.flightlist.get(index).economyTickets[rear] = t;
                    FlightDetails.flightlist.get(index).rear2 = rear;

                }
                ticketQueue.add(BookingUI.selectedDate(), t);
                JOptionPane.showMessageDialog(null, "Ticket booked successfully");
                dispose();
                index = Users.usersList.indexOf(Users.currentUser);
                Users.usersList.get(index).d.add(t);
                new ReturnUI();
            }

            if (bClass.isSelected()) {

                soloTotal = FlightShowingUI.selectedFlight.businessclass_ticket_fare;
                total = FlightShowingUI.selectedFlight.businessclass_ticket_fare * Integer.parseInt(BookingUI.selected_number);

                selectedClass = "Business Class";
                int index = FlightDetails.flightlist.indexOf(FlightShowingUI.selectedFlight);
                int front = FlightDetails.flightlist.get(index).front1;
                int rear = FlightDetails.flightlist.get(index).rear1;
                int size = FlightDetails.flightlist.get(index).businessclass_seats;

                if ((rear + 1) % size == front) {
                    JOptionPane.showMessageDialog(null, "No seats available");
                    return;
                }
                Ticket t = new Ticket(Users.currentUser.username, BookingUI.selected_depart, BookingUI.selected_dest,
                        BookingUI.selectedDate(), Integer.toString(FlightShowingUI.selectedFlight.departureTime),
                        Integer.toString(FlightShowingUI.selectedFlight.arrivalTime), "Business Class",
                        FlightShowingUI.selectedFlight.flightNo,
                        additional_users);
                if (front == -1 && rear == -1) {
                    front = rear = 0;
                    FlightDetails.flightlist.get(index).businessTickets[rear] = t;
                    FlightDetails.flightlist.get(index).front1 = front;
                    FlightDetails.flightlist.get(index).rear1 = rear;
                } else {
                    rear = (rear + 1) % size;
                    FlightDetails.flightlist.get(index).businessTickets[rear] = t;
                    FlightDetails.flightlist.get(index).rear1 = rear;
                }
                ticketQueue.add(BookingUI.selectedDate(), t);
                JOptionPane.showMessageDialog(null, "Ticket booked successfully");
                dispose();
                index = Users.usersList.indexOf(Users.currentUser);
                Users.usersList.get(index).d.add(t);
                new ReturnUI();
            }
        }
    }
}