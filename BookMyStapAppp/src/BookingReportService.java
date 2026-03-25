import java.util.*;

/**
 * Generates reports from booking history
 */
public class BookingReportService{

    // Total bookings
    public void totalBookings(BookingHistory bh){
        System.out.println("\nTotal Bookings: "+bh.getAll().size());
    }

    // Bookings per room type
    public void bookingsByRoomType(BookingHistory bh){

        HashMap<String,Integer> countMap=new HashMap<>();

        for(Reservation r:bh.getAll()){
            String type=r.getRoomType();
            countMap.put(type,countMap.getOrDefault(type,0)+1);
        }

        System.out.println("\nBookings by Room Type:");
        for(String type:countMap.keySet()){
            System.out.println(type+" : "+countMap.get(type));
        }
    }

    // Display all bookings (report view)
    public void fullReport(BookingHistory bh){
        System.out.println("\n===== Full Booking Report =====");
        for(Reservation r:bh.getAll()){
            r.display();
        }
    }
}