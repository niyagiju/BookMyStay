/**
 * Main Application
 * Use Case 11: Concurrent Booking Simulation
 */

public class APP{

    public static void main(String[] args){

        // Shared resources
        BookingQueue queue=new BookingQueue();
        RoomInventory inventory=new RoomInventory();

        // Setup inventory (limited rooms)
        inventory.addRoom("Single Room",2);

        // Simulate multiple guest requests
        queue.addRequest(new Reservation("Alice","Single Room"));
        queue.addRequest(new Reservation("Bob","Single Room"));
        queue.addRequest(new Reservation("Charlie","Single Room"));
        queue.addRequest(new Reservation("David","Single Room"));

        // Multiple threads (concurrent users)
        BookingProcessor t1=new BookingProcessor(queue,inventory);
        BookingProcessor t2=new BookingProcessor(queue,inventory);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}