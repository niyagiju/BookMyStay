import java.util.*;

/**
 * Handles booking requests using FIFO Queue
 */
public class BookingQueue{

    private Queue<Reservation> queue=new LinkedList<>();

    // Add request
    public void addRequest(Reservation r){
        queue.add(r);
        System.out.println("Request added for "+r.getGuestName());
    }

    // View all requests
    public void displayQueue(){
        System.out.println("\n===== Booking Queue =====");
        for(Reservation r:queue){
            r.display();
        }
    }

    // Get next request (FIFO)
    public Reservation getNextRequest(){
        return queue.poll();
    }
}