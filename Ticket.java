import java.util.Date;

public class Ticket {
    
    String passenger_name;
    String from;
    String to;
    Date date;
    String departure_time;
    String arrival_time;

    static Users [] additional_users;

    Ticket(String name,String from,String to,Date d,String departure_time,String arrival_time,Users[] additional_users){
       this.passenger_name = name;
       this.from = from;
       this.to = to;
       this.date = d;
       this.departure_time = departure_time;
       this.arrival_time = arrival_time;
       this.additional_users = additional_users;
    }
}
