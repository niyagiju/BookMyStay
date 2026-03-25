public class APP {
/**
 * Main Application
 * Use Case 7: Add-On Service Selection
 */

public class APP{

    public static void main(String[] args){

        // Assume reservation already created in Use Case 6
        String reservationId="Single_Room_1";

        AddOnServiceManager manager=new AddOnServiceManager();

        // Guest selects services
        manager.addService(reservationId,new AddOnService("Breakfast",20));
        manager.addService(reservationId,new AddOnService("WiFi",10));
        manager.addService(reservationId,new AddOnService("Airport Pickup",50));

        // Display selected services
        manager.displayServices(reservationId);

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