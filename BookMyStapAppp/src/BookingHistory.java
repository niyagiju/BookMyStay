import java.util.*;

public class BookingHistory{

    private HashMap<String,Reservation> history=new HashMap<>();

    public void add(Reservation r){
        history.put(r.getReservationId(),r);
    }

    public Reservation get(String id){
        return history.get(id);
    }
}