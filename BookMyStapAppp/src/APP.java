/**
 * Main Application
 * Use Case 6: Reservation Confirmation & Room Allocation
 */

public class APP{

    public static void main(String[] args){

        // Inventory setup
        RoomInventory inv=new RoomInventory();
        inv.addRoom("Single Room",2);
        inv.addRoom("Double Room",1);

        // Queue setup
        BookingQueue q=new BookingQueue();
        q.addRequest(new Reservation("Alice","Single Room"));
        q.addRequest(new Reservation("Bob","Single Room"));
        q.addRequest(new Reservation("Charlie","Single Room")); // extra request
        q.addRequest(new Reservation("David","Double Room"));

        // Booking Service
        BookingService bs=new BookingService();
        bs.process(q,inv);
    }
}