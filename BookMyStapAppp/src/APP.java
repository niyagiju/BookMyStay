/**
 * Main Application
 * Use Case 9: Error Handling & Validation
 */

public class APP{

    public static void main(String[] args){

        RoomInventory inv=new RoomInventory();

        // Setup inventory
        inv.addRoom("Single Room",1);
        inv.addRoom("Double Room",0);

        BookingService bs=new BookingService();

        // Valid booking
        bs.process(new Reservation("Alice","Single Room"),inv);

        // Invalid room type
        bs.process(new Reservation("Bob","Luxury Room"),inv);

        // No availability
        bs.process(new Reservation("Charlie","Double Room"),inv);

        // Empty guest name
        bs.process(new Reservation("","Single Room"),inv);
    }
}