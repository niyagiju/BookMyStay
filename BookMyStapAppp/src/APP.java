public class APP {
/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 * Demonstrates Queue for handling booking requests.
 *
 * @author ni
 * @version 1.0
 */

import java.util.*;

// ----------- Reservation (Request Object) -----------
class Reservation{
    String guestName;
    String roomType;

    public Reservation(String guestName,String roomType){
        this.guestName=guestName;
        this.roomType=roomType;
    }

    public void show(){
        System.out.println("Guest: "+guestName+" | Requested: "+roomType);
    }
}

// ----------- Booking Queue -----------
class BookingQueue{

    private Queue<Reservation> queue=new LinkedList<>();

    // Add request (enqueue)
    public void addRequest(Reservation r){
        queue.add(r);
        System.out.println("Request added for "+r.guestName);
    }

    // View all requests (without removing)
    public void showQueue(){
        System.out.println("\n===== Booking Request Queue =====");
        for(Reservation r:queue){
            r.show();
        }
    }

    // Process next request (dequeue)
    public Reservation getNext(){
        return queue.poll(); // removes in FIFO order
    }
}

// ----------- Main Application -----------
public class APP{

    public static void main(String[] args){

        BookingQueue bq=new BookingQueue();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();
        // Guests submit booking requests
        bq.addRequest(new Reservation("Alice","Single Room"));
        bq.addRequest(new Reservation("Bob","Suite Room"));
        bq.addRequest(new Reservation("Charlie","Double Room"));

        // Show queue (arrival order preserved)
        bq.showQueue();

        // Demonstrate FIFO processing
        System.out.println("\nProcessing next request...");
        Reservation r=bq.getNext();

        if(r!=null){
            System.out.println("Processing:");
            r.show();
        }

        r3.displayDetails();
        System.out.println("Available: "+suiteAvailable);
        System.out.println();
        // Remaining queue
        bq.showQueue();
    }
}