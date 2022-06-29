import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ChatBot extends Users {

    static SortedPriorityQueue ticketQueue = new SortedPriorityQueue();

    public static void main(String[] args) {
        String line = "";
        String splitby = ",";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("flight_details.csv"));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitby);
                FlightDetails flight = new FlightDetails(data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]),
                        Integer.parseInt(data[9]), Integer.parseInt(data[10]));
                FlightDetails.flightlist.add(flight);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }
        finally{
            if(br!=null){
                try{
                    br.close();
                }
                catch(IOException e){
                    System.out.println("IO exception");
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            FlightShowingUI.labels[i][0] = new JLabel("");
            FlightShowingUI.labels[i][1] = new JLabel("");
            FlightShowingUI.labels[i][2] = new JLabel("");
            FlightShowingUI.labels[i][3] = new JLabel("");
            FlightShowingUI.labels[i][4] = new JLabel("");
            FlightShowingUI.labels[i][5] = new JLabel("");
            FlightShowingUI.labels[i][6] = new JLabel("");
            FlightShowingUI.labels[i][7] = new JLabel("");
            FlightShowingUI.labels[i][8] = new JLabel("");
            FlightShowingUI.buttons[i] = new JButton("");
        }
        // WelcomeUI w = new WelcomeUI();
        BookingUI b = new BookingUI();
        // FlightShowingUI f = new FlightShowingUI();
        // TicketDetailsUI t = new TicketDetailsUI();
        // new MainUI();
    }
}