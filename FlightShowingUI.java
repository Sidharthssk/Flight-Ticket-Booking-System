import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlightShowingUI extends JFrame {

    static int generateRandomNumber(int min,int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

    JTable table;

    FlightShowingUI(){
        setTitle("Flight details");
        setSize(1000, 800);
        setLocation(100, 100);

        FlightDetails.addFlights();

        String [][] data = new String [FlightDetails.flightlist.size()][9];

        String [] columnNames = {"Flight Name", "Flight ID", "Flight Source", "Flight Destination", "Flight Departure Time", "Flight Arrival Time", "Flight Duration", "Flight Price(Business Class)", "Flight Price(Economy Class)"};

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

            setVisible(true);
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }
}
