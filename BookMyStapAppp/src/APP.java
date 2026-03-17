/**
 * Use Case 4: Room Search & Availability Check
 * Demonstrates read-only search using inventory.
 *
 * @author ni
 * @version 1.0
 */

import java.util.*;

// ----------- Room (Domain Model) -----------
abstract class Room{
    String type;
    double price;

    public Room(String type,double price){
        this.type=type;
        this.price=price;
    }

    public void show(){
        System.out.println("Room: "+type+" | Price: $"+price);
    }
}

class SingleRoom extends Room{
    public SingleRoom(){
        super("Single Room",100);
    }
}

class DoubleRoom extends Room{
    public DoubleRoom(){
        super("Double Room",180);
    }
}

class SuiteRoom extends Room{
    public SuiteRoom(){
        super("Suite Room",300);
    }
}

// ----------- Inventory (State Holder) -----------
class RoomInventory{
    private HashMap<String,Integer> map=new HashMap<>();

    public void add(String type,int count){
        map.put(type,count);
    }

    // READ-ONLY ACCESS
    public int get(String type){
        return map.getOrDefault(type,0);
    }
}

// ----------- Search Service -----------
class SearchService{

    public void search(RoomInventory inv,List<Room> rooms){

        System.out.println("===== Available Rooms =====");

        for(Room r:rooms){
            int available=inv.get(r.type);

            // Validation (Defensive Programming)
            if(available>0){
                r.show();
                System.out.println("Available: "+available);
                System.out.println();
            }
        }
    }
}

// ----------- Main -----------
public class APP{

    public static void main(String[] args){

        // Inventory setup
        RoomInventory inv=new RoomInventory();
        inv.add("Single Room",5);
        inv.add("Double Room",0);
        inv.add("Suite Room",2);

        // Room objects
        List<Room> rooms=new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Search (read-only)
        SearchService s=new SearchService();
        s.search(inv,rooms);
    }
}