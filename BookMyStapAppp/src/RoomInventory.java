import java.util.*;

public class RoomInventory{

    private HashMap<String,Integer> map=new HashMap<>();

    public void addRoom(String type,int count){
        map.put(type,count);
    }

    public int getAvailability(String type){
        return map.getOrDefault(type,0);
    }

    public void increase(String type){
        map.put(type,map.get(type)+1);
    }
}