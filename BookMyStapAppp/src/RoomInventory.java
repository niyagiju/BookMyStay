import java.util.*;

public class RoomInventory{

    private HashMap<String,Integer> map=new HashMap<>();

    public void addRoom(String type,int count){
        map.put(type,count);
    }

    public boolean isValidRoomType(String type){
        return map.containsKey(type);
    }

    public int getAvailability(String type){
        return map.getOrDefault(type,0);
    }

    public void decrease(String type) throws InvalidBookingException{
        int available=getAvailability(type);

        if(available<=0){
            throw new InvalidBookingException("No rooms available for "+type);
        }

        map.put(type,available-1);
    }
}