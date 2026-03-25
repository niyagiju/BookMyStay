import java.util.*;

/**
 * Handles cancellation and rollback
 */
public class CancellationService{

    // Stack for rollback tracking (LIFO)
    private Stack<String> rollbackStack=new Stack<>();

    public void cancel(String reservationId,
                       BookingHistory history,
                       RoomInventory inventory){

        Reservation r=history.get(reservationId);

        // Validation
        if(r==null){
            System.out.println("Cancellation Failed: Reservation not found\n");
            return;
        }

        if(!r.isActive()){
            System.out.println("Cancellation Failed: Already cancelled\n");
            return;
        }

        // Record rollback (room ID)
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.increase(r.getRoomType());

        // Update reservation status
        r.cancel();

        System.out.println("Cancellation Successful!");
        System.out.println("Reservation ID: "+reservationId+"\n");
    }

    // View rollback stack
    public void showRollbackStack(){
        System.out.println("Rollback Stack: "+rollbackStack);
    }
}
