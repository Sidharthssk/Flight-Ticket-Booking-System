import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot extends Users {

    static  SortedPriorityQueue ticketQueue = new SortedPriorityQueue();
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
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
        //WelcomeUI w = new WelcomeUI();
        BookingUI b = new BookingUI();
        //FlightShowingUI f = new FlightShowingUI();
        //TicketDetailsUI t = new TicketDetailsUI();
       
    }
}