/**
 * Booking logic with validation and error handling
 */
public class BookingService{

    public void process(Reservation r,RoomInventory inv){

        try{
            // FAIL-FAST validation
            BookingValidator.validate(r,inv);

            // Safe state update
            inv.decrease(r.getRoomType());

            System.out.println("Booking Successful!");
            System.out.println("Guest: "+r.getGuestName());
            System.out.println("Room: "+r.getRoomType()+"\n");

        }
        catch(InvalidBookingException e){
            // Graceful failure
            System.out.println("Booking Failed: "+e.getMessage()+"\n");
        }
    }
}