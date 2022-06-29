import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlightShowingUI extends JFrame implements ActionListener {

    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static FlightDetails selectedFlight = new FlightDetails();

    static JLabel[][] labels = new JLabel[10][9];
    static JButton[] buttons = new JButton[10];
    Container c;

    static FlightDetails[] flightDetails = new FlightDetails[10];
    int h = 0;

    FlightShowingUI() {
        setTitle("Flight details");
        setSize(1200, 800);
        setLocation(100, 100);
        c = getContentPane();
        c.setLayout(null);

        int y_axis = 100;

        for (FlightDetails tempFlight : FlightDetails.flightlist) {
            if (tempFlight.departure_airport.equals(BookingUI.selected_depart)
                    && tempFlight.arrival_airport.equals(BookingUI.selected_dest)) {
                flightDetails[h] = tempFlight;
                h++;
            }
        }

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

            labels[i][4].setText(Integer.toString(flightDetails[i].departureTime));
            labels[i][4].setBounds(490, y_axis, 100, 30);
            c.add(labels[i][4]);

            labels[i][5].setText(Integer.toString(flightDetails[i].arrivalTime));
            labels[i][5].setBounds(600, y_axis, 100, 30);
            c.add(labels[i][5]);

            labels[i][6].setText(Integer.toString(flightDetails[i].arrivalTime - flightDetails[i].departureTime));
            labels[i][6].setBounds(710, y_axis, 100, 30);
            c.add(labels[i][6]);

            labels[i][7].setText(Integer.toString(flightDetails[i].economyclass_ticket_fare));
            labels[i][7].setBounds(820, y_axis, 100, 30);
            c.add(labels[i][7]);

            labels[i][8].setText(Integer.toString(flightDetails[i].businessclass_ticket_fare));
            labels[i][8].setBounds(930, y_axis, 100, 30);
            c.add(labels[i][8]);

            buttons[i] = new JButton("Book");
            buttons[i].setBounds(1040, y_axis, 100, 30);
            c.add(buttons[i]);
            buttons[i].addActionListener(this);

            System.out.println(flightDetails[i].name);

            y_axis += 50;
        }

        h = 0;

        // get all flights for the given source and destination from the database

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < FlightDetails.flightlist.size(); i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Booked successfully");
                selectedFlight = FlightDetails.flightlist.get(i);
                dispose();
                c.removeAll();
                new TicketDetailsUI();
            }
        }
    }
}