import java.util.HashMap;
import java.util.Map;

/**
 * Hotel Booking System
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates HashMap based inventory control.
 *
 * @author ni
 * @version 1.0
 */

/* Inventory Management Class */
class RoomInventory{

    private HashMap<String,Integer> inventory;

    public RoomInventory(){
        inventory=new HashMap<>();
    }

    // Register room type
    public void addRoomType(String roomType,int count){
        inventory.put(roomType,count);
    }

    // Get availability
    public int getAvailability(String roomType){
        return inventory.getOrDefault(roomType,0);
    }

    // Update availability
    public void updateAvailability(String roomType,int newCount){
        if(inventory.containsKey(roomType)){
            inventory.put(roomType,newCount);
        }
    }

    // Display inventory
    public void displayInventory(){
        System.out.println("===== Current Room Inventory =====");
        for(Map.Entry<String,Integer> entry:inventory.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue()+" rooms available");
        }
    }
}

/* Main Application */
public class APP{

    public static void main(String[] args){

        RoomInventory inventory=new RoomInventory();

        // Register room types
        inventory.addRoomType("Single Room",5);
        inventory.addRoomType("Double Room",3);
        inventory.addRoomType("Suite Room",2);

        // Display inventory
        inventory.displayInventory();

        // Example update
        System.out.println("\nBooking 1 Single Room...");
        int available=inventory.getAvailability("Single Room");
        inventory.updateAvailability("Single Room",available-1);

        // Display updated inventory
        inventory.displayInventory();
    }
}