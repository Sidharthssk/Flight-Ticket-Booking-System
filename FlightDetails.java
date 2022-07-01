import java.util.ArrayList;

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
    String date;
    Ticket[] businessTickets;
    Ticket[] economyTickets;
    int front1 = -1;
    int rear1 = -1;
    int front2 = -1;
    int rear2 = -1;

    FlightDetails() {
    }

    FlightDetails(String name, String flightNo, int departureTime, int arrivalTime) {
        this.name = name;
        this.flightNo = flightNo;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    FlightDetails(String name, String flight_no, String departure_airport, String arrival_airport, String date,int departureTime,
            int arrivalTime, int businessclass_seats, int economyclass_seats, int economyclass_ticket_fare,
            int businessclass_ticket_fare) {
        this.name = name;
        this.flightNo = flight_no;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.businessclass_seats = businessclass_seats;
        this.economyclass_seats = economyclass_seats;
        this.economyclass_ticket_fare = economyclass_ticket_fare;
        this.businessclass_ticket_fare = businessclass_ticket_fare;
        this.businessTickets = new Ticket[businessclass_seats];
        this.economyTickets = new Ticket[economyclass_seats];
        this.date = date;
    }

    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static ArrayList<FlightDetails> flightlist = new ArrayList<>();

    static String[] flightName = { "Air India", "Indigo", "Air Asia", "Fly Dubai", "SpiceJet" };
    static String[] destination = { "Dammam", "Riyadh", "Qatar", "Kuwait", "Dubai" };
    static String[] departure = { "Cochin", "Trivandrum", "Kozhikode", "Mumbai", "NewDelhi" };

}