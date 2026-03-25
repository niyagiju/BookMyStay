/**
 * Main Application
 * Use Case 8: Booking History & Reporting
 */

public class APP{

    public static void main(String[] args){

        BookingHistory history=new BookingHistory();

        // Simulating confirmed bookings (from Use Case 6)
        history.add(new Reservation("R1","Alice","Single Room"));
        history.add(new Reservation("R2","Bob","Double Room"));
        history.add(new Reservation("R3","Charlie","Single Room"));
        history.add(new Reservation("R4","David","Suite Room"));

        // Display history
        history.display();

        // Reporting
        BookingReportService report=new BookingReportService();

        report.totalBookings(history);
        report.bookingsByRoomType(history);
        report.fullReport(history);
    }
}