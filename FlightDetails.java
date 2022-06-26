import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Random;

public class FlightDetails {

    String name;
    String flightNo;
    int departureTime;
    int arrivalTime;
    String departure_airport;
    String arrival_airport;
    int businessclass_seats;
    int economyclass_seats;
    int economyclass_ticket_fare;
    int businessclass_ticket_fare;

    FlightDetails(){}

    FlightDetails(String name,String departure_airport,String arrival_airport,int departureTime,int arrivalTime,int businessclass_seats,int economyclass_seats,int economyclass_ticket_fare,int businessclass_ticket_fare){
        this.name=name;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.departure_airport=departure_airport;
        this.arrival_airport=arrival_airport;
        this.businessclass_seats=businessclass_seats;
        this.economyclass_seats=economyclass_seats;
        this.economyclass_ticket_fare=economyclass_ticket_fare;
        this.businessclass_ticket_fare=businessclass_ticket_fare;
    }
    
     static int generateRandomNumber(int min,int max){
          return (int)(Math.random()*(max-min+1)+min);
      }

    static ArrayList<FlightDetails> flightlist = new ArrayList<>();

    static String [] flightName = {"Air India","Indigo","Air Asia","Fly Dubai","SpiceJet"};
    static String [] destination = {"Dammam", "Riyadh", "Qatar","Kuwait","Dubai"};
    static String [] departure = {"Cochin", "Trivandrum", "Kozhikode","Mumbai","NewDelhi"};

    static void addFlights(){
        if(flightlist.size()!=0){
            flightlist.clear();
        }
        for(int i = 0;i<10;i++ ){
            int departureTime = generateRandomNumber(0,19);
            int arrivalTime = generateRandomNumber(departureTime,23);
            while((arrivalTime-departureTime)<=4){
                arrivalTime = generateRandomNumber(departureTime, 23);
            }
            int economyclass_ticket_fare = generateRandomNumber(10000,100000);
            int businessclass_ticket_fare = generateRandomNumber(economyclass_ticket_fare+20000,150000);
            
            flightlist.add(new FlightDetails(flightName[generateRandomNumber(0, 4)], BookingUI.selected_depart, BookingUI.selected_dest,departureTime,arrivalTime,generateRandomNumber(10, 30), generateRandomNumber(150, 200), economyclass_ticket_fare, businessclass_ticket_fare));
        }
    }
}