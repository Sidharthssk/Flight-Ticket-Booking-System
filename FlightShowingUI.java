import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

class FlightShowingUI extends JFrame implements ActionListener {

    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static FlightDetails selectedFlight = new FlightDetails();

    static JLabel[][] labels = new JLabel[10][9];
    static JButton[] buttons = new JButton[10];
    JButton back;
    Container c;
    JLabel name, number, departure, arrival, dep_time, arr_time, duration, e_price, b_price;

    static FlightDetails[] flightDetails = new FlightDetails[10];
    int h = 0;

    FlightShowingUI() {
        setTitle("Flight details");
        setSize(1200, 600);
        setLocation(200, 50);
        c = getContentPane();
        c.setLayout(null);

        int y_axis = 100;
        h=0;

        for (FlightDetails tempFlight : FlightDetails.flightlist) {
            if (tempFlight.departure_airport.equals(BookingUI.selected_depart)
                    && tempFlight.arrival_airport.equals(BookingUI.selected_dest)
                     && BookingUI.final_selected_date.equals(tempFlight.date) && h<10) {
                flightDetails[h] = tempFlight;
                h++;
            }
        }

        if(h == 0){
            JLabel lbl = new JLabel("No flights found");
            lbl.setBounds(550, 350, 200, 50);
            c.add(lbl);

            back = new JButton("Back");
            back.setBounds(500, 400, 200, 30); 
            c.add(back);
            back.addActionListener(this);
        }
        else{

            name = new JLabel("Flight Name");
            name.setBounds(50, 75, 100, 30);
            name.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(name);

            number = new JLabel("Flight Number");
            number.setBounds(160, 75, 100, 30);
            number.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(number);

            departure = new JLabel("Departure");
            departure.setBounds(270, 75, 100, 30);
            departure.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(departure);

            arrival = new JLabel("Arrival");
            arrival.setBounds(380, 75, 100, 30);
            arrival.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(arrival);

            dep_time = new JLabel("Departure Time");
            dep_time.setBounds(490, 75, 100, 30);
            dep_time.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(dep_time);

            arr_time = new JLabel("Arrival Time");
            arr_time.setBounds(600, 75, 100, 30);
            arr_time.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(arr_time);

            duration = new JLabel("Duration");
            duration.setBounds(710, 75, 100, 30);
            duration.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(duration);

            e_price = new JLabel("Economy Price");
            e_price.setBounds(820, 75, 100, 30);
            e_price.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(e_price);

            b_price = new JLabel("Business Price");
            b_price.setBounds(930, 75, 100, 30);
            b_price.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(b_price);

            for (int i = 0; i < h; i++) {
                labels[i][0].setText(flightDetails[i].name);
                labels[i][0].setBounds(50, y_axis, 100, 30);
                c.add(labels[i][0]);
    
                labels[i][1].setText(flightDetails[i].flightNo);
                labels[i][1].setBounds(160, y_axis, 100, 30);
                c.add(labels[i][1]);
    
                labels[i][2].setText(flightDetails[i].departure_airport);
                labels[i][2].setBounds(270, y_axis, 100, 30);
                c.add(labels[i][2]);
    
                labels[i][3].setText(flightDetails[i].arrival_airport);
                labels[i][3].setBounds(380, y_axis, 100, 30);
                c.add(labels[i][3]);
    
                labels[i][4].setText(Integer.toString(flightDetails[i].departureTime)+":00");
                labels[i][4].setBounds(490, y_axis, 100, 30);
                c.add(labels[i][4]);
    
                labels[i][5].setText(Integer.toString(flightDetails[i].arrivalTime)+":00");
                labels[i][5].setBounds(600, y_axis, 100, 30);
                c.add(labels[i][5]);
    
                labels[i][6].setText(Integer.toString(Math.abs(flightDetails[i].arrivalTime - flightDetails[i].departureTime))+":00");
                labels[i][6].setBounds(710, y_axis, 100, 30);
                c.add(labels[i][6]);
    
                labels[i][7].setText("Rs. "+Integer.toString(flightDetails[i].economyclass_ticket_fare));
                labels[i][7].setBounds(820, y_axis, 100, 30);
                c.add(labels[i][7]);
    
                labels[i][8].setText("Rs. "+Integer.toString(flightDetails[i].businessclass_ticket_fare));
                labels[i][8].setBounds(930, y_axis, 100, 30);
                c.add(labels[i][8]);
    
                buttons[i] = new JButton("Book");
                buttons[i].setBounds(1040, y_axis, 100, 20);
                c.add(buttons[i]);
                buttons[i].addActionListener(this);
    
                y_axis += 50;
            }
            
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            dispose();
            new BookingUI();
            return;
        }
        for (int i = 0; i < h; i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Flight Selected");
                selectedFlight = FlightDetails.flightlist.get(i);
                dispose();
                c.removeAll();
                new TicketDetailsUI();
            }
        }
    }
}

class ReturnFlightShowingUI extends JFrame implements ActionListener {

    static FlightDetails selectedFlight = new FlightDetails();

    static JLabel[][] labels = new JLabel[10][9];
    static JButton[] buttons = new JButton[10];
    JButton back;
    Container c;
    JLabel name, number, departure, arrival, dep_time, arr_time, duration, e_price, b_price;

    static FlightDetails[] flightDetails = new FlightDetails[10];
    int h = 0;

    ReturnFlightShowingUI() {
        setTitle("Flight details");
        setSize(1200, 600);
        setLocation(200, 50);
        c = getContentPane();
        c.setLayout(null);

        int y_axis = 100;
        h=0;

        for (FlightDetails tempFlight : FlightDetails.returnflights) {
            if (tempFlight.departure_airport.equals(BookingUI.selected_depart)
                    && tempFlight.arrival_airport.equals(BookingUI.selected_dest)
                     && BookingUI.final_selected_date.equals(tempFlight.date) && h<10) {
                flightDetails[h] = tempFlight;
                h++;
            }
        }

        if(h == 0){
            JLabel lbl = new JLabel("No flights found");
            lbl.setBounds(550, 350, 200, 50);
            c.add(lbl);

            back = new JButton("Back");
            back.setBounds(500, 400, 200, 30); 
            c.add(back);
            back.addActionListener(this);
        }
        else{

            name = new JLabel("Flight Name");
            name.setBounds(50, 75, 100, 30);
            name.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(name);

            number = new JLabel("Flight Number");
            number.setBounds(160, 75, 100, 30);
            number.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(number);

            departure = new JLabel("Departure");
            departure.setBounds(270, 75, 100, 30);
            departure.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(departure);

            arrival = new JLabel("Arrival");
            arrival.setBounds(380, 75, 100, 30);
            arrival.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(arrival);

            dep_time = new JLabel("Departure Time");
            dep_time.setBounds(490, 75, 100, 30);
            dep_time.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(dep_time);

            arr_time = new JLabel("Arrival Time");
            arr_time.setBounds(600, 75, 100, 30);
            arr_time.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(arr_time);

            duration = new JLabel("Duration");
            duration.setBounds(710, 75, 100, 30);
            duration.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(duration);

            e_price = new JLabel("Economy Price");
            e_price.setBounds(820, 75, 100, 30);
            e_price.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(e_price);

            b_price = new JLabel("Business Price");
            b_price.setBounds(930, 75, 100, 30);
            b_price.setFont(new Font("Arial", Font.BOLD, 13));
            c.add(b_price);

            for (int i = 0; i < h; i++) {
                labels[i][0].setText(flightDetails[i].name);
                labels[i][0].setBounds(50, y_axis, 100, 30);
                c.add(labels[i][0]);
    
                labels[i][1].setText(flightDetails[i].flightNo);
                labels[i][1].setBounds(160, y_axis, 100, 30);
                c.add(labels[i][1]);
    
                labels[i][2].setText(flightDetails[i].departure_airport);
                labels[i][2].setBounds(270, y_axis, 100, 30);
                c.add(labels[i][2]);
    
                labels[i][3].setText(flightDetails[i].arrival_airport);
                labels[i][3].setBounds(380, y_axis, 100, 30);
                c.add(labels[i][3]);
    
                labels[i][4].setText(Integer.toString(flightDetails[i].departureTime)+":00");
                labels[i][4].setBounds(490, y_axis, 100, 30);
                c.add(labels[i][4]);
    
                labels[i][5].setText(Integer.toString(flightDetails[i].arrivalTime)+":00");
                labels[i][5].setBounds(600, y_axis, 100, 30);
                c.add(labels[i][5]);
    
                labels[i][6].setText(Integer.toString(Math.abs(flightDetails[i].arrivalTime - flightDetails[i].departureTime))+":00");
                labels[i][6].setBounds(710, y_axis, 100, 30);
                c.add(labels[i][6]);
    
                labels[i][7].setText("Rs. "+Integer.toString(flightDetails[i].economyclass_ticket_fare));
                labels[i][7].setBounds(820, y_axis, 100, 30);
                c.add(labels[i][7]);
    
                labels[i][8].setText("Rs. "+Integer.toString(flightDetails[i].businessclass_ticket_fare));
                labels[i][8].setBounds(930, y_axis, 100, 30);
                c.add(labels[i][8]);
    
                buttons[i] = new JButton("Book");
                buttons[i].setBounds(1040, y_axis, 100, 20);
                c.add(buttons[i]);
                buttons[i].addActionListener(this);
    
                y_axis += 50;
            }
            
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            dispose();
            new BookingUI();
            return;
        }
        for (int i = 0; i < h; i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Flight Selected");
                selectedFlight = FlightDetails.returnflights.get(i);

                Ticket returnTicket = new Ticket(Users.currentUser.username, ReturnUI.selected_depart, 
                ReturnUI.selected_dest, ReturnUI.selectedDate(), 
                Integer.toString(ReturnFlightShowingUI.selectedFlight.departureTime), 
                Integer.toString(ReturnFlightShowingUI.selectedFlight.arrivalTime), 
                TicketDetailsUI.selectedClass, TicketDetailsUI.additional_users);

                ChatBot.ticketQueue.add(ReturnUI.selectedDate(),returnTicket);

                if (TicketDetailsUI.selectedClass.equals("Economy")) {
                    int front = FlightShowingUI.selectedFlight.front2;
                    int rear = FlightShowingUI.selectedFlight.rear2;
                    int size = FlightShowingUI.selectedFlight.economyclass_seats;
    
                    if ((rear + 1) % size == front) {
                        JOptionPane.showMessageDialog(null, "No seats available");
                        return;
                    }
                    if (front == -1 && rear == -1) {
                        front = rear = 0;
                        FlightShowingUI.selectedFlight.economyTickets[rear] = returnTicket;
                        FlightShowingUI.selectedFlight.front2 = front;
                        FlightShowingUI.selectedFlight.rear2 = rear;
                    } else {
                        rear = (rear + 1) % size;
                        FlightShowingUI.selectedFlight.economyTickets[rear] = returnTicket;
                        FlightShowingUI.selectedFlight.rear2 = rear;
                    }
                }
    
                if (TicketDetailsUI.selectedClass.equals("Business")) {
                    int front = FlightShowingUI.selectedFlight.front1;
                    int rear = FlightShowingUI.selectedFlight.rear1;
                    int size = FlightShowingUI.selectedFlight.businessclass_seats;
    
                    if ((rear + 1) % size == front) {
                        JOptionPane.showMessageDialog(null, "No seats available");
                        return;
                    }
                    if (front == -1 && rear == -1) {
                        front = rear = 0;
                        FlightShowingUI.selectedFlight.businessTickets[rear] = returnTicket;
                        FlightShowingUI.selectedFlight.front1 = front;
                        FlightShowingUI.selectedFlight.rear1 = rear;
                    } else {
                        rear = (rear + 1) % size;
                        FlightShowingUI.selectedFlight.businessTickets[rear] = returnTicket;
                        FlightShowingUI.selectedFlight.rear1 = rear;
                    }
                }

                dispose();
                new MainUI();
            }
        }
    }
}