import java.util.*;

public class BookingService{

    private Set<String> allocatedRooms=new HashSet<>();
    private HashMap<String,Set<String>> roomAllocations=new HashMap<>();

    // Generate unique room ID
    private String generateRoomId(String type,int number){
        return type.replace(" ","_")+"_"+number;
    }

    public void process(BookingQueue queue,RoomInventory inventory){

        int idCounter=1;

        while(!queue.isEmpty()){

            Reservation r=queue.getNext();
            String type=r.getRoomType();

            int available=inventory.getAvailability(type);

            if(available>0){

                // Generate unique ID
                String roomId=generateRoomId(type,idCounter++);

                // Ensure uniqueness
                if(!allocatedRooms.contains(roomId)){

                    allocatedRooms.add(roomId);

                    // Map room type → allocated IDs
                    roomAllocations.putIfAbsent(type,new HashSet<>());
                    roomAllocations.get(type).add(roomId);

                    // Update inventory immediately
                    inventory.decrease(type);

                    System.out.println("Booking Confirmed!");
                    System.out.println("Guest: "+r.getGuestName());
                    System.out.println("Room Type: "+type);
                    System.out.println("Room ID: "+roomId+"\n");
                }
            }
            else{
                System.out.println("Booking Failed (No Availability)");
                System.out.println("Guest: "+r.getGuestName());
                System.out.println("Requested: "+type+"\n");
            }
        }
    }
}