/**
 * Represents a confirmed reservation
 */
public class Reservation{

    private String reservationId;
    private String roomType;
    private boolean active;

    public Reservation(String reservationId,String roomType){
        this.reservationId=reservationId;
        this.roomType=roomType;
        this.active=true;
    }

    public String getReservationId(){
        return reservationId;
    }

    public String getRoomType(){
        return roomType;
    }

    public boolean isActive(){
        return active;
    }

    public void cancel(){
        active=false;
    }
}