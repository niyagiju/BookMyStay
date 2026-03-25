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
    }
}