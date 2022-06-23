import java.util.Date;

public class Ticket {
    
    String passenger_name;
    String from;
    String to;
    Date date;
    String time;


    Ticket(String passenger_name, String from, String to, Date date, String time) {
        this.passenger_name = passenger_name;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    
    
}
