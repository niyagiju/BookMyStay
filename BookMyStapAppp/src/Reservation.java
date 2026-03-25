import java.io.Serializable;

public class Reservation implements Serializable{

    private static final long serialVersionUID=1L;

    private String reservationId;
    private String roomType;

    public Reservation(String reservationId,String roomType){
        this.reservationId=reservationId;
        this.roomType=roomType;
    }

    public String getReservationId(){
        return reservationId;
    }

    public String getRoomType(){
        return roomType;
    }

    public String toString(){
        return reservationId+" - "+roomType;
    }
}