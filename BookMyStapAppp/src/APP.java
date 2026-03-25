/**
 * Main Application
 * Use Case 10: Booking Cancellation & Inventory Rollback
 */

public class APP{

    public static void main(String[] args){

        // Setup inventory
        RoomInventory inv=new RoomInventory();
        inv.addRoom("Single Room",1);

        // Setup history (confirmed bookings)
        BookingHistory history=new BookingHistory();

        Reservation r1=new Reservation("R1","Single Room");
        Reservation r2=new Reservation("R2","Single Room");

        history.add(r1);
        history.add(r2);

        CancellationService cs=new CancellationService();

        // Valid cancellation
        cs.cancel("R1",history,inv);

        // Duplicate cancellation
        cs.cancel("R1",history,inv);

        // Invalid ID
        cs.cancel("R3",history,inv);

        // Check rollback stack
        cs.showRollbackStack();

        // Check inventory
        System.out.println("Available Single Rooms: "+inv.getAvailability("Single Room"));
    }
}