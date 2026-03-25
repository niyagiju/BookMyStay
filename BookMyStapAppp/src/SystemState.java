import java.io.Serializable;

/**
 * Combines all persistent data
 */
public class SystemState implements Serializable{

    private static final long serialVersionUID=1L;

    public RoomInventory inventory;
    public BookingHistory history;

    public SystemState(RoomInventory inventory,BookingHistory history){
        this.inventory=inventory;
        this.history=history;
    }
}