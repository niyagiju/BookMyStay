import java.util.*;

/**
 * Manages services linked to reservations
 */
public class AddOnServiceManager{

    // Map<ReservationID, List of Services>
    private HashMap<String,List<AddOnService>> serviceMap=new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId,AddOnService service){

        serviceMap.putIfAbsent(reservationId,new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println(service.getName()+" added to Reservation "+reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId){

        System.out.println("\nServices for Reservation "+reservationId+":");

        List<AddOnService> list=serviceMap.get(reservationId);

        if(list==null || list.isEmpty()){
            System.out.println("No services selected.");
            return;
        }

        for(AddOnService s:list){
            s.display();
        }
    }

    // Calculate total service cost
    public double calculateTotalCost(String reservationId){

        double total=0;

        List<AddOnService> list=serviceMap.get(reservationId);

        if(list!=null){
            for(AddOnService s:list){
                total+=s.getCost();
            }
        }

        return total;
    }
}