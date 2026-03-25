/**
 * Use Case 12: Persistence & Recovery
 */

public class APP{

    public static void main(String[] args){

        // Try loading previous state
        SystemState state=PersistenceService.load();

        RoomInventory inventory;
        BookingHistory history;

        if(state==null){
            // Fresh start
            inventory=new RoomInventory();
            history=new BookingHistory();

            inventory.addRoom("Single Room",3);

            System.out.println("New system initialized.\n");
        }
        else{
            // Recovery
            inventory=state.inventory;
            history=state.history;

            System.out.println("System recovered from file.\n");
        }

        // Simulate booking
        Reservation r=new Reservation("R1","Single Room");
        history.add(r);
        inventory.allocate("Single Room");

        // Show current state
        inventory.show();
        history.show();

        // Save before shutdown
        PersistenceService.save(new SystemState(inventory,history));
    }
}