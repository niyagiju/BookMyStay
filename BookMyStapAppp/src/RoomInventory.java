import java.util.*;

public class RoomInventory{

    private HashMap<String,Integer> map=new HashMap<>();

    public void addRoom(String type,int count){
        map.put(type,count);
    }

    // synchronized ensures thread-safe updates
    public synchronized boolean allocateRoom(String type){

        int available=map.getOrDefault(type,0);

        if(available>0){
            map.put(type,available-1);
            return true;
        }
        return false;
    }

    public int getAvailability(String type){
        return map.getOrDefault(type,0);
    }
}