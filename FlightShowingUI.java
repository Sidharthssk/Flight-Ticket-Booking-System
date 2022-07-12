import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlightShowingUI extends JFrame implements ActionListener {

    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static FlightDetails selectedFlight;

    static JLabel[][] labels = new JLabel[10][11];
    static JButton[] buttons = new JButton[10];
    JButton back;
    Container c;
    JLabel name, number, departure, arrival, dep_time, arr_time, duration, e_price, b_price, b_seats, e_seats;

    transient FlightDetails[] flightDetails = new FlightDetails[10];
    int h = 0;

    final String font1 = "Arial";

    FlightShowingUI() {
        setTitle("Flight details");
        setSize(1350, 600);
        setLocationRelativeTo(null);
        c = getContentPane();
        c.setLayout(null);

        int y_axis = 100;
        h = 0;

        for (FlightDetails tempFlight : FlightDetails.flightlist) {
            if (tempFlight.departure_airport.equals(BookingUI.selected_depart)
                    && tempFlight.arrival_airport.equals(BookingUI.selected_dest)
                    && BookingUI.final_selected_date.equals(tempFlight.date) && h < 10) {
                flightDetails[h] = tempFlight;
                h++;
            }
        }

        if (h == 0) {
            JLabel lbl = new JLabel("No flights found");
            lbl.setBounds(550, 350, 200, 50);
            c.add(lbl);

            back = new JButton("Back");
            back.setBounds(500, 400, 200, 30);
            c.add(back);
            back.addActionListener(this);
        } else {

            name = new JLabel("Flight Name");
            name.setBounds(50, 75, 100, 30);
            name.setFont(new Font(font1, Font.BOLD, 13));
            c.add(name);

            number = new JLabel("Flight Number");
            number.setBounds(160, 75, 100, 30);
            number.setFont(new Font(font1, Font.BOLD, 13));
            c.add(number);

            departure = new JLabel("Departure");
            departure.setBounds(270, 75, 80, 30);
            departure.setFont(new Font(font1, Font.BOLD, 13));
            c.add(departure);

            arrival = new JLabel("Arrival");
            arrival.setBounds(360, 75, 80, 30);
            arrival.setFont(new Font(font1, Font.BOLD, 13));
            c.add(arrival);

            dep_time = new JLabel("Departure Time");
            dep_time.setBounds(450, 75, 100, 30);
            dep_time.setFont(new Font(font1, Font.BOLD, 13));
            c.add(dep_time);

            arr_time = new JLabel("Arrival Time");
            arr_time.setBounds(560, 75, 100, 30);
            arr_time.setFont(new Font(font1, Font.BOLD, 13));
            c.add(arr_time);

            duration = new JLabel("Duration");
            duration.setBounds(670, 75, 100, 30);
            duration.setFont(new Font(font1, Font.BOLD, 13));
            c.add(duration);

            e_price = new JLabel("Economy Price");
            e_price.setBounds(780, 75, 100, 30);
            e_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(e_price);

            b_price = new JLabel("Business Price");
            b_price.setBounds(890, 75, 100, 30);
            b_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(b_price);

            b_seats = new JLabel("Business Seats");
            b_seats.setBounds(1000, 75, 100, 30);
            b_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(b_seats);

            b_seats = new JLabel("Economy Seats");
            b_seats.setBounds(1110, 75, 100, 30);
            b_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(b_seats);

            for (int i = 0; i < h; i++) {

                int index = FlightDetails.flightlist.indexOf(flightDetails[i]);

                int front1 = FlightDetails.flightlist.get(index).getFront1();
                int rear1 = FlightDetails.flightlist.get(index).getRear1();
                int size1 = FlightDetails.flightlist.get(index).getSize1();

                int front2 = FlightDetails.flightlist.get(index).getFront2();
                int rear2 = FlightDetails.flightlist.get(index).getRear2();
                int size2 = FlightDetails.flightlist.get(index).getSize2();

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

                labels[i][4].setText(Integer.toString(flightDetails[i].departureTime) + ":00");
                labels[i][4].setBounds(490, y_axis, 80, 30);
                c.add(labels[i][4]);

                labels[i][5].setText(Integer.toString(flightDetails[i].arrivalTime) + ":00");
                labels[i][5].setBounds(580, y_axis, 80, 30);
                c.add(labels[i][5]);

                labels[i][6].setText(
                        Integer.toString(Math.abs(flightDetails[i].arrivalTime - flightDetails[i].departureTime))
                                + ":00");
                labels[i][6].setBounds(670, y_axis, 100, 30);
                c.add(labels[i][6]);

                labels[i][7].setText("Rs. " + Integer.toString(flightDetails[i].economyclass_ticket_fare));
                labels[i][7].setBounds(780, y_axis, 100, 30);
                c.add(labels[i][7]);

                labels[i][8].setText("Rs. " + Integer.toString(flightDetails[i].businessclass_ticket_fare));
                labels[i][8].setBounds(890, y_axis, 100, 30);
                c.add(labels[i][8]);

                int size = 0;
                int j = front1;
                int flag = 0;

                do {
                    if (front1 == -1 && rear1 == -1) {
                        break;
                    }
                    if (front1 == 0 && rear1 == 0) {
                        size++;
                        break;
                    }
                    flag = 1;
                    size++;
                    j = (j + 1) % size1;
                } while (j != rear1);

                if (flag == 1) {
                    size++;
                }

                labels[i][9].setText(Integer.toString(size1 - size));
                labels[i][9].setBounds(1000, y_axis, 100, 30);
                c.add(labels[i][9]);

                size = 0;
                j = front2;
                flag = 0;
                do {
                    if (front2 == -1 && rear2 == -1) {
                        break;
                    }
                    if (front2 == 0 && rear2 == 0) {
                        size++;
                        break;
                    }
                    flag = 1;
                    size++;
                    j = (j + 1) % size2;
                } while (j != rear2);

                if (flag == 1) {
                    size++;
                }

                labels[i][10].setText(Integer.toString(size2 - size));
                labels[i][10].setBounds(1110, y_axis, 100, 30);
                c.add(labels[i][10]);

                buttons[i] = new JButton("Book");
                buttons[i].setBounds(1220, y_axis, 100, 20);
                c.add(buttons[i]);
                buttons[i].addActionListener(this);

                y_axis += 50;
            }

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            new BookingUI();
            return;
        }
        for (int i = 0; i < h; i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Flight Selected");
                int index = FlightDetails.flightlist.indexOf(flightDetails[i]);
                selectedFlight = FlightDetails.flightlist.get(index);
                dispose();
                c.removeAll();
                new TicketDetailsUI();
            }
        }
    }
}

class ReturnFlightShowingUI extends JFrame implements ActionListener {

    static FlightDetails selectedFlight = new FlightDetails();

    static JLabel[][] labels = new JLabel[10][11];
    static JButton[] buttons = new JButton[10];
    JButton back;
    Container c;
    JLabel name, number, departure, arrival, dep_time, arr_time, duration, e_price, b_price, b_seats, e_seats;

    static FlightDetails[] flightDetails = new FlightDetails[10];
    int h = 0;

    static int total = 0;
    static int soloTotal = 0;

    final String font1 = "Arial";

    ReturnFlightShowingUI() {
        setTitle("Flight details");
        setSize(1350, 600);
        setLocation(200, 50);
        c = getContentPane();
        c.setLayout(null);

        int y_axis = 100;
        h = 0;

        for (FlightDetails tempFlight : FlightDetails.returnflights) {
            if (tempFlight.departure_airport.equals(BookingUI.selected_dest)
                    && tempFlight.arrival_airport.equals(BookingUI.selected_depart)
                    && ReturnUI.final_selected_date.equals(tempFlight.date) && h < 10) {
                flightDetails[h] = tempFlight;
                h++;
            }
        }

        if (h == 0) {
            JLabel lbl = new JLabel("No flights found");
            lbl.setBounds(550, 350, 200, 50);
            c.add(lbl);

            back = new JButton("Back");
            back.setBounds(500, 400, 200, 30);
            c.add(back);
            back.addActionListener(this);
        } else {

            back = new JButton("Back");
            back.setBounds(5, 5, 100, 30);
            c.add(back);
            back.addActionListener(this);

            name = new JLabel("Flight Name");
            name.setBounds(50, 75, 100, 30);
            name.setFont(new Font(font1, Font.BOLD, 13));
            c.add(name);

            number = new JLabel("Flight Number");
            number.setBounds(160, 75, 100, 30);
            number.setFont(new Font(font1, Font.BOLD, 13));
            c.add(number);

            departure = new JLabel("Departure");
            departure.setBounds(270, 75, 80, 30);
            departure.setFont(new Font(font1, Font.BOLD, 13));
            c.add(departure);

            arrival = new JLabel("Arrival");
            arrival.setBounds(360, 75, 100, 30);
            arrival.setFont(new Font(font1, Font.BOLD, 13));
            c.add(arrival);

            dep_time = new JLabel("Departure Time");
            dep_time.setBounds(470, 75, 100, 30);
            dep_time.setFont(new Font(font1, Font.BOLD, 13));
            c.add(dep_time);

            arr_time = new JLabel("Arrival Time");
            arr_time.setBounds(580, 75, 100, 30);
            arr_time.setFont(new Font(font1, Font.BOLD, 13));
            c.add(arr_time);

            duration = new JLabel("Duration");
            duration.setBounds(690, 75, 100, 30);
            duration.setFont(new Font(font1, Font.BOLD, 13));
            c.add(duration);

            e_price = new JLabel("Economy Price");
            e_price.setBounds(800, 75, 100, 30);
            e_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(e_price);

            b_price = new JLabel("Business Price");
            b_price.setBounds(910, 75, 100, 30);
            b_price.setFont(new Font(font1, Font.BOLD, 13));
            c.add(b_price);

            b_seats = new JLabel("Business Seats");
            b_seats.setBounds(1020, 75, 100, 30);
            b_seats.setFont(new Font(font1, Font.BOLD, 13));
            c.add(b_seats);

            e_seats = new JLabel("Economy Seats");
            e_seats.setBounds(1130, 75, 100, 30);
            e_seats.setFont(new Font(font1, Font.BOLD, 13));
            c.add(e_seats);

            for (int i = 0; i < h; i++) {

                int index = FlightDetails.returnflights.indexOf(flightDetails[i]);
                int front1 = FlightDetails.returnflights.get(index).getFront1();
                int rear1 = FlightDetails.returnflights.get(index).getRear1();
                int size1 = FlightDetails.returnflights.get(index).getSize1();

                int front2 = FlightDetails.returnflights.get(index).getFront2();
                int rear2 = FlightDetails.returnflights.get(index).getRear2();
                int size2 = FlightDetails.returnflights.get(index).getSize2();

                labels[i][0].setText(flightDetails[i].name);
                labels[i][0].setBounds(50, y_axis, 100, 30);
                c.add(labels[i][0]);

                labels[i][1].setText(flightDetails[i].flightNo);
                labels[i][1].setBounds(160, y_axis, 100, 30);
                c.add(labels[i][1]);

                labels[i][2].setText(flightDetails[i].departure_airport);
                labels[i][2].setBounds(270, y_axis, 80, 30);
                c.add(labels[i][2]);

                labels[i][3].setText(flightDetails[i].arrival_airport);
                labels[i][3].setBounds(360, y_axis, 100, 30);
                c.add(labels[i][3]);

                labels[i][4].setText(Integer.toString(flightDetails[i].departureTime) + ":00");
                labels[i][4].setBounds(470, y_axis, 100, 30);
                c.add(labels[i][4]);

                labels[i][5].setText(Integer.toString(flightDetails[i].arrivalTime) + ":00");
                labels[i][5].setBounds(580, y_axis, 100, 30);
                c.add(labels[i][5]);

                labels[i][6].setText(
                        Integer.toString(Math.abs(flightDetails[i].arrivalTime - flightDetails[i].departureTime))
                                + ":00");
                labels[i][6].setBounds(690, y_axis, 100, 30);
                c.add(labels[i][6]);

                labels[i][7].setText("Rs. " + Integer.toString(flightDetails[i].economyclass_ticket_fare));
                labels[i][7].setBounds(800, y_axis, 100, 30);
                c.add(labels[i][7]);

                labels[i][8].setText("Rs. " + Integer.toString(flightDetails[i].businessclass_ticket_fare));
                labels[i][8].setBounds(910, y_axis, 100, 30);
                c.add(labels[i][8]);

                int size = 0;
                int j = front1;
                int flag = 0;

                do {
                    if (front1 == -1 && rear1 == -1) {
                        break;
                    }
                    if (front1 == 0 && rear1 == 0) {
                        size++;
                        break;
                    }
                    flag = 1;
                    size++;
                    j = (j + 1) % size1;
                } while (j != rear1);

                if (flag == 1) {
                    size++;
                }

                labels[i][9].setText(Integer.toString(size1 - size));
                labels[i][9].setBounds(1020, y_axis, 100, 30);
                c.add(labels[i][9]);

                size = 0;
                j = front2;
                flag = 0;
                do {
                    if (front2 == -1 && rear2 == -1) {
                        break;
                    }
                    if (front2 == 0 && rear2 == 0) {
                        size++;
                        break;
                    }
                    flag = 1;
                    size++;
                    j = (j + 1) % size2;
                } while (j != rear2);

                if (flag == 1) {
                    size++;
                }

                labels[i][10].setText(Integer.toString(size2 - size));
                labels[i][10].setBounds(1130, y_axis, 100, 30);
                c.add(labels[i][10]);

                buttons[i] = new JButton("Book");
                buttons[i].setBounds(1240, y_axis, 100, 20);
                c.add(buttons[i]);
                buttons[i].addActionListener(this);

                y_axis += 50;
            }

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            new ReturnUI();
            return;
        }
        for (int i = 0; i < h; i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Flight Selected");
                int index = FlightDetails.returnflights.indexOf(flightDetails[i]);
                selectedFlight = FlightDetails.returnflights.get(index);

                Ticket returnTicket = new Ticket(Users.currentUser.username, ReturnUI.selected_depart,
                        ReturnUI.selected_dest, ReturnUI.selectedDate(),
                        Integer.toString(ReturnFlightShowingUI.selectedFlight.departureTime),
                        Integer.toString(ReturnFlightShowingUI.selectedFlight.arrivalTime),
                        TicketDetailsUI.selectedClass, selectedFlight.flightNo, selectedFlight,
                        TicketDetailsUI.additional_users);

                FlightBook.ticketQueue.add(ReturnUI.selectedDate(), returnTicket);
                index = Users.usersList.indexOf(Users.currentUser);
                Users.usersList.get(index).d.add(returnTicket);

                if (TicketDetailsUI.selectedClass.equals("Economy Class")) {

                    soloTotal = ReturnFlightShowingUI.selectedFlight.economyclass_ticket_fare;
                    total = ReturnFlightShowingUI.selectedFlight.economyclass_ticket_fare
                            * Integer.parseInt(BookingUI.selected_number);

                    index = FlightDetails.returnflights.indexOf(selectedFlight);

                    for (int j = 0; j < Integer.parseInt(BookingUI.selected_number); j++) {

                        int front = FlightDetails.returnflights.get(index).getFront2();
                        int rear = FlightDetails.returnflights.get(index).getRear2();
                        int size = FlightDetails.returnflights.get(index).getEconomySeats();

                        if ((rear + 1) % size == front) {
                            JOptionPane.showMessageDialog(null, "No seats available");
                            return;
                        }
                        if (front == -1 && rear == -1) {
                            front = rear = 0;
                            FlightDetails.returnflights.get(index).addEconomyTicket(returnTicket, rear);
                            FlightDetails.returnflights.get(index).setfront2(front);
                            FlightDetails.returnflights.get(index).setrear2(rear);
                        } else {
                            rear = (rear + 1) % size;
                            FlightDetails.returnflights.get(index).addEconomyTicket(returnTicket, rear);
                            FlightDetails.returnflights.get(index).setrear2(rear);
                        }

                    }

                    dispose();
                    new PaymentUI();
                }

                if (TicketDetailsUI.selectedClass.equals("Business Class")) {

                    soloTotal = ReturnFlightShowingUI.selectedFlight.businessclass_ticket_fare;
                    total = ReturnFlightShowingUI.selectedFlight.businessclass_ticket_fare
                            * Integer.parseInt(BookingUI.selected_number);

                    index = FlightDetails.returnflights.indexOf(selectedFlight);

                    for (int j = 0; j < Integer.parseInt(BookingUI.selected_number); j++) {
                        int front = FlightDetails.returnflights.get(index).getFront1();
                        int rear = FlightDetails.returnflights.get(index).getRear1();
                        int size = FlightDetails.returnflights.get(index).getBusinessSeats();
                        if ((rear + 1) % size == front) {
                            JOptionPane.showMessageDialog(null, "No seats available");
                            return;
                        }
                        if (front == -1 && rear == -1) {
                            front = rear = 0;
                            FlightDetails.returnflights.get(index).addBuisinessTicket(returnTicket, rear);
                            FlightDetails.returnflights.get(index).setfront1(front);
                            FlightDetails.returnflights.get(index).setrear1(rear);
                        } else {
                            rear = (rear + 1) % size;
                            FlightDetails.returnflights.get(index).addBuisinessTicket(returnTicket, rear);
                            FlightDetails.returnflights.get(index).setrear1(rear);
                        }
                    }

                    dispose();
                    new PaymentUI();
                }
            }

        }
    }
}