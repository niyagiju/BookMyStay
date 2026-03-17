/**
 * Main Application
 * Demonstrates Use Case 5: Booking Request Queue
 */
public class APP{

    public static void main(String[] args){

        BookingQueue bq=new BookingQueue();

        // Guests submit requests
        bq.addRequest(new Reservation("Alice","Single Room"));
        bq.addRequest(new Reservation("Bob","Suite Room"));
        bq.addRequest(new Reservation("Charlie","Double Room"));

        // Show queue
        bq.displayQueue();

        // Process first request (FIFO)
        System.out.println("\nProcessing next request...");
        Reservation r=bq.getNextRequest();

        if(r!=null){
            r.display();
        }

        // Remaining queue
        bq.displayQueue();
    }
}