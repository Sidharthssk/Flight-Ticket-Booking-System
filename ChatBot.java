import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

public class ChatBot extends Users {

    static SortedPriorityQueue ticketQueue;

    public static void main(String[] args) {
        ticketQueue = new SortedPriorityQueue();
        String line = "";
        String splitby = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("flight_new.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitby);
                FlightDetails flight = new FlightDetails(data[1], data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]),
                        Integer.parseInt(data[10]), Integer.parseInt(data[11]));
                FlightDetails.flightlist.add(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fi = new FileInputStream(new File("users.txt"))) {
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() != 0) {
                Users.usersList.add((Users) oi.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
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
        new WelcomeUI();
    }
}