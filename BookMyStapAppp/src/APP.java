public class APP {
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
        // Empty guest name
        bs.process(new Reservation("","Single Room"),inv);
        report.totalBookings(history);
        report.bookingsByRoomType(history);
        report.fullReport(history);
        // Calculate total add-on cost
        double total=manager.calculateTotalCost(reservationId);

        System.out.println("\nTotal Add-On Cost: $"+total);
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