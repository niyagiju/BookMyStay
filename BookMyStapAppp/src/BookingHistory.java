import java.util.*;

/**
 * Stores confirmed bookings in order
 */
public class BookingHistory{

    private List<Reservation> history=new ArrayList<>();

    // Add confirmed reservation
    public void add(Reservation r){
        history.add(r);
    }

    // Get all bookings (read-only)
    public List<Reservation> getAll(){
        return history;
    }

    // Display history
    public void display(){
        System.out.println("\n===== Booking History =====");
        for(Reservation r:history){
            r.display();
        }
    }
}