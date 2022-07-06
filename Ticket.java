import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    
    String passenger_name;
    String from;
    String to;
    LocalDate date;
    String departure_time;
    String arrival_time;
    String class_type;
    String flightNo;

    static Users [] additional_users;

    Ticket(String name,String from,String to,LocalDate d,String departure_time,String arrival_time,String class_type,String flightNo, Users[] additional_users){
       this.passenger_name = name;
       this.from = from;
       this.to = to;
       this.date = d;
       this.departure_time = departure_time;
       this.arrival_time = arrival_time;
       this.class_type = class_type;
       this.flightNo = flightNo;
       this.additional_users = additional_users;
    }
}
