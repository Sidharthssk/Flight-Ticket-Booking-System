import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FlightShowingUI extends JFrame implements ListSelectionListener{

    static int generateRandomNumber(int min,int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

    static FlightDetails selectedFlight = new FlightDetails();

    JTable table;
    JRadioButton business_class, economy_class;

    FlightShowingUI(){
        setTitle("Flight details");
        setSize(1000, 800);
        setLocation(100, 100);

        FlightDetails.addFlights();

        String [][] data = new String [FlightDetails.flightlist.size()][9];

        String [] columnNames = {"Flight Name", "Flight ID", "Flight Source", "Flight Destination", "Flight Departure Time", "Flight Arrival Time", "Flight Duration", "Business Class(in Rs)", "Economy Class(in Rs)"};

        for(int i=0;i<FlightDetails.flightlist.size();i++){
            data[i][0] = FlightDetails.flightlist.get(i).name;
            if(data[i][0].equals("Air India"))data[i][1] = "AI-"+ Integer.toString(generateRandomNumber(100, 110));
            else if(data[i][0].equals("Indigo"))data[i][1] = "IN-"+ Integer.toString(generateRandomNumber(100, 110));
            else if(data[i][0].equals("Air Asia"))data[i][1] = "AS-"+ Integer.toString(generateRandomNumber(100, 110));
            else if(data[i][0].equals("Fly Dubai"))data[i][1] = "FD-"+ Integer.toString(generateRandomNumber(100, 110));
            else if(data[i][0].equals("SpiceJet"))data[i][1] = "SJ-"+ Integer.toString(generateRandomNumber(100, 110));
            data[i][2] = FlightDetails.flightlist.get(i).departure_airport;
            data[i][3] = FlightDetails.flightlist.get(i).arrival_airport;
            data[i][4] = Integer.toString(FlightDetails.flightlist.get(i).departureTime);
            data[i][5] = Integer.toString(FlightDetails.flightlist.get(i).arrivalTime);
            data[i][6] = Integer.toString(FlightDetails.flightlist.get(i).arrivalTime-FlightDetails.flightlist.get(i).departureTime)+" Hrs";
            data[i][7] = Integer.toString(FlightDetails.flightlist.get(i).businessclass_ticket_fare);
            data[i][8] = Integer.toString(FlightDetails.flightlist.get(i).economyclass_ticket_fare);
        }

        table = new JTable(data, columnNames);
        table.setShowHorizontalLines(true);
        table.setRowSelectionAllowed(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        ListSelectionModel model = table.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.addListSelectionListener(this);

        // economy_class = new JRadioButton("Economy Class");
        // business_class = new JRadioButton("Business Class");
        // economy_class.setSelected(true);
        // add(economy_class);
        // add(business_class);

        setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e){
            selectedFlight.name = (String)table.getValueAt(table.getSelectedRow(), 0);
            selectedFlight.flightNo = (String)table.getValueAt(table.getSelectedRow(), 1);
            selectedFlight.departureTime = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 4));
            selectedFlight.arrivalTime = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 5));
            selectedFlight.departure_airport = (String)table.getValueAt(table.getSelectedRow(), 2);
            selectedFlight.arrival_airport = (String)table.getValueAt(table.getSelectedRow(), 3);
            selectedFlight.businessclass_ticket_fare = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 7));
            selectedFlight.economyclass_ticket_fare = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 8));
            dispose();
            new TicketDetailsUI();
    }
}
