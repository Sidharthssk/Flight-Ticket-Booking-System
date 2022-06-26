import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlightShowingUI extends JFrame implements ActionListener {

    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static FlightDetails selectedFlight = new FlightDetails();

    //int row_size = FlightDetails.flightlist.size();

    static JLabel [][] labels = new JLabel[10][9];
    static JButton [] buttons = new JButton[10];
    Container c;

    FlightShowingUI(){
        setTitle("Flight details");
        setSize(1200, 800);
        setLocation(100, 100);
        c = getContentPane();
        c.setLayout(null);
        

        FlightDetails.addFlights();
        // labels = new JLabel[FlightDetails.flightlist.size()][9];
        // buttons = new JButton[FlightDetails.flightlist.size()];

        int y_axis = 100;
        
        // for(int i=0;i<FlightDetails.flightlist.size();i++){
        //     labels[i][0] = new JLabel(FlightDetails.flightlist.get(i).name);
        //     labels[i][0].setBounds(50, y_axis, 100, 30);
        //     c.add(labels[i][0]);

        //     if(labels[i][0].getText().equals("Air India"))labels[i][1] = new JLabel("AI-"+ Integer.toString(generateRandomNumber(100, 110)));
        //     else if(labels[i][0].getText().equals("Indigo"))labels[i][1] = new JLabel("IN-"+ Integer.toString(generateRandomNumber(100, 110)));
        //     else if(labels[i][0].getText().equals("Air Asia"))labels[i][1] = new JLabel("AS-"+ Integer.toString(generateRandomNumber(100, 110)));
        //     else if(labels[i][0].getText().equals("Fly Dubai"))labels[i][1] = new JLabel("FD-"+ Integer.toString(generateRandomNumber(100, 110)));
        //     else if(labels[i][0].getText().equals("SpiceJet"))labels[i][1] = new JLabel("SJ-"+ Integer.toString(generateRandomNumber(100, 110)));
        //     labels[i][1].setBounds(160, y_axis, 100, 30);
        //     c.add(labels[i][1]);

        //     labels[i][2] = new JLabel(FlightDetails.flightlist.get(i).departure_airport);
        //     labels[i][2].setBounds(270, y_axis, 100, 30);
        //     c.add(labels[i][2]);

        //     labels[i][3] = new JLabel(FlightDetails.flightlist.get(i).arrival_airport);
        //     labels[i][3].setBounds(380, y_axis, 100, 30);
        //     c.add(labels[i][3]);

        //     labels[i][4] = new JLabel(Integer.toString(FlightDetails.flightlist.get(i).departureTime));
        //     labels[i][4].setBounds(490, y_axis, 100, 30);
        //     c.add(labels[i][4]);

        //     labels[i][5] = new JLabel(Integer.toString(FlightDetails.flightlist.get(i).arrivalTime));
        //     labels[i][5].setBounds(600, y_axis, 100, 30);
        //     c.add(labels[i][5]);

        //     labels[i][6] = new JLabel(Integer.toString(FlightDetails.flightlist.get(i).arrivalTime-FlightDetails.flightlist.get(i).departureTime));
        //     labels[i][6].setBounds(710, y_axis, 100, 30);
        //     c.add(labels[i][6]);

        //     labels[i][7] = new JLabel(Integer.toString(FlightDetails.flightlist.get(i).economyclass_ticket_fare));
        //     labels[i][7].setBounds(820, y_axis, 100, 30);
        //     c.add(labels[i][7]);

        //     labels[i][8] = new JLabel(Integer.toString(FlightDetails.flightlist.get(i).businessclass_ticket_fare));
        //     labels[i][8].setBounds(930, y_axis, 100, 30);
        //     c.add(labels[i][8]);

        //     buttons[i] = new JButton("Book");
        //     buttons[i].setBounds(1040, y_axis, 100, 30);
        //     c.add(buttons[i]);
        //     buttons[i].addActionListener(this);

        //     y_axis += 50;
        // }

        for(int i=0;i<10;i++){
            labels[i][0].setText(FlightDetails.flightlist.get(i).name);
            labels[i][0].setBounds(50, y_axis, 100, 30);
            c.add(labels[i][0]);
            if(labels[i][0].getText().equals("Air India"))labels[i][1].setText("AI-"+ Integer.toString(generateRandomNumber(100, 110)));
            else if(labels[i][0].getText().equals("Indigo"))labels[i][1].setText("IN-"+ Integer.toString(generateRandomNumber(100, 110)));
            else if(labels[i][0].getText().equals("Air Asia"))labels[i][1].setText("AS-"+ Integer.toString(generateRandomNumber(100, 110)));
            else if(labels[i][0].getText().equals("Fly Dubai"))labels[i][1].setText("FD-"+ Integer.toString(generateRandomNumber(100, 110)));
            else if(labels[i][0].getText().equals("SpiceJet"))labels[i][1].setText("SJ-"+ Integer.toString(generateRandomNumber(100, 110)));
            labels[i][1].setBounds(160, y_axis, 100, 30);
            c.add(labels[i][1]);
            labels[i][2].setText(FlightDetails.flightlist.get(i).departure_airport);
            labels[i][2].setBounds(270, y_axis, 100, 30);
            c.add(labels[i][2]);
            labels[i][3].setText(FlightDetails.flightlist.get(i).arrival_airport);
            labels[i][3].setBounds(380, y_axis, 100, 30);
            c.add(labels[i][3]);
            labels[i][4].setText(Integer.toString(FlightDetails.flightlist.get(i).departureTime));
            labels[i][4].setBounds(490, y_axis, 100, 30);
            c.add(labels[i][4]);
            labels[i][5].setText(Integer.toString(FlightDetails.flightlist.get(i).arrivalTime));
            labels[i][5].setBounds(600, y_axis, 100, 30);
            c.add(labels[i][5]);
            labels[i][6].setText(Integer.toString(FlightDetails.flightlist.get(i).arrivalTime-FlightDetails.flightlist.get(i).departureTime));
            labels[i][6].setBounds(710, y_axis, 100, 30);
            c.add(labels[i][6]);
            labels[i][7].setText(Integer.toString(FlightDetails.flightlist.get(i).economyclass_ticket_fare));
            labels[i][7].setBounds(820, y_axis, 100, 30);
            c.add(labels[i][7]);
            labels[i][8].setText(Integer.toString(FlightDetails.flightlist.get(i).businessclass_ticket_fare));
            labels[i][8].setBounds(930, y_axis, 100, 30);
            c.add(labels[i][8]);
            buttons[i] = new JButton("Book");
            buttons[i].setBounds(1040, y_axis, 100, 30);
            c.add(buttons[i]);
            buttons[i].addActionListener(this);
            y_axis += 50;
        }


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0;i<FlightDetails.flightlist.size();i++){
            if(e.getSource() == buttons[i]){
                JOptionPane.showMessageDialog(this, "Booked successfully");
                selectedFlight = FlightDetails.flightlist.get(i);
                dispose();
                c.removeAll();
                new TicketDetailsUI();
            }
        }   
    }
}